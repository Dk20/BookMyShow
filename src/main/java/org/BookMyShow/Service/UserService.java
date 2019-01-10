package org.BookMyShow.Service;

import org.BookMyShow.Model.User;
import org.BookMyShow.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String RegistrationUtil(String uname,String upass){
        String outT = "User Added!";
        String outF = "User Could not be added!";
        try{
            userRepository.save(new User(uname, upass));
            return outT;
        }catch(Exception e){
            System.out.println("User Could not be added!");
            e.printStackTrace();
            return outF;
        }

    }

    public Boolean LoginUtil(String uname,String upass){
        Optional<User> user = null ;
        try{
            user = userRepository.findByUnameAndUpass(uname, upass);
        }catch (Exception e){
            System.out.println("DB problem!");
            e.printStackTrace();
        }

        if(user.isPresent())
            return true;
        return false;
    }

}
