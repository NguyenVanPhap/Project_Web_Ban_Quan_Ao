package com.webbanquanao.controller.admin;

import com.webbanquanao.model.ContactEntity;
import com.webbanquanao.service.ContactService;
import com.webbanquanao.service.impl.ContactServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = { "/admin/contact/list" })
public class ContactListController extends HttpServlet {
    ContactService contactService = new ContactServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ContactEntity> contactEntityList = contactService.getAll();
        req.setAttribute("contactEntityList", contactEntityList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/View/admin/list-contact.jsp");
        dispatcher.forward(req, resp);
    }
}
