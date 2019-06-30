package pl.maciejapanowicz.tasksmanager.activity;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.widget.Toolbar;

import pl.maciejapanowicz.tasksmanager.fragment.TaskEditFragment;
import pl.maciejapanowicz.tasksmanager.interfaces.OnTaskEditFinished;


public class TaskEditActivity extends Activity implements OnTaskEditFinished {
    public static final String EXTRA_TASKID = "taskId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_edit);
        setActionBar((Toolbar) findViewById(R.id.toolbar));

        long taskID = getIntent().getLongExtra(TaskEditActivity.EXTRA_TASKID, 0);
        System.out.println(taskID);
        Fragment fragment = TaskEditFragment.newInstance(taskID);
        String fragmentTag = TaskEditFragment.TASK_EDIT_FRAGMENT_TAG;
        if (savedInstanceState == null){
            getFragmentManager().beginTransaction().add(
                    R.id.container,
                    fragment,
                    fragmentTag).commit();
        }
    }

    @Override
    public void finishEditingTask() {
        finish();
    }
}
