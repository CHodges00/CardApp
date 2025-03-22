package backEnd.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import backEnd.Models.Year;


@Repository
public interface YearRepo extends JpaRepository<Year, Long> {

}
