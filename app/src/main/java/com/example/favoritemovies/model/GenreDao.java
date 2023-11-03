package com.example.favoritemovies.model;

import androidx.lifecycle.LiveData;
import androidx.room.*;

import java.util.List;

@Dao
public interface GenreDao {
    @Insert
    public void insert(Genre genre);

    @Update
    public void update(Genre genre);

    @Delete
    public void delete(Genre genre);

    @Query("select * from genres_table")
    public LiveData<List<Genre>> getAllGenres();
}
