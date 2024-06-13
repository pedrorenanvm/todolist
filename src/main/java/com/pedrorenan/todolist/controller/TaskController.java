package com.pedrorenan.todolist.controller;

import com.pedrorenan.todolist.model.Task;
import com.pedrorenan.todolist.service.TaskService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("api/v1")
@AllArgsConstructor
@Slf4j
public class TaskController {

    TaskService taskService;


    @PostMapping("/tasks")
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTask(@RequestBody Task task){
        log.info("Criando uma nova tarefa[{}]",task);
        return taskService.createTask(task);
    }

    @GetMapping("/tasks")
    @ResponseStatus(HttpStatus.OK)
    public List<Task> getAllTasks(){
        log.info("Listando tarefas cadastradas");
        return taskService.listAllTaskes();
    }

    @GetMapping("/tasks/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Task> getTaskById(@PathVariable (value = "id") Long id){
        log.info("Buscando a tarefa por id [{}]",id);
        return taskService.findTaskById(id);

    }
    @PutMapping("/tasks/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Task> getTaskById(@PathVariable (value = "id") Long id,@RequestBody Task task){
        log.info("Atualizando a tarefa com id [{}] as novas informações são: [{}]",id,task);
        return taskService.updateTaskById(task,id);

    }
    @DeleteMapping("/tasks/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deleteTaskById(@PathVariable (value = "id") Long id){
        log.info("Excluindo tarefas com o id [{}]",id);
        return taskService.deleteById(id);

    }
}
