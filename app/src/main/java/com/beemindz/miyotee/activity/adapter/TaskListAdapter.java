package com.beemindz.miyotee.activity.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Paint;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.beemindz.miyotee.R;
import com.beemindz.miyotee.dao.Task;
import com.beemindz.miyotee.util.CommonUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TaskListAdapter extends ArrayAdapter<Item> {

  //private static final String TAG = "TaskListAdapter";
  LayoutInflater inflater;
  private List<Item> tasks;
  private Context context;
  private ArrayList<Integer> colors;

  public TaskListAdapter(Context context, List<Item> tasks) {
    super(context, 0, tasks);
    this.context = context;
    this.tasks = tasks;
    inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    addBackgroundColor();
  }

  /**
   * Backgroup color item list.
   */
  private void addBackgroundColor() {
    colors = new ArrayList<Integer>();
    colors.add(R.color.GREEN_07ad4c);
    colors.add(R.color.GREEN_55b847);
    colors.add(R.color.GREEN_81c341);
    colors.add(R.color.GREEN_a5ce39);
    colors.add(R.color.GREEN_81c341);
    colors.add(R.color.GREEN_55b847);
    colors.add(R.color.GREEN_07ad4c);
    colors.add(R.color.GREEN_00a65c);
    colors.add(R.color.GREEN_00a76d);
    colors.add(R.color.GREEN_00a99d);
    colors.add(R.color.BLUE_00abc0);
    colors.add(R.color.BLUE_00adef);
    colors.add(R.color.BLUE_0094d9);
    colors.add(R.color.BLUE_0072bc);
    colors.add(R.color.BLUE_005eac);
    colors.add(R.color.BLUE_014fa3);
    colors.add(R.color.BLUE_223f99);
    colors.add(R.color.BLUE_014fa3);

    // complete
    colors.add(R.color.BLUE_005eac);
    colors.add(R.color.BLUE_0072bc);
    colors.add(R.color.BLUE_0094d9);
    colors.add(R.color.BLUE_00adef);
    colors.add(R.color.BLUE_00abc0);
    colors.add(R.color.GREEN_00a99d);
    colors.add(R.color.GREEN_00a76d);
    colors.add(R.color.GREEN_00a65c);
    colors.add(R.color.GREEN_07ad4c);
    colors.add(R.color.GREEN_55b847);
  }

  @SuppressLint("DefaultLocale")
  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    // color background.
    int sizeColor = colors.size();
    int colorPos = position % sizeColor;

    // get data item task for this position.
    final Item item = tasks.get(position);
    if (item != null) {
      if (!item.isSection()) {
        Task task = (Task) item;
        // Check if an existing view is being reused, otherwise inflate the

        // View lookup cache stored in tag
        ViewHolder viewHolder;
        //if (convertView == null) {
          viewHolder = new ViewHolder();
          //LayoutInflater inflater = LayoutInflater.from(context);
          convertView = inflater.inflate(R.layout.task_list_item, parent, false);
          viewHolder.tvTaskName = (TextView) convertView.findViewById(R.id.tvTaskName);
          viewHolder.tvDueDate = (TextView) convertView.findViewById(R.id.tv_due_date);
          viewHolder.imgReminder = (ImageView) convertView.findViewById(R.id.img_reminder_clock);
          convertView.setTag(viewHolder);
        //} else {
        //  viewHolder = (ViewHolder) convertView.getTag();
        //}

        int width = parent.getWidth();

        Log.d("===width list view====", "" + width + "; length:" + task.getTaskName().trim().length());

        Calendar dueDate = Calendar.getInstance();
        dueDate.setTime(task.getDueDate());
        String dueDateStr = (String) DateFormat.format(CommonUtils.getDateFormatSystem(context), dueDate);

        //viewHolder.tvTaskName.setIncludeFontPadding(false);
        if (task.getTaskName() != null) {
          viewHolder.tvTaskName.setText(cutStr(width, task.getTaskName().trim().toUpperCase()));
        }
        viewHolder.tvDueDate.setText(dueDateStr);
        if (task.getIsReminder()) {
          viewHolder.imgReminder.setVisibility(View.VISIBLE);
        } else {
          viewHolder.imgReminder.setVisibility(View.GONE);
        }

        // set color background item.
        convertView.setBackgroundResource(colors.get(colorPos));
        float alpha = 1;
        if (task.getIsComplete()) {
          alpha = 0.45f;
          viewHolder.tvTaskName.setPaintFlags(viewHolder.tvTaskName.getPaintFlags() | (Paint.STRIKE_THRU_TEXT_FLAG));
        } else if ((viewHolder.tvTaskName.getPaintFlags() & Paint.STRIKE_THRU_TEXT_FLAG) > 0) {
          viewHolder.tvTaskName.setPaintFlags(viewHolder.tvTaskName.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
        }

        //AlphaAnimation alphaUp = new AlphaAnimation(alpha, alpha);
        //alphaUp.setFillAfter(true);
        //viewHolder.tvTaskName.startAnimation(alphaUp);
      } else {
        SectionItem sectionItem = (SectionItem) item;
        //inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.task_item_section, parent, false);
        final TextView sectionView = (TextView) convertView.findViewById(R.id.list_item_section_text);
        sectionView.setText(sectionItem.getTitle());
        sectionView.setTextColor(context.getResources().getColor(android.R.color.white));
      }
    }

    return convertView;
  }

  private String cutStr(int width, String name) {

    if (width == 320 && name.length() > 15) {
      return String.format("%s ...", name.substring(0, 15));
    }

    if (width == 480 && name.length() > 25) {
      return String.format("%s ...", name.substring(0, 25));
    }

    if ((width == 720 || width == 768) && name.length() > 35) {
      return String.format("%s ...", name.substring(0, 35));
    }

    if (width >= 800 && name.length() > 45) {
      return String.format("%s ...", name.substring(0, 45));
    }

    return name;
  }

  /**
   * View lookup cache
   */
  private static class ViewHolder {
    TextView tvTaskName;
    TextView tvDueDate;
    ImageView imgReminder;
  }
}
