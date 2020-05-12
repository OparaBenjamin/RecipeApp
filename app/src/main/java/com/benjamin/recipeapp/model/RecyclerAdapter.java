package com.benjamin.recipeapp.model;

/*
 * Created by OPARA BENJAMIN
 * On 5/12/2020 - 9:12 PM
 */

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.benjamin.recipeapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    List<RecipeResult.RecipesBean> mRecipesBeans;
    Context mContext;

    public RecyclerAdapter(List<RecipeResult.RecipesBean> recipesBeans, Context context) {
        mRecipesBeans = recipesBeans;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Picasso.with(mContext).load(mRecipesBeans.get(position).getImage());
        viewHolder.titleTV.setText(mRecipesBeans.get(position).getTitle());
        viewHolder.timeTV.setText(mRecipesBeans.get(position).getReadyInMinutes());
        viewHolder.healthScoreTV.setText(Double.toString(mRecipesBeans.get(position).getHealthScore()));
        viewHolder.scoreTV.setText(Double.toString(mRecipesBeans.get(position).getSpoonacularScore()));
        viewHolder.likes.setText(mRecipesBeans.get(position).getAggregateLikes());
        viewHolder.sourceNameTV.setText(mRecipesBeans.get(position).getSourceName());
    }

    @Override
    public int getItemCount() {
        return mRecipesBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView mCardView;
        ImageView recipeImage;
        TextView titleTV;
        TextView timeTV;
        TextView healthScoreTV;
        TextView scoreTV;
        TextView likes;
        TextView sourceNameTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mCardView = itemView.findViewById(R.id.card_view);
            recipeImage = itemView.findViewById(R.id.recyclerViewImage);
            titleTV = itemView.findViewById(R.id.recyclerViewRecipeTitle);
            timeTV = itemView.findViewById(R.id.prepTime);
            healthScoreTV = itemView.findViewById(R.id.healthScore);
            scoreTV = itemView.findViewById(R.id.score);
            likes = itemView.findViewById(R.id.like);
            sourceNameTV = itemView.findViewById(R.id.sourceName);

        }
    }
}
