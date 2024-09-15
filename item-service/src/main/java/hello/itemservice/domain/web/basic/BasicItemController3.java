package hello.itemservice.domain.web.basic;

import hello.itemservice.domain.item.Item;
import hello.itemservice.domain.item.ItemRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/basic/items")
@RequiredArgsConstructor
public class BasicItemController3 {
    private final ItemRepository itemRepository;

    @GetMapping
    public String items(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "basic/items";
    }

    @GetMapping("/{itemId}")
    public String item(@PathVariable Long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "basic/item";
    }

    @GetMapping("/add")
    public String addForm() {
        return "basic/addForm";
    }

    //@ModelAttribute를 쓰면 Item 객체를 생성하고 프로퍼티 설정과 모델에 저장해주는 것까지 해줌
    @PostMapping("/add")
    public String save(@ModelAttribute("item") Item item) {
        itemRepository.save(item);
        return "basic/item";
    }

    @GetMapping("/{itemId}/edit")
    public String editForm(@PathVariable Long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "basic/editForm";
    }

    @PostMapping("/{itemId}/edit")
    public String edit(@ModelAttribute Item item, @PathVariable Long itemId) {
        itemRepository.update(itemId, item);
        return "redirect:/basic/items/{itemId}";
    }
    //addForm.html에서 name=itemName, name=price, name=quantity 의 형태로 서버에서 데이터가 넘어오면
    // @RequestParam으로 데이터를 가져와서 맵핑
   /* @PostMapping("/add")
    public String save1(@RequestParam String itemName,
                        @RequestParam Integer price,
                        @RequestParam Integer quantity,
                        Model model
                        ) {
        Item item = new Item();
        item.setItemName(itemName);
        item.setPrice(price);
        item.setQuantity(quantity);
        itemRepository.save(item);
        model.addAttribute("item", item);
        return "basic/item";
    }*/


    @PostConstruct
    public void init() {
        Item item1 = new Item(10000, "사과", 5);
        Item item2 = new Item(20000, "포도", 10);
        itemRepository.save(item1);
        itemRepository.save(item2);
    }
}
