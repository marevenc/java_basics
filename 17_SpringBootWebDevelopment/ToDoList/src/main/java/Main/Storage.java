package Main;

import Main.model.Task;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class Storage {
    private  static int currentId = 1;
    private static HashMap<Integer, Task> tasks = new HashMap<>();

    public static int addTask(Task task){
        int id = currentId;
        task.setId(id);
        tasks.put(id, task);
        currentId++;
        return id;
    }

    public static List<Task> getAllTasks(){
        ArrayList<Task> tasksList = new ArrayList<>();
        tasksList.addAll(tasks.values());
        return tasksList;
    }

    public static Collection<Task> updateTasks(Task[] tasksList){
        tasks = new HashMap<>();
        currentId = 1;
        for(Task task : tasksList){
            task.setId(currentId);
            tasks.put(currentId, task);
            currentId++;
        }
        return tasks.values();
    }

    public static void deleteAll(){
        currentId = 1;
        tasks = new HashMap<>();
    }

    public static Task getTask(int taskId){
        if(tasks.containsKey(taskId)){
            return tasks.get(taskId);
        }
        return null;
    }

    public static Task updateTask(int taskId, Task newTask){
        tasks.put(taskId, newTask);
        return getTask(taskId);
    }

    public static void deleteTask(int id){
        tasks.remove(id);
    }
}
