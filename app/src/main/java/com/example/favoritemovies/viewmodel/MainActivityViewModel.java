package com.example.favoritemovies.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.favoritemovies.model.AppRepository;
import com.example.favoritemovies.model.Genre;
import com.example.favoritemovies.model.Movie;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel{

    AppRepository appRepository;
    private LiveData<List<Genre>> genres;
    private LiveData<List<Movie>> movies;
    private LiveData<List<Movie>> genreMovies;

    public MainActivityViewModel(@NotNull Application application) {
        super(application);
        appRepository = new AppRepository(application);
    }

    public LiveData<List<Genre>> getGenres() {
        genres = appRepository.getGenres();
        return genres;
    }

    public LiveData<List<Movie>> getMovies() {
        movies = appRepository.getMovies();
        return movies;
    }

    public LiveData<List<Movie>> getGenreMovies(int genreId) {
        genreMovies = appRepository.getGenreMovies(genreId);
        return genreMovies;
    }

    public void insertGenre(Genre genre){
        appRepository.insertGenre(genre);
    }

    public void insertMovie(Movie movie){
        appRepository.insertMovie(movie);
    }

    public void updateGenre(Genre genre){
        appRepository.updateGenre(genre);
    }

    public void updateMovie(Movie movie){
        appRepository.updateMovie(movie);
    }

    public void deleteGenre(Genre genre){
        appRepository.deleteGenre(genre);
    }

    public void deleteMovie(Movie movie){
        appRepository.deleteMovie(movie);
    }
}
