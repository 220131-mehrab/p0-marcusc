package com.revature.cardex;

import com.revature.cardex.repository.CarRepository;

import java.sql.*;
import java.util.List;

public class SQLCarRepository implements CarRepository {
    @Override
    public Car getCar(String name) {
        Car result = null;
        try {
            Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            String query = "select * from car where name = '" + name + "'";
            Statement statement = conn.createStatement();
            statement.execute(query);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                result = Car.of()
                        .id(resultSet.getInt("id"))
                        .carModel(resultSet.getString("name"))
                        .mpg(resultSet.getInt("mpg"))
                        .horsePower(resultSet.getInt("horse_power"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Car> getCars() {
        return null;
    }
}
