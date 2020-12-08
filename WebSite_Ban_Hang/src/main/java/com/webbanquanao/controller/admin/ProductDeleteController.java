package com.webbanquanao.controller.admin;

import com.webbanquanao.service.ProductService;
import com.webbanquanao.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = { "/admin/product/delete" })
public class ProductDeleteController extends HttpServlet {
    ProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        productService.delete(Integer.parseInt(id));

        response.sendRedirect(request.getContextPath() + "/admin/product/list");
    }

}
