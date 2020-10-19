package sdaindividualproject;
import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Task
{
    /**
     * This is the task class of the to-do-list application. Here it is defined the several
     * attributes of what makes a task. This class will then be used to populate the ToDoList
     * class in an array.
     */

    String title, project, status, taskDate;
    private Date date;
    private ToDoList task;
    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    public Task(String title, String project, String status, String taskDate) {
        this.title = title;
        this.project = project;
        this.status = status;
        this.taskDate = taskDate;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(String taskDate) {
        this.taskDate = taskDate;
    }

    @Override
    public String toString()
    {
        return "t: " + title;
    }


}




