package com.example.emb_madhtom.inheritancedemo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class CollegeListAdapter extends RecyclerView.Adapter<CollegeListAdapter.CollegeListViewHolder> {

    private List<University> universities;

    public CollegeListAdapter(List<University> universities)
    {

        this.universities = universities;
    }


    @NonNull
    @Override
    public CollegeListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_college_list,
                parent, false);
        // set the view's size, margins, paddings and layout parameters
        CollegeListViewHolder viewholder = new CollegeListViewHolder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull CollegeListViewHolder collegeListViewHolder, int i) {
collegeListViewHolder.textView.setText(universities.get(i).college.getName());
    }

    @Override
    public int getItemCount() {
        return universities.size();
    }

    protected class CollegeListViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public CollegeListViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=(TextView)itemView.findViewById(R.id.tv_item_college_list);
        }
    }
}
