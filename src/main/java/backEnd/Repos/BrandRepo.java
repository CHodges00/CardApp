package backEnd.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import backEnd.Models.Brand;


@Repository
public interface BrandRepo extends JpaRepository<Brand, Long> {

}
