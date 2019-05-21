package com.example.trymagazine;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;



public class NumbersAdapter extends RecyclerView.Adapter<NumbersAdapter.NumberViewHolder>{

    private static int viewHolderCount;
    private int numberItems;

    int i = 0;

    public NumbersAdapter(int numberOfItems) {
        numberItems = numberOfItems;
        viewHolderCount = 0;

    }

    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public NumberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.cards_activity;

        String[] names = new String[] {
                context.getResources().getString(R.string.comfort_2),
                context.getResources().getString(R.string.comfort_5),
                context.getResources().getString(R.string.comfort_7),
                context.getResources().getString(R.string.comfort_8),
                context.getResources().getString(R.string.comfort_9),
                context.getResources().getString(R.string.comfort_11),
                context.getResources().getString(R.string.comfort_13),
                context.getResources().getString(R.string.comfort_14),
                context.getResources().getString(R.string.comfort_15),
                context.getResources().getString(R.string.comfort_18),
                context.getResources().getString(R.string.comfort_19),
                context.getResources().getString(R.string.comfort_24),
                context.getResources().getString(R.string.comfort_34),
                context.getResources().getString(R.string.comfort_35)};

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutIdForListItem, parent, false);

        NumberViewHolder viewHolder = new NumberViewHolder(view);

        viewHolder.viewHolderIndex.setText("Модель: " + names[i]);
        viewHolder.imageView.setImageResource(R.drawable.k5);
        i++;
        viewHolderCount++;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NumberViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return numberItems;
    }

    class NumberViewHolder extends RecyclerView.ViewHolder {

        TextView listItemNumberView;
        TextView viewHolderIndex;
        ImageView imageView;

        public NumberViewHolder(@NonNull View itemView) {
            super(itemView);

            listItemNumberView = itemView.findViewById(R.id.name_of_model);
            viewHolderIndex = itemView.findViewById(R.id.action);
            imageView = itemView.findViewById(R.id.model_image);
        }

        void bind(int listIndex) {
            listItemNumberView.setText(String.valueOf(listIndex));

        }
    }
}
