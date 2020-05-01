<%-- 
    Document   : loginPage
    Created on : 08-Apr-2020, 10:54:16 PM
    Author     : RUDRESH PATEL, Win_It
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/CSS/styles.css">
        <title>Student Home</title>
    </head>
    <body>
        <h1 class="header">Welcome, ${Data.getsName()}</h1>
        <div class="line"></div>
        
        <h5 class="header_small">Select an assignment</h5>
        
        <div class ="container">
            <form method="POST" action="SubmitAssignment">
                <input type="hidden" name="studentEnno" value="${Data.getsEnNumber()}">

                <select class="assignment_select" id="completeAssignment" name="completeAssignment">
                    <option value="">Select assignment name</option>
                    <c:forEach items="${assignments}" var="assignment" varStatus="status">
                        <c:if test="${not AssignmentStatus[status.index].isSubmited()}">
                            <option value="${assignment.getAssignment_name()}">${assignment.getAssignment_name()}</option>
                        </c:if>
                    </c:forEach>
                </select>

                <div class="btn">
                    <input id="submit" type="submit" value="submit">
                </div>

            </form>
        </div>
        <div class="line"></div>
        <h2 class="header">Assignments</h2>
        
        <table class="assignment_table">
            <thead>
                <tr>
                    <th>Index</th>
                    <th>Year</th>
                    <th>Branch</th>
                    <th>Subject</th>
                    <th>Name</th>
                    <th>Teacher</th>
                    <th>Date</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${assignments}" var="assignment" varStatus="status">
                <tr>
                    <td>${status.index+1}</td>
                    <td>${assignment.getAssignment_year()}</td>
                    <td>${Branches[status.index]}</td>
                    <td>${Subjects[status.index]}</td>
                    <td>${assignment.getAssignment_name()}</td>
                    <td>${TeacherName[status.index]}</td>
                    <td>${assignment.getSubmission_date()}</td>
                    <td><c:if test="${AssignmentStatus[status.index].isSubmited()}">Submitted</c:if><c:if test="${not AssignmentStatus[status.index].isSubmited()}">Not Submitted</c:if></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </body>
</html>
