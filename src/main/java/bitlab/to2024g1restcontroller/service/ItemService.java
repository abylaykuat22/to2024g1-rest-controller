package bitlab.to2024g1restcontroller.service;

import bitlab.to2024g1restcontroller.entity.Item;
import bitlab.to2024g1restcontroller.repository.ItemRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService {

  private final ItemRepository itemRepository;

  public Item getItemById(Long id) {
    return itemRepository.findById(id).orElseThrow();
  }

  public List<Item> getAllItems() {
    return itemRepository.findAll();
  }

  public Item create(Item item) {
    return itemRepository.save(item);
  }

  public Item edit(Item item) {
    return itemRepository.save(item);
  }

  public Item edit(Long id, String name) {
    Item item = getItemById(id);
    item.setName(name);
    return itemRepository.save(item);
  }

  public void deleteById(Long id) {
    itemRepository.deleteById(id);
  }
}
