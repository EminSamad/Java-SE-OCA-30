import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskManager {
    private List<Task> tasks =new ArrayList<>();

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
    public void addTask(){
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter Task Name:");
        String taskName=scanner.nextLine();
        System.out.print("Enter Task Deadline-(yyyy-MM-dd HH:mm) : ");
        String deadline=scanner.nextLine();
        LocalDateTime localDateTime=LocalDateTime.parse(deadline,dateTimeFormatter);

        Task task=new Task();
        task.setTaskName(taskName);
        task.setLocalDateTime(localDateTime);
        tasks.add(task);
        System.out.println("Task was successfully added.");
    }
    public void showTasks(){
        for ( Task print : tasks ){
            System.out.println(print);
        }
    }
    public void taskDeadline() {
        System.out.println("Tasks' Deadlines:");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        for (Task task : tasks) {
            System.out.println("Task Name: " + task.getTaskName());
            System.out.println("Deadline: " + task.getLocalDateTime().format(dateTimeFormatter));
            Period periodCompare = Period.between(LocalDate.now(), task.getLocalDateTime().toLocalDate());
            System.out.println("Time left: " + periodCompare.getDays() + " days");
        }
    }
    public void whileLoop(){
        TaskManager TM=new TaskManager();
        boolean check=true;
        while (check){
            Scanner scanner=new Scanner(System.in);
            System.out.print("Enter Option:");
            int option=scanner.nextInt();

            switch (option){
                case 1:
                    TM.addTask();
                    break;
                case 2:
                    TM.showTasks();
                    break;
                case 3:
                    TM.taskDeadline();
                    break;
                case 4:
                    check=false;
                    System.out.println("Exiting from System...");
                    break;
                default:
                    System.out.println("Invalid Entrance!");
            }
        }
    }
    public void entrance(){
        System.out.println("---Welcome Our Task Manager App---");
        System.out.println("Options :");
        System.out.println("1: Add Task");
        System.out.println("2: See Tasks");
        System.out.println("3: Specific Task's Deadline");
        System.out.println("4: Exit");
    }
}
