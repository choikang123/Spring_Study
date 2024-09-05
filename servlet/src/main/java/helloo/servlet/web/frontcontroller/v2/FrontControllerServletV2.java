package helloo.servlet.web.frontcontroller.v2;

import helloo.servlet.web.frontcontroller.MyView;
import helloo.servlet.web.frontcontroller.v2.controller.MemberFormControllerV2;
import helloo.servlet.web.frontcontroller.v2.controller.MemberListControllerV2;
import helloo.servlet.web.frontcontroller.v2.controller.MemberSaveControllerV2;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV2", urlPatterns = "/front-controller/v2/*")
public class FrontControllerServletV2 extends HttpServlet {
    Map<String, ControllerV2> controllerV2 = new HashMap<>();

   public FrontControllerServletV2() {
        controllerV2.put("/front-controller/v2/members/new-form", new MemberFormControllerV2());
        controllerV2.put("/front-controller/v2/members/save", new MemberSaveControllerV2());
        controllerV2.put("/front-controller/v2/members", new MemberListControllerV2());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        ControllerV2 controller = controllerV2.get(requestURI);
        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        MyView view = controller.process(request, response);
        //controller 비즈니스 로직을 실행시켜주고 MyView를 반환해서 myview 안에서 랜더링하여 jsp로 넘겨주는
        view.render(request, response);
    }
}
