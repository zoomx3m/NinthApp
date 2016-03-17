package com.example.asus.ninthapp.Utils;

import java.io.Serializable;

public final class Person implements Serializable {
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private Gender gender;


//public Person(String login,String password, String firstName,String lastName, String gender){
//    this.login = login;
//    this.password = password;
//    this.firstName = firstName;
//    this.lastName = lastName;
//    this.gender = Gender.female;
//    this.gender = Gender.male;
//}


    //getter
    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Gender getGender() {
        return gender;
    }
    // setter
    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getMale_Female (){
        if (getGender() == Gender.male){
            return "Mr.";
        }else if (getGender() == Gender.female){
            return "Mrs.";
        }else {
            return "";
        }
    }

    public String setLogin (){
        return login;
    }

    public String getHeadLineName (){
        return getMale_Female() + " " + getFirstName() + " " + getLastName();
    }


}
