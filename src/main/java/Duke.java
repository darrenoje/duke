import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] array;
        array = new String[100];
        int counter=0;

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println(logo + "Hello! I'm Duke\n" + "What can I do for you?");
        while (true) {
            String words = sc.nextLine();
            if (words.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            }

            if (words.equals("list")) {
                System.out.println("list");
                for (int i=0; i<100; i++) {
                    if (array[i] == null) break;
                    System.out.println(i+1 + "." + array[i]);
                }
            } else {
                array[counter] = words;
                counter++;
                System.out.println("added: " + words);
            }

        }
    }
}
