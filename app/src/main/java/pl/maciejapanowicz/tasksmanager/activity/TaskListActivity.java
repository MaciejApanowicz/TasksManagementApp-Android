package pl.maciejapanowicz.tasksmanager.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toolbar;

import pl.maciejapanowicz.tasksmanager.interfaces.OnTaskEdit;

public class TaskListActivity extends Activity implements OnTaskEdit {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);
        setActionBar((Toolbar) findViewById(R.id.toolbar));
    }

    @Override
    public void editTask(long id) {
        startActivity(new Intent(this, TaskEditActivity.class)
        .putExtra(TaskEditActivity.EXTRA_TASKID, id));
    }
}
