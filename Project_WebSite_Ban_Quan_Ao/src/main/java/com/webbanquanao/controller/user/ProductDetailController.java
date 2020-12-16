package com.webbanquanao.controller.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webbanquanao.model.CategoryEntity;
import com.webbanquanao.model.ProductEntity;
import com.webbanquanao.service.CategoryService;
import com.webbanquanao.service.ProductService;
import com.webbanquanao.service.impl.CategoryServiceImpl;
import com.webbanquanao.service.impl.ProductServiceImpl;
@WebServlet(urlPatterns="/product/detail")
public class ProductDetailController extends HttpServlet {
    ProductService productService = new ProductServiceImpl();
    CategoryService categoryService = new CategoryServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProductEntity> productList = productService.getAll();
        Random rand = new Random();

        List<ProductEntity> newList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            // take a raundom index between 0 to size
            // of given List
            int randomIndex = rand.nextInt(productList.size());
            // add element in temporary list
            newList.add(productList.get(randomIndex));
        }
        req.setAttribute("RelateProductList", newList);

        String id = req.getParameter("id");
        ProductEntity product = productService.get(Integer.parseInt(id));
        List<CategoryEntity> categories = categoryService.getAll();
        req.setAttribute("categories", categories);
        req.setAttribute("product", product);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/View/User/product-detail.jsp");
        dispatcher.forward(req, resp);
    }

}
