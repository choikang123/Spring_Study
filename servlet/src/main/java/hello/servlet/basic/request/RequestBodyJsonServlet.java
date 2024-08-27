package hello.servlet.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestBodyJsonServlet", urlPatterns = "/request-body-json")
public class RequestBodyJsonServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //postman 에서 json형식으로 데이터 보내주고 난 다음에

        ServletInputStream inputStream = request.getInputStream(); //json,바이너리 데이터,xml등의 데이터를 읽을 수 있는 스트림으로 변환
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8); //

        System.out.println("messageBody = " + messageBody);

        HelloData helloData = objectMapper.readValue(messageBody, HelloData.class); //객체 변환 후 데이터 뽑아내기
        System.out.println("helloData.getUserName() = " + helloData.getUserName());
        System.out.println("helloData.getAge() = " + helloData.getAge());

        response.getWriter().write("okk");
    }
}
