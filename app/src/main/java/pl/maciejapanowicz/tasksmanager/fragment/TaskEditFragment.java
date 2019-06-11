package pl.maciejapanowicz.tasksmanager.fragment;


import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import pl.maciejapanowicz.tasksmanager.activity.R;
import pl.maciejapanowicz.tasksmanager.activity.TaskEditActivity;
import pl.maciejapanowicz.tasksmanager.adapter.TaskListAdapter;


public class TaskEditFragment extends Fragment {

    public static final String TASK_EDIT_FRAGMENT_TAG = "taskEditFragment";
    private int taskIdNumber;
    private String TASK_ID_NUMBER = "taskIdNumber";
    View rootView;
    EditText titleText;
    EditText notesText;
    ImageView imageView;

    public TaskEditFragment() {
    }

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle data = getArguments();
        if (savedInstanceState != null) {
            assert data != null;
            taskIdNumber = data.getInt(TASK_ID_NUMBER);
        }
    }

    @Override
    public void onSaveInstanceState (Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(TASK_ID_NUMBER, taskIdNumber);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_task_edit, container, false);
        rootView = view.getRootView();
        titleText = view.findViewById(R.id.task_title);
        notesText = view.findViewById(R.id.notes);
        imageView = view.findViewById(R.id.task_image);
        Picasso.with(getActivity())
                .load(TaskListAdapter.downloadPicturesForThisTask(taskIdNumber))
                .into(imageView);
        return view;
    }

    public static TaskEditFragment getInstance(int taskIdNumber){
        TaskEditFragment taskEditFragment = new TaskEditFragment();
        Bundle data = new Bundle();
        data.putInt(TaskEditActivity.EXTRA_TASKID, taskIdNumber);
        taskEditFragment.setArguments(data);
        return taskEditFragment;
    }

}
