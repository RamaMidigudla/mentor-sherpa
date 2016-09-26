<%-- 
    Document   : list
    Created on : Sep 10, 2016, 8:40:06 PM
    Author     : Sudheer.Parasker@SnapIT.Solutions
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authentication var="user" property="principal" />
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<div class="row">
    <div class="col-xs-12">          
        <div class="box box-primary">
            <div class="box-header">
                <h3 class="box-title">Student/Mentee</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
                <table id="Mentor List" class="table table-bordered table-striped">
                    <thead>
                        <tr>
                            <th>Student/Mentee Name</th>
                            <th>Age</th>
                            <th>Gender</th>
                            <th>Program Name</th>
                            <th>Assigned Mentor</th>
                        </tr>
                    </thead>
                    <tbody><c:if test="${not empty studentList.registeredStudentList}">
                            <c:forEach items="${studentList.registeredStudentList}" var="entry">
                                <c:if test="${not empty entry.value}"> 
                                    <c:forEach items="${entry.value}" var="student">
                                        <tr> 
                                            <td><a href="${contextPath}/organization/viewProfile/${student.key.userObjectId}">${student.key.name}</a></td>
                                            <td>${student.key.age}</td>
                                            <td>${student.key.gender}</td>
                                            <td>${entry.key}</td>
                                            <c:choose>
                                                <c:when test="${empty student.value}"> <%-- No mentor Assigned --%>
                                                    <sec:authorize access="hasRole('ORG_ADMIN') OR hasRole('ORG_USER')">
                                                        <td><a href="${pageContext.request.contextPath}/organization/${student.key.id}/assign"><span class="btn btn-info">Assign Mentor</span></a></td>
                                                    </sec:authorize>
                                                </c:when>
                                                <c:otherwise> <%-- Mentor has been assigned --%>
                                                    <td>${student.value.name}</td>
                                                </c:otherwise>
                                            </c:choose>
                                        </tr>
                                    </c:forEach>
                                </c:if> 
                            </c:forEach>
                        </c:if>
                    </tbody>
                </table>
            </div>
            <!-- /.box-body -->
        </div>
        <!-- /.box -->
    </div>
</div>
