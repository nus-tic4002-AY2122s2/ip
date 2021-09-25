package main.java.duke.commands;

import main.java.duke.task.Task;

import java.util.*;

/**
 * Finds and lists all tasks in taskList whose description contains any of the argument keywords.
 * Keyword matching is case-sensitive.
 */
public class FindCommand extends Command {

    public static final String COMMAND_WORD="find";

    public static final String MESSAGE_USAGE= "||"+COMMAND_WORD+": finds the specific tasks based on the keywords you entered.\n" +
            "Syntax: find KEYWORDS\n" +
            "Example: "+COMMAND_WORD+"find book(will return the task that contains the keyword book.";

    private final Set<String> keywords;
    private boolean isCombined = true;

    public FindCommand(Set<String> keywords) {
        this.keywords = keywords;
    }
    public FindCommand(Set<String> keywords,boolean isCombined) {
        this.keywords = keywords;
        this.isCombined = isCombined;
    }

    @Override
    public void execute(){
        final List<Task> foundTasks= getTasksFromKeyword(keywords,isCombined);
        if(foundTasks.isEmpty()){
            System.out.print("No Result Found\n");
            return;
        }
        for (int i = 1; i <= foundTasks.size(); i++) {
            System.out.println(i + ". " + foundTasks.get(i-1).toString());
        }

    }


    /**
     * Retrieves all tasks in the TaskList whose descriptions contain some specified keywords.
     *
     * @param keywords for searching
     * @param isCombined if true then will match all the keyword combined, else will match all the keyword separately
     * @return list of tasks found
     */
    private List<Task> getTasksFromKeyword(Set<String> keywords, boolean isCombined) {
        final List<Task> matchedTasks= new ArrayList<>();
        if(isCombined){
            for(Task task : taskList.getAllTasks()){
                Set<String> descriptionWords= new HashSet<>( Arrays.asList(task.getDescription().split(" ")));
                if (descriptionWords.containsAll(keywords)){
                    matchedTasks.add(task);
                }
            }
        }else{
            for(Task task : taskList.getAllTasks()){
                if(keywords.stream().anyMatch(keyword -> task.getDescription().contains(keyword))){
                    matchedTasks.add(task);
                }
            }
        }

        return  matchedTasks;
    }


}
