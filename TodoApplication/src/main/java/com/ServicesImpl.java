package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServicesImpl implements Services{

    private final List<Task> tasks = new ArrayList<>();
    @Autowired
    Repository repository;

    public List<Task> getAllTasks() {
        return tasks;
    }

    public Optional<Task> getTaskById(long id) {
        return tasks.stream().filter(task -> task.getId() == id).findFirst();
    }

    public Task addTask(String description) {
        Task newTask = new Task(description);
        tasks.add(newTask);
        return newTask;
    }

    public boolean markTaskAsComplete(long id) {
        Optional<Task> task = getTaskById(id);
        if (task.isPresent()) {
        	if(task.get().isCompleted())
        		return false;
            task.get().setCompleted(true);
            return true;
        }
        return false;
    }

    public boolean removeTask(long id) {
        return tasks.removeIf(task -> task.getId() == id);
    }
    
    
    
    
    
    
    
    
    
    
    public List<Task> getAllTasksDb() {
        return repository.findAll();
    }

    public Optional<Task> getTaskByIdDb(long id) {
    	
        return repository.findById(id);
    }

    public Task addTaskDb(String description) {
        Task newTask = new Task(description);
        return repository.save(newTask);
    }

    public boolean markTaskAsCompleteDb(long id) {
        Optional<Task> task = repository.findById(id);
        if (task.isPresent()) {
        	if(task.get().isCompleted())
        		return false;
            task.get().setCompleted(true);
            repository.save(task.get());
            return true;
        }
        return false;
    }

    public boolean removeTaskDb(long id) {
    	if(repository.existsById(id)) {
    		repository.deleteById(id);
    		return true;
    	}
    	else
    		return false;
    }
}

