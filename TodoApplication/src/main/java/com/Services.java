package com;

import java.util.List;
import java.util.Optional;

public interface Services {

    public List<Task> getAllTasks();

    public Optional<Task> getTaskById(long id);

    public Task addTask(String description);

    public boolean markTaskAsComplete(long id);

    public boolean removeTask(long id);
    
    
    
    
    
    
    public List<Task> getAllTasksDb();

    public Optional<Task> getTaskByIdDb(long id);

    public Task addTaskDb(String description);

    public boolean markTaskAsCompleteDb(long id);

    public boolean removeTaskDb(long id);
}
