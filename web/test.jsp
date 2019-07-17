<%--
  Created by IntelliJ IDEA.
  User: mot_a
  Date: 7/13/2019
  Time: 5:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <title>WAP Online Exam</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css" />
    <script src="/js/jquery-1.11.3.js"></script>
</head>

<body onload="startTimer()">

<script type="text/javascript">
    var question_no=1;
    var question_id=0;
    var max_questions=15;

    var timer=60;
    var min=0;
    var sec=0;
    var isTimeOut=false;

//in case of relod log out the exame
    window.onbeforeunload = function() {
        if(question_no!=max_questions && !isTimeOut)
        {
            //alert("You will lose you work !!!!");
            //
           // $.get('logout',function(data,status) {
             //   window.location="login.jsp";
            //});border: 4px solid maroon;
            ${sessionScope.currentExam=null}
            //window.location="result.jsp";
        }
    };

    function startTimer(){
        min=parseInt(timer/60);
        sec=parseInt(timer%60);

        if(timer<1){
            isTimeOut=true;
            $.post('getQuestion');
            window.location='result.jsp';
        }
        $("#time").html("<strong>Time Left: </strong>"+min.toString()+":"+sec.toString());
        //document.getElementById("time").innerHTML = "<strong>Time Left: </strong>"+min.toString()+":"+sec.toString();
        timer--;
        setTimeout(function(){ startTimer(); }, 1000);
    }

    $(document).ready(function(){
        $.get('getQuestion?question_no='+question_no+'&req=first',function(data,status){
            var obj=JSON.parse(data);
            question_id=obj.id;
            $('#question').html('<strong>Question '+question_no+': </strong><br/>'+obj.question);
            $('#a').html('<strong>A:</strong><input type="radio" name="answer" value="A">'+obj.a);
            $('#b').html('<strong>B:</strong><input type="radio" name="answer" value="B">'+obj.b);
            $('#c').html('<strong>C:</strong><input type="radio" name="answer" value="C">'+obj.c);
            $('#d').html('<strong>D:</strong><input type="radio" name="answer" value="D">'+obj.d);
        });

        if(question_no==1){
            $('#back').hide();
        }
        else{
            $('#back').show();
        }

        if(question_no==max_questions){
            $('#next').hide();
        }
        else{
            $('#next').show();
        }

        if(question_no!=max_questions){
            $('#submit').hide();
        }
        else{
            $('#submit').show();
        }

        $('#next').click(function(){
            var answer=$('input[name=answer]:checked').val();
            var s=$('input[name=answer]:checked').size();

            if(s==0){
                alert("Please select answer for this question");
            }
            else{
                question_no++;
                $.get('getQuestion?question_no='+question_no+'&question_id='+question_id+'&answer='+answer,function(data,status){
                    var obj=JSON.parse(data);
                    question_id=obj.id;
                    $('#question').html('<strong>Question '+question_no+': </strong><br/>'+obj.question);
                    $('#a').html('<strong>A:</strong><input type="radio" name="answer" value="A">'+obj.a);
                    $('#b').html('<strong>B:</strong><input type="radio" name="answer" value="B">'+obj.b);
                    $('#c').html('<strong>C:</strong><input type="radio" name="answer" value="C">'+obj.c);
                    $('#d').html('<strong>D:</strong><input type="radio" name="answer" value="D">'+obj.d);
                });

                if(question_no==1){
                    $('#back').hide();
                }
                else{
                    $('#back').show();
                }

                if(question_no==max_questions){
                    $('#next').hide();
                }
                else{
                    $('#next').show();
                }

                if(question_no!=max_questions){
                    $('#submit').hide();
                }
                else{
                    $('#submit').show();
                }
            }
        });

        $('#submit').click(function(){
            var answer=$('input[name=answer]:checked').val();
            var s=$('input[name=answer]:checked').size();

            if(s==0){
                alert("Please select answer for this question");
            }
            else{
                $.post('getQuestion?question_no='+question_no+'&question_id='+question_id+'&answer='+answer+"&req=last");
                window.location='result.jsp';
            }
        });


        $('#back').click(function(){
            question_no--;
            var answer=$('input[name=answer]:checked').val();

            $.get('getQuestion?question_no='+question_no+'&question_id='+question_id+'&answer='+answer,function(data,status){
                var obj=JSON.parse(data);
                question_id=obj.id;
                $('#question').html('<strong>Question '+question_no+': </strong><br/>'+obj.question);
                $('#a').html('<strong>A:</strong><input type="radio" name="answer" value="A" required>'+obj.a);
                $('#b').html('<strong>B:</strong><input type="radio" name="answer" value="B">'+obj.b);
                $('#c').html('<strong>C:</strong><input type="radio" name="answer" value="C">'+obj.c);
                $('#d').html('<strong>D:</strong><input type="radio" name="answer" value="D">'+obj.d);
                switch(obj.yAnswer){
                    case "A":
                        $("input[name=answer][value=A]").prop('checked', true);
                        break;
                    case "B":
                        $("input[name=answer][value=B]").prop('checked', true);
                        break;
                    case "C":
                        $("input[name=answer][value=C]").prop('checked', true);
                        break;
                    case "D":
                        $("input[name=answer][value=D]").prop('checked', true);
                        break;

                }
            });

            if(question_no==1){
                $('#back').hide();
            }
            else{
                $('#back').show();
            }

            if(question_no==max_questions){
                $('#next').hide();
            }
            else{
                $('#next').show();
            }

            if(question_no!=max_questions){
                $('#submit').hide();
            }
            else{
                $('#submit').show();
            }
        });

    });

</script>
<div id="userName" style="position: absolute;
    left: 175px;
    top: 20px;
    box-shadow: 10px 10px 5px grey;
    font-weight: bold;
    background-color: snow;
    font-size: 15pt;">
    UserID : ${sessionScope.user.username}
</div>
<div id="showtime" style="position: absolute;
    left: 1223px;
    top: 20px;
    box-shadow: 10px 10px 5px grey;">
    <p id="time"></p>
    <p id="test"></p>
</div>

<div style="position: relative;
    height: 50%;
    top: 78px;
    margin: auto;
    width: 75%;
    box-shadow: 10px 10px 5px grey;
    padding: 10px;
    background-color: whitesmoke;">

    <p id="question"></p><br/><br/>
    <p id="a"></p>
    <p id="b"></p>
    <p id="c"></p>
    <p id="d"></p>

    <br/>
<div style="margin: auto;text-align: center;">
    <button class="button" id="back">Back</button>&nbsp;
    <button class="button" id="next">Next</button>
    <button class="button" id="submit">Submit</button>
</div>

</div>
<h3 style="position: relative;
    top: 25%;
    color: red;
    text-align: center;">Don`t refresh this page or try to navigate back using the browser navigator buttons...</h3>
</body>

</html>
