package sdaindividualproject;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Comparator;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/** This class is where the arraylist of the actual to do list will be written. The methods from
 * the main class will ne accessing, printing, adding, modifying, and removing from this class.
 * Moreover, the arraylist present here will have a list of tasks from the task class used as an
 * object.
 */
public class ToDoList {
    private ArrayList<Task> toDoList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);



    /**toDoList is an arraylist of the object Task. However, the task object needs to
    *be converted to string so that other methods like addTask from main can access
    *it and add to it. This method is supposed to change said arraylist.
    */

    public int getSize() {
        return toDoList.size();
    }

    /*Although the to do list is an arraylist of tasks, it would be hard to iterate over
    **without it being converted to a string. so this function does that first
    *@param Task
    */
    public void addToDoList(Task t) {
        toDoList.add(t);
    }

    public ArrayList<String> getToDoList() {
        ArrayList<String> listTitles = new ArrayList<String>();
        for (int i = 0; i < toDoList.size(); i++) {
            listTitles.add(toDoList.get(i).toString());
        }

        return listTitles;
    }


    public void printToDoList() {

        if (toDoList.size() == 0) {
            System.out.println("You have no items in your to-do list");
        } else if(toDoList.size()>0){

            System.out.println("You have " + toDoList.size() + " tasks in your to do list");
            System.out.println("\n How would you like to sort your list?");
            System.out.println("\t Press 1 to choose by date ");
            System.out.println("\t Press 2 to choose by project");
            int sortChoice = scanner.nextInt();
            scanner.nextLine();
            if (sortChoice == 1) {
                sortByDate();
            } else if (sortChoice == 2) {
                sortByProject();
            } else {
                System.out.println("Please select a valid option");
            }
        }
    }

        /*Made a search method so the code for delete, mark as done would not be redundant
        *In this case, they simply search for the index of task first
        * @Param int
        * @return boolean
        */
    public  boolean searchForTask(int searchTaskIndex) {
        for (int i = 0; i < toDoList.size(); i++) {
            if (i == searchTaskIndex) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public void deleteTask(int position){
        toDoList.remove(position);
    }


    public void markAsDoneText(int indexInput) {
        toDoList.get(indexInput).setStatus("done");
    }



    public void readFromFile(String fileName) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            int counter = 0;
            while (line != null) {
                // read next line
                line = reader.readLine();
                if (line != null) {
                    String[] parts = line.split("\\t");
                    Task readedTask = new Task(parts[1],parts[2],parts[3],parts[4]);
                    addToDoList(readedTask);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void printToFile(String fileName) {
        try {
            FileWriter fw =new FileWriter(fileName);
            String format1 = "%-9s\t%-40s\t%-43s\t%-12s\t%-15s\n";
            fw.write(String.format(format1,"Task Number","Task title","ProjectName" , "Status", " Date"));
            for (int i = 0; i < toDoList.size(); i++) {
                Task task = toDoList.get(i);
                if (task.status.equals("done")){
                    fw.write(String.format(format1, i, task.title, task.project,task.status, task.taskDate));
                    FileWriter writer = new FileWriter("done_list.txt");
                }
            }
            fw.close();
        } catch (IOException exception) {
            System.out.println(" file cannot be written");
        }


    }
        /*The printToDoList method got too long so made separate methods for sorting and
        *called them inside the printToDoList
        */
    public void sortByDate() {
        toDoList.sort((Task t1, Task t2)-> t1.getTaskDate().compareTo(t2.getTaskDate()));
        String format1 = "%-9s\t%-40s\t%-43s\t%-12s\t%-15s";
        System.out.println(String.format(format1,"Task Number","Task title","ProjectName" , "Status", " Date"));
        for (int i = 0; i < toDoList.size(); i++) {
            Task task = toDoList.get(i);
            System.out.println(String.format(format1, i, task.title, task.project,task.status, task.taskDate));
        }
    }

    public void sortByProject(){
        toDoList.sort((Task t1, Task t2)-> t1.getProject().compareTo(t2.project));
        String format1 = "%-9s\t%-40s\t%-43s\t%-12s\t%-15s";
        System.out.println(String.format(format1,"Task Number","Task title","ProjectName" , "Status", " Date"));
        for (int i = 0; i < toDoList.size(); i++) {
            Task task = toDoList.get(i);
            System.out.println(String.format(format1, i, task.title, task.project,task.status, task.taskDate));
        }
    }

}







