package com.theawesomecompany.projectawesome.service;

import com.theawesomecompany.projectawesome.model.Task;

import java.util.List;

public interface TaskService {

    void save(Task task);
    List<Task> loadAll();
    Task findById(Long userId);
}
