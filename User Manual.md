# User Manual for To-Do-List

To-Do-List is a basic java application that has a text interface to interact with the user. It has some basic functions and this manual describes on how to use the application.

When the Main.java class runs it present a list options as shown below:

Hello! This is your to-do list app.
Press 
	 0 - To print options.
	 1 - To print your to-do list.
	 2 - To add a task to the to-do list.
	 3 - To edit task on the to do list.
	 4- To mark a task as done.
	 5- To remove a task.
	 6- to quit the application.
Enter your instruction number here: 

Pressing '0' will return us to the list of options given above. 

Should the user choose to print the list of tasks by pressing '1', the application will first check whether the to do list has tasks in it. If not, a message lettint the user know it is empty will appear. If there are tasks however, this prompt will appear. 

You have x tasks in your to do list

 How would you like to sort your list?
	 Press 1 to choose by date 
	 Press 2 to choose by project

Adding a task is list under prompt number '2'. When the user selects it, the application asks for a task title, task project, task status and due date. It is then added to the to-do-list. 
Enter the task title   :  

Enter the project name :  

Enter the status of the task:  

Enter the due date in this format (yyyy-MM-dd) : 

Editing a task follows the same vein where a user inputs the index of the task they want to edit and a prompt similar as above pops up and they can replace the old task. 

To mark as done is the only one of the choices that has the option of saving to a txt file. When a user selects to put a task as 'done', the application saves the task to a file and deletes it from the to-do-list Arraylist. 
