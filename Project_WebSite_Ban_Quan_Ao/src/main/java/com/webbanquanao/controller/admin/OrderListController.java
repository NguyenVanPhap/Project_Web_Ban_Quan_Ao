package com.webbanquanao.controller.admin;

import com.webbanquanao.model.CartItem;
import com.webbanquanao.service.CartItemService;
import com.webbanquanao.service.CartService;
import com.webbanquanao.service.impl.CartItemServiceImpl;
import com.webbanquanao.service.impl.CartServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns= {"/admin/order/list"})
public class OrderListController extends HttpServlet {
    CartItemService cartItemService=new CartItemServiceImpl();
    CartService cartService=new CartServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CartItem> listCartItem =cartItemService.getAll();
        request.setAttribute("listCartItem", listCartItem);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/View/admin/list-order.jsp");
        dispatcher.forward(request, response);
    }
}
