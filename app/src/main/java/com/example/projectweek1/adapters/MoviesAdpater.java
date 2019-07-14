package com.example.projectweek1.adapters;


import android.content.Context;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.projectweek1.R;
import com.example.projectweek1.models.movie_model;

import java.util.ArrayList;
import java.util.List;

public class MoviesAdpater extends RecyclerView.Adapter<MoviesAdpater.ViewHolder>{
    Context context;
    ArrayList<movie_model> movies;

    public MoviesAdpater(Context context, ArrayList<movie_model> movies) {
        this.context = context;
        this.movies = movies;
    }

    @NonNull
    @Override
    public MoviesAdpater.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View view = LayoutInflater.from(context).inflate(R.layout.item_movie,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesAdpater.ViewHolder viewHolder, int i) {
    movie_model movie = movies.get(i);
    viewHolder.bind(movie);
    }

    @Override
    public int getItemCount() {
  return movies.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvtitle,tvlang,tvoverview,tvdate;
        ImageView ivposter;

        public ViewHolder( View itemView) {
            super(itemView);
            tvtitle = itemView.findViewById(R.id.tv_title);
            tvlang = itemView.findViewById(R.id.tvLang);
            tvoverview = itemView.findViewById(R.id.tv_overview);
            tvdate = itemView.findViewById(R.id.tvrdate);
            ivposter = itemView.findViewById(R.id.iv_movie);
        }

        public void bind( movie_model movie) {
            tvtitle.setText(movie.getTitle());
            tvlang.setText(movie.getOriginal_language());
            tvoverview.setText(movie.getOverview());
            tvdate.setText(movie.getRelease_date());
            String imageUrl = movie.getPoster_path();
            if (context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
              imageUrl = movie.getBackdrop_path();
            }
            Glide.with(context).load(imageUrl).into(ivposter);

        }
    }
}
