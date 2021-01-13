package com.webbanquanao.controller.user;

import com.webbanquanao.model.CartEntity;
import com.webbanquanao.model.CustomerEntity;
import com.webbanquanao.model.UserEntity;
import com.webbanquanao.service.CartService;
import com.webbanquanao.service.CustomerService;
import com.webbanquanao.service.ProductService;
import com.webbanquanao.service.UserService;
import com.webbanquanao.service.impl.CartServiceImpl;
import com.webbanquanao.service.impl.CustomerServiceImpl;
import com.webbanquanao.service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns= {"/payment"})
public class PaymentController extends HttpServlet {
    UserService userService = new UserServiceImpl();
    CustomerService customerService = new CustomerServiceImpl();
    CartService cartService = new CartServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fullname = req.getParameter("fullname");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        String note = req.getParameter("note");

        HttpSession httpSession = req.getSession();
        String u_email = (String) httpSession.getAttribute("email");
        CartEntity cartEntity = (CartEntity) httpSession.getAttribute("cartEntity");

        UserEntity userEntity = new UserEntity();
        userEntity = userService.getUser(u_email);
        int c_id = customerService.getCustomerId(userEntity.getId());

        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setFullname(fullname);
        customerEntity.setEmail(email);
        customerEntity.setPhone(phone);
        customerEntity.setAddress(address);

        if(c_id!=0) {
            customerEntity.setId(c_id);
            customerService.edit(customerEntity);
        }
        else {
            customerService.insert(customerEntity);
            int new_c_id = customerService.getNewIDCustomer();
            customerEntity.setId(new_c_id);

            cartService.UpdateCustomer(cartEntity.getId(),new_c_id);
        }

        cartEntity.setCustomerEntity(customerEntity);
        httpSession.setAttribute("cartEntity",cartEntity);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/Home");
        dispatcher.forward(req, resp);
    }
}

