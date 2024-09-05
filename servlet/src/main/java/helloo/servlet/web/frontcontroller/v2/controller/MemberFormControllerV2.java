package helloo.servlet.web.frontcontroller.v2.controller;

import helloo.servlet.domain.member.MemberRepository;
import helloo.servlet.web.frontcontroller.MyView;
import helloo.servlet.web.frontcontroller.v2.ControllerV2;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MemberFormControllerV2 implements ControllerV2 {
    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return new MyView("WEB-INF/views/new-form.jsp");
    }
}
