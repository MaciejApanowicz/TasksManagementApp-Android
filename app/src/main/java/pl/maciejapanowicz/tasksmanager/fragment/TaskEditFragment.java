package pl.maciejapanowicz.tasksmanager.fragment;

import android.os.Bundle;

import android.app.Fragment;
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
    long taskIdNumber;
    private String TASK_ID = "taskIdNumber";
    View rootView;
    EditText titleText;
    EditText notesText;
    ImageView imageView;

    public TaskEditFragment() {
    }

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle arguments = getArguments();
        if (arguments != null){
            taskIdNumber = arguments.getLong(TaskEditActivity.EXTRA_TASKID, 0L);
        }

        if (savedInstanceState != null) {
            taskIdNumber = savedInstanceState.getLong(TASK_ID);
        }

    }

    @Override
    public void onSaveInstanceState (Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putLong(TASK_ID, taskIdNumber);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_task_edit, container, false);
        rootView = view.getRootView();

        titleText = view.findViewById(R.id.task_title);
        notesText = view.findViewById(R.id.task_notes);
        imageView = view.findViewById(R.id.task_image);
        Picasso.with(getActivity())
                .load(TaskListAdapter.downloadPicturesForThisTask(taskIdNumber))
                .into(imageView);
        return view;
    }

    public static TaskEditFragment getInstance(long taskIdNumber){
        TaskEditFragment taskEditFragment = new TaskEditFragment();
        Bundle data = new Bundle();
        data.putLong(TaskEditActivity.EXTRA_TASKID, taskIdNumber);
        taskEditFragment.setArguments(data);
        return taskEditFragment;
    }

}
