<%-- 
    Document   : index
    Created on : 08-Apr-2020, 12:28:44 AM
    Author     : RUDRESH PATEL
--%>

<%@page isELIgnored="false"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Student Management</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/CSS/styles.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script>
            $(document).ready(function () {
                $(".teacher-signup-form").hide();
                $(".student").css("color","#34b3a0");

                $(".teacher").click(function () {
                    $(".student-signup-form").hide();
                    $(".teacher-signup-form").show();
                    $(".student").css("color", "black");
                    $(".teacher").css("color", "#34b3a0");
                });

                $(".student").click(function () {
                    $(".teacher-signup-form").hide();
                    $(".student-signup-form").show();
                    $(".student").css("color", "#34b3a0");
                    $(".teacher").css("color", "black");
                });

            });
        </script>
    </head>
    <body>
        <div class="container">
            <div class="student">Student</div>
            <div class="teacher">Teacher</div>

            <div class="student-signup-form">
                <form method="POST" action="#">
                    <input type="number" name="studentID" placeholder="Enrollment number" class="input" required=""><br>
                    <!-- <input type="email" name="" placeholder="Email Address" class="input"><br> -->
                    <input type="password" name="studentPassword" placeholder="Password" class="input" required=""><br>
                    <div class="btn">
                        <button formaction="StudentLogin">Login</button>
                    </div>
                </form>

            </div>
            <div class="teacher-signup-form">
                <form method="POST" action="#">
                    <input type="text" name="teacherName" placeholder="Teacher Name" class="input" required=""><br>
                    <!-- <input type="email" name="" placeholder="Email Address" class="input"><br> -->
                    <input type="password" name="teacherPass" placeholder="Password" class="input" required=""><br>
                    <div class="btn">
                        <button formaction="TeacherLogin">Login</button>
                    </div>
                </form>
            </div>
            
        </div>
    </body>
</html>