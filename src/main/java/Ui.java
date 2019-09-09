/**
 * A class called Ui which interacts with the user
 */
public class Ui {

    /**
     * Shows default message when Duke is running
     */
    void startDuke() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println(logo + "Hello! I'm Duke\n" + "What can I do for you?");
    }

    /**
     * Displays message when Duke has ended
     */
    void endDuke() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    /**
     * Displays message when user wants to add a task
     *
     * @param tempTask task to be added
     * @param list ArrayList
     */
    void addingTask(Task tempTask, TaskList list) {
        System.out.println("Got it. I've added this task:");
        System.out.println(tempTask.toString());
        System.out.println("Now you have " + list.returnTask().size() + " tasks in the list.");
    }

    /**
     * Displays message when user wants to delete a task
     *
     * @param tempTask task to be deleted
     * @param list ArrayList
     */
    void deletingTask(Task tempTask, TaskList list) {
        System.out.println("Noted. I've removed this task:");
        System.out.println(tempTask);
        System.out.println("Now you have " + list.returnTask().size() + " tasks in the list.");
    }

    /**
     * Displays message when user finishes a task
     *
     * @param num finished task's number in the list
     * @param list ArrayList
     */
    void finishingTask(int num, TaskList list) {
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("[" + list.returnTask().get(num - 1).getStatusIcon() + "] " + list.returnTask().get(num - 1).getDescription());
    }

    /**
     * Displays message when user wants to find tasks corresponding to a word
     *
     * @param words2 String of word user inputted
     * @param list ArrayList
     */
    void findingTask(String words2, TaskList list) {
        System.out.println("Here are the matching tasks in your list:");
        int counter = 1;
        for (Task task : list.returnTask()) {
            if (task.getDescription().contains(words2)) {
                System.out.println(counter + "." + task.toString());
                counter++;
            }
        }
    }

    /**
     * Displays message listing task
     */
    void listingTask() {
        System.out.println("Here are the tasks in your list:");
    }

    /**
     * Deadline error
     *
     * @throws DukeException for invalid deadline input
     */
    void deadlineError() throws DukeException {
        throw new DukeException("☹ OOPS!!! The description of a deadline cannot be empty.");
    }

    /**
     * To-do error
     *
     * @throws DukeException for invalid to-do input
     */
    void todoError() throws DukeException {
        throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.");
    }

    /**
     * Event error
     *
     * @throws DukeException for invalid event input
     */
    void eventError() throws DukeException {
        throw new DukeException("☹ OOPS!!! The description of a event cannot be empty.");
    }

    /**
     * Date error
     *
     * @throws DukeException for invalid date input
     */
    void dateError() throws DukeException {
        throw new DukeException("Check format of date entered is dd/MM/yyyy HHmm");
    }

    /**
     * for general error
     *
     * @throws DukeException for invalid input
     */
    void normalError() throws DukeException {
        throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
    }
}
