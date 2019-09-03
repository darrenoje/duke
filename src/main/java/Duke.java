import java.text.ParseException;
import java.time.DateTimeException;
import java.util.Scanner;

public class Duke {
    private Storage storage;
    private TaskList list;
    private Ui ui;

    public Duke() {
        ui = new Ui();
        storage = new Storage();
        list = new TaskList(storage.load());
        storage.readFile();
    }

    public void run() throws DukeException {
        ui.startDuke();
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                if (sc.hasNextLine()) {
                    String words = sc.nextLine();
                    if (words.equals("bye")) {
                        break;
                    }
                    Parser parser = new Parser(storage, ui, list);
                    parser.parse(words);
                } else {
                    break;
                }
            } catch (ArrayIndexOutOfBoundsException | DukeException | ParseException e) {
                System.out.println(e.getMessage());
            } catch (DateTimeException e) {
                ui.dateError();
            }
        }
        ui.endDuke();
    }

    public static void main(String[] args) throws DukeException {
        new Duke().run();
    }
}
