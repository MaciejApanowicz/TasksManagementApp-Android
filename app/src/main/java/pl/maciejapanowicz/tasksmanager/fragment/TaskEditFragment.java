package pl.maciejapanowicz.tasksmanager.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import pl.maciejapanowicz.tasksmanager.activity.R;


public class TaskEditFragment extends Fragment {
    View rootView;
    EditText titleText;
    EditText notesText;
    ImageView imageView;

    public TaskEditFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_task_edit, container, false);
        rootView = view.getRootView();

        titleText = view.findViewById(R.id.task_title);
        notesText = view.findViewById(R.id.notes);
        imageView = view.findViewById(R.id.task_image);

        TextView textView = new TextView(getActivity());
        textView.setText(R.string.hello_blank_fragment);
        return textView;
    }

}
