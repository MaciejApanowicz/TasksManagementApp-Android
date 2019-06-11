package pl.maciejapanowicz.tasksmanager.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import pl.maciejapanowicz.tasksmanager.fragment.TaskEditFragment;

public class TaskEditActivity extends Activity {
    public static final String EXTRA_TASKID = "taskId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_edit);
        int taskID = getIntent().getIntExtra(TaskEditActivity.EXTRA_TASKID,0);
        Fragment fragment = TaskEditFragment.getInstance(taskID);
        String fragmentTag = TaskEditFragment.TASK_EDIT_FRAGMENT_TAG;
        if (savedInstanceState == null){
            getFragmentManager().beginTransaction().add(
                    R.id.container,
                    fragment,
                    fragmentTag).commit();
        }
    }
}
