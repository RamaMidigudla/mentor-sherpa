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
                        <h3 class="box-title">Student</h3>
                    </div>
                    <!-- /.box-header -->
                    <div class="box-body">
                        <table id="Mentor List" class="table table-bordered table-striped">
                            <thead>
                                <tr>
                                    <th>Student Name</th>
                                    <th>Age</th>
                                    <th>Gender</th>
                                    <th>Interests</th>
                                    <sec:authorize access="hasRole('ORG_ADMIN') OR hasRole('ORG_USER')">
                                    <th>Assignment</th>
                                    </sec:authorize>
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
                                        <td><a href="${pageContext.request.contextPath}/organization/${student.id}/assign"><span class="label label-success">Assign Mentor</span></a></td>
                                    </sec:authorize>
                                </tr>
                            </c:forEach>
                               
                            </tbody>
                            <tfoot>
                                <tr>
                                    <th>Student Name</th>
                                    <th>Age</th>
                                    <th>Gender</th>
                                    <th>Interests</th>
                                </tr>
                            </tfoot>
                        </table>
                    </div>
                    <!-- /.box-body -->
                </div>
                <!-- /.box -->
            </div>
        </div>
