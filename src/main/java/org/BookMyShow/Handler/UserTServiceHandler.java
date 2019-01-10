package org.BookMyShow.Handler;

import org.BookMyShow.Service.UserService;
import org.BookMyShow.thrift.gen.UserTService;
import org.BookMyShow.thrift.gen.UserThrift;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserTServiceHandler implements UserTService.Iface {
    private UserService userService;
    @Autowired
    public UserTServiceHandler(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean ping() throws TException {
        return true;
    }

    @Override
    public List<UserThrift> getAllUser() throws TException {
        return null;
    }

    @Override
    public boolean loginUser(String uname, String upass) throws TException {

        return userService.LoginUtil(uname, upass);
    }

    @Override
    public String registerUser(String uname, String upass) throws TException {

        //System.out.println("------------->In Register");
        String out= userService.RegistrationUtil(uname, upass);
        //System.out.println("------------->"+out);
        return out;
    }


}
