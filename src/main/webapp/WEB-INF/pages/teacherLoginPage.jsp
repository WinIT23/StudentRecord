<%-- 
    Document   : teacherLoginPage
    Created on : Apr 12, 2020, 9:48:54 AM
    Author     : KHATRI
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Teacher Home</title>
        <style>
            /* Chrome, Safari, Edge, Opera */
            input::-webkit-outer-spin-button,
            input::-webkit-inner-spin-button {
                -webkit-appearance: none;
                margin: 0;
            }

            /* Firefox */
            input[type=number] {
                -moz-appearance: textfield;
            }
        </style>
    </head>
    <body>
        
        <h1>Welcome ${Data}</h1>
        
        ${As.getAssignment_name()}
       
        <form method="POST">
            <input type="hidden" name="tName" value="${Data}">
            <input type="number" name="assignmentYear" placeholder="Year"><br>
<!--            <input type="text" name="assignmentBranch" placeholder="Branch" ><br>-->
            <input type="text" name="assginmentSubmitDate" placeholder="Submition date"><br>
            <input type="text" name="assginmentTitle" placeholder="AssignmentTitle"><br>
            <button formaction="AddAssign">Add</button>
        </form>
        
        <table>
            <th>Year</th>
            <th>Branch</th>
            <th>Name</th>
            <th>Date</th>
            
            <c:forEach items="${assignments}" var="assignment">
                <tr>
                    <td>${assignment.getAssignment_year()}</td>
                    <td>${year}</td>
                    <td>${assignment.getAssignment_name()}</td>
                    <td>${assignment.getSubmission_date()}</td>
                </tr>
            </c:forEach>
        </table>
       
    </body>
</html>
