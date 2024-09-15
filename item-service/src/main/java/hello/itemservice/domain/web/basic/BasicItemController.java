package hello.itemservice.domain.web.basic;

import hello.itemservice.domain.item.Item;
import hello.itemservice.domain.item.ItemRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
/*
@Controller
@RequestMapping("/basic/items") // /basic/items url이 호출되면 이 메서드가 실행
@RequiredArgsConstructor
public class BasicItemController {
    private final ItemRepository itemRepository;

    @GetMapping // 아이템 목록 찾아오기 Model을 통해 데이터 값을 받고 타임리프로 해당주소의 html에서 동작
    public String items(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "basic/items"; // 논리적 이름 반환 controller 에노테이션 쓴 이유
    }
    //이 코드는 논리적인 뷰 이름을 의미하며, Spring Boot는 뷰 리졸버를 통해 다음과 같은 경로로 변환합니다:
    //prefix: /templates/
    //뷰 이름: "basic/items"
    //suffix: .html
    // 그래서 basic/items 만 썼던 거

    @GetMapping("/{itemId}") // url 매핑 기능을 동적으로 가능하게 해줌
        public String item(@PathVariable Long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "basic/item";
    }

    @PostConstruct // 아이템이 있는지 보려면 우선 아이템들이 들어가 있어야 하니까 의존성 주입 먼저 해주기
    public void init() {
        itemRepository.save(new Item(10000, "testA", 10));
        itemRepository.save(new Item(20000, "testB", 20));
    }
    //컨트롤러 로직은 itemRepository에서 모든 상품을 조회한 다음에 모델에 담는다. 그리고 뷰 템플릿을 호출한다.
}
// th:onclick=|location.href='@
*/

