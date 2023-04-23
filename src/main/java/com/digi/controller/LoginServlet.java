package com.digi.controller;

import com.digi.enums.Status;
import com.digi.model.User;
import com.digi.repository.impl.UserRepositoryImplJDBC;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        UserRepositoryImplJDBC jdbc = new UserRepositoryImplJDBC();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        session.setAttribute("username",username);
        User user = jdbc.getByUsername(username);

        if(user!= null && user.getPassword().equals(password) && user.getStatus().equals(Status.ACTIVE)){
           request.setAttribute("userInfo",user.getName() + " " + user.getSurname() + " " + user.getAge());
           request.getRequestDispatcher("/home-page.jsp").forward(request,response);
        } else {
           request.setAttribute("errorMessage", "Wrong email or password");
           request.getRequestDispatcher("/login-page.jsp").forward(request,response);
        }
    }
}
