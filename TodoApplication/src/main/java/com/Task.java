package com;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Task {
	
    public Task() {
		super();
	}

	private static long idCounter = 0;

    @Id
    private long id;
    private String description;
    private boolean isCompleted;

    public Task(String description) {
        this.id = ++idCounter;
        this.description = description;
        this.isCompleted = false;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}

