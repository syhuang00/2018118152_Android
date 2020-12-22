package com.example.hsyaddressbook;

import java.security.PublicKey;
import java.util.List;

public interface UserDao {
    public List<User> getUser();
    public boolean AddMail(User user);
    public boolean DelMail(String id);
    public boolean UpdateMail(User ml);
    public User GetOne(String id);
    public List<User> SearchLikeUser(String s);
}
