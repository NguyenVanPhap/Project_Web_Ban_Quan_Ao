package com.webbanquanao.controller.admin;

import com.webbanquanao.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns="/admin")
public class welcome extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Object obj=session.getAttribute("account");
        User user=(User) obj;
        request.setAttribute("username", user.getUserName());
        request.getRequestDispatcher("/view/admin/view/index.jsp").forward(request, response);
    }

}

