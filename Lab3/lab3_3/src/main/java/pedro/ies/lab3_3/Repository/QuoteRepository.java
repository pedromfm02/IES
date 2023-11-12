package pedro.ies.lab3_3.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pedro.ies.lab3_3.Entity.Movie;
import pedro.ies.lab3_3.Entity.Quote;
import java.util.List;


public interface QuoteRepository extends JpaRepository<Quote, Long>{
    List<Quote> findByMovie(Movie movie);
}
