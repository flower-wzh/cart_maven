package com.wzh.action;

import com.wzh.entity.User;
import com.wzh.service.impl.UserServiceImpl;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;

import static com.opensymphony.xwork2.Action.SUCCESS;

public class UserAction {
    private String username;
    private String password;
    private User user;

    public String execute() {
        UserServiceImpl userService = new UserServiceImpl();
        user = userService.login(username, password);
        HttpSession session = ServletActionContext.getRequest().getSession();
        session.setAttribute("user", user);
        return SUCCESS;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
