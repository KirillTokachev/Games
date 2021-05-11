package com.example.games.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import com.example.games.R;
import com.example.games.model.Movies;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder> {

    private Context context;
    private ArrayList<Movies> movies;

    public MoviesAdapter(Context context, ArrayList<Movies> movies){
        this.context = context;
        this.movies = movies;
    }

    @Override
    public MoviesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.movies_item,
                parent,false);

        return new MoviesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MoviesAdapter.MoviesViewHolder holder, int position) {

        Movies currentGame = movies.get(position);

        String title = currentGame.getTitle();
        String posterUrl = currentGame.getPosterUrl();
        String released = currentGame.getReleased();

        holder.titleTextView.setText(title);
        holder.releasedTextView.setText(released);
        Picasso.get().load(posterUrl).fit().centerInside().into(holder.posterImageView);

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class MoviesViewHolder extends RecyclerView.ViewHolder{

        // Создание полей
        ImageView posterImageView;
        TextView titleTextView;
        TextView releasedTextView;

        public MoviesViewHolder(View itemView) {
            super(itemView);

            // Связывание полей
            posterImageView = itemView.findViewById(R.id.posterImageView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            releasedTextView = itemView.findViewById(R.id.releasedTextView);
        }
    }

}
