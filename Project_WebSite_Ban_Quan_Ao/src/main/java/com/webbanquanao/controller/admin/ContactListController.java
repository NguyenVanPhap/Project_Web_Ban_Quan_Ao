package com.webbanquanao.controller.admin;

import com.webbanquanao.model.ContactEntity;
import com.webbanquanao.model.UserEntity;
import com.webbanquanao.service.ContactService;
import com.webbanquanao.service.UserService;
import com.webbanquanao.service.impl.ContactServiceImpl;
import com.webbanquanao.service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = { "/admin/contact/list" })
public class ContactListController extends HttpServlet {
    ContactService contactService = new ContactServiceImpl();
    UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String email = session.getAttribute("email").toString();
        List<UserEntity> user = userService.search(email);
        user.forEach((u -> {
            req.setAttribute("user", u.getUserName());
        }));
        List<ContactEntity> contactEntityList = contactService.getAll();
        req.setAttribute("contactEntityList", contactEntityList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/View/admin/list-contact.jsp");
        dispatcher.forward(req, resp);
    }
}
