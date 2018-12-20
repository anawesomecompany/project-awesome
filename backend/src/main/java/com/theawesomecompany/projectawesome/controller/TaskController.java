package com.theawesomecompany.projectawesome.controller;


import com.theawesomecompany.projectawesome.model.Task;
import com.theawesomecompany.projectawesome.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/task")
@CrossOrigin
public class TaskController {


    @Autowired
    TaskService taskService;

    @PostMapping("")
    public ResponseEntity createTask(@RequestBody Task task,BindingResult result){
        if(result.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();

            for (FieldError error : result.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }

            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }

        taskService.save(task);

        return new ResponseEntity<Task>(task,HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public Iterable<Task> loadAllTasks(){
        return taskService.loadAll();
    }

    @GetMapping("/{user_id}")
    public ResponseEntity<?> findTaskById(@PathVariable Long user_id){

        Task task = taskService.findById(user_id);
        return new ResponseEntity<Task>(task, HttpStatus.OK);
    }
}
