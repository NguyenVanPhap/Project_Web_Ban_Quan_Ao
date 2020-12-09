package com.webbanquanao.controller.admin;

import com.webbanquanao.service.CartItemService;
import com.webbanquanao.service.impl.CartItemServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns="/admin/order/delete")
public class OrderDeleteController extends HttpServlet {
    CartItemService cartItemService=new CartItemServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id= request.getParameter("id");
        cartItemService.delete(id);
        response.sendRedirect(request.getContextPath()+"/admin/order/list");
    }
}

