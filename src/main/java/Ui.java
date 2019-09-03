public class Ui {
    void startDuke() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println(logo + "Hello! I'm Duke\n" + "What can I do for you?");
    }

    void endDuke() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    void addingTask(Task tempTask, TaskList list) {
        System.out.println("Got it. I've added this task:");
        System.out.println(tempTask.toString());
        System.out.println("Now you have " + list.returnTask().size() + " tasks in the list.");
    }

    void deletingTask(Task tempTask, TaskList list) {
        System.out.println("Noted. I've removed this task:");
        System.out.println(tempTask);
        System.out.println("Now you have " + list.returnTask().size() + " tasks in the list.");
    }

    void finishingTask(int num, TaskList list) {
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("[" + list.returnTask().get(num - 1).getStatusIcon() + "] " + list.returnTask().get(num - 1).getDescription());
    }

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

    void listingTask() {
        System.out.println("Here are the tasks in your list:");
    }

    void deadlineError() throws DukeException {
        throw new DukeException("☹ OOPS!!! The description of a deadline cannot be empty.");
    }

    void todoError() throws DukeException {
        throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.");
    }

    void eventError() throws DukeException {
        throw new DukeException("☹ OOPS!!! The description of a event cannot be empty.");
    }

    void dateError() throws DukeException {
        throw new DukeException("Check format of date entered is dd/MM/yyyy HHmm");
    }

    void normalError() throws DukeException {
        throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
    }
}
