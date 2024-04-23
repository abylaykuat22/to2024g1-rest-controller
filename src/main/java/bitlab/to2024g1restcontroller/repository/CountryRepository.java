package bitlab.to2024g1restcontroller.repository;

import bitlab.to2024g1restcontroller.entity.Country;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

  Optional<Country> findByCode(String code);
}
