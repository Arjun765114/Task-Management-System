package com.task.TaskManagement.service;

import com.task.TaskManagement.entity.Task;

import java.util.List;

public interface TaskService {
    Task SaveTask(Task task);

    List<Task> getAllTask();
}
