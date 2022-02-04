package Main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import Main.model.Task;

import java.util.List;

@RestController
public class TaskController{
    @Autowired
    private TaskRepositoryService service;

    @GetMapping("/tasks/")
    public List<Task> list(){
        return service.getAll();
    }

    @PostMapping("/tasks/")
    public int add(Task task){
        return service.add(task);
    }

    @PutMapping("/tasks/")
    public void updateAll(String tasksStr){
        service.update(tasksStr);
    }

    @DeleteMapping("/tasks/")
    public void deleteAll(){
        service.deleteAll();
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity get(@PathVariable int id){
        if(service.get(id) == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(service.get(id).get(), HttpStatus.OK);
    }

    @PostMapping("/tasks/{id}")
    public ResponseEntity postId(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(null);
    }

    @PutMapping("/tasks/{id}")
    public Task updateTask(@PathVariable int id, Task task){
        return service.updateById(task);
    }

    @DeleteMapping("/tasks/{id}")
    public void deleteTask(@PathVariable int id){
        service.delete(id);
    }
}
