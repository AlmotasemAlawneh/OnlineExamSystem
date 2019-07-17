package models;

public class Question {
    String questionText;
    String a;
    String b;
    String c;
    String d;
    String correct;
    int num;

    public String getquestionText() {
        return questionText;
    }
    public void setquestionText(String questionText){
        this.questionText = questionText;
    }

    public String geta() {
        return a;
    }
    public void seta(String a){
        this.a = a;
    }

    public String getb() {
        return b;
    }
    public void setb(String b){
        this.b = b;
    }

    public String getc() {
        return c;
    }
    public void setc(String c){
        this.c = c;
    }

    public String getd() {
        return d;
    }
    public void setd(String d){
        this.d = d;
    }

    public String getcorrect() {
        return correct;
    }
    public void setcorrect(String correct){
        this.correct = correct;
    }

    public int getnum() {
        return num;
    }
    public void setnum(int num){
        this.num = num;
    }
}
