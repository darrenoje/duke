import java.util.ArrayList;

public class TaskList {
    public ArrayList<Task> taskList;

    public TaskList(ArrayList<Task> tempTask) {
        this.taskList = tempTask;
    }

    public ArrayList<Task> returnTask() {
        return taskList;
    }

    public void addTask(Task tempTask) {
        taskList.add(tempTask);
    }

    public void deleteTask(int num) {
        taskList.remove(num);
    }
}
