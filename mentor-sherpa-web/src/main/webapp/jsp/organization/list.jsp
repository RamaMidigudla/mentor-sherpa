<%-- 
    Document   : list
    Created on : Jul 8, 2016, 10:11:51 PM
    Author     : Sudheer.Parasker@SnapIT.Solutions
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authentication var="user" property="principal" />
<sec:authorize access="hasRole('MENTOR')">
<c:url var="mentorStudent" value="mentor"></c:url>    
</sec:authorize>
<sec:authorize access="hasRole('STUDENT')">
<c:url var="mentorStudent" value="student"></c:url>
</sec:authorize>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
        <div class="row">
            <div class="col-xs-12">          
                <div class="box box-primary">
                    <div class="box-header">
                        <h3 class="box-title">Organizations</h3>
                    </div>
                    <!-- /.box-header -->
                    <div class="box-body">
                        <table id="Mentor List" class="table table-bordered table-striped">
                            <thead>
                                <tr>
                                    <th>Organization Name</th>
                                    <th>Available Programs</th>
                                    <th>Select to Signup</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${organizationList}" var="organization">
                                <tr>
                                    <td>${organization.organizationName}</td>
                                    <td>
                                    <c:forEach items="${organization.programs}" var="program">
                                        ${program.programName}</br>
                                    </c:forEach>
                                    </td>
                                    <td><a href="${contextPath}/${mentorStudent}/signup/${organization.id}"><span class="btn btn-info">Signup</span></a></td>
                                </tr>
                            </c:forEach>
                               
                            </tbody>
                        </table>
                    </div>
                    <!-- /.box-body -->
                </div>
                <!-- /.box -->
            </div>
        </div>
