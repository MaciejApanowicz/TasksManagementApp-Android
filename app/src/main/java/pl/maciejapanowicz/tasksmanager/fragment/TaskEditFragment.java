package pl.maciejapanowicz.tasksmanager.fragment;

import android.os.Bundle;

import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.util.Calendar;

import pl.maciejapanowicz.tasksmanager.activity.R;
import pl.maciejapanowicz.tasksmanager.activity.TaskEditActivity;
import pl.maciejapanowicz.tasksmanager.adapter.TaskListAdapter;
import pl.maciejapanowicz.tasksmanager.interfaces.OnTaskEditFinished;


public class TaskEditFragment extends Fragment {

    public static final String TASK_EDIT_FRAGMENT_TAG = "taskEditFragment";
    static final String TASK_DATE_AND_TIME = "taskDateAndTime";
    public String TASK_ID = "taskId";
    private static final int MENU_SAVE = 1;

    View rootView;
    EditText titleText;
    TextView taskTime;
    TextView taskDate;
    EditText notesText;
    ImageView imageView;
    long taskIdNumber;
    Calendar taskDateAndTime;

    public static TaskEditFragment newInstance(long taskIdNumber){
        TaskEditFragment fragment = new TaskEditFragment();
        Bundle data = new Bundle();
        data.putLong(TaskEditActivity.EXTRA_TASKID, taskIdNumber);
        fragment.setArguments(data);
        return fragment;
    }

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle arguments = getArguments();
        taskIdNumber = arguments.getLong(TaskEditActivity.EXTRA_TASKID);
        if (savedInstanceState != null) {
            taskIdNumber = savedInstanceState.getLong(TASK_ID);
            taskDateAndTime = (Calendar) savedInstanceState.getSerializable(TASK_DATE_AND_TIME);
        }
        if (taskDateAndTime == null){
            taskDateAndTime = Calendar.getInstance();
        }

    }

    @Override
    public void onSaveInstanceState (Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putLong(TASK_ID, taskIdNumber);
        outState.putSerializable(TASK_DATE_AND_TIME, taskDateAndTime);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_task_edit, container, false);
        rootView = view.getRootView();

        titleText = view.findViewById(R.id.task_title);
        taskTime = view.findViewById(R.id.task_time);
        taskDate = view.findViewById(R.id.task_date);
        notesText = view.findViewById(R.id.task_notes);
        imageView = view.findViewById(R.id.task_image);
        Picasso.with(getActivity())
                .load(TaskListAdapter.downloadPicturesForThisTask(taskIdNumber))
                .into(imageView);
        updateDateAndTime();
        return view;
    }

    @Override
    public void onActivityCreated (Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
        public void onCreateOptionsMenu (Menu menu, MenuInflater inflater){
        super.onCreateOptionsMenu(menu, inflater);

        menu.add(0, MENU_SAVE, 0, R.string.save)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        switch (item.getItemId()){
            case MENU_SAVE:
                // TODO: 30.06.2019 create a saving method
                ((OnTaskEditFinished) getActivity()).finishEditingTask();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void updateDateAndTime() {
        DateFormat timeFormat = DateFormat.getTimeInstance(DateFormat.SHORT);
        String timeForButton = timeFormat.format(taskDateAndTime.getTime());
        taskTime.setText(timeForButton);
        DateFormat dateFormat = DateFormat.getDateInstance();
        String dateForButton = dateFormat.format(taskDateAndTime.getTime());
        taskDate.setText(dateForButton);
    }

}
