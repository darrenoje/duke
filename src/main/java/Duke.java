import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Duke {
    private static String projRoot = "C:/Users/darre/OneDrive/Desktop/CS2113T intellij/duke/src/main/";
    private static ArrayList<Task> list;

    public static void main(String[] args) throws DukeException, FileNotFoundException, ParseException {
        Scanner sc = new Scanner(System.in);
        list = new ArrayList<>();
        readFile();
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
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println(i + 1 + "." + list.get(i).toString());
                    }
                } else if (words.equals("done")) {
                    int num = sc.nextInt();
                    list.get(num - 1).setDone(true);
                    refreshFile();
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println("[" + list.get(num - 1).getStatusIcon() + "] " + list.get(num - 1).getDescription());
                } else if (words.equals("deadline")) {
                    try {
                        String words2 = sc.nextLine();
                        if (words2.trim().isEmpty())
                            throw new DukeException("☹ OOPS!!! The description of a deadline cannot be empty.");
                        String[] temparray = words2.trim().split(" /by ");
                        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HHmm");
                        Date date = format.parse(temparray[1]);
                        System.out.println("Got it. I've added this task:");
                        Task tempDeadline = new Deadline(temparray[0], date);
                        list.add(tempDeadline);
                        appendFile(tempDeadline);
                        System.out.println(tempDeadline.toString());
                        System.out.println("Now you have " + list.size() + " tasks in the list.");
                    } catch (DukeException e) {
                        System.out.println(e.getMessage());
                    } catch (ParseException e) {
                        System.out.println("Check format of date entered");
                    }
                } else if (words.equals("todo")) {
                    try {
                        String words2 = sc.nextLine();
                        if (words2.trim().isEmpty())
                            throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.");
                        System.out.println("Got it. I've added this task:");
                        Task tempTodo = new Todo(words2.trim());
                        list.add(tempTodo);
                        appendFile(tempTodo);
                        System.out.println(tempTodo.toString());
                        System.out.println("Now you have " + list.size() + " tasks in the list.");
                    } catch (DukeException e) {
                        System.out.println(e.getMessage());
                    }
                } else if (words.equals("event")) {
                    try {
                        String words2 = sc.nextLine();
                        if (words2.trim().isEmpty())
                            throw new DukeException("☹ OOPS!!! The description of a event cannot be empty.");
                        String[] temparray = words2.trim().split(" /at ");
                        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HHmm");
                        Date date = format.parse(temparray[1]);
                        System.out.println("Got it. I've added this task:");
                        Task tempEvent = new Event(temparray[0], date);
                        list.add(tempEvent);
                        appendFile(tempEvent);
                        System.out.println(tempEvent.toString());
                        System.out.println("Now you have " + list.size() + " tasks in the list.");
                    } catch (DukeException e) {
                        System.out.println(e.getMessage());
                    } catch (ParseException e) {
                        System.out.println("Check format of date entered");
                    }
                } else if (words.equals("find")) {
                    try {
                        String words2 = sc.nextLine();
                        int counter = 1;
                        System.out.println("Here are the matching tasks in your list:");
                        for (Task task : list) {
                            if (task.getDescription().contains(words2)) {
                                System.out.println(counter + "." + task.toString());
                            }
                            counter++;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else {
                    throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                }
            } catch (DukeException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    private static void readFile() {
        File fileName = new File(projRoot + "duke.txt");
        ArrayList<String> temp = new ArrayList<>();
        try {
            temp = new ArrayList<>(Files.readAllLines(Paths.get(String.valueOf(fileName))));
            for (String string : temp) {
                Task tempTask;
                if (string.contains("[T]")) {
                    tempTask = new Todo(string.substring(7));
                } else if (string.contains("[D]")) {
                    DateFormat format = new SimpleDateFormat("dd/MM/yyyy HHmm");
                    Date date = format.parse(string.substring(string.indexOf("(by: ") + 5, string.length() - 1));
                    tempTask = new Deadline(string.substring(7, string.indexOf("(by: ") - 1), date);
                } else {
                    DateFormat format = new SimpleDateFormat("dd/MM/yyyy HHmm");
                    Date date = format.parse(string.substring(string.indexOf("(by: ") + 5, string.length() - 1));
                    tempTask = new Event(string.substring(7, string.indexOf("(at: ") - 1), date);
                }
                if (string.contains("\u2713")) {
                    tempTask.setDone(true);
                }
                list.add(tempTask);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
    private static void appendFile(Task mytask) {
        File myFile = new File(projRoot + "duke.txt");
        try {
            FileWriter fileWriter = new FileWriter(myFile, true);
            fileWriter.write(mytask.toString() + "\n");
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    private static void refreshFile() {
        File myFile = new File(projRoot + "duke.txt");
        try {
            FileWriter fileWriter = new FileWriter(myFile, false);
            for (Task task : list) {
                fileWriter.write(task.toString() + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
