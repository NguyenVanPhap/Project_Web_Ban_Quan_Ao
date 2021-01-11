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

@WebServlet(urlPatterns = { "/admin/contact/update" })
public class ContactUpdateController extends HttpServlet {
    ContactService contactService = new ContactServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id= Integer.parseInt((String)req.getParameter("id"));
        int value = Integer.parseInt((String)req.getParameter("value"));
        contactService.updateAction(id,value);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/contact/list");
        dispatcher.forward(req, resp);
    }
}
