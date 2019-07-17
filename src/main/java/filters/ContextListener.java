package filters;

import Storage.ApplicationStorage;
import Storage.StorageType;
import models.Exame;
import models.Question;
import models.User;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@WebListener()
public class ContextListener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    // Public constructor is required by servlet spec
    public ContextListener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent arg0) {
        List<User> users = getUsersDb();

        ApplicationStorage.getInstance(arg0.getServletContext()).setValue(StorageType.Application, "users", users);

        List<Exame> exames = getExameDb();

        ApplicationStorage.getInstance(arg0.getServletContext()).setValue(StorageType.Application, "exames", exames);
    }

    private List<Exame> getExameDb() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate localDate = LocalDate.now();
        String dateOfToday=dtf.format(localDate);

        List<Exame> exames = new ArrayList<>();
        Exame set1=new Exame();//https://www.tutorialspoint.com/java/java_online_test.htm
        set1.setset(1);
        set1.settitle("Core Java Concepts Exam "+ dateOfToday);
        Question q1=new Question();
        q1.setquestionText("What is synchronization?");
        q1.seta("Synchronization is the capability to control the access of multiple threads to shared resources.");
        q1.setb("Synchronization is the process of writing the state of an object to another object..");
        q1.setc("Synchronization is the process of writing the state of an object to byte stream.");
        q1.setd("None of the above..");
        q1.setcorrect("A");//zero based index
        q1.setnum(1);
        set1.addQuestion(q1);
        Question q2=new Question();
        q2.setquestionText(" What is the default value of byte variable?");
        q2.seta("0");
        q2.setb("0.0");
        q2.setc("null");
        q2.setd("undefined");
        q2.setcorrect("A");//zero based index
        q2.setnum(2);
        set1.addQuestion(q2);
        Question q3=new Question();
        q3.setquestionText("Method Overriding is an example of?");
        q3.seta("Static Binding.");
        q3.setb("Dynamic Binding.");
        q3.setc("Both of the above.");
        q3.setd("None of the above.");
        q3.setcorrect("B");//zero based index
        q3.setnum(3);
        set1.addQuestion(q3);
        Question q4=new Question();
        q4.setquestionText("When static binding occurs?");
        q4.seta("Static binding occurs during Compile time.");
        q4.setb("Static binding occurs during load time.");
        q4.setc("Static binding occurs during runtime.");
        q4.setd("None of the above.");
        q4.setcorrect("A");//zero based index
        q4.setnum(4);
        set1.addQuestion(q4);
        Question q5=new Question();
        q5.setquestionText("Which is the way in which a thread can enter the waiting state?");
        q5.seta("Invoke its sleep() method.");
        q5.setb("invoke object's wait method.");
        q5.setc("Invoke its suspend() method.");
        q5.setd("All of the above.");
        q5.setcorrect("D");//zero based index
        q5.setnum(5);
        set1.addQuestion(q5);
        Question q6=new Question();
        q6.setquestionText("Which of the following stands true about default modifier of class members?");
        q6.seta("By default, variables, methods and constructors can be accessed by subclass only.");
        q6.setb("By default, variables, methods and constructors can be accessed by any class lying in any package.");
        q6.setc("By default, variables, methods and constructors can be accessed by any class lying in the same package.");
        q6.setd("None of the above.");
        q6.setcorrect("C");//zero based index
        q6.setnum(6);
        set1.addQuestion(q6);
        Question q7=new Question();
        q7.setquestionText("What kind of variables a class can consist of?");
        q7.seta("class variables, instance variables");
        q7.setb("class variables, local variables, instance variables");
        q7.setc("class variables");
        q7.setd("class variables, local variables");
        q7.setcorrect("B");//zero based index
        q7.setnum(7);
        set1.addQuestion(q7);
        Question q8=new Question();
        q8.setquestionText("What is instance variable?");
        q8.seta("Instance variables are static variables within a class but outside any method.");
        q8.setb("Instance variables are variables defined inside methods, constructors or blocks.");
        q8.setc("Instance variables are variables within a class but outside any method.");
        q8.setd("None of the above.");
        q8.setcorrect("C");//zero based index
        q8.setnum(8);
        set1.addQuestion(q8);
        Question q9=new Question();
        q9.setquestionText("Which of the following is true about private access modifier?");
        q9.seta("Variables, methods and constructors which are declared private can be accessed only by the members of the same class.");
        q9.setb("Variables, methods and constructors which are declared private can be accessed by any class lying in same package.");
        q9.setc("Variables, methods and constructors which are declared private in the superclass can be accessed only by its child class.");
        q9.setd("None of the above.");
        q9.setcorrect("A");//zero based index
        q9.setnum(9);
        set1.addQuestion(q9);
        Question q10=new Question();
        q10.setquestionText("What is the default value of short variable?");
        q10.seta("0.0");
        q10.setb("0");
        q10.setc("null");
        q10.setd("undefined");
        q10.setcorrect("A");//zero based index
        q10.setnum(10);
        set1.addQuestion(q10);
        Question q11=new Question();
        q11.setquestionText("What is the size of long variable?");
        q11.seta("8 bit");
        q11.setb("16 bit");
        q11.setc("32 bit");
        q11.setd("64 bit");
        q11.setcorrect("D");//zero based index
        q11.setnum(11);
        set1.addQuestion(q11);
        Question q12=new Question();
        q12.setquestionText("What is Encapsulation?");
        q12.seta("Encapsulation is a technique to define different methods of same type.");
        q12.setb("Encapsulation is the ability of an object to take on many forms.");
        q12.setc("Encapsulation is the technique of making the fields in a class private and providing access to the fields via public methods.");
        q12.setd("None of the above.");
        q12.setcorrect("C");//zero based index
        q12.setnum(12);
        set1.addQuestion(q12);
        Question q13=new Question();
        q13.setquestionText("What is the default value of long variable?");
        q13.seta("0");
        q13.setb("0.0");
        q13.setc("0L");
        q13.setd("not defined");
        q13.setcorrect("C");//zero based index
        q13.setnum(13);
        set1.addQuestion(q13);
        Question q14=new Question();
        q14.setquestionText("What is the default value of int variable?");
        q14.seta("0");
        q14.setb("0.0");
        q14.setc("null");
        q14.setd("not defined");
        q14.setcorrect("A");//zero based index
        q14.setnum(14);
        set1.addQuestion(q14);
        Question q15=new Question();
        q15.setquestionText("What is the default value of float variable?");
        q15.seta("0.0d");
        q15.setb("0.0f");
        q15.setc("0");
        q15.setd("not defined");
        q15.setcorrect("B");//zero based index
        q15.setnum(15);
        set1.addQuestion(q15);

        Exame set2=new Exame();
        set2.setset(2);
        set2.settitle("HTML-CSS-JavaScript Exam "+ dateOfToday);
        List<Question> set2Question= new ArrayList<>();
        q1=new Question();
        q1.setquestionText("Which of the following defines 1% of viewport height?");
        q1.seta("px");
        q1.setb("vh");
        q1.setc("vw");
        q1.setd("vmin");
        q1.setcorrect("B");//zero based index
        q1.setnum(1);
        set2.addQuestion(q1);
        q2=new Question();
        q2.setquestionText("Which of the following property is used to underline, overline, and strikethrough text?");
        q2.seta(" text-indent");
        q2.setb("text-align");
        q2.setc("text-decoration");
        q2.setd("text-transform");
        q2.setcorrect("C");//zero based index
        q2.setnum(2);
        set2.addQuestion(q2);
        q3=new Question();
        q3.setquestionText("Which of the following property changes the style of bottom border?");
        q3.seta(":border-bottom-style");
        q3.setb(":border-top-style");
        q3.setc(":border-left-style");
        q3.setd(":border-right-style");
        q3.setcorrect("A");//zero based index
        q3.setnum(3);
        set2.addQuestion(q3);
        q4=new Question();
        q4.setquestionText("Which of the following property specifies the left margin of an element?");
        q4.seta(":margin");
        q4.setb(":margin-bottom");
        q4.setc(":margin-top");
        q4.setd(" :margin-left");
        q4.setcorrect("D");//zero based index
        q4.setnum(4);
        set2.addQuestion(q4);
        q5=new Question();
        q5.setquestionText("Which of the following property specifies the top padding of an element?");
        q5.seta("padding-bottom");
        q5.setb("padding-top");
        q5.setc("padding-left");
        q5.setd("padding-right");
        q5.setcorrect("B");//zero based index
        q5.setnum(5);
        set2.addQuestion(q5);
        q6=new Question();
        q6.setquestionText("Which of the following is true about variable naming conventions in JavaScript?");
        q6.seta("You should not use any of the JavaScript reserved keyword as variable name.");
        q6.setb("JavaScript variable names should not start with a numeral (0-9).");
        q6.setc("Both of the above.");
        q6.setd("None of the above.");
        q6.setcorrect("C");//zero based index
        q6.setnum(6);
        set2.addQuestion(q6);
        q7=new Question();
        q7.setquestionText("Which of the following function of String object returns the character at the specified index?");
        q7.seta("charAt()");
        q7.setb("charCodeAt()");
        q7.setc("concat()");
        q7.setd(" indexOf()");
        q7.setcorrect("A");//zero based index
        q7.setnum(7);
        set2.addQuestion(q7);
        q8=new Question();
        q8.setquestionText("Which of the following function of String object returns the calling string value \\n converted to lower case while respecting the current locale?");
        q8.seta("toLocaleLowerCase()");
        q8.setb("toLowerCase()");
        q8.setc("toString()");
        q8.setd("substring()");
        q8.setcorrect("A");//zero based index
        q8.setnum(8);
        set2.addQuestion(q8);
        q9=new Question();
        q9.setquestionText("Which of the following function of Array object removes the last element from an array and returns that element?");
        q9.seta("pop()");
        q9.setb("push()");
        q9.setc("join()");
        q9.setd("map()");
        q9.setcorrect("A");//zero based index
        q9.setnum(9);
        set2.addQuestion(q9);
        q10=new Question();
        q10.setquestionText("How can you show an alert box using JavaScript ?");
        q10.seta("frame.alert().");
        q10.setb("window.alert().");
        q10.setc("warning.alert().");
        q10.setd("authenticate.alert().");
        q10.setcorrect("B");//zero based index
        q10.setnum(10);
        set2.addQuestion(q10);
        q11=new Question();
        q11.setquestionText("Which of the following tag represents an independent piece of content of a document in HTML5?");
        q11.seta("section");
        q11.setb("article");
        q11.setc("aside");
        q11.setd("header");
        q11.setcorrect("B");//zero based index
        q11.setnum(11);
        set2.addQuestion(q11);
        q12=new Question();
        q12.setquestionText("Which of the following attribute triggers event when an element leaves a valid drop target?");
        q12.seta("ondrag");
        q12.setb("ondragleave");
        q12.setc("ondragover");
        q12.setd("ondragstart");
        q12.setcorrect("B");//zero based index
        q12.setnum(12);
        set2.addQuestion(q12);
        q13=new Question();
        q13.setquestionText("Which of the following attribute triggers events when a form gets user input?");
        q13.seta("onchange");
        q13.setb("onedit");
        q13.setc("onformchange");
        q13.setd("onforminput");
        q13.setcorrect("D");//zero based index
        q13.setnum(13);
        set2.addQuestion(q13);
        q14=new Question();
        q14.setquestionText("How can you show an alert box using JavaScript ?");
        q14.seta("frame.alert().");
        q14.setb("window.alert().");
        q14.setc("warning.alert().");
        q14.setd("authenticate.alert().");
        q14.setcorrect("B");//zero based index
        q14.setnum(14);
        set2.addQuestion(q14);
        q15=new Question();
        q15.setquestionText("How can you show an alert box using JavaScript ?");
        q15.seta("frame.alert().");
        q15.setb("window.alert().");
        q15.setc("warning.alert().");
        q15.setd("authenticate.alert().");
        q15.setcorrect("B");//zero based index
        q15.setnum(15);
        set2.addQuestion(q15);

        exames.add(set1);
        exames.add(set2);
        return exames;

    }
    private List<User> getUsersDb() {
        List<User> users = new ArrayList<>();
        User u = new User();
        u.setUsername("admin");
        u.setPassword("admin");
        u.setemail("admin@mum");
        u.addTestSet("<a href=\"takeExam?set=1\"><img class=\"button\" height=\"200\" width=\"200\"  style=\"border-radius: 50%;border: 5px solid #607D8B;background-color: snow;\" src=\"/images/java.png\"/></a>");
        u.addTestSet("<a href=\"takeExam?set=2\"><img class=\"button\" height=\"200\" width=\"200\" style=\"border-radius: 50%;border: 5px solid #607D8B;background-color: snow;left: 103px; position: relative;\" src=\"/images/javascript.png\"/></a>");
        users.add(u);

        u = new User();
        u.setUsername("user1");
        u.setPassword("pass");
        u.setemail("user1@mum");
        u.addTestSet("<a href=\"takeExam?set=1\"><img class=\"button\" height=\"200\" width=\"200\"  style=\"border-radius: 50%;border: 5px solid #607D8B;background-color: snow;\" src=\"/images/java.png\"/></a>");
        users.add(u);

        u = new User();
        u.setUsername("user2");
        u.setPassword("pass");
        u.setemail("user2@mum");
        u.addTestSet("<a href=\"takeExam?set=2\"><img class=\"button\" height=\"200\" width=\"200\" style=\"border-radius: 50%;border: 5px solid #607D8B;background-color: snow;\" src=\"/images/javascript.png\"/></a>");
        users.add(u);

        return users;
    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context
         (the Web application) is undeployed or
         Application Server shuts down.
      */
    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is added to a session.
      */
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attibute
         is replaced in a session.
      */
    }
}
