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
    public String TASK_ID = "taskId";

    public static TaskEditFragment newInstance(long taskIdNumber){
        TaskEditFragment fragment = new TaskEditFragment();
        Bundle data = new Bundle();
        data.putLong(TaskEditActivity.EXTRA_TASKID, taskIdNumber);
        fragment.setArguments(data);
        return fragment;
    }

    View rootView;
    EditText titleText;
    EditText notesText;
    ImageView imageView;

    long taskIdNumber;

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle arguments = getArguments();
        taskIdNumber = arguments.getLong(TaskEditActivity.EXTRA_TASKID);
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


}
