package ua.somedomen.obcc.service;


import ua.somedomen.obcc.entity.User;

import java.util.List;

public interface UserService
{
    void save(User user);
    List<User> findAll();
    User findByUsername(String name);
}
