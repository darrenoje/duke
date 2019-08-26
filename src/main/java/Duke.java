import java.util.Scanner;

public class Duke {
    public static void main(String[] args) throws DukeException {
        Scanner sc = new Scanner(System.in);
        Task[] array;
        array = new Task[100];
        int counter=0;

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println(logo + "Hello! I'm Duke\n" + "What can I do for you?");
        while (true) {
            try {
                String words = sc.next();
                if (words.equals("bye")) {
                    System.out.println("Bye. Hope to see you again soon!");
                    break;
                }

                if (words.equals("list")) {
                    System.out.println("Here are the tasks in your list:");
                    for (int i = 0; i < 100; i++) {
                        if (array[i] == null) break;
                        System.out.println(i + 1 + "." + array[i].toString());
                    }
                } else if (words.equals("done")) {
                    int num = sc.nextInt();
                    array[num - 1].setDone(true);
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println("[" + array[num - 1].getStatusIcon() + "] " + array[num - 1].getDescription());
                } else if (words.equals("deadline")) {
                    try {
                        String words2 = sc.nextLine();
                        if (words2.trim().isEmpty())
                            throw new DukeException("☹ OOPS!!! The description of a deadline cannot be empty.");
                        String[] temparray = words2.trim().split(" /by ");
                        System.out.println("Got it. I've added this task:");
                        array[counter] = new Deadline(temparray[0], temparray[1]);
                        counter++;
                        System.out.println(array[counter - 1].toString());
                        System.out.println("Now you have " + counter + " tasks in the list.");
                    } catch (DukeException e) {
                        System.out.println(e.getMessage());
                    }
                } else if (words.equals("todo")) {
                    try {
                        String words2 = sc.nextLine();
                        if (words2.trim().isEmpty())
                            throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.");
                        System.out.println("Got it. I've added this task:");
                        array[counter] = new Todo(words2.trim());
                        counter++;
                        System.out.println(array[counter - 1].toString());
                        System.out.println("Now you have " + counter + " tasks in the list.");
                    } catch (DukeException e) {
                        System.out.println(e.getMessage());
                    }
                } else if (words.equals("event")) {
                    try {
                        String words2 = sc.nextLine();
                        if (words2.trim().isEmpty())
                            throw new DukeException("☹ OOPS!!! The description of a event cannot be empty.");
                        String[] temparray = words2.trim().split(" /at ");
                        System.out.println("Got it. I've added this task:");
                        array[counter] = new Event(temparray[0], temparray[1]);
                        counter++;
                        System.out.println(array[counter - 1].toString());
                        System.out.println("Now you have " + counter + " tasks in the list.");
                    } catch (DukeException e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                }
            } catch (DukeException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
