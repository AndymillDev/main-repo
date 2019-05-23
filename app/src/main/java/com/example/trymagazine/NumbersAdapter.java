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

import java.util.HashMap;
import java.util.Map;


public class NumbersAdapter extends RecyclerView.Adapter<NumbersAdapter.NumberViewHolder>{

    private static int viewHolderCount;
    private int numberItems;
    NumberViewHolder viewHolder;
    public Map<Integer, String> names;
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
       
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutIdForListItem, parent, false);

        viewHolder = new NumberViewHolder(view);
        mSetCollection();
        viewHolder.imageView.setImageResource(R.drawable.k5);
        viewHolder.viewHolderIndex.setText("Модель: " + i + names.get(i));
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
    
    public void mSetCollection() {

        names = new HashMap<>();
            names.put(1, "comfort_2");
            names.put(2, "comfort_5");
            names.put(3, "comfort_7");
            names.put(4, "comfort_8");
            names.put(5, "comfort_9");
            names.put(6, "comfort_11");
            names.put(7, "comfort_13");
            names.put(8, "comfort_14");
            names.put(9, "comfort_15");
            names.put(10, "comfort_18");
            names.put(11, "comfort_19");
            names.put(12, "comfort_24");
            names.put(13, "comfort_34");
            names.put(14, "comfort_35");
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
