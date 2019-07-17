package filters;

import Storage.ApplicationStorage;
import Storage.StorageType;
import controller.UserDA;
import models.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AppFilter", urlPatterns = { "/*" })
public class AppFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();

        User user = ApplicationStorage
                .getInstance(request, response)
                .getValue(StorageType.Session, "user");

        if (user == null && (!request.getServletPath().contains("login"))){
            response.sendRedirect( ((HttpServletRequest)servletRequest).getContextPath() + "/login.jsp");
            return;
        }
        else if (user != null && (request.getServletPath().contains("/home"))) {
            ApplicationStorage.getInstance(request, response).setValue(StorageType.Session,"TotalAnsweredQuestions", 0);
            ApplicationStorage.getInstance(request, response).setValue(StorageType.Session,"examName", "NA");
            ApplicationStorage.getInstance(request, response).setValue(StorageType.Session,"correcAnswers", 0);
            ApplicationStorage.getInstance(request, response).setValue(StorageType.Session,"currentExam", null);
            //response.sendRedirect(((HttpServletRequest)servletRequest).getContextPath() +"/home.jsp");

            //return;
        }
        else if(user != null && session.getAttribute("currentExam") == null &&(request.getServletPath().contains("/test"))) {
            ApplicationStorage.getInstance(request, response).setValue(StorageType.Session,"TotalAnsweredQuestions", "Not Completed");
            ApplicationStorage.getInstance(request, response).setValue(StorageType.Session,"examName", "Not Completed");
            ApplicationStorage.getInstance(request, response).setValue(StorageType.Session,"correcAnswers", 0);
            ApplicationStorage.getInstance(request, response).setValue(StorageType.Session,"currentExam", null);
            response.sendRedirect(((HttpServletRequest) servletRequest).getContextPath() + "/result.jsp");
        }

        chain.doFilter(servletRequest, servletResponse);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
