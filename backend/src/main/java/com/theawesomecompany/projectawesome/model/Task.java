package com.theawesomecompany.projectawesome.model;

import com.theawesomecompany.projectawesome.model.enums.TaskStatus;

import javax.persistence.*;
import java.io.Serializable;


@Entity
public class Task implements Serializable{

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", taskName='" + taskName + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", taskStatus=" + taskStatus +
                ", taskBounty=" + taskBounty +
                '}';
    }
}
