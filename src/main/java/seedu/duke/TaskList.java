package seedu.duke;

import java.util.ArrayList;

public class TaskList {

    public ArrayList<Task> list;

    public TaskList() {
        this.list = new ArrayList<Task>();
    }

    /**
     * Get the current list size.
     *
     * @return The current list size in integer
     */
    public int getSize() {
        return list.size();
    }

    /**
     * Get the current list.
     *
     * @return The current list.
     */
    public ArrayList<Task> getList() {
        return this.list;
    }

    /**
     * Check whether the list is empty.
     *
     * @return True if list is empty, false if list is not empty.
     */
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    /**
     * Duke adds a Task.
     * All index are there to extract the exact data for each parameter.
     *
     * @param message Details of the Task.
     */
    public void addToDo(String message) {
        String description = message.substring(5);
        list.add(new Todo(description));
    }

    public void addDeadline(String message) {
        int deadlineIndex = message.indexOf("/by");
        String deadline = message.substring(deadlineIndex + 4);
        String description = message.substring(9, deadlineIndex - 1);
        list.add(new Deadline(description, deadline));
    }

    public void addEvent(String message) {
        int eventIndex = message.indexOf("/at");
        String event = message.substring(eventIndex + 5);
        String description = message.substring(6, eventIndex - 1);
        list.add(new Event(description, event));
    }

    public void getTaskDetails() {
        for (Task task : list) {
            if (task instanceof Todo) {
                ((Todo) task).getTaskDetails();
            } else if (task instanceof Deadline) {
                ((Deadline) task).getTaskDetails();
            } else {
                ((Event) task).getTaskDetails();
            }
        }
    }

    /**
     * Duke update a Task.
     */
    public void markTask(String message) {
        String number = message.substring(5).trim();
        int index = Integer.parseInt(number);
        index = index - 1;
        list.get(index).setMark(true);
    }

    /**
     * Duke delete a Task.
     */
    public void deleteTask(String message) {
        String number = message.substring(7).trim();
        int index = Integer.parseInt(number);
        index = index - 1;
        list.remove(index);
    }

    /**
     * Duke search Task.
     */
    public ArrayList<Task> searchTask(String message) {
        list.indexOf(message.substring(5));
        int i = 0;
        ArrayList<Task> tempList = new ArrayList<Task>();
        for (Task task : this.list) {
            if (task.getTaskDetails().contains(message.substring(5))) {
                i = i + 1;
                tempList.add(task);
            }
        }
        return tempList;
    }

    /**
     * Air Rec edit Flight details.
     * version 3.0 will be able to edit flight details by keyword.
    */
    /*public void editFlight(String message) {
        String from = "";
        String to = "";
        String date = "";
        String price = "";
        int fromIndex = message.indexOf("/from");
        int toIndex = message.indexOf("/to");
        int dateIndex = message.indexOf("/date");
        int priceIndex = message.indexOf("/price");
        if (message.indexOf('/') == -1) {
            System.out.println("☹ OOPS!!! I'm sorry, Please check the format for edit command :-(");
        } else {
            String number = message.substring(5,message.indexOf('/')).trim();
            int index = Integer.parseInt(number);
            index = index - 1;
            int counter = 0;
            for (Flight flight : this.list) {
                if (counter == index) {
                    from = flight.getFrom();
                    to = flight.getTo();
                    String[] splitDate = flight.getStringDateAndTime().split("\\s+");
                    price = Integer.toString(flight.getPrice());
                    switch (splitDate[1]) {
                    case "Jan":
                        splitDate[1] = "01";
                        break;
                    case "Feb":
                        splitDate[1] = "02";
                        break;
                    case "Mar":
                        splitDate[1] = "04";
                        break;
                    case "Apr":
                        splitDate[1] = "04";
                        break;
                    case "May":
                        splitDate[1] = "05";
                        break;
                    case "Jun":
                        splitDate[1] = "06";
                        break;
                    case "Jul":
                        splitDate[1] = "07";
                        break;
                    case "Aug":
                        splitDate[1] = "08";
                        break;
                    case "Sep":
                        splitDate[1] = "09";
                        break;
                    case "Oct":
                        splitDate[1] = "10";
                        break;
                    case "Nov":
                        splitDate[1] = "11";
                        break;
                    case "Dec":
                        splitDate[1] = "12";
                        break;
                    default:
                        break;
                    }
                    String time = splitDate[3].substring(0,splitDate[3].length() - 1);
                    date = splitDate[2] + "-" + splitDate[1] + "-" + splitDate[0] + " " + time;
                }
                counter++;
            }
            if (fromIndex != -1) {
                from = message.substring(fromIndex + 6) + " ";
            }
            if (toIndex != -1) {
                to = message.substring(toIndex + 4) + " ";
            }
            if (dateIndex != -1) {
                date = message.substring(dateIndex + 6) + " ";
            }
            if (priceIndex != -1) {
                price = message.substring(priceIndex + 7);
            }
            this.list.set(index, new Flight(from, to, date, price));
        }
    }*/
}
