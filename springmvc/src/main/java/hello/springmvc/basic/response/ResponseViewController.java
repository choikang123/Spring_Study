package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ResponseViewController {
    @RequestMapping("/response-view-v2")
    public String responseView2(Model model) {
        model.addAttribute("data", "hello!");
        return "response/hello"; // view의 논리이름 template에서 렌더링 됨을 알 수 있다
    }
    // 클라이언트에서 서버로 데이터를 받아쓰는것과
    // 지금은 서버에서 응답으로 데이터를 내보내기 위한 방법 둘은 서로 다름

}
