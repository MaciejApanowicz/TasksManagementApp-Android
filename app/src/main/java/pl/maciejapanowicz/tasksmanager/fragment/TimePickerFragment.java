package pl.maciejapanowicz.tasksmanager.fragment;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;

import java.util.Calendar;

public class TimePickerFragment extends DialogFragment {
    static final String MINS = "mins";
    static final String HOURS = "hours";

    public static TimePickerFragment newInstance (Calendar time) {
        TimePickerFragment timePickerFragment = new TimePickerFragment();

        Bundle data = new Bundle();
        data.putInt(HOURS, time.get(Calendar.HOUR_OF_DAY));
        data.putInt(MINS, time.get(Calendar.MINUTE));
        timePickerFragment.setArguments(data);
        return timePickerFragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        TimePickerDialog.OnTimeSetListener listener = (TimePickerDialog.OnTimeSetListener)
                getFragmentManager()
                        .findFragmentByTag(TaskEditFragment.TASK_EDIT_FRAGMENT_TAG);
        Bundle data = getArguments();

        return new TimePickerDialog(getActivity(), listener, data.getInt(HOURS), data.getInt(MINS), false);
    }

}
