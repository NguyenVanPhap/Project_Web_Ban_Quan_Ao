package com.webbanquanao.controller.user;

import com.webbanquanao.model.ProductEntity;
import com.webbanquanao.service.ProductService;
import com.webbanquanao.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet(urlPatterns="/product/searchByPrice")
public class ProductSearchByPrice extends HttpServlet{
    ProductService productService=new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Hello");
        double startPrice=Double.parseDouble(req.getParameter("startPrice"));
        double endPrice=Double.parseDouble(req.getParameter("endPrice"));
        List<ProductEntity> productSeachByPrice =productService.searchByPrice(startPrice,endPrice);
        req.setAttribute("productList", productSeachByPrice);
        req.getRequestDispatcher("/View/User/ProductSearchByCategory.jsp").forward(req, resp);
    }
}

