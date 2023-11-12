package pedro.ies.lab3_3.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pedro.ies.lab3_3.Entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{
    List<Movie> findByTitle(String title);
}
