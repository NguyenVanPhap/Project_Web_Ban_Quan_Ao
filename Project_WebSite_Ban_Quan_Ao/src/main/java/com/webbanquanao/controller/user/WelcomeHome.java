package com.webbanquanao.controller.user;


import com.webbanquanao.model.CategoryEntity;
import com.webbanquanao.model.ProductEntity;
import com.webbanquanao.model.UserEntity;
import com.webbanquanao.service.CategoryService;
import com.webbanquanao.service.ProductService;
import com.webbanquanao.service.impl.CategoryServiceImpl;
import com.webbanquanao.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns="/Home")
public class WelcomeHome extends HttpServlet {
    ProductService productService = new ProductServiceImpl();
    CategoryService cateService = new CategoryServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*HttpSession session = request.getSession();
        Object obj=session.getAttribute("account");
        UserEntity user=(UserEntity) obj;
        request.setAttribute("username", user.getUserName());*/
        List<ProductEntity> productList = productService.getAll();
        List<CategoryEntity> cateList = cateService.getAll();
        request.setAttribute("cateList",cateList);

        List<ProductEntity> newList = new ArrayList<>();
        for (int i = 0; i <productList.size() ; i++)
        {
            if(i<=10)
                newList.add(productList.get(i));
        }
        request.setAttribute("productList",newList);
        request.getRequestDispatcher("/View/User/index.jsp").forward(request, response);
    }

}


