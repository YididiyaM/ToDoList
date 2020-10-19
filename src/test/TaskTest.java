package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sdaindividualproject.Task;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTest {

    @BeforeEach
    void setup()
    {
        Task taskTest = new Task("Test","Test Project","Open","2020-11-30");
    }

    @Test
    void getTaskTitle ()
    {
        Task taskTest = new Task("Test", "Test Project", "Finished","date");
        assertEquals("Test", taskTest.getTitle());
    }

    @Test

    void getProjectName ()
    {
        Task taskTest = new Task("Test","Test ","Open","2020-11-30");
        assertEquals("Test Project", taskTest.getProject());
    }



}
