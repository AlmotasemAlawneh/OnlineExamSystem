package controller;
import Storage.ApplicationStorage;
import Storage.StorageType;
import models.*;
import org.json.simple.JSONObject;

import javax.naming.Context;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import java.util.stream.Collectors;
import java.util.zip.Checksum;

public class UserDA{
    public static String registerUser(String name, String email, HttpServletRequest req, HttpServletResponse resp) {
        try{
            ApplicationStorage storage = ApplicationStorage.getInstance(req,resp);
            List<User> users = storage.getValue(StorageType.Application, "users");
            User user = new User();

            if(users.stream().anyMatch(u ->
                    u.getUsername().equals(name) &&
                            u.getemail().equals(email)
            )){
                return "registered";
            }
            else {
                User u = new User();
                u.setUsername(name);
                u.setPassword("pass");
                u.setemail(email);
                users.add(u);
                storage.setValue(StorageType.Application, "users", users);
                return "true";
            }
        }catch(Exception e) {
            e.printStackTrace();
            return "false";
        }

    }
    public static String getQuestion(String question_no,String set,String answer, HttpServletRequest req, HttpServletResponse resp){
        ApplicationStorage storage = ApplicationStorage.getInstance(req,resp);
        List<Exame> exames = storage.getValue(StorageType.Application, "exames");
        Exame selectedSet=exames.stream().filter(x->x.getset()==Integer.parseInt(set)).collect(Collectors.toList()).get(0);
        JSONObject obj=new JSONObject();

        try{
            Question q = selectedSet.getquestion().stream().filter(x->x.getnum()==Integer.parseInt(question_no)).collect(Collectors.toList()).get(0);
            if(q != null)
            {
                obj.put("question", q.getquestionText());
                obj.put("id",q.getnum());
                obj.put("a", q.geta());
                obj.put("c", q.getc());
                obj.put("d", q.getd());
                obj.put("b", q.getb());
                obj.put("yAnswer", answer);
            }


        }catch(Exception e){
            e.printStackTrace();
        }

        return obj.toString();
    }
    public static boolean CheckLogedInUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
       ApplicationStorage storage = ApplicationStorage.getInstance(req,resp);
       List<User> users = storage.getValue(StorageType.Application, "users");
       User user = new User();
       user.setUsername(req.getParameter("username"));
       user.setPassword(req.getParameter("password"));

       if(users.stream().noneMatch(u ->
               u.getUsername().equals(user.getUsername()) &&
                       u.getPassword().equals(user.getPassword())
       )) {
           return false;
       }
       else {
           User u1=users.stream().filter(x->x.getUsername().equals(user.getUsername())).collect(Collectors.toList()).get(0);
           user.seAvailabelTest(u1.getAvailabelTest());
           storage.setValue(StorageType.Session, "user", user);
           return true;
       }
   }
    public static String getTheExamame(int set,HttpServletRequest req, HttpServletResponse resp){
        ApplicationStorage storage = ApplicationStorage.getInstance(req,resp);
        List<Exame> exames = storage.getValue(StorageType.Application, "exames");
        Exame selectedSet=exames.stream().filter(x->x.getset()==set).collect(Collectors.toList()).get(0);

        return selectedSet!=null ? selectedSet.gettitle() : "";
    }
    public static int setResult(int set, LinkedHashMap lhm,HttpServletRequest req, HttpServletResponse resp){
        int countCorrectAnswes=0;
        try{
            ApplicationStorage storage = ApplicationStorage.getInstance(req,resp);
            List<Exame> exames = storage.getValue(StorageType.Application, "exames");
            Exame selectedSet=exames.stream().filter(x->x.getset()==set).collect(Collectors.toList()).get(0);


            Set all_Answeres=lhm.entrySet();
            Iterator it=all_Answeres.iterator();

            while(it.hasNext()){
                Map.Entry m=(Map.Entry)it.next();
                if(selectedSet.getQuestionAnswer(Integer.parseInt(m.getKey().toString())).equals(m.getValue().toString()))
                    countCorrectAnswes++;
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        finally {

            return countCorrectAnswes;
        }
    }
    public static String getAvailableExams(HttpServletRequest req, HttpServletResponse resp)
    {
        String toReturn="";
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        User user = ApplicationStorage
                .getInstance(request, response)
                .getValue(StorageType.Session, "user");
        for (String x:user.getAvailabelTest()) {
            toReturn+=x;
        }

        return toReturn;
    }
}
