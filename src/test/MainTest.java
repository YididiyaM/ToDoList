package test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sdaindividualproject.Task;

public class MainTest {
    ArrayList<Task> toDoList = new ArrayList<>();

    @BeforeEach

    void setup()
    {
        Task task = new Task("Zero","Test Project","Half Way","2020-12-23");
        Task task1 = new Task("First","First Project","Started","2021-01-21");
        Task task2 = new Task("Second","Second Project","Finished","2020-11-23");

        toDoList.add(task);
        toDoList.add(task1);
        toDoList.add(task2);
    }

    @Test

    void checkAdd ()
    {
        assertEquals("Zero", toDoList.get(0).getTitle());
        assertEquals("First Project", toDoList.get(1).getProject());
        assertEquals("2020-11-23", toDoList.get(2).getTaskDate());

    }

   /* public  static void editTask()

    public static void markAsDone()

    public static void removeTask()*/

}
