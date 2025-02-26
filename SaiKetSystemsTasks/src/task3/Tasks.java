package task3;

import java.util.ArrayList;

public class Tasks {
    private String taskTitle;

    public Tasks(String taskTitle, String taskStatus) {
        this.taskTitle = taskTitle;
        this.taskStatus = taskStatus;
    }

    @Override
    public String toString() {
        return "Tasks{" +
                "taskTitle='" + taskTitle + '\'' +
                ", taskStatus='" + taskStatus + '\'' +
                '}';
    }

    private String taskStatus;

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public ArrayList<String> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<String> arrayList) {
        this.arrayList = arrayList;
    }

    private ArrayList<String> arrayList;


}
