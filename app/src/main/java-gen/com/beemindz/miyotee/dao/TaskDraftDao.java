package com.beemindz.miyotee.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import com.beemindz.miyotee.dao.TaskDraft;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table TASK_DRAFT.
*/
public class TaskDraftDao extends AbstractDao<TaskDraft, Long> {

    public static final String TABLENAME = "TASK_DRAFT";

    /**
     * Properties of entity TaskDraft.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property TaskId = new Property(1, Integer.class, "taskId", false, "TASK_ID");
        public final static Property UserName = new Property(2, String.class, "userName", false, "USER_NAME");
        public final static Property TaskName = new Property(3, String.class, "taskName", false, "TASK_NAME");
        public final static Property TaskDescription = new Property(4, String.class, "taskDescription", false, "TASK_DESCRIPTION");
        public final static Property ReminderDate = new Property(5, java.util.Date.class, "reminderDate", false, "REMINDER_DATE");
        public final static Property IsReminder = new Property(6, Boolean.class, "isReminder", false, "IS_REMINDER");
        public final static Property IsComplete = new Property(7, Boolean.class, "isComplete", false, "IS_COMPLETE");
        public final static Property CreatedDate = new Property(8, java.util.Date.class, "createdDate", false, "CREATED_DATE");
        public final static Property UpdatedDate = new Property(9, java.util.Date.class, "updatedDate", false, "UPDATED_DATE");
        public final static Property Status = new Property(10, Integer.class, "status", false, "STATUS");
    };


    public TaskDraftDao(DaoConfig config) {
        super(config);
    }
    
    public TaskDraftDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'TASK_DRAFT' (" + //
                "'_id' INTEGER PRIMARY KEY ," + // 0: id
                "'TASK_ID' INTEGER," + // 1: taskId
                "'USER_NAME' TEXT," + // 2: userName
                "'TASK_NAME' TEXT," + // 3: taskName
                "'TASK_DESCRIPTION' TEXT," + // 4: taskDescription
                "'REMINDER_DATE' INTEGER," + // 5: reminderDate
                "'IS_REMINDER' INTEGER," + // 6: isReminder
                "'IS_COMPLETE' INTEGER," + // 7: isComplete
                "'CREATED_DATE' INTEGER," + // 8: createdDate
                "'UPDATED_DATE' INTEGER," + // 9: updatedDate
                "'STATUS' INTEGER);"); // 10: status
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'TASK_DRAFT'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, TaskDraft entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Integer taskId = entity.getTaskId();
        if (taskId != null) {
            stmt.bindLong(2, taskId);
        }
 
        String userName = entity.getUserName();
        if (userName != null) {
            stmt.bindString(3, userName);
        }
 
        String taskName = entity.getTaskName();
        if (taskName != null) {
            stmt.bindString(4, taskName);
        }
 
        String taskDescription = entity.getTaskDescription();
        if (taskDescription != null) {
            stmt.bindString(5, taskDescription);
        }
 
        java.util.Date reminderDate = entity.getReminderDate();
        if (reminderDate != null) {
            stmt.bindLong(6, reminderDate.getTime());
        }
 
        Boolean isReminder = entity.getIsReminder();
        if (isReminder != null) {
            stmt.bindLong(7, isReminder ? 1l: 0l);
        }
 
        Boolean isComplete = entity.getIsComplete();
        if (isComplete != null) {
            stmt.bindLong(8, isComplete ? 1l: 0l);
        }
 
        java.util.Date createdDate = entity.getCreatedDate();
        if (createdDate != null) {
            stmt.bindLong(9, createdDate.getTime());
        }
 
        java.util.Date updatedDate = entity.getUpdatedDate();
        if (updatedDate != null) {
            stmt.bindLong(10, updatedDate.getTime());
        }
 
        Integer status = entity.getStatus();
        if (status != null) {
            stmt.bindLong(11, status);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public TaskDraft readEntity(Cursor cursor, int offset) {
        TaskDraft entity = new TaskDraft( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1), // taskId
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // userName
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // taskName
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // taskDescription
            cursor.isNull(offset + 5) ? null : new java.util.Date(cursor.getLong(offset + 5)), // reminderDate
            cursor.isNull(offset + 6) ? null : cursor.getShort(offset + 6) != 0, // isReminder
            cursor.isNull(offset + 7) ? null : cursor.getShort(offset + 7) != 0, // isComplete
            cursor.isNull(offset + 8) ? null : new java.util.Date(cursor.getLong(offset + 8)), // createdDate
            cursor.isNull(offset + 9) ? null : new java.util.Date(cursor.getLong(offset + 9)), // updatedDate
            cursor.isNull(offset + 10) ? null : cursor.getInt(offset + 10) // status
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, TaskDraft entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setTaskId(cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1));
        entity.setUserName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setTaskName(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setTaskDescription(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setReminderDate(cursor.isNull(offset + 5) ? null : new java.util.Date(cursor.getLong(offset + 5)));
        entity.setIsReminder(cursor.isNull(offset + 6) ? null : cursor.getShort(offset + 6) != 0);
        entity.setIsComplete(cursor.isNull(offset + 7) ? null : cursor.getShort(offset + 7) != 0);
        entity.setCreatedDate(cursor.isNull(offset + 8) ? null : new java.util.Date(cursor.getLong(offset + 8)));
        entity.setUpdatedDate(cursor.isNull(offset + 9) ? null : new java.util.Date(cursor.getLong(offset + 9)));
        entity.setStatus(cursor.isNull(offset + 10) ? null : cursor.getInt(offset + 10));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(TaskDraft entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(TaskDraft entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
