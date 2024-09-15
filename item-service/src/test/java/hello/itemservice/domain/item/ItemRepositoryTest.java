package hello.itemservice.domain.item;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest {
    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void afterEach() {
        itemRepository.clearStore();
    }

    @Test
    void save() {
        //given
        Item item = new Item(1000, "item1", 1);
        //when
        Item saveItem = itemRepository.save(item);
        //then
        Item findItem = itemRepository.findById(saveItem.getId());
        assertThat(findItem).isEqualTo(saveItem);
    }

    @Test
    void findAll() {
        //given
        Item item1 = new Item(1000, "item1", 1);
        Item item2 = new Item(1000, "item2", 2);
        //when
        itemRepository.save(item1);
        itemRepository.save(item2);
        //then
        List<Item> itemList = itemRepository.findAll();
        assertThat(itemList.size()).isEqualTo(2);
        assertThat(itemList).contains(item1, item2);
    }
}