<%-- 
    Document   : list
    Created on : Jun 28, 2016, 4:56:49 PM
    Author     : Sudheer.Parasker@SnapIT.Solutions
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
        <div class="row">
            <div class="col-xs-12">          
                <div class="box box-primary">
                    <div class="box-header">
                        <h3 class="box-title"><spring:message code="pageTitle.student" /></h3>
                    </div>
                    <!-- /.box-header -->
                    <div class="box-body">
                        <table id="Mentor List" class="table table-bordered table-striped">
                            <thead>
                                <tr>
                                    <th><spring:message code="list.table.header.studentName" /></th>
                                    <th><spring:message code="list.table.header.age" /></th>
                                    <th><spring:message code="list.table.header.gender" /></th>
                                    <th><spring:message code="list.table.header.status" /></th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:if test="${not empty assignedStudentList}">
                            <c:forEach items="${assignedStudentList}" var="student">
                                <tr>
                                    <td><a href="${contextPath}/organization/viewProfile/${student.userObjectId}">${student.name}</a></td>
                                    <td>${student.age}</td>
                                    <td>${student.gender}</td>
                                    <td><span class="label label-success"><spring:message code="label.assigned" /></span></td>
                                </tr>
                            </c:forEach>
                             </c:if>
                            <c:if test="${not empty availableStudentList}">
                             <c:forEach items="${availableStudentList}" var="availableStudent">
                                <tr>
                                    <td><a href="${contextPath}/organization/viewProfile/${availableStudent.userObjectId}">${availableStudent.name}</a></td>
                                    <td>${availableStudent.age}</td>
                                    <td>${availableStudent.gender}</td>
                                    <td><span class="label label-info"><spring:message code="label.unassigned" /></span></td>
                                </tr>
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
