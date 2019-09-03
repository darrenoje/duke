import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Storage {
    private String projRoot = "C:/Users/darre/OneDrive/Desktop/CS2113T intellij/duke/src/main/";
    private ArrayList<Task> list = new ArrayList<>();

    public ArrayList<Task> load() {
        return list;
    }

    void readFile() {
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
    void appendFile(Task mytask) {
        File myFile = new File(projRoot + "duke.txt");
        try {
            FileWriter fileWriter = new FileWriter(myFile, true);
            fileWriter.write(mytask.toString() + "\n");
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    void refreshFile() {
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

