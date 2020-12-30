package com.webbanquanao.controller.user;

import com.webbanquanao.model.CartEntity;
import com.webbanquanao.model.CartitemEntity;
import com.webbanquanao.model.ProductEntity;
import com.webbanquanao.service.ProductService;
import com.webbanquanao.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@WebServlet(urlPatterns = { "/member/cart/add" }) // ?pId=123
public class CartAddController extends HttpServlet {
    ProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
/*        String pId = req.getParameter("pId");
//        String quantity = req.getParameter("quantity");
        ProductEntity product = productService.get(Integer.parseInt(pId));
        CartitemEntity cartItem = new CartitemEntity();
//        cartItem.setQuantity(Integer.parseInt(quantity));
        cartItem.setUnitPrice(product.getPrice());
                cartItem.setProductEntity(product);

        HttpSession httpSession = req.getSession();
        Object obj = httpSession.getAttribute("cart");
        if (obj == null) {
            Map<Integer, CartitemEntity> map = new HashMap<Integer, CartitemEntity>();
            map.put(cartItem.getProductEntity().getId(), cartItem);
            httpSession.setAttribute("cart", map);
        } else {
            Map<Integer, CartitemEntity> map = (Map<Integer, CartitemEntity>) obj;

            CartitemEntity existedCartItem = map.get(Integer.valueOf(pId));

            if (existedCartItem == null) {
                map.put(product.getId(), cartItem);
            } else {
   //             existedCartItem.setQuantity(existedCartItem.getQuantity() + Integer.parseInt(quantity));
            }

            httpSession.setAttribute("cart", map);
        }
        /*
         * if (obj != null) { CartItem cartItem = new CartItem();
         * cartItem.setProduct(product); cartItem.setQuantity(1);
         * cartItem.setUnitPrice(product.getPrice());
         *
         * Map<Integer, CartItem> map = new HashMap<Integer, CartItem>(); // Su dung map
         * de luu va tim kiem nhanh hon map.put(cartItem.getProduct().getId(),
         * cartItem);
         *
         * httpSession.setAttribute("cart", map);// luu vao session
         *
         * } else {
         *
         * Map<Integer, CartItem> map = (Map<Integer, CartItem>) obj; CartItem cartItem
         * = map.get(product.getId()); // 1: Chua co san pham trong gio hang if
         * (cartItem == null) { CartItem cartItems = new CartItem();
         * cartItems.setProduct(product); cartItems.setQuantity(1);
         * cartItems.setUnitPrice(product.getPrice());
         *
         * // Su dung map de luu va tim kiem nhanh hon
         * map.put(cartItems.getProduct().getId(), cartItems);
         *
         * httpSession.setAttribute("cart", map);// luu vao session } else { // Truong
         * hop da co roi cartItem.setQuantity(1 + cartItem.getQuantity());
         *
         * httpSession.setAttribute("cart", map); }

        resp.sendRedirect(req.getContextPath() + "/member/cart");*/
        int quantity = 1;
        int id;
        if(req.getParameter("pId")!=null){
            id = Integer.parseInt(req.getParameter("pId"));
            ProductEntity productEntity = productService.get(id);
            if(productEntity!=null){
                if(req.getParameter("quantity")!=null){
                    quantity = Integer.parseInt(req.getParameter("quantity"));
                }
                HttpSession session = req.getSession();
                if(session.getAttribute("cartEntity") == null){
                    CartEntity cartEntity = new CartEntity();
                    List<CartitemEntity> listCartItem =new ArrayList<CartitemEntity>();
                    CartitemEntity cartitemEntity = new CartitemEntity();
                    cartitemEntity.setQuantity(quantity);
                    cartitemEntity.setProductEntity(productEntity);
                    listCartItem.add(cartitemEntity);
                    cartEntity.setCartitemEntities(listCartItem);
                    session.setAttribute("cartEntity",cartEntity);
                }
                else{
                    CartEntity cartEntity = (CartEntity) session.getAttribute("cartEntity");
                    List<CartitemEntity> listCartItem = cartEntity.getCartitemEntities();
                    boolean check = false;
                    for(CartitemEntity cartitemEntity : listCartItem){
                        if(cartitemEntity.getProductEntity().getId() == productEntity.getId()){
                            cartitemEntity.setQuantity(cartitemEntity.getQuantity() + quantity);
                            check = true;
                        }
                    }
                    if(check == false){
                        CartitemEntity cartitemEntity = new CartitemEntity();
                        cartitemEntity.setQuantity(quantity);
                        cartitemEntity.setProductEntity(productEntity);
                        listCartItem.add(cartitemEntity);
                        cartEntity.setCartitemEntities(listCartItem);
                    }
                    session.setAttribute("cartEntity",cartEntity);
                }
            }
            resp.sendRedirect(req.getContextPath()+"/member/cart");
        }
        else {
            resp.sendRedirect(req.getContextPath()+"/member/cart");
        }
    }
}