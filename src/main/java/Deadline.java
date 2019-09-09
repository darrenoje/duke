import java.util.Date;

/**
 * A task called Deadline
 */
public class Deadline extends Task {

    protected Date by;

    /**
     * Creating Deadline object
     *
     * @param description Description of a task
     * @param by Date of task completion
     */
    public Deadline(String description, Date by) {
        super(description);
        this.by = by;
    }

    /**
     * Converting Deadline object to a string
     *
     * @return Returns the string of the Deadline object
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}