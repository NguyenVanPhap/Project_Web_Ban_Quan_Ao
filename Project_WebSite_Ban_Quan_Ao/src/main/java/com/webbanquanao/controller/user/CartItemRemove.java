package com.webbanquanao.controller.user;

import com.webbanquanao.model.CartEntity;
import com.webbanquanao.model.CartitemEntity;
import com.webbanquanao.service.CartService;
import com.webbanquanao.service.impl.CartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet(urlPatterns = { "/member/cart/remove" }) // ?pId=?123
public class CartItemRemove extends HttpServlet {
    CartService cartService = new CartServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        CartEntity cartEntity = (CartEntity) httpSession.getAttribute("cartEntity");// Doc tu Session ra
        int pId = Integer.parseInt(req.getParameter("pId"));
        if (cartEntity != null) {
            cartService.removeProduct(cartEntity,pId);
    //        cartService.delete(pId);

            //Map<Integer, CartitemEntity> map = (Map<Integer, CartitemEntity>) obj; // ep ve kieu cua no
            // Xoa san pham trong map
            //map.remove(pId);

            // Cap nhat lai Session
            httpSession.setAttribute("cartEntity", cartEntity);
        }
        resp.sendRedirect(req.getContextPath() + "/member/cart");
    }
}