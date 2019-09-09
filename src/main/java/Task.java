/**
 * A task class in Duke
 */
public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Creating Task object
     *
     * @param description Description of the task
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Checks if the task is completed
     * tick icon if task is completed
     * cross icon if task is not completed
     *
     * @return icon
     */
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    /**
     * Sets the task to done
     *
     * @param done Boolean value of whether the task is done
     */
    public void setDone(boolean done) {
        isDone = done;
    }

    /**
     * Gets the description of the task
     *
     * @return String of the description of the task
     */
    public String getDescription() {
        return description;
    }

    /**
     * Converts the task to a string with its corresponding icon
     * if it is done and its description
     *
     * @return String format of the task
     */
    public String toString() {
        return "[" + getStatusIcon() + "] " + getDescription();
    }

}
