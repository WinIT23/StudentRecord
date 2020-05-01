<%-- 
    Document   : teacherLoginPage
    Created on : Apr 12, 2020, 9:48:54 AM
    Author     : KHATRI, Win_It
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/CSS/styles.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Teacher Home</title>
    </head>
    <body>

        <h1 class="header">Welcome ${Data}</h1>

        <div class="header_small">
            <c:if test="${!empty As.assignment_name}">
            ${As.assignment_name} is added!!
        </c:if>
        </div>

        <div class="container">
            <div class="assignment-form">
                <form method="POST">
                    <input type="hidden" name="tName" class="input" value="${Data}">
                    <input type="number" name="assignmentYear" class="input" placeholder="Year"><br>
                    <!--            <input type="text" name="assignmentBranch" placeholder="Branch" ><br>-->
                    <input type="text" name="assginmentSubmitDate" class="input" placeholder="Submition date"><br>
                    <input type="text" name="assginmentTitle" class="input" placeholder="AssignmentTitle"><br>
                    <div class="btn">
                        <button style="margin:10px 0px" formaction="AddAssign">Add</button>
                    </div>
                </form>
            </div>
        </div>

        </div>
        <table class="assignment_table">
            <thead>
                <tr>
                    <th>Year</th>
                    <th>Branch</th>
                    <th>Name</th>
                    <th>Date</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${assignments}" var="assignment">
                    <tr>
                        <td>${assignment.getAssignment_year()}</td>
                        <td>${year}</td>
                        <td>${assignment.getAssignment_name()}</td>
                        <td>${assignment.getSubmission_date()}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
