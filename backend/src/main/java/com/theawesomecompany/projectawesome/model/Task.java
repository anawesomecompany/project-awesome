package com.theawesomecompany.projectawesome.model;

import com.theawesomecompany.projectawesome.model.enums.TaskStatus;

import java.io.Serializable;

public class Task implements Serializable{

    private String taskName;
    private String taskDescription;
    private TaskStatus taskStatus;
    private double taskBounty;

    public Task() {
    }

    public Task(String taskName, String taskDescription, TaskStatus taskStatus, double taskBounty) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskStatus = taskStatus;
        this.taskBounty = taskBounty;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public double getTaskBounty() {
        return taskBounty;
    }

    public void setTaskBounty(double taskBounty) {
        this.taskBounty = taskBounty;
    }
}
