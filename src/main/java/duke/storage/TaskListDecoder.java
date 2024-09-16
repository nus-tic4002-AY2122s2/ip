package duke.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import duke.common.Utils;
import duke.exception.IllegalValueException;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.TaskList;
import duke.task.Todo;


/**
 * Decodes the storage data file into an {@code taskList} object.
 */
public class TaskListDecoder {


    public static final Pattern TODO_TXT_FILE_FORMAT = Pattern.compile("T[|](?<isDone>[01])[|](?<taskDesc>[^|]+)[|]"
            + "(?<finishTime>[^|]*)");
    public static final Pattern DEADLINE_TXT_FILE_FORMAT = Pattern.compile("D[|](?<isDone>[01])"
            + "[|](?<taskDesc>[^|]+)"
            + "[|](?<planTime>[^|]+)[|]"
            + "(?<finishTime>[^|]*)");
    public static final Pattern EVENT_TXT_FILE_FORMAT = Pattern.compile("E[|](?<isDone>[01])"
            + "[|](?<taskDesc>[^|]+)"
            + "[|](?<planTime>[^|]+)[|]"
            + "(?<finishTime>[^|]*)");


    /**
     * Decodes {@code encodedTasklist} into an {@code TaskList} containing the decoded tasks.
     *
     * @throws IllegalValueException if any of the fields in any encoded task string is invalid.
     */
    public static TaskList decodeTaskList(List<String> encodedTasklist) throws IllegalValueException {

        final List<Task> decodedTasks = new ArrayList<>();
        for (String encodedTask : encodedTasklist) {
            decodedTasks.add(decodeTaskFromString(encodedTask));
        }
        return new TaskList(decodedTasks);
    }

    /**
     * Decodes {@code encodedTask} into a {@code Task}.
     *
     * @throws IllegalValueException if any field in the {@code encodedTask} is invalid.
     */
    private static Task decodeTaskFromString(String encodedTask) throws IllegalValueException {
        final Matcher matcherTodo = TODO_TXT_FILE_FORMAT.matcher(encodedTask.trim());
        final Matcher matcherDeadline = DEADLINE_TXT_FILE_FORMAT.matcher(encodedTask.trim());
        final Matcher matcherEvent = EVENT_TXT_FILE_FORMAT.matcher(encodedTask.trim());

        boolean isDone;
        if (matcherTodo.matches()) {
            isDone = "1".equals(matcherTodo.group("isDone"));
            return new Todo(matcherTodo.group("taskDesc"), isDone,
                    isDone ? Utils.getDatetimeFromString(matcherTodo.group("finishTime")) : null);
        } else if (matcherDeadline.matches()) {
            isDone = "1".equals(matcherDeadline.group("isDone"));
            return new Deadline(matcherDeadline.group("taskDesc"),
                    Utils.getDatetimeFromString(matcherDeadline.group("planTime")), isDone,
                    isDone ? Utils.getDatetimeFromString(matcherDeadline.group("finishTime")) : null);
        } else if (matcherEvent.matches()) {
            isDone = "1".equals(matcherEvent.group("isDone"));
            return new Event(matcherEvent.group("taskDesc"),
                    Utils.getDatetimeFromString(matcherEvent.group("planTime")), isDone,
                    isDone ? Utils.getDatetimeFromString(matcherEvent.group("finishTime")) : null);
        } else {
            throw new IllegalValueException("No match, please check your txt file format");
        }

    }


}
