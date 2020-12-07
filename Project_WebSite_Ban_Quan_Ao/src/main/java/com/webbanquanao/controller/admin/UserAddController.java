package com.webbanquanao.controller.admin;

import com.webbanquanao.model.User;
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
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@WebServlet(urlPatterns = { "/admin/user/add" })
public class UserAddController extends HttpServlet {
    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String eString = req.getParameter("e");
        if (eString != null) {
            if (eString.equals("1")) {
                req.setAttribute("errMsg", "Username da ton tai!!!");
            }
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/View/admin/add-user.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();

        ServletContext servletContext = this.getServletConfig().getServletContext();
        /*File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
        diskFileItemFactory.setRepository(repository);*/

        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);

        try {
            List<FileItem> items = servletFileUpload.parseRequest(req);
            for (FileItem item : items) {
                if (item.getFieldName().equals("email")) {
                    user.setEmail(item.getString());;
                } else if (item.getFieldName().equals("username")) {
                    user.setUserName(item.getString());
                } else if (item.getFieldName().equals("password")) {
                    user.setPassword(item.getString());
                }else if (item.getFieldName().equals("address")) {
                    user.setAddress(item.getString());
                } else if (item.getFieldName().equals("permission")) {
                    user.setPermission(Integer.parseInt(item.getString()));;
                } else if (item.getFieldName().equals("avatar")) {
                    String originalFileName = item.getName();
                    Path path =Paths.get(originalFileName);
                    final String storepath=servletContext.getRealPath("image");
                    System.out.println("File1: "+storepath+"\\"+path.getFileName());
                    File file = new File(storepath + "\\" + path.getFileName());
                    item.write(file);
                    user.setAvatar(originalFileName);
                    userService.insert(user);

                }
            }



            resp.sendRedirect(req.getContextPath() + "/admin/user/list");
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            resp.sendRedirect(req.getContextPath() + "/admin/user/add?e=1");
        }

    }
}
