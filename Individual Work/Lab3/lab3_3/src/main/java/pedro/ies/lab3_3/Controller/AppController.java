package pedro.ies.lab3_3.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import pedro.ies.lab3_3.Entity.Movie;
import pedro.ies.lab3_3.Entity.Quote;
import pedro.ies.lab3_3.Service.AppService;


@RestController
@AllArgsConstructor
@RequestMapping("/api/lab3_3")
public class AppController {
    
    private AppService appService;


    @PostMapping("/movie") // create movie
    public ResponseEntity<Movie> createMovie(@Valid @RequestBody Movie mov){
        Movie savedMov = appService.createMovie(mov);
        return new ResponseEntity<>(savedMov,HttpStatus.CREATED);
    }

    @PostMapping("/quote") // create quote
    public ResponseEntity<Quote> createQuote(@Valid @RequestBody Quote quo){
        Quote savedQuo = appService.createQuote(quo);
        return new ResponseEntity<>(savedQuo,HttpStatus.CREATED);
    }

    @DeleteMapping("/movie/{id}") // delete Movie
    public ResponseEntity<String> deleteMovie(@PathVariable("id") Long MovId){
        appService.deleteMovie(MovId);
        return new ResponseEntity<>("Movie successfully deleted!",HttpStatus.OK);
    }

    @DeleteMapping("/quote/{id}") // delete Quote
    public ResponseEntity<String> deleteQuote(@PathVariable("id") Long QuoId){
        appService.deleteQuote(QuoId);
        return new ResponseEntity<>("Quote successfully deleted!",HttpStatus.OK);
    }

    @PutMapping("/movie/{id}") // update Movie
    public ResponseEntity<Movie> updateMovie(@PathVariable("id") Long MovId, @RequestBody Movie mov){
        mov.setId(MovId);
        Movie updatedMov = appService.updateMovie(mov);
        return new ResponseEntity<>(updatedMov,HttpStatus.OK);
    }

    @PutMapping("/quote/{id}") // update Quote
    public ResponseEntity<Quote> updateQuote(@PathVariable("id") Long QuoId, @RequestBody Quote quo){
        quo.setId(QuoId);
        Quote updatedQuo = appService.updateQuote(quo);
        return new ResponseEntity<>(updatedQuo,HttpStatus.OK);
    }

    @GetMapping("/movies") // get all movies
    public ResponseEntity<List<Movie>> getAllMovies(){
        List<Movie> mov = appService.getAllMovies();
        return new ResponseEntity<>(mov,HttpStatus.OK);
    }

    @GetMapping("/quotes") // get all quotes
    public ResponseEntity<List<Quote>> getAllQuotes(){
        List<Quote> quo = appService.getAllQuotes();
        return new ResponseEntity<>(quo,HttpStatus.OK);
    }

    @GetMapping("/movies?title={title}") // get Movie by title
    public ResponseEntity<List<Movie>> getMoviesByTitle(@PathVariable("title") String title){
        List<Movie> mov = appService.getMoviesByTitle(title);
        return new ResponseEntity<>(mov,HttpStatus.OK);
    }

    @GetMapping("/quotes?title={title}") // get quote by movie title
    public ResponseEntity<List<Quote>> getQuotesByTitle(@PathVariable("title") String title){
        List<Movie> mov = appService.getMoviesByTitle(title);
        List<Quote> quo = new ArrayList<>();
        for(Movie m : mov){
            List<Quote> quo_mov = appService.getQuotesByMovie(m);
            for(Quote q: quo_mov){
                quo.add(q);
            }
        }
        return new ResponseEntity<>(quo,HttpStatus.OK);
    }

    @GetMapping("/movie/{id}") // get movie by id
    public ResponseEntity<Movie> getMovieById(@PathVariable("id") Long movId){
        Movie mov = appService.getMovieById(movId);
        return new ResponseEntity<>(mov,HttpStatus.OK);
    }

    @GetMapping("/quote/{id}") // get quote by id
    public ResponseEntity<Quote> getQuoteById(@PathVariable("id") Long quoId){
        Quote quo = appService.getQuoteById(quoId);
        return new ResponseEntity<>(quo,HttpStatus.OK);
    }
}
