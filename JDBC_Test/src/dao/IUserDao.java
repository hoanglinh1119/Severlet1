package dao;

import models.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDao {
    void insertUser(User user);
    User selectUser(int id);
    List<User> selectAllUser();
    List<User> searchUserFollowCountry(String country);
    boolean deleteUser(int id);
    boolean updateUser(User user);
}
