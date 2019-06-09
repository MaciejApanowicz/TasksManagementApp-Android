package pl.maciejapanowicz.tasksmanager.activity;

import android.app.Activity;
import android.os.Bundle;

public class TaskEditActivity extends Activity {
    public static final String EXTRA_TASKID = "taskId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_edit);
    }
}
