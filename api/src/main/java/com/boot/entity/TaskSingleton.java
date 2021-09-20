package com.boot.entity;

import java.util.HashMap;

public class TaskSingleton {

    private static TaskSingleton instance = null;
    private static HashMap<String, Long> taskProgress;
    private static HashMap<String, String> taskData;

    public static TaskSingleton getInstance(){
        if(instance==null){
            synchronized (TaskSingleton.class){
                if(instance==null){
                    instance = new TaskSingleton();
                }
            }
        }
        return instance;
    }

    public HashMap<String, Long> getTaskProgress() {
        return taskProgress;
    }

    public void setTaskProgress(String taskName, Long progress) {
        if(TaskSingleton.taskProgress==null){
            TaskSingleton.taskProgress= new HashMap<>();
        }
        if(TaskSingleton.taskProgress.containsKey(taskName)){
            TaskSingleton.taskProgress.replace(taskName,progress);
        }else{
            TaskSingleton.taskProgress.put(taskName,progress);
        }
    }

    public HashMap<String, String> getTaskData() {
        return taskData;
    }

    public void setTaskData(String taskName, String taskData) {
        if(TaskSingleton.taskData==null){
            TaskSingleton.taskData= new HashMap<>();
        }
        if(TaskSingleton.taskData.containsKey(taskName)){
            TaskSingleton.taskData.replace(taskName,taskData);
        }else{
            TaskSingleton.taskData.put(taskName,taskData);
        }
    }
}
