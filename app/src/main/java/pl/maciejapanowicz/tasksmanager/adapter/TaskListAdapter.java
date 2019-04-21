package pl.maciejapanowicz.tasksmanager.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import pl.maciejapanowicz.tasksmanager.activity.R;

public class TaskListAdapter extends RecyclerView.Adapter<TaskListAdapter.ViewHolder> {

    static String [] sampleData = new String[]{
        "first task",
        "second task",
        "third task",
        "fourth task",
        "fifth task",
        "sixth task"
    };

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_task,parent,false);
        return new ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.titleView.setText(sampleData[i]);
    }

    @Override
    public int getItemCount() {
        return sampleData.length;
    }

    static class  ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView titleView;

        public ViewHolder (CardView singleCard){
            super(singleCard);
            cardView = singleCard;
            titleView = (TextView)singleCard.findViewById(R.id.title);
        }
    }
}
