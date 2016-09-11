<%-- 
    Document   : home
    Created on : Jul 5, 2016, 9:54:55 PM
    Author     : Sudheer.Parasker@SnapIT.Solutions
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mentor Sherpa</title>
    </head>
    <c:if test="${not empty successMessage}">
        <div class="alert alert-success alert-dismissible">
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
            <h3><i class="icon fa fa-check"></i> Success!</h3>
            <span class="info-box-content"><c:out value="${successMessage}" /></span>
        </div>
    </c:if>
    <c:if test="${not empty infoMessage}">
        <div class="alert alert-info alert-dismissible">
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
            <h3><i class="icon fa fa-check"></i> Information!</h3>
            <span class="info-box-content"><c:out value="${infoMessage}" /></span>
        </div>
    </c:if>
     <h2>Welcome! Select an activity from Main Menu.</h2>
    </body>
</html>
