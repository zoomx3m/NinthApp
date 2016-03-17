package com.example.asus.ninthapp.Handler;

import com.example.asus.ninthapp.Utils.Person;

public interface EventHandler {

    boolean onButtonLoginPressed(String login, String password);
    void onButtonRegisterPressed();
    void onButtonRegisterOk(Person person);

}
