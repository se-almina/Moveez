package com.example.moveez;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MovieAdapter extends BaseAdapter {
    private List<Movie> movieList;
    private Context context;

    public MovieAdapter(List<Movie> movieList, Context context) {
        this.movieList = movieList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return movieList.size();
    }

    @Override
    public Object getItem(int i) {
        return movieList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return movieList.indexOf(i);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater=LayoutInflater.from(context);
        view= inflater.inflate(R.layout.movielist_layout,viewGroup, false);

        Movie movie= (Movie) getItem(i);
        ImageView image = view.findViewById(R.id.image);
        TextView name= view.findViewById(R.id.movie_name);
        TextView actors=view.findViewById(R.id.movie_actors);
        TextView projection=view.findViewById(R.id.movie_projection);
        TextView genre=view.findViewById(R.id.movie_genre);
        TextView year=view.findViewById(R.id.movie_year);


        image.setImageResource(movie.getImageResId());
        name.setText(movie.getName());
        actors.setText(movie.getActors());
        projection.setText(movie.getProjection());
        genre.setText(movie.getGenre());
        year.setText(movie.getYear());

        return view;
    }
}
