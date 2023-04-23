package com.digi.repository.impl;

import com.digi.model.Address;
import com.digi.repository.AddressRepository;
import com.digi.util.MyDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressRepositoryImplJDBC implements AddressRepository{
    @Override
    public void saveAddress(Address address) {

        Connection connection = MyDataSource.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into address values (?,?,?,?,?,?)");

            preparedStatement.setInt(1,address.getAddressID());
            preparedStatement.setString(2, address.getCountry());
            preparedStatement.setString(3, address.getCity());
            preparedStatement.setString(4, address.getStreet());
            preparedStatement.setString(5, address.getHouse());
            preparedStatement.setInt(6,address.getUserID());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
