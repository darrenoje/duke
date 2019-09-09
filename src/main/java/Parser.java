import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A class called Parser
 * which processes user's input
 * and execute commands
 *
 */
public class Parser {
    private Storage storage;
    private TaskList list;
    private Ui ui;

    /**
     * Creating a Parser object
     *
     * @param storage1 object that reads and writes to the Duke.txt file
     * @param ui1 object that interacts with the user
     * @param tasklist1 task list that stores the tasks inputted by user
     */
    public Parser(Storage storage1, Ui ui1, TaskList tasklist1) {
        this.storage = storage1;
        this.ui = ui1;
        this.list = tasklist1;
    }

    /**
     * A method to execute the user's different inputs
     *
     * @param words user's input
     * @throws DukeException for invalid input
     * @throws ParseException for invalid parsing
     */
    void parse(String words) throws DukeException, ParseException {
        String[] separatewords = words.split(" ", 2);
        if (words.equals("list")) {
            ui.listingTask();
            for (int i = 0; i < list.returnTask().size(); i++) {
                System.out.println(i + 1 + "." + list.returnTask().get(i).toString());
            }
        } else if (words.startsWith("done")) {
            int num = Integer.parseInt(separatewords[1]);
            list.returnTask().get(num - 1).setDone(true);
            storage.refreshFile();
            ui.finishingTask(num, list);
        } else if (words.startsWith("deadline")) {
            String words2 = separatewords[1];
            if (words2.trim().isEmpty()) {
                ui.deadlineError();
            }
            String[] temparray = words2.trim().split(" /by ");
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HHmm");
            Date date = format.parse(temparray[1]);
            Task tempDeadline = new Deadline(temparray[0], date);
            list.returnTask().add(tempDeadline);
            storage.appendFile(tempDeadline);
            ui.addingTask(tempDeadline, list);
        } else if (words.startsWith("todo")) {
            String words2 = separatewords[1];
            if (words2.trim().isEmpty()) {
                ui.todoError();
            }
            Task tempTodo = new Todo(separatewords[1].trim());
            list.returnTask().add(tempTodo);
            storage.appendFile(tempTodo);
            ui.addingTask(tempTodo, list);
        } else if (words.startsWith("event")) {
            String words2 = separatewords[1];
            if (words2.trim().isEmpty()) {
                ui.eventError();
            }
            String[] temparray = words2.trim().split(" /at ");
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HHmm");
            Date date = format.parse(temparray[1]);
            Task tempEvent = new Event(temparray[0], date);
            list.returnTask().add(tempEvent);
            storage.appendFile(tempEvent);
            ui.addingTask(tempEvent, list);
        } else if (words.startsWith("delete")) {
            int num = Integer.parseInt(separatewords[1]);
            Task temp = list.returnTask().get(num - 1);
            list.returnTask().remove(num - 1);
            storage.refreshFile();
            ui.deletingTask(temp, list);
        } else if (words.startsWith("find")) {
            String words2 = separatewords[1];
            ui.findingTask(words2, list);
        } else {
            ui.normalError();
        }
    }
}
