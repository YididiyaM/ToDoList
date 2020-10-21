package sdaindividualproject;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    /**
     * This is the main class of a simple to-do list application. The to-do list
     * application is able to model a task title, due date, status and project of tasks
     * as well as sort by date and name of project.
     * <p>
     * To use the application, simply run the main class.
     */
    private static Scanner scanner = new Scanner(System.in);
    private static ToDoList toDoList = new ToDoList();

    public static void main(String[] args) throws Exception {
        boolean quit = false;
        int instructionChoice = 0;

        // to be removed
        // Task t1 = new Task("task1", "project1", "todo", "2020-10-10");
        // toDoList.addToDoList(t1);
        // Task t2 = new Task("task2", "project2", "todo", "2020-06-06");
        // toDoList.addToDoList(t2);
        toDoList.readFromFile("done_list.txt");
        if (toDoList.getSize() > 0){
            toDoList.sortByDate();
        }

        while (!quit) {
            printInstructions();
            instructionChoice = scanner.nextInt();
            scanner.nextLine();
            switch (instructionChoice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    toDoList.printToDoList();
                    break;
                case 2:
                    addTask();
                    break;
                case 3:
                    editTask();
                    break;
                case 4:
                    markAsDone();
                    break;
                case 5:
                    removeTask();
                    break;
                case 6:
                    quit = true;
                    break;
            }
        }
    }

    public static void printInstructions() {
        System.out.println("Hello! This is your to-do list app.");
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print options.");
        System.out.println("\t 1 - To print your to-do list.");
        System.out.println("\t 2 - To add a task to the to-do list.");
        System.out.println("\t 3 - To edit task on the to do list.");
        System.out.println("\t 4- To mark a task as done.");
        System.out.println("\t 5- To remove a task.");
        System.out.println("\t 6- to quit the application.");
        System.out.println("Enter your instruction number here: ");
    }

    //The scanner for the date will be taking in a String input from the user
    // but needs to be parsed into a date format. This might cause some exception errors.
    //so a method is implemented to catch those errors.

    private static void addTask() throws ParseException {
        System.out.println("Enter the task title   :  ");
        String title = scanner.nextLine();
        System.out.println("Enter the project name :  ");
        String project = scanner.nextLine();
        System.out.println("Enter the status of the task      :  ");
        String status = scanner.nextLine();
        System.out.println("Enter the due date in this format (yyyy-MM-dd)      :  ");
        String taskDate = scanner.nextLine();
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(taskDate);

        } catch (ParseException p) {
            System.out.println(" There was an error while entering date. Please try again.");
        }

        Task t = new Task(title, project, status, taskDate);
        toDoList.addToDoList(t);

    }

    public  static void editTask() throws ParseException {
        toDoList.printToDoList();
        System.out.print("Please enter  the index of the task you want to edit: ");
        int userInput = Integer.parseInt(scanner.nextLine());
        if(toDoList.searchForTask(userInput)== true) {

            toDoList.deleteTask(userInput);
        };
        System.out.println("Please enter new task");
        addTask();
    }

    public static void markAsDone(){
        System.out.print("Please enter  the index of the task you want to mark as done: ");
        int userInput = Integer.parseInt(scanner.nextLine());
        toDoList.markAsDoneText(userInput);
        toDoList.printToFile("done_list.txt");
        toDoList.deleteTask(userInput);
    }

    public static void removeTask(){
        toDoList.printToDoList();
        System.out.print("Please enter  the index of the task you want to edit: ");
        int userInput = Integer.parseInt(scanner.nextLine());
        toDoList.deleteTask(userInput);
    }

}


