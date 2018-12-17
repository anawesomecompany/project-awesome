package com.theawesomecompany.projectawesome.Dao;

import com.theawesomecompany.projectawesome.model.Task;

import java.io.Serializable;
import java.util.List;

public interface TaskDao {
    void save(Task task);
    List<Task> loadAll();

    Task findById(Long userId);
}
