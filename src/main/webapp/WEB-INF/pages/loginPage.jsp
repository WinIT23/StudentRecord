<%-- 
    Document   : loginPage
    Created on : 08-Apr-2020, 10:54:16 PM
    Author     : RUDRESH PATEL
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Home</title>
       
    </head>
        <h1>Welcome ${Data}</h1>
        
        <h2>Assignments</h2>
        
        <table style="text-align:center">
            <th>Index</th>
            <th>Year</th>
            <th>Branch</th>
            <th>Subject</th>
            <th>Name</th>
            <th>Teacher</th>
            <th>Date</th>
            <th>Status</th>
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
                </form>
                </tr>
            </c:forEach>
        </table>
    </body>

