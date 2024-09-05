package helloo.servlet.web.frontcontroller.v3;

import helloo.servlet.web.frontcontroller.ModelView;
import helloo.servlet.web.frontcontroller.MyView;
import helloo.servlet.web.frontcontroller.v2.ControllerV2;
import helloo.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3;
import helloo.servlet.web.frontcontroller.v3.controller.MemberListControllerV3;
import helloo.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV3", urlPatterns = "/front-controller/v3/*")
public class FrontControllerServletV3 extends HttpServlet {
    Map<String, ControllerV3> controllerV3 = new HashMap<>();

   public FrontControllerServletV3() {
        controllerV3.put("/front-controller/v3/members/new-form", new MemberFormControllerV3());
        controllerV3.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
        controllerV3.put("/front-controller/v3/members", new MemberListControllerV3());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        ControllerV3 controller = controllerV3.get(requestURI);
      //ControllerV3 controller = new MemberFormControllerV3();
      //controller.process(string,string) -> ModelView 반환
        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        Map<String, String> paramMap = createParamMap(request);
        // key 변수명은 paramname
        // 이렇게 하면 paramMap에 username = "" age=" " 의 정보가 문자열로 들어가게 됨

        ModelView mv = controller.process(paramMap);
        //controller 비즈니스 로직을 실행시켜주고 MyView를 반환해서 myview 안에서 랜더링하여 jsp로 넘겨주는
        String viewName = mv.getViewName();
        MyView view = viewResolver(viewName);
        view.render(mv.getModel(), request, response);
    }

    private static MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

    private static Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator().
                forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
