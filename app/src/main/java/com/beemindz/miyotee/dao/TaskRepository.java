package com.beemindz.miyotee.dao;

import android.content.Context;
import android.util.Log;

import com.beemindz.miyotee.MiyoteeApplication;
import com.beemindz.miyotee.util.Constant;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

/**
 * Created by Sony on 7/31/2014.
 */
public class TaskRepository {
  public static long insertOrUpdate(Context context, Task task) {
    if (task != null) {
//      Long idTemp = task.getId();
      Long id = getTaskDao(context).insertOrReplace(task);
      TaskDraft draft = new TaskDraft();
      convertToTaskDraft(draft, task);
      if (draft.getTaskId() != null) {
        draft.setStatus(Constant.TASK_DRAFT_STATUS_UPDATE);
      } else {
        draft.setStatus(Constant.TASK_DRAFT_STATUS_INSERT);
      }
      Long idDraft = TaskDraftRepository.insertOrUpdate(context, draft);
      Log.d("Insert Task ", "Id : " + id);
      Log.d("Insert Task Draft", "Id : " + idDraft);

      /*
      //Insert taskDraft with status = update
      if (idTemp != null) {
        TaskDraft taskDraft = TaskDraftRepository.getTaskDraftForId(context,idTemp);
        if (taskDraft != null) {
          convertToTaskDraft(taskDraft, task);
          if (task.getTaskId() != null) {
            taskDraft.setStatus(Constant.TASK_DRAFT_STATUS_UPDATE);
          } else {
            taskDraft.setStatus(Constant.TASK_DRAFT_STATUS_INSERT);
          }

          Long idDraft = TaskDraftRepository.insertOrUpdate(context, taskDraft);

          Log.d("Insert Task Draft", "Id : " + idDraft);
        }
        Log.d("Update Task ", "Id : " + idTemp);

      } else { //Insert taskDraft with status = insert
        TaskDraft taskDraft = new TaskDraft();
        convertToTaskDraft(taskDraft, task);
        taskDraft.setId(id);
        taskDraft.setStatus(Constant.TASK_DRAFT_STATUS_INSERT);
        Long idDraft = TaskDraftRepository.insertOrUpdate(context, taskDraft);
        Log.d("Insert Task ", "Id : " + id);
        Log.d("Insert Task Draft", "Id : " + idDraft);
      }*/

      return id;
    }
    return 0;
  }

  public static void clearTasks(Context context) {
    getTaskDao(context).deleteAll();
  }

  public static void deleteTaskWithId(Context context, long id) {
    Task task = getTaskForId(context, id);
    if (task != null) {
      TaskDraft taskDraft = new TaskDraft();
      convertToTaskDraft(taskDraft, task);
      getTaskDao(context).delete(task);
      taskDraft.setStatus(Constant.TASK_DRAFT_STATUS_DELETE);
      Long idTaskDraft = TaskDraftRepository.insertOrUpdate(context, taskDraft);
      Log.d("Insert status delete : ", idTaskDraft.toString());
    }
  }

  public static List<Task> getAllTasks(Context context) {
    return getTaskDao(context).loadAll();
  }

  public static Task getTaskForId(Context context, long id) {
    return getTaskDao(context).load(id);
  }

  private static TaskDao getTaskDao(Context c) {
    return ((MiyoteeApplication) c.getApplicationContext()).getDaoSession().getTaskDao();
  }

  private static TaskDraft convertToTaskDraft(TaskDraft taskDraft, Task task) {

    taskDraft.setId(task.getId());
    taskDraft.setTaskId(task.getTaskId());
    taskDraft.setTaskName(task.getTaskName());
    taskDraft.setTaskDescription(task.getTaskDescription());
    taskDraft.setDueDate(task.getDueDate());
    taskDraft.setReminderDate(task.getReminderDate());
    taskDraft.setIsReminder(task.getIsReminder());
    taskDraft.setIsDueDate(task.getIsDueDate());
    taskDraft.setIsComplete(task.getIsComplete());
    taskDraft.setCreatedDate(task.getCreatedDate());
    taskDraft.setUpdatedDate(task.getUpdatedDate());

    return taskDraft;
  }

}
