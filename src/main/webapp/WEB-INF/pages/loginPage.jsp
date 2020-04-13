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
        ${Date}
        
        ${assignments}
        
        <h2>Assignments</h2>
        
        <table>
            <th>Year</th>
            <th>Branch</th>
            <th>Name</th>
            <th>Date</th>
            <c:forEach items="${assignments}" var="assignment">
                <tr>
                    <td>${assignment.getYear()}</td>
                    <td>${assignment.getBranch()}</td>
                    <td>${assignment.getAssignment_name()}</td>
                    <td>${assignment.getSubmit_date()}</td>
                </tr>
            </c:forEach>
        </table>
    </body>

