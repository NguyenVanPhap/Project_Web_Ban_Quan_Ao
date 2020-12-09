package com.webbanquanao.controller.admin;

import com.webbanquanao.service.UserService;
import com.webbanquanao.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns= {"/admin/user/delete"})
public class UserDeleteController extends HttpServlet {
    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        userService.delete(Integer.parseInt(id));

        response.sendRedirect(request.getContextPath() + "/admin/user/list");
    }
}
