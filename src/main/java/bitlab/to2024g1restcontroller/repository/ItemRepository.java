package bitlab.to2024g1restcontroller.repository;

import bitlab.to2024g1restcontroller.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}
