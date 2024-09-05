package helloo.servlet.web.frontcontroller.v1;

import helloo.servlet.web.frontcontroller.v1.controller.MemberFormControllerV1;
import helloo.servlet.web.frontcontroller.v1.controller.MemberListControllerV1;
import helloo.servlet.web.frontcontroller.v1.controller.MemberSaveControllerV1;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV1", urlPatterns = "/front-controller/v1/*")
public class FrontControllerServletV1 extends HttpServlet {
    private Map<String, MemberControllerV1> controller = new HashMap<>();

    public FrontControllerServletV1() {
        controller.put("/front-controller/v1/members/new-form", new MemberFormControllerV1());
        controller.put("/front-controller/v1/members/save", new MemberSaveControllerV1());
        controller.put("/front-controller/v1/members", new MemberListControllerV1());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FrontControllerServletV1.service");
        String requestURI = request.getRequestURI();
        MemberControllerV1 memberControllerV1 = controller.get(requestURI);
        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        memberControllerV1.process(request, response);
    }
}
