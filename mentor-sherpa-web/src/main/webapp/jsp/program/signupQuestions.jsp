<%-- 
    Document   : programSignupQuestions
    Created on : Jul 10, 2016, 5:38:21 PM
    Author     : Sudheer.Parasker@SnapIT.Solutions
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container">
    <c:if test="${not empty errorMessage}">
        <div class="alert alert-error alert-dismissible">
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
            <h4><i class="icon fa fa-check"></i> <spring:message code="error.label.header.alert" /></h4>
            <c:out value="${errorMessage}" />
        </div>
    </c:if>
    <div class="col-md-12">
        <!-- Horizontal Form -->
        <div class="box box-info">
            <div class="box-header with-border">
                <form:form class="form-horizontal" action="save" commandName="programSignupForm">
                    <spring:bind path="*">
                        <c:if test="${not empty status.errorMessages}">

                            <div class="alert alert-danger alert-dismissible">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                <h4><i class="icon fa fa-ban"></i> <spring:message code="error.label.header.alert" /></h4>
                                <form:errors path="*" />
                            </div>
                        </c:if>
                    </spring:bind>

                    <form:hidden path="organizationId" />
                    <form:hidden path="selectedProgramName" />
                    <c:choose>
                        <c:when test="${empty programSignupForm.questionResponseMap}">
                            <h3 class="box-title"><spring:message code="label.header.noQuestions" arguments="${programSignupForm.selectedProgramName}"/></h3>
                        </c:when>
                        <c:otherwise>
                            <h3 class="box-title"><spring:message code="label.header.questions" arguments="${programSignupForm.selectedProgramName}"/></h3>

                                <div class="box-body">
                                    <div class="box-group" id="accordion">

                                        <!-- we are adding the .panel class so bootstrap.js collapse plugin detects it -->
                                    <c:forEach items="${programSignupForm.questionResponseMap}" var="entry" varStatus="index2">
                                        <div class="panel box box-primary">
                                            <div class="box-header with-border">
                                                        <i class="glyphicon glyphicon-plus-sign pull-right"></i>
                                                <h4 class="box-title">
                                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne${index2.index}" aria-expanded="false" class="collapsed">
                                                        <c:out value="${entry.key}"></c:out>
                                                        </a>
                                                    </h4>
                                                </div>
                                                <div id="collapseOne${index2.index}" class="panel-collapse collapse" aria-expanded="false" style="height: 0px;">
                                                <div class="box-body">
                                                    <c:forEach items="${entry.value}" var="questionResponseColl" varStatus="index1">
                                                        <div class="form-group">
                                                            <label for="optionsRadios" class="control-label"><c:out value="${questionResponseColl.questionOption.question}" /></label>
                                                            <form:hidden path="questionResponseMap['${entry.key}'][${index1.index}].questionOption.question" value="${questionResponseColl.questionOption.question}"/>
                                                            <form:hidden path="questionResponseMap['${entry.key}'][${index1.index}].questionOption.questionType" value="${questionResponseColl.questionOption.questionType}"/>
                                                            <form:hidden path="questionResponseMap['${entry.key}'][${index1.index}].questionResponse.question" value="${questionResponseColl.questionOption.question}" />
                                                        </div>

                                                        <div class="form-group">
                                                            <div>
                                                                <c:forEach items="${questionResponseColl.questionOption.options}" var="option"  varStatus="index2">
                                                                    <form:hidden path="questionResponseMap['${entry.key}'][${index1.index}].questionOption.options[${index2.index}]" value="${option}"/>
                                                                    <c:if test="${questionResponseColl.questionOption.questionType eq 'radioButton'}">
                                                                        <label class="col-sm-2">
                                                                            <%--<form:radiobutton path="questionResponses[${index1.index}]" name="optionsRadios" id="optionsRadios" value="${option}" />   <c:out value="${option}"/>--%>
                                                                            <form:radiobutton path="questionResponseMap['${entry.key}'][${index1.index}].questionResponse.response" name="optionsRadios" id="optionsRadios" value="${option}" />   <c:out value="${option}"/>
                                                                        </label>
                                                                    </c:if>
                                                                    <c:if test="${questionResponseColl.questionOption.questionType eq 'checkBox'}">
                                                                        <label class="col-sm-3">
                                                                            <%--<form:checkbox path="questionResponses[${index1.index}]" name="optionsRadios" id="optionsRadios" value="${option}" />   <c:out value="${option}"/>--%>
                                                                            <form:checkbox path="questionResponseMap['${entry.key}'][${index1.index}].questionResponse.response" name="optionsRadios" id="optionsRadios" value="${option}" />   <c:out value="${option}"/>
                                                                        </label>
                                                                    </c:if>
                                                                </c:forEach>
                                                                <c:if test="${questionResponseColl.questionOption.questionType eq 'textBox'}">
                                                                    <label class="col-sm-8">
                                                                        <%--<form:textarea path="questionResponses[${index1.index}]" name="optionsRadios" id="optionsRadios" rows="5" cols="100"/>--%>
                                                                        <form:textarea path="questionResponseMap['${entry.key}'][${index1.index}].questionResponse.response" name="optionsRadios" id="optionsRadios" rows="5" cols="100"/>
                                                                    </label>
                                                                </c:if>
                                                            </div>
                                                        </div>
                                                    </c:forEach>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </c:otherwise>

                            </c:choose>

                        </div>


                        <!-- /.box-body -->
                        <div class="box-footer">
                            <button type="reset" class="btn btn-default"><spring:message code="button.label.cancel" /></button>
                            <button type="submit" class="btn btn-info pull-right"><spring:message code="button.label.save" /></button>
                        </div>
                        <!-- /.box-footer -->
                    </form:form>
                </div>



            </div> <!-- /container -->
