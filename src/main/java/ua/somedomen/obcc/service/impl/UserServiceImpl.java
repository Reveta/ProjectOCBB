package ua.somedomen.obcc.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.somedomen.obcc.dao.UserDAO;
import ua.somedomen.obcc.entity.User;
import ua.somedomen.obcc.service.UserService;


import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService
{
    @Autowired
    private UserDAO dao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void save(User user)
    {
        String password = user.getPassword();
        String encode = passwordEncoder.encode(password);
        user.setPassword(encode);
        dao.save(user);
    }

    @Override
    public List<User> findAll()
    {
        return dao.findAll();
    }

    @Override
    public User findByUsername(String name)
    {
        return dao.findByUsername(name);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        return findByUsername(username);
    }
}
