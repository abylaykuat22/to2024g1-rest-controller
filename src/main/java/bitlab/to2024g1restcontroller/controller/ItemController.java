package bitlab.to2024g1restcontroller.controller;

import bitlab.to2024g1restcontroller.entity.Item;
import bitlab.to2024g1restcontroller.service.ItemService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item") // корневой url
@RequiredArgsConstructor
public class ItemController {

  private final ItemService itemService;

  @GetMapping("{id}")
  public Item getItem(@PathVariable Long id) {
    return itemService.getItemById(id);
  }

  @GetMapping // для чтения
  public List<Item> getItems() {
    return itemService.getAllItems();
  }

  @PostMapping// для добавления
  public Item createItem(@RequestBody Item item) {
    return itemService.create(item);
  }

  @PutMapping // для изменения
  public Item editItem(@RequestBody Item item) {
    return itemService.edit(item);
  }

  @DeleteMapping ("{id}")// для удаления
  public void deleteItem(@PathVariable Long id) {
    itemService.deleteById(id);
  }

  @PatchMapping("{id}")
  public Item editItem1(@PathVariable Long id, @RequestParam String name) {
    return itemService.edit(id, name);
  }
}
