package com.digi.controller;

import com.digi.enums.Status;
import com.digi.model.User;
import com.digi.repository.impl.UserRepositoryImplJDBC;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class VerificationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        UserRepositoryImplJDBC jdbc = new UserRepositoryImplJDBC();

        String verifyCode = request.getParameter("verifyCode");
        String email = (String) session.getAttribute("username");

        User user = jdbc.getByUsername(email);
        String verifyCodeDB = user.getVerifyCode();

        if(verifyCode.equals(verifyCodeDB)){
            user.setVerifyCode(null);
            user.setStatus(Status.ACTIVE);
            jdbc.updateUser(user);
            session.removeAttribute("username");
            response.sendRedirect("/login-page.jsp");
        } else {
           request.setAttribute("verifyCodeDB",verifyCodeDB);
           request.setAttribute("errorMessage","Wrong verification code");
           request.getRequestDispatcher("/verification.jsp").forward(request,response);
        }

    }
}
