<%-- 
    Document   : home
    Created on : Jul 5, 2016, 9:54:55 PM
    Author     : Sudheer.Parasker@SnapIT.Solutions
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><spring:message code="pageTitle.mentorSherpa" /></title>
    </head>
    <c:if test="${not empty successMessage}">
        <div class="alert alert-success alert-dismissible">
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
            <h3><i class="icon fa fa-check"></i> <spring:message code="error.label.header.success" /></h3>
            <span class="info-box-content"><c:out value="${successMessage}" /></span>
        </div>
    </c:if>
    <c:if test="${not empty infoMessage}">
        <div class="alert alert-info alert-dismissible">
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
            <h3><i class="icon fa fa-check"></i> <spring:message code="error.label.header.info" /></h3>
            <span class="info-box-content"><c:out value="${infoMessage}" /></span>
        </div>
    </c:if>
     <h2><spring:message code="label.welcomeMessage" /></h2>
    </body>
</html>
