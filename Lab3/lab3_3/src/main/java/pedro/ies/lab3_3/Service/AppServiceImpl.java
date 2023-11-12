package pedro.ies.lab3_3.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import pedro.ies.lab3_3.Entity.*;
import pedro.ies.lab3_3.Repository.MovieRepository;
import pedro.ies.lab3_3.Repository.QuoteRepository;

@Service
@AllArgsConstructor
public class AppServiceImpl implements AppService{
    
    private MovieRepository movieRepository;
    private QuoteRepository quoteRepository;

    //creates both movie and quote
    @Override
    public Movie createMovie(Movie movie){
        return movieRepository.save(movie);
    }

    @Override
    public Quote createQuote(Quote quote){
        return quoteRepository.save(quote);
    }
    //deletes both movie and quote
    @Override
    public void deleteMovie(Long mId){
        movieRepository.deleteById(mId);
    }

    @Override
    public void deleteQuote(Long qId){
        quoteRepository.deleteById(qId);
    }

    //updates both movie and quote
    @Override
    public Movie updateMovie(Movie movie){
        Movie existingMov = movieRepository.findById(movie.getId()).get();
        existingMov.setTitle(movie.getTitle());
        existingMov.setYear(movie.getYear());
        Movie updatedMov = movieRepository.save(existingMov);
        return updatedMov;
    }

    @Override
    public Quote updateQuote(Quote quote){
        Quote existingQuo = quoteRepository.findById(quote.getId()).get();
        existingQuo.setContent(quote.getContent());
        existingQuo.setMovie(quote.getMovie());
        Quote updatedQuo = quoteRepository.save(existingQuo);
        return updatedQuo;
    }
    // gets all the movies and quotes
    @Override
    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    @Override
    public List<Quote> getAllQuotes(){
        return quoteRepository.findAll();
    }
    //gets movies by their title
    @Override
    public List<Movie> getMoviesByTitle(String title){
        return movieRepository.findByTitle(title);
    }
    // gets quotes by their movie
    @Override
    public List<Quote> getQuotesByMovie(Movie movie){
        return quoteRepository.findByMovie(movie);
    }
    // gets movies and  quote by their ids
    @Override
    public Movie getMovieById(Long mId){
        Optional<Movie> optionalMov = movieRepository.findById(mId);
        return optionalMov.get();
    } 
    
    @Override
    public Quote getQuoteById(Long qId){
        Optional<Quote> optionalQuo = quoteRepository.findById(qId);
        return optionalQuo.get();
    }
}
