package service;

import pojo.User;

import java.util.List;

public interface UserDao {
    public User Login(User user);
    public Boolean RegisterUser(User user);
    public List<User> getUserList(User user);
    public boolean updateUser(User user);
    public boolean deleteUserByid(Integer user_id);
    public User getUserByid(Integer user_id);
    public List<User> selectUserByWhere(String name);
    public boolean checkPassword(User user);
    public boolean updatePwd1(User user);
    public int updatePwd2(String password,Integer user_id);
}
