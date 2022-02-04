package Main;

import Main.model.Task;
import Main.model.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class TaskRepositoryService implements Dao<Task> {

    @Autowired
    private TaskRepository taskRepository;

    public int add(Task task){
        Task newTask = taskRepository.save(task);
        return newTask.getId();
    }

    @Override
    public Optional<Task> get(int id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if(!optionalTask.isPresent()){
            return null;
        }
        return optionalTask;
    }

    @Override
    public List<Task> getAll() {
        Iterable<Task> taskIterable = taskRepository.findAll();
        ArrayList<Task> tasks = new ArrayList<>();
        for(Task task : taskIterable){
            tasks.add(task);
        }
        return tasks;
    }

    @Override
    public void save(Task task) {

    }

    public Task updateById(Task task){
        Task updatedTask = taskRepository.save(task);
        return updatedTask;
    }

    @Override
    public void update(String tasksStr) {
        deleteAll();
        String str = tasksStr.substring(1, tasksStr.length() - 1);
        String[] tasksStrArr = str.split(", ");
        Task[] tasks = new Task[tasksStrArr.length];
        for (int i = 0; i < tasksStrArr.length; i++) {
            tasks[i] = new Task(tasksStrArr[i]);
            taskRepository.save(tasks[i]);
        }
    }

    @Override
    public void delete(int id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        taskRepository.delete(optionalTask.get());
    }

    public void deleteAll(){
        taskRepository.deleteAll();
    }
}
