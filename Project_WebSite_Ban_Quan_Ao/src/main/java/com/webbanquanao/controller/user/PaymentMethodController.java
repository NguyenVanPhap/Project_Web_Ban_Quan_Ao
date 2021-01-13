/*
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

@WebServlet(urlPatterns= {"User/payment/method"})
public class PaymentMethodController extends HttpServlet {
    private CartService cartService = new CartServiceImpl();
    private ProductService productService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String posturl = "";

        String method = req.getParameter("method");
        if(method=="online"){
            posturl = "https://www.sandbox.paypal.com/cgi-bin/webscr";
        }
        else{
            posturl = "/guiMailDi";
        }

        req.setAttribute("posturl",posturl);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/View/User/payment.jsp");
        dispatcher.forward(req, resp);
    }
}
*/
