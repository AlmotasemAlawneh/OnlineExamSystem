package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Exame {
    int set;
    String title;
    List<Question> questions=new ArrayList<>();

    public int getset() {
        return set;
    }
    public void setset(int set){
        this.set = set;
    }

    public String gettitle() {
        return title;
    }
    public void settitle(String title){
        this.title = title;
    }

    public  List<Question> getquestion() {
        return questions;
    }
    public void setquestion( List<Question> question){
        this.questions = questions;
    }

    public void addQuestion(Question q){questions.add(q);}

    public String getQuestionAnswer(int qId){
        return questions.stream().filter(x->x.getnum()==qId).collect(Collectors.toList()).get(0).getcorrect();
    }

}
