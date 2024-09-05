package helloo.servlet.web.frontcontroller;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
@Getter @Setter
public class ModelView {
    private String viewName; // 뷰의 논리적 이름
    private Map<String, Object> model = new HashMap<>(); // MODEL

    public ModelView(String viewName) {
        this.viewName = viewName;
    }

}

// 프론트컨트롤러에서 매핑정보로 컨트롤러 조회: controllerMap 에 넣어놓고, 주소를 받아들여 주소에 매칭되는 컨트롤러 꺼내기
// 이후에 컨트롤러 호출: 파라미터의 정보를 createParam 메서드를 통해 paramMap 에 넣어주고, 컨트롤러에 param을 넣어서 process 메서드 실행
// 이후 modelView 반환하여 논리적 주소와, jsp에 들어갈 model 정보 반환
// viewResolver를 통해 물리적주소를 View로 반환, 이후에 modelView의 model 정보를 넣어 view에서 render함수 실행
// render함수로 modelSet하고 jsp 연결해주는 역할시행

// 핸들러=컨트롤러 라고 생각하면 됨
// 프론트컨트롤러에서 핸들러매핑맵, 핸들러어댑터들을 담는 맵 생성(어댑터라고 생각 규격이 맞는지 확인하고, 변환했다면 핸들러에 맞게 호출)
// 프론트 컨트롤러를 생성할때 생성자로 어떤 어뎁터를 쓸건지 맵에 넣어주고, 주소와 컨트롤러를 담는 핸들러 맵 생성
// 주소를 받고 어떤 핸들러를 쓸지 Object로 핸들러를 꺼내는 getHandler 메서드 실행
// getHandlerAdapter 메서드로 핸들러에 맞는 어뎁터를 꺼내오고
// 어뎁터에서 안에 호출프로세스 실행(해당 컨트롤러로 변환해서 실행) V3인경우 modelView반환, v4인경우 viewname로 반환
// 차례로 viewResolver로 물리적 주소 반환 받고 render 실행