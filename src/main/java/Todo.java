/**
 * A task called To-do
 */

public class Todo extends Task {

    protected String by;

    /**
     * Creating To-do object
     *
     * @param description Description of a task
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * Converting To-do object to a string
     *
     * @return Returns the string of the To-do object
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
