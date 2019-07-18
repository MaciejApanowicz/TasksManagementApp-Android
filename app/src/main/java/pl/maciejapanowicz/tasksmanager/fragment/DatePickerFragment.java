package pl.maciejapanowicz.tasksmanager.fragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment {
    static final String DAY = "day";
    static final String MONTH = "month";
    static final String YEAR = "year";

    public static DatePickerFragment newInstance(Calendar date) {
        DatePickerFragment datePickerFragment = new DatePickerFragment();

        Bundle data = new Bundle();
        data.putInt(DAY, date.get(Calendar.DAY_OF_MONTH));
        data.putInt(MONTH, date.get(Calendar.MONTH));
        data.putInt(YEAR, date.get(Calendar.YEAR));
        datePickerFragment.setArguments(data);

        return datePickerFragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        DatePickerDialog.OnDateSetListener callback = (DatePickerDialog.OnDateSetListener)
                getFragmentManager()
                        .findFragmentByTag(TaskEditFragment.TASK_EDIT_FRAGMENT_TAG);

        Bundle data = getArguments();
        return new DatePickerDialog(
                getActivity(),
                callback,
                data.getInt(DAY),
                data.getInt(MONTH),
                data.getInt(YEAR));
     }
}

