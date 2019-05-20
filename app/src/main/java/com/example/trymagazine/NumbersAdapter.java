package com.example.trymagazine;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class NumbersAdapter extends RecyclerView.Adapter<NumbersAdapter.NumberViewHolder>{

    private static int viewHolderCount;
    private int numberItems;

    public NumbersAdapter(int numberOfItems) {
        numberItems = numberOfItems;
        viewHolderCount = 0;
    }

    @NonNull
    @Override
    public NumberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.cards_activity;

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutIdForListItem, parent, false);

        NumberViewHolder viewHolder = new NumberViewHolder(view);
        viewHolder.viewHolderIndex.setText("ViewHolder Index " + viewHolderCount);

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

        public NumberViewHolder(@NonNull View itemView) {
            super(itemView);

            listItemNumberView = itemView.findViewById(R.id.name_of_model);
            viewHolderIndex = itemView.findViewById(R.id.action);
        }

        void bind(int listIndex) {
            listItemNumberView.setText(String.valueOf(listIndex));
        }
    }
}
