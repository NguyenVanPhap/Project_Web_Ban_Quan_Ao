package com.webbanquanao.controller.admin;


import com.webbanquanao.model.Product;
import com.webbanquanao.service.ProductService;
import com.webbanquanao.service.impl.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = { "/admin/product/list" })
public class ProductListController extends HttpServlet {
    ProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> proList = productService.getAll();
        request.setAttribute("proList", proList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/View/admin/list-product.jsp");
        dispatcher.forward(request, response);
    }
}