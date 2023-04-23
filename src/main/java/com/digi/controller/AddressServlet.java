package com.digi.controller;

import com.digi.model.Address;
import com.digi.model.User;
import com.digi.repository.impl.AddressRepositoryImplJDBC;
import com.digi.repository.impl.UserRepositoryImplJDBC;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class AddressServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session = request.getSession();

        AddressRepositoryImplJDBC ajdbc = new AddressRepositoryImplJDBC();

        String country = request.getParameter("Country");
        String city = request.getParameter("City");
        String street = request.getParameter("Street");
        String house = request.getParameter("House");

        UserRepositoryImplJDBC jdbc = new UserRepositoryImplJDBC();

        String email = (String) session.getAttribute("username");
        User user1 = jdbc.getByUsername(email);
        int userID = user1.getId();

        Address address = new Address(0,country,city,street,house,userID);
        ajdbc.saveAddress(address);

        String userInfo = (String) request.getAttribute("userInfo");
        request.setAttribute("addressInfo",user1.getName() + " " + user1.getSurname() + " " + user1.getAge() + "<br><br>"+
                "country: " + address.getCountry() + "<br><br>" + "city: " + address.getCity());

        request.getRequestDispatcher("/home-page.jsp").forward(request,response);
    }
}
