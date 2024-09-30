package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class Controller {

	@Autowired
    private Services service;

    // Add a new task
    @PostMapping
    public ResponseEntity<Task> addTask(@RequestBody String description) {
        Task newTask = service.addTask(description);
        return new ResponseEntity<>(newTask, HttpStatus.CREATED);
    }

    // Mark a task as complete
    @PutMapping("/{id}/complete")
    public ResponseEntity<String> markTaskAsComplete(@PathVariable long id) {
        boolean result = service.markTaskAsComplete(id);
        if (result) {
            return new ResponseEntity<>("Task marked as complete.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Task not updated.", HttpStatus.NOT_FOUND);
        }
    }

    // Remove a task
    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeTask(@PathVariable long id) {
        boolean result = service.removeTask(id);
        if (result) {
            return new ResponseEntity<>("Task removed.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Task not found.", HttpStatus.NOT_FOUND);
        }
    }

    // View all tasks
    @GetMapping
    public List<Task> getAllTasks() {
        return service.getAllTasks();
    }
    
    
    
    
    
    
    
    
    
    
    @PostMapping("/db")
    public ResponseEntity<Task> addTaskDb(@RequestBody String description) {
        Task newTask = service.addTaskDb(description);
        return new ResponseEntity<>(newTask, HttpStatus.CREATED);
    }

    // Mark a task as complete
    @PutMapping("/db/{id}/complete")
    public ResponseEntity<String> markTaskAsCompleteDb(@PathVariable long id) {
        boolean result = service.markTaskAsCompleteDb(id);
        if (result) {
            return new ResponseEntity<>("Task marked as complete.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Task not updated.", HttpStatus.NOT_FOUND);
        }
    }

    // Remove a task
    @DeleteMapping("/db/{id}")
    public ResponseEntity<String> removeTaskDb(@PathVariable long id) {
        boolean result = service.removeTaskDb(id);
        if (result) {
            return new ResponseEntity<>("Task removed.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Task not found.", HttpStatus.NOT_FOUND);
        }
    }

    // View all tasks
    @GetMapping("/db")
    public List<Task> getAllTasksDb() {
        return service.getAllTasksDb();
    }
}

