package com.webbanquanao.controller.user;

import com.webbanquanao.model.CartEntity;
import com.webbanquanao.service.CartService;
import com.webbanquanao.service.ProductService;
import com.webbanquanao.service.impl.CartServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns= {"/checkout"})
public class CheckOutController extends HttpServlet {
    private CartService cartService = new CartServiceImpl();
    private ProductService productService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        CartEntity cartEntity = (CartEntity) httpSession.getAttribute("cartEntity");
        cartEntity.setAction(true);
        cartService.edit(cartEntity);
        httpSession.removeAttribute("cartEntity");
        double total = 0;
        httpSession.setAttribute("total",total);
  //      httpSession.setAttribute("cartEntity",cartEntity);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/View/User/cart.jsp");
        dispatcher.forward(req, resp);
    }
}
