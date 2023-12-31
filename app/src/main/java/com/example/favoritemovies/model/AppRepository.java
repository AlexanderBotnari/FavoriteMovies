package com.example.favoritemovies.model;

import android.app.Application;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;

import java.util.List;

public class AppRepository {

    private GenreDao genreDao;
    private MovieDao movieDao;

    private LiveData<List<Genre>> genres;
    private LiveData<List<Movie>> movies;

    public AppRepository(Application application){
        MoviesDatabase moviesDatabase = MoviesDatabase.getInstance(application);
        genreDao = moviesDatabase.getGenreDao();
        movieDao = moviesDatabase.getMovieDao();
    }

    public LiveData<List<Genre>> getGenres(){
        return genreDao.getAllGenres();
    }

    public LiveData<List<Movie>> getMovies(){
        return movieDao.getAllMovies();
    }

    public LiveData<List<Movie>> getGenreMovies(int genreId){
        return movieDao.getMoviesByGenre(genreId);
    }

    public void insertGenre(Genre genre){
        new InsertGenreAsyncTask(genreDao).execute(genre);
    }

    public void insertMovie(Movie movie){
        new InsertMovieAsyncTask(movieDao).execute(movie);
    }

    public void updateGenre(Genre genre){
        new UpdateGenreAsyncTask(genreDao).execute(genre);
    }

    public void updateMovie(Movie movie){
        new UpdateMovieAsyncTask(movieDao).execute(movie);
    }

    public void deleteGenre(Genre genre){
        new DeleteGenreAsyncTask(genreDao).execute(genre);
    }

    public void deleteMovie(Movie movie){
        new DeleteMovieAsyncTask(movieDao).execute(movie);
    }

    private class InsertGenreAsyncTask extends AsyncTask<Genre, Void, Void>{

        private GenreDao genreDao;

        public InsertGenreAsyncTask(GenreDao genreDao) {
            this.genreDao = genreDao;
        }

        @Override
        protected Void doInBackground(Genre... genres) {
            genreDao.insert(genres[0]);
            return null;
        }
    }

    private class InsertMovieAsyncTask extends AsyncTask<Movie, Void, Void>{

        private MovieDao movieDao;

        public InsertMovieAsyncTask(MovieDao movieDao) {
            this.movieDao = movieDao;
        }

        @Override
        protected Void doInBackground(Movie... movies) {
            movieDao.insert(movies[0]);
            return null;
        }
    }

    private class UpdateGenreAsyncTask extends AsyncTask<Genre, Void, Void>{

        private GenreDao genreDao;

        public UpdateGenreAsyncTask(GenreDao genreDao) {
            this.genreDao = genreDao;
        }

        @Override
        protected Void doInBackground(Genre... genres) {
            genreDao.update(genres[0]);
            return null;
        }
    }

    private class UpdateMovieAsyncTask extends AsyncTask<Movie, Void, Void>{

        private MovieDao movieDao;

        public UpdateMovieAsyncTask(MovieDao movieDao) {
            this.movieDao = movieDao;
        }

        @Override
        protected Void doInBackground(Movie... movies) {
            movieDao.update(movies[0]);
            return null;
        }
    }

    private class DeleteGenreAsyncTask extends AsyncTask<Genre, Void, Void>{

        private GenreDao genreDao;

        public DeleteGenreAsyncTask(GenreDao genreDao) {
            this.genreDao = genreDao;
        }

        @Override
        protected Void doInBackground(Genre... genres) {
            genreDao.delete(genres[0]);
            return null;
        }
    }

    private class DeleteMovieAsyncTask extends AsyncTask<Movie, Void, Void>{

        private MovieDao movieDao;

        public DeleteMovieAsyncTask(MovieDao movieDao) {
            this.movieDao = movieDao;
        }

        @Override
        protected Void doInBackground(Movie... movies) {
            movieDao.delete(movies[0]);
            return null;
        }
    }

}
