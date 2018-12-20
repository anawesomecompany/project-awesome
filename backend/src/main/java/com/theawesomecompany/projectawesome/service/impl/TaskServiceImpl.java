package com.theawesomecompany.projectawesome.service.impl;

import com.theawesomecompany.projectawesome.Dao.TaskDao;
import com.theawesomecompany.projectawesome.model.Task;
import com.theawesomecompany.projectawesome.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    TaskDao taskDao;


    @Override
    @Transactional
    public void save(Task task) {
        taskDao.save(task);
    }

    @Override
    @Transactional
    public List<Task> loadAll() {
        return taskDao.loadAll();
    }

    @Override
    @Transactional
    public Task findById(Long userId) {
        return taskDao.findById(userId);
    }
}
