package pedro.ies.lab3_3.Service;

import java.util.List;

import pedro.ies.lab3_3.Entity.Movie;
import pedro.ies.lab3_3.Entity.Quote;

public interface AppService {
    
    Movie createMovie(Movie movie);

    Quote createQuote(Quote quote);

    Movie updateMovie(Movie movie);

    Quote updateQuote(Quote quote);

    void deleteMovie(Long movieId);

    void deleteQuote(Long quoteId);

    List<Movie> getAllMovies();

    List<Quote> getAllQuotes();

    List<Movie> getMoviesByTitle(String title);

    List<Quote> getQuotesByMovie(Movie movie);

    Movie getMovieById(Long mId);

    Quote getQuoteById(Long qId);

}
