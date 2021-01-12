package com.webbanquanao.controller.admin;

import com.webbanquanao.model.UserEntity;
import com.webbanquanao.service.CartItemService;
import com.webbanquanao.service.UserService;
import com.webbanquanao.service.impl.CartItemServiceImpl;
import com.webbanquanao.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns="/admin/order/delete")
public class OrderDeleteController extends HttpServlet {
    CartItemService cartItemService=new CartItemServiceImpl();
    UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 //       String id= request.getParameter("id");
 //       cartItemService.delete(id);
        HttpSession session = request.getSession();
        String email = session.getAttribute("email").toString();
        List<UserEntity> user = userService.search(email);
        user.forEach((u -> {
            request.setAttribute("user", u.getUserName());
        }));
        response.sendRedirect(request.getContextPath()+"/admin/order/list");
    }
}

