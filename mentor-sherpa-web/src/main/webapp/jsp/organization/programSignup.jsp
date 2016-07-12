<%-- 
    Document   : programSignup
    Created on : Jul 9, 2016, 5:41:51 PM
    Author     : Sudheer.Parasker@SnapIT.Solutions
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
        <div class="container">

            <div class="col-md-8">
                <!-- Horizontal Form -->
                <div class="box box-info">
                    <div class="box-header with-border">
                        <h3 class="box-title">Signup for a Program - <c:out value="${organization.organizationName}"></c:out></h3>
                    </div>
                    <!-- /.box-header -->
                    <!-- form start -->
                        <form:form class="form-horizontal" commandName="programSignupForm">
                        <form:hidden path="organizationId" />
                        <div class="box-body">
                            <div class="form-group">
                                <label for="optionsRadios" class="col-sm-4 control-label">Select Program</label>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-4 control-label">
                            <c:forEach items="${organization.programs}" var="program" varStatus="i">
                                <form:radiobutton class="minimal" path="selectedProgramName" name="optionsRadios" id="optionsRadios" value="${program.programName}" />   <c:out value="${program.programName}"/> </br>
                            </c:forEach>
                                </label></br>
                            </div>


                        <!-- /.box-body -->
                        <div class="box-footer">
                            <button type="reset" class="btn btn-default">Cancel</button>
                            <button type="submit" class="btn btn-info pull-right">Next</button>
                        </div>
                        <!-- /.box-footer -->
                    </form:form>
                </div>



            </div> <!-- /container -->
