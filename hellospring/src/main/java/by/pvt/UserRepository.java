package by.pvt;

import org.springframework.stereotype.Component;

@Component
public class UserRepository {

    public String findUserAddressByChannel(String channel, String userName){

        return "user_name@mail.ru";
    }
}
