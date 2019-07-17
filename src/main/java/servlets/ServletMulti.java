package servlets;

import Storage.ApplicationStorage;
import Storage.StorageType;
import controller.UserDA;
import models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Random;

@WebServlet(name = "ServletMulti" ,urlPatterns = { "/login" ,"/takeExam" })
public class ServletMulti extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*String name=request.getParameter("name");
        String email=request.getParameter("email");
        String result= UserDA.CheckLogedInUser(request,response);
*/
        String applicationContextPath = request.getContextPath();
        if (request.getRequestURI().equals(applicationContextPath + "/login")) {
            HttpSession session = request.getSession();
            if (UserDA.CheckLogedInUser(request, response)) {
                request.setAttribute("LogedInUser", request.getParameter("username"));
                ApplicationStorage.getInstance(request, response).setValue(StorageType.Session,"availableTests", UserDA.getAvailableExams(request,response));
                RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
                rd.forward(request, response);

            } else {
                request.setAttribute("errorMessage", "Invalid username or password");
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
            }
        }





    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String applicationContextPath = request.getContextPath();
        if(request.getRequestURI().equals(applicationContextPath + "/takeExam")){

            String examSet = request.getParameter("set");
            String exameTitle=UserDA.getTheExamame(Integer.parseInt(examSet),request,response);
            if(exameTitle != "") {
                ApplicationStorage.getInstance(request, response).setValue(StorageType.Session,"currentExam1", "T");
                ApplicationStorage.getInstance(request, response).setValue(StorageType.Session,"currentExam", "True");
                ApplicationStorage.getInstance(request, response).setValue(StorageType.Session,"set", examSet);
                ApplicationStorage.getInstance(request, response).setValue(StorageType.Session,"exameTitle", exameTitle);
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher("ExamInstruction.jsp");
            dispatcher.forward(request, response);
        }
    }
}
