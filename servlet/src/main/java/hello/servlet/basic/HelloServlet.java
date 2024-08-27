package hello.servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        String username = request.getParameter("username"); //쿼리 파라미터 조회
        // http 문자를 따로 파싱해서 해석하지 않아도 서블릿이 파라미터를 가져올 수 있게하여 쉽게 볼 수 있다는 장점!
        System.out.println("username = " + username);

        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8"); //헤더정보
        response.getWriter().write("hello" + username); // 바디 부분에 쓸 수 있는거
        //response에 값을 넣으면 웹브라우저에 응답 메세지에 데이터가 담겨서 나가게 된다.
    }
}
