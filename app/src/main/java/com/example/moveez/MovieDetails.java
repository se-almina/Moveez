package com.example.moveez;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MovieDetails extends AppCompatActivity {
    private ImageView imageView;
    private TextView name;
    private TextView year;
    private TextView genre;
    private TextView actors;
    private TextView projection;
    private long id;

    public static final String MOVIE_NAME = "MOVIE_NAME";
    public static final String MOVIE_IMAGE = "MOVIE_IMAGE";
    public static final String MOVIE_PROJECTION = "MOVIE_PROJECTION";
    public static final String USER_ID = "USER_ID";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_details);

        imageView = findViewById(R.id.image);
        name = findViewById(R.id.name_movie);
        year = findViewById(R.id.year_movie);
        genre = findViewById(R.id.genre_movie);
        actors = findViewById(R.id.actors_movie);
        projection = findViewById(R.id.projection_movie);


        Bundle extras = getIntent().getExtras();
        if(extras != null){
            id = extras.getLong(MovieFragment.USER_ID);
            setTitle(extras.getString(MovieFragment.EXTRA_NAME));
            imageView.setImageResource(extras.getInt(MovieFragment.EXTRA_IMAGE));
            name.setText(extras.getString(MovieFragment.EXTRA_NAME));
            year.setText(extras.getString(MovieFragment.EXTRA_YEAR));
            genre.setText(extras.getString(MovieFragment.EXTRA_GENRE));
            actors.setText(extras.getString(MovieFragment.EXTRA_ACTORS));
            projection.setText(extras.getString(MovieFragment.EXTRA_PROJECTION));


        }
    }

    public void reserve(View view) {
        Intent intent = new Intent(this, Reserve.class);
        String movie_name = name.getText().toString();
        Movie movie = MovieDatabase.getInstance(this).movieDao().getMovieByName(movie_name);
        intent.putExtra(USER_ID,id);
        intent.putExtra(MOVIE_IMAGE, movie.getImageResId());
        intent.putExtra(MOVIE_NAME, movie.getName());
        intent.putExtra(MOVIE_PROJECTION, movie.getProjection());
        startActivity(intent);
    }


}