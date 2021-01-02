package com.webbanquanao.controller.user;


import com.webbanquanao.model.CategoryEntity;
import com.webbanquanao.model.ProductEntity;
import com.webbanquanao.model.UserEntity;
import com.webbanquanao.service.CategoryService;
import com.webbanquanao.service.ProductService;
import com.webbanquanao.service.UserService;
import com.webbanquanao.service.impl.CategoryServiceImpl;
import com.webbanquanao.service.impl.ProductServiceImpl;
import com.webbanquanao.service.impl.UserServiceImpl;

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
    UserService userService = new UserServiceImpl();

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

        try {
            String id=request.getParameter("cateid");
            if(id!=null)
            {
                int cateid = Integer.parseInt(id);
                if ( cateid == 5 || cateid == 8) {
                    productList = productService.searchByCategory(cateid);
                }
            }
        }
        catch (Exception e)
        {}
        if(productList==null)
        {
            productList = productService.getAll();
        }
        for (int i = 0; i <productList.size() ; i++)
        {
            if(i<=10)
                newList.add(productList.get(i));
        }

        try {
        //Đăng nhập:
            HttpSession session = request.getSession();
            String email = session.getAttribute("email").toString();
            List<UserEntity> user = userService.search(email);
            user.forEach((u -> {
                request.setAttribute("user", u.getUserName());
            }));
            request.setAttribute("email", email);
        }
        catch (Exception e) {

        }

        request.setAttribute("productList",newList);
        request.getRequestDispatcher("/View/User/index.jsp").forward(request, response);
    }

}


