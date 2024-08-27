package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

/*
* 1.파라미터 전송 기능
* http://localhost:8080/request-param?username=hello&age=20
*
* */
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration<String> parameterNames = request.getParameterNames(); // username age등의 파라미터를 꺼낼 수 있음
        // content-type은 html form을 웹 부라우저가 만들어주는 것 : 메세지 바디의 데이터 형식 지정
        System.out.println("[전체 파라미터 조회] - start");
        request.getParameterNames().asIterator().
                forEachRemaining(paramName -> System.out.println(paramName + "=" + request.getParameter(paramName)));
        System.out.println("[전체 파라미터 조회] - end");
        System.out.println();

        System.out.println("[단일 파라미터 조회]");
        String username = request.getParameter("username");
        String age = request.getParameter("age");
        System.out.println("username = " + username);
        System.out.println("age = " + age);
        System.out.println();
        // request.getParameter는 쿼리파라미터와 html form에서 동일하게 작동한다
        System.out.println("[이름이 같은 파라미터 복수조회");
        String[] usernames = request.getParameterValues("username");
        for (String name : usernames) {
            System.out.println("username= " + name);
        }
        response.getWriter().write("ok");

        //테스트할떄 매번 html form을 만들 수 없기 때문에 postman 사용
    }
}
