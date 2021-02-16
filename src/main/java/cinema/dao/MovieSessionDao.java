package cinema.dao;

import cinema.model.MovieSession;
import java.time.LocalDate;
import java.util.List;

public interface MovieSessionDao {
    MovieSession add(MovieSession movieSession);

    MovieSession update(MovieSession movieSession);

    List<MovieSession> findAvailableSessions(Long movieId, LocalDate date);

    void delete(Long id);
}
