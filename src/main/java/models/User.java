package models;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String password;
    private String email;
    private List<String> availabelTest=new ArrayList<>();

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public String getemail() {
        return email;
    }
    public void setemail(String email) {
        this.email = email;
    }

    public void addTestSet(String setNum){availabelTest.add(setNum);}
    public List<String> getAvailabelTest() {
        return availabelTest;
    }
    public void seAvailabelTest(List<String> availabelTest) {
        this.availabelTest = availabelTest;
    }

}
