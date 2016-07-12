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
    <div class="col-md-8">
        <!-- Horizontal Form -->
        <div class="box box-info">
            <div class="box-header with-border">
                <form:form class="form-horizontal" action="save" commandName="programSignupForm">
                    <form:hidden path="organizationId" />
                    <form:hidden path="selectedProgramName" />
                    <c:choose>
                        <c:when test="${empty programSignupForm.questionsList}">
                            <h3 class="box-title">There are no special requirements for - <c:out value="${programSignupForm.selectedProgramName}"></c:out>. Just hit Save!</h3>
                        </c:when>
                        <c:otherwise>
                            <h3 class="box-title">Answer Questions for the Program - <c:out value="${programSignupForm.selectedProgramName}"></c:out></h3>
                                <div class="box-body">
                                <c:forEach items="${programSignupForm.questionsList}" var="question" varStatus="index1">
                                    <div class="form-group">
                                        <label for="optionsRadios" class="control-label"><c:out value="${question.question}" /></label>
                                        <form:hidden path="questions[${index1.index}]" value="${question.question}" />
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-4 control-label">
                                            <c:forEach items="${question.options}" var="option"  varStatus="index2">
                                                <form:checkbox class="minimal" path="questionResponses" name="optionsRadios" id="optionsRadios" value="${option}" />   <c:out value="${option}"/> </br>
                                            </c:forEach>
                                        </label></br>
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
