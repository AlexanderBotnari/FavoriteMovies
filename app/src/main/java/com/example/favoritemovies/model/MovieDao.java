package com.example.favoritemovies.model;

import androidx.lifecycle.LiveData;
import androidx.room.*;

import java.util.List;

@Dao
public interface MovieDao {
    @Insert
    public void insert(Movie movie);

    @Update
    public void update(Movie movie);

    @Delete
    public void delete(Movie movie);

    @Query("select * from movies_table")
    public LiveData<List<Movie>> getAllMovies();

    @Query("select * from movies_table where genre_id==:genreId")
    public LiveData<List<Movie>> getMoviesByGenre(int genreId);
}
