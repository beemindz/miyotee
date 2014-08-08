package com.beemindz.miyotee.util;

public class Constant {

  public static final String URL_HOST = "http://192.168.1.77/miyotee-service/";
  public static final String ACCOUNT_TYPE = "com.beemindz.miyotee";
  public static final String DATE_FORMAT = "yyyy-MM-dd";
  public static final String TIME_FORMAT = "kk:mm";
  public static final String DATE_TIME_FORMAT = "yyyy-MM-dd kk:mm:ss";
  
  public static final int TASK_DRAFT_STATUS_INSERT = 1;
  public static final int TASK_DRAFT_STATUS_UPDATE = 2;
  public static final int TASK_DRAFT_STATUS_DELETE = 3;

  public static final String GOOGLE_ANALYTICS_API = "UA-38082894-3";
  
  public static final String FB_ACCESSTOKEN = "fbAccessToken";
  public static final String FB_MIYOTEE_ID = "160310317499004";
  public static final String FB_MIYOTEE_NAME = "miyoteeapp";
  public static final String USERNAME = "username";
  public static final String FULL_NAME = "fullName";
  
  public static final String ADMOD_APP_NAME = "Miyotee";
  public static final String ADMOD_UNIT_NAME = "Bottom Banner";
  public static final String ADMOD_UNIT_ID = "ca-app-pub-8021202070896817/5741420082";
  
  public static final int ADDED_MINUTE = 15;
  
  public static final int VIBRATE_MINUTE = 5000 * 60;

  public static final String KEY_TASK_ID = "taskId";
  public static final String KEY_TASK_NAME = "taskName";
  public static final String KEY_TASK_DESCRIPTION = "taskDescription";
  public static final String KEY_TASK_REMINDER_DATE = "taskReminderDate";

  public static class JsonNoteName {
    public static final String TASK_ID = "taskId";
    public static final String TASK_NAME = "taskName";
    public static final String TASK_DESCRIPTION = "taskDescription";
    public static final String TASK_DUE_DATE = "dueDate";
    public static final String TASK_REMINDER_DATE = "reminderDate";
    public static final String TASK_IS_REMINDER = "isReminder";
    public static final String TASK_IS_DUE_DATE = "isDueDate";
    public static final String TASK_IS_COMPLETE = "isComplete";
    public static final String TASK_CREATED_DATE = "createdDate";
    public static final String TASK_UPDATED_DATE = "updatedDate";
  }

  public static final String REST_URL_FORGOT_PASSWORD = "http://ohoh123.byethost8.com/api.miyotee/forgot_pass.php";
}
