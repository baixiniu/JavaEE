package sas.dao;

public class User {
    private String username;
    private String password;
    public User(String name, String pass){
        username=name;password=pass;
    }
    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }
}
