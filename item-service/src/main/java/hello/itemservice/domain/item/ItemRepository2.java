package hello.itemservice.domain.item;

import jakarta.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ItemRepository2 {
    ConcurrentHashMap<Long, Item> store = new ConcurrentHashMap<>();
    Long sequence = 1L;

    public Item save(Item item) {
        item.setId(sequence++);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id) {
        return store.get(id);
    }

    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }

    public void updateItem(Long id, Item updatedItem) {
        Item findItem = findById(id);
        findItem.setItemName(updatedItem.getItemName());
        findItem.setId(updatedItem.getId());
        findItem.setPrice(updatedItem.getPrice());
        findItem.setQuantity(updatedItem.getQuantity());
    }

}
