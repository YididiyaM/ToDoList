package sdaindividualproject;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Comparator;

/** This class is where the arraylist of the actual to do list will be written. The methods from
 * the main class will ne accessing, printing, adding, modifying, and removing from this class.
 * Moreover, the arraylist present here will have a list of tasks from the task class used as an
 * object.
 */
public class ToDoList {
    private ArrayList<Task> toDoList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);



    //toDoList is an arraylist of the object Task. However, the task object needs to
    //be converted to string so that other methods like addTask from main can access
    //it and add to it. This method is supposed to change said arraylist.
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

        System.out.println("You have " + toDoList.size() + " tasks in your to do list");
        System.out.println("\n How would you like to sort your list?");
        System.out.println("\t Press 1 to choose by date ");
        System.out.println( "\t Press 2 to choose by project");
        int sortChoice = scanner.nextInt();
             scanner.nextLine();
             if(sortChoice == 1)  {
                 sortByDate();} else if (sortChoice == 2){
                 sortByProject(); } else {
                 System.out.println("Please seletct a valid option");
                 printToDoList();
             }

        }


    public  boolean searchForTask(int searchTaskIndex) {
        for (int i = 0; i < toDoList.size(); i++) {
            if (toDoList.get(i).equals(searchTaskIndex)) {
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

    //public static void sortByDate()
    public void sortByProject(){
            toDoList.sort((Task t1, Task t2)-> t1.getProject().compareTo(t2.project));

             }
    }







