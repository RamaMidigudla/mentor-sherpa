<%-- 
    Document   : programSignupQuestions
    Created on : Jul 10, 2016, 5:38:21 PM
    Author     : Sudheer.Parasker@SnapIT.Solutions
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container">
    <c:if test="${not empty infoMessage}">
        <div class="alert alert-success alert-dismissible">
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
            <h4><i class="icon fa fa-check"></i> Alert!</h4>
            <c:out value="${infoMessage}" />
        </div>
    </c:if>
    <div class="col-md-12">
        <!-- Horizontal Form -->
        <div class="box box-info">
            <div class="box-header with-border">
                <form:form class="form-horizontal" action="save" commandName="programSignupForm">
                    <form:hidden path="organizationId" />
                    <form:hidden path="selectedProgramName" />
                    <c:choose>
                        <c:when test="${empty programSignupForm.userSelection}">
                            <h3 class="box-title">There are no special requirements for - <c:out value="${programSignupForm.selectedProgramName}"></c:out>. Just hit Save!</h3>
                        </c:when>
                        <c:otherwise>
                            <h3 class="box-title">Answer Questions for the Program - <c:out value="${programSignupForm.selectedProgramName}"></c:out></h3>

                                <div class="box-body">
                                    <div class="box-group" id="accordion">
                                        <!-- we are adding the .panel class so bootstrap.js collapse plugin detects it -->
                            <c:forEach items="${programSignupForm.userSelection}" var="entry" varStatus="index2">
                                        <div class="panel box box-primary">
                                            <div class="box-header with-border">
                                                <h4 class="box-title">
                                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne${index2.index}" aria-expanded="false" class="collapsed">
                                                        <c:out value="${entry.key}"></c:out>
                                                        </a>
                                                    </h4>
                                                </div>
                                                <div id="collapseOne${index2.index}" class="panel-collapse collapse" aria-expanded="false" style="height: 0px;">
                                                    <div class="box-body">
                                                    <c:forEach items="${entry.value}" var="question" varStatus="index1">
                                                        <div class="form-group">
                                                            <label for="optionsRadios" class="control-label"><c:out value="${question.question}" /></label>
                                                            <form:hidden path="questions[${index1.index}]" value="${question.question}" />
                                                        </div>

                                                        <div class="form-group">
                                                            <div>
                                                                <c:forEach items="${question.options}" var="option"  varStatus="index2">
                                                                    <c:if test="${question.questionType eq 'radioButton'}">
                                                                        <label class="col-sm-2">
                                                                            <form:radiobutton path="questionResponses[${index1.index}]" name="optionsRadios" id="optionsRadios" value="${option}" />   <c:out value="${option}"/>
                                                                        </label>
                                                                    </c:if>
                                                                    <c:if test="${question.questionType eq 'checkBox'}">
                                                                        <label class="col-sm-3">
                                                                            <form:checkbox path="questionResponses[${index1.index}]" name="optionsRadios" id="optionsRadios" value="${option}" />   <c:out value="${option}"/>
                                                                        </label>
                                                                    </c:if>
                                                                </c:forEach>
                                                                <c:if test="${question.questionType eq 'textBox'}">
                                                                    <label class="col-sm-8">
                                                                        <form:textarea path="questionResponses[${index1.index}]" name="optionsRadios" id="optionsRadios" rows="5" cols="100"/>
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
                            <button type="reset" class="btn btn-default">Cancel</button>
                            <button type="submit" class="btn btn-info pull-right">Save</button>
                        </div>
                        <!-- /.box-footer -->
                    </form:form>
                </div>



            </div> <!-- /container -->
