package com.theawesomecompany.projectawesome.service.impl;

import com.theawesomecompany.projectawesome.Dao.TaskDao;
import com.theawesomecompany.projectawesome.model.Task;
import com.theawesomecompany.projectawesome.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    TaskDao taskDao;


    @Override
    public void save(Task task) {
        taskDao.save(task);
    }

    @Override
    public List<Task> loadAll() {
        return taskDao.loadAll();
    }

    @Override
    public Task findById(Long userId) {
        return taskDao.findById(userId);
    }
}
