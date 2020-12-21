package com.webbanquanao.controller.user;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webbanquanao.model.ProductEntity;
import com.webbanquanao.service.ProductService;
import com.webbanquanao.service.impl.ProductServiceImpl;
@WebServlet(urlPatterns="/product/SearchName")
public class ProductSearchByName extends HttpServlet {
    ProductService productService=new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name_search=req.getParameter("search_name");
        List<ProductEntity> productSeachByName =productService.searchByName(name_search);
        req.setAttribute("productList", productSeachByName);
        req.getRequestDispatcher("/View/User/ProductSearchByName.jsp").forward(req, resp);
    }
}
