package com.beemindz.miyotee.dao;

import android.content.Context;

import com.beemindz.miyotee.MiyoteeApplication;

import java.util.List;

public class TaskDraftRepository {
  public static long insertOrUpdate(Context context, TaskDraft taskDraft) {
    return getTaskDraftDao(context).insertOrReplace(taskDraft);
  }

  public static void clearTaskDrafts(Context context) {
    getTaskDraftDao(context).deleteAll();
  }

  public static void deleteTaskDraftWithId(Context context, long id) {
    getTaskDraftDao(context).delete(getTaskDraftForId(context, id));
  }

  public static List<TaskDraft> getAllTaskDrafts(Context context) {
    return getTaskDraftDao(context).loadAll();
  }

  public static TaskDraft getTaskDraftForId(Context context, long id) {
    return getTaskDraftDao(context).load(id);
  }

  private static TaskDraftDao getTaskDraftDao(Context c) {
    return ((MiyoteeApplication) c.getApplicationContext()).getDaoSession().getTaskDraftDao();
  }
}
