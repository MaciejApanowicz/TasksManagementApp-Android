package pl.maciejapanowicz.tasksmanager.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import pl.maciejapanowicz.tasksmanager.activity.R;
import pl.maciejapanowicz.tasksmanager.interfaces.OnTaskEdit;

public class TaskListAdapter extends RecyclerView.Adapter<TaskListAdapter.ViewHolder> {

    private static final String downloadPicturesFromThisUrl = "http://lorempixel.com/600/400/city/?fakeId";
    private static String[] sampleData = new String[]{
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
                .inflate(R.layout.item_task, parent, false);
        return new ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int taskIndex) {
        final Context context = viewHolder.titleView.getContext();

        viewHolder.titleView.setText(sampleData[taskIndex]);
        Picasso.with(context)
                .load(downloadPicturesFromThisUrl)
                .into(viewHolder.imageView);

        viewHolder.cardView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ((OnTaskEdit) context).editTask(viewHolder.getAdapterPosition());
                    }
                }
        );
    }

    @Override
    public int getItemCount() {
        return sampleData.length;
    }

    public static String downloadPicturesForThisTask (int taskId) {
        return downloadPicturesFromThisUrl+"="+taskId;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView titleView;
        ImageView imageView;

        private ViewHolder(CardView singleCard) {
            super(singleCard);
            cardView = singleCard;
            titleView = (TextView) singleCard.findViewById(R.id.title);
            imageView = (ImageView) singleCard.findViewById(R.id.image);
        }
    }
}
