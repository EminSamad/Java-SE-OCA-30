package task3;

import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListApplication {
    static ArrayList<Tasks> taskList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("***************************************************");
        System.out.println("---To-Do List Application---");
        System.out.println("***************************************************");

        while(true){
            System.out.println("Functions :");
            System.out.println("Enter '1' for Adding task");
            System.out.println("Enter '2' for Marking task as complete");
            System.out.println("Enter '3' for Display tasks");
            System.out.println("Enter 'q' for Quitting");

            System.out.print("Enter the number of function which you want :");
            String functionNum=scanner.nextLine();

            if (functionNum.equals("q")) {
                System.out.println("Quitting the system. Goodbye!");
                break;
            }

            if (!functionNum.equals("1") && !functionNum.equals("2") && !functionNum.equals("3")  ){
                System.out.println("Invalid Function Number! ");
            }
            switch (functionNum) {
                case "1" :
                    addingTask();
                    break;
                case "2" :
                    markingComplete();
                    break;
                case "3" :
                    displayTasks();
                    break;
            }
        }
    }
    public static void addingTask(){
        System.out.print("Enter task title: ");
        Scanner scanner = new Scanner(System.in);
        String titleName = scanner.nextLine();
        taskList.add(new Tasks(titleName ,"Pending"));
        System.out.println("Task is created successfully.");
    }
    public static void markingComplete(){
        Scanner scanner = new Scanner(System.in);
        if (taskList.isEmpty()) {
            System.out.println("No tasks to mark as complete.");
            return;
        }
        displayTasks();
        System.out.print("Enter the task number to mark as complete: ");
        int taskNumber;
        try {
            taskNumber = Integer.parseInt(scanner.nextLine()) - 1;
            if (taskNumber < 0 || taskNumber >= taskList.size()) {
                System.out.println("Invalid task number.");
            } else {
                Tasks task = taskList.get(taskNumber);
                task.setTaskStatus("Complete");
                System.out.println("Task marked as complete.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
    }
    public static void displayTasks(){
        if (taskList.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        System.out.println("Task List:");
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println((i + 1) + ". " + taskList.get(i));
        }

    }

}

