<%-- 
    Document   : list
    Created on : Jun 28, 2016, 6:22:56 PM
    Author     : Sudheer.Parasker@SnapIT.Solutions
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authentication var="user" property="principal" />

        <div class="row">
            <div class="col-xs-12">          
                <div class="box box-primary">
                    <div class="box-header">
                        <h3 class="box-title">Student/Mentee</h3>
                    </div>
                    <!-- /.box-header -->
                    <div class="box-body">
                            <c:if test="${not empty selectedProgramName}">
                                <div class="callout callout-info"><h4>Program - <c:out value="${selectedProgramName}" /></h4></div>
                            </c:if>
                        <table id="Mentor List" class="table table-bordered table-striped">
                            <thead>
                                <tr>
                                    <th>Student/Mentee Name</th>
                                    <th>Age</th>
                                    <th>Gender</th>
                                    <th>Interests</th>
                            <c:if test="${not empty selectedProgramName}">
                                    <sec:authorize access="hasRole('ORG_ADMIN') OR hasRole('ORG_USER')">
                                    <th>Assignment</th>
                                    </sec:authorize>
                            </c:if>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${studentList}" var="student">
                                <tr>
                                    <td>${student.name}</td>
                                    <td>${student.age}</td>
                                    <td>${student.gender}</td>
                                    <td><c:forEach items="${student.interests}" var="interest">${interest}</br></c:forEach></td>                           
                                    <sec:authorize access="hasRole('ORG_ADMIN') OR hasRole('ORG_USER')">
                                        <td><a href="${pageContext.request.contextPath}/organization/${student.id}/assign"><span class="label label-success">Find Mentors</span></a></td>
                                    </sec:authorize>
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
