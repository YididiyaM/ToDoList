package sdaindividualproject;
import java.util.ArrayList;

/** This class is where the arraylist of the actual to do list will be written. The methods from
 * the main class will ne accessing, printing, adding, modifying, and removing from this class.
 * Moreover, the arraylist present here will have a list of tasks from the task class used as an
 * object.
 */
public class ToDoList {
    private ArrayList<Task> toDoList = new ArrayList<>();

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
        for (int i = 0; i < toDoList.size(); i++) {
            System.out.println((i) + ". " + toDoList.get(i));
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
    }







