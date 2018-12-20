package com.theawesomecompany.projectawesome.Dao.impl;

import com.theawesomecompany.projectawesome.Dao.TaskDao;
import com.theawesomecompany.projectawesome.model.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class TaskDaoImpl implements TaskDao{


    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void save(Task task) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(task);
    }

    @Override
    public List<Task> loadAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Task> allTasks = session.createQuery("from TASK_tb").list();
        return allTasks;
    }

    @Override
    public Task findById(Long userId) {
        Session session = this.sessionFactory.getCurrentSession();
        Task task = (Task) session.load(Task.class, userId);
        return task;
    }
}
