package helloo.servlet.web.frontcontroller.v3;

import helloo.servlet.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {
    ModelView process(Map<String, String> paramMap);
    // 이전과 다르게 서블릿 기술이 안들어가고 순수한 자바 코드로 만들어짐
}
