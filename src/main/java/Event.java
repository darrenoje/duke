import java.util.Date;

/**
 * A task called Event
 */
public class Event extends Task {

    protected Date by;

    /**
     * Creating Event object
     *
     * @param description Description of a task
     * @param by Date of task
     */
    public Event(String description, Date by) {
        super(description);
        this.by = by;
    }

    /**
     * Converting Event object to a string
     *
     * @return Returns the string of the Event object
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + by + ")";
    }
}
