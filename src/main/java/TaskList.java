import java.util.ArrayList;

/**
 * A class called TaskList which contains user's inputted tasks
 */
public class TaskList {
    public ArrayList<Task> taskList;

    /**
     * Creating a TaskList object
     *
     * @param tempTask ArrayList<Task> which stores the user's inputted tasks
     */
    public TaskList(ArrayList<Task> tempTask) {
        this.taskList = tempTask;
    }

    /**
     * Retrieve tasklist
     *
     * @return tasklist of the user
     */
    public ArrayList<Task> returnTask() {
        return taskList;
    }

    /**
     * Add a task
     *
     * @param tempTask Task object to be added
     */
    public void addTask(Task tempTask) {
        taskList.add(tempTask);
    }

    /**
     * Delete a task
     *
     * @param num index in the ArrayList to delete the task
     */
    public void deleteTask(int num) {
        taskList.remove(num);
    }
}
