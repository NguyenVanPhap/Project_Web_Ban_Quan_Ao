package com.webbanquanao.controller.user;

import com.webbanquanao.model.UserEntity;
import com.webbanquanao.service.UserService;
import com.webbanquanao.service.impl.UserServiceImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = { "/User/signup" })
public class SignUpController extends HttpServlet {
    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String eString = req.getParameter("e");
        if (eString != null) {
            if (eString.equals("1")) {
                req.setAttribute("errMsg", "Username da ton tai!!!");
            }
        }
        //req.setAttribute("passError","Those passwords didn't match. Try again.");
//        String passErr = session.getAttribute("passErr").toString();
//        session.setAttribute("passError",passErr);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/View/User/signin.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserEntity user = new UserEntity();
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();

        ServletContext servletContext = this.getServletConfig().getServletContext();
        /*File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
        diskFileItemFactory.setRepository(repository);*/

        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
        String url="";
        String email = "";
        String pass = "";
        String cfpass = "";
        String passError = null;
        try {
            List<FileItem> items = servletFileUpload.parseRequest(req);
            for (FileItem item : items) {
                if (item.getFieldName().equals("email"))
                {
                    user.setEmail(item.getString());
                    email = item.getString();

                    session.setAttribute("email",email);
                } else if (item.getFieldName().equals("password"))
                {
                    user.setPassword(item.getString());
                    pass = item.getString();
                } else if (item.getFieldName().equals("cfpassword")){
                    cfpass = item.getString();
                }


            }
            user.setUserName("");
            user.setAddress("");
            user.setPermission(0);;
            user.setAvatar(null);
            if(email.equals("")){
                session.setAttribute("SignUpErr","Enter your Email.");

                resp.sendRedirect(req.getContextPath() + "/User/signup");
            }
            else if(userService.checkExistEmail(email)){
                session.setAttribute("SignUpErr","This Email was used.");
                resp.sendRedirect(req.getContextPath() + "/User/signup");
            }
            else if(pass.equals("")){
                session.setAttribute("SignUpErr","Enter password");
                resp.sendRedirect(req.getContextPath() + "/User/signup");
            }
            else if(pass.equals(cfpass)){
                userService.insert(user);
                resp.sendRedirect(req.getContextPath() + "/admin/user/list");
            }
            else{
                session.setAttribute("SignUpErr","Those passwords didn't match. Try again.");
                resp.sendRedirect(req.getContextPath() + "/User/signup");
            }
            //req.setAttribute("passError","Those passwords didn't match. Try again.");


        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            /*resp.sendRedirect(req.getContextPath() + "/admin/user/add?e=1");*/
            resp.sendRedirect(req.getContextPath() + "/admin/user/list");
        }

    }
}