import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println(logo + "Hello! I'm Duke\n" + "What can I do for you?");
        while (true) {
            String words = sc.next();
            if (words.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            }
            if (words.equals("list")) {
                System.out.println("list");
            }
            if (words.equals("blah")) {
                System.out.println("blah");
            }
        }
    }
}
