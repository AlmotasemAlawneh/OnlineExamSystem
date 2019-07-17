package servlets;

import Storage.ApplicationStorage;
import Storage.StorageType;
import controller.UserDA;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedHashMap;

@WebServlet(name = "ServletgetQuestion")
public class ServletgetQuestion extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String question_id = request.getParameter("question_id");
        String req = request.getParameter("req");
        LinkedHashMap lhm = (LinkedHashMap) ApplicationStorage.getInstance(request, response).getValue(StorageType.Session,"all_answers");
        String answer = request.getParameter("answer");
        String set = (String) ApplicationStorage.getInstance(request, response).getValue(StorageType.Session,"set");

        if (req != null) { //submit action
            if (req.equals("last")) {
                lhm.put(question_id, answer);
                ApplicationStorage.getInstance(request, response).setValue(StorageType.Session,"all_answers", lhm);
            }

        }
        int correctAnswers= UserDA.setResult(Integer.parseInt(set),lhm,request,response);
        ApplicationStorage.getInstance(request, response).setValue(StorageType.Session,"TotalAnsweredQuestions", lhm.size());
        ApplicationStorage.getInstance(request, response).setValue(StorageType.Session,"examName", UserDA.getTheExamame(Integer.parseInt(set),request,response));
        ApplicationStorage.getInstance(request, response).setValue(StorageType.Session,"correcAnswers", correctAnswers);
        ApplicationStorage.getInstance(request, response).setValue(StorageType.Session,"currentExam", null);
        //response.sendRedirect("result.jsp");



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       HttpSession session = request.getSession();

        String set = (String) ApplicationStorage.getInstance(request, response).getValue(StorageType.Session,"set");
        String question_no = request.getParameter("question_no");
        String req = request.getParameter("req");
        String yAnswer= "";

        if (req != null) {
            if (req.equals("first")) {
                String result = UserDA.getQuestion(question_no, set,yAnswer,request,response);
                response.getWriter().print(result);
            }
            else {
                String question_id = request.getParameter("question_id");
                String answer = request.getParameter("answer");
                LinkedHashMap lhm = (LinkedHashMap) ApplicationStorage.getInstance(request, response).getValue(StorageType.Session,"all_answers");

                if (!answer.equals("undefined")) {


                    if (lhm == null) {
                        lhm = new LinkedHashMap();
                        lhm.put(question_id, answer);
                        ApplicationStorage.getInstance(request, response).setValue(StorageType.Session,"all_answers", lhm);
                    } else {
                        lhm.put(question_id, answer);
                        ApplicationStorage.getInstance(request, response).setValue(StorageType.Session,"all_answers", lhm);
                    }
                }

            }
        } else {
            String question_id = request.getParameter("question_id");
            String answer = request.getParameter("answer");
            LinkedHashMap lhm = (LinkedHashMap) ApplicationStorage.getInstance(request, response).getValue(StorageType.Session,"all_answers");

            if (!answer.equals("undefined")) {


                if (lhm == null) {
                    lhm = new LinkedHashMap();
                    lhm.put(question_id, answer);
                    ApplicationStorage.getInstance(request, response).setValue(StorageType.Session,"all_answers", lhm);
                }
                else {
                    lhm.put(question_id, answer);
                    ApplicationStorage.getInstance(request, response).setValue(StorageType.Session,"all_answers", lhm);
                }
            }

            yAnswer=lhm.get(question_no) != null ? (String)lhm.get(question_no):"";
            String result = UserDA.getQuestion(question_no, set,yAnswer,request,response);
            response.getWriter().print(result);
        }
    }
}
