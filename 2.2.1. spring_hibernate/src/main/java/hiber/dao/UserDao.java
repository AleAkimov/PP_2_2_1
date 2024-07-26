package hiber.dao;

import hiber.model.User;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface UserDao {
    void add(User user);

    List<User> listUsers();

    User findUserByCarModelAndSeries(String carModel, int carSeries) throws SQLException;
}
