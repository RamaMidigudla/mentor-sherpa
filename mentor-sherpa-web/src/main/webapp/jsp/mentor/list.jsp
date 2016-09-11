<%-- 
    Document   : list
    Created on : Jun 28, 2016, 4:56:49 PM
    Author     : Sudheer.Parasker@SnapIT.Solutions
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
        <div class="row">
            <div class="col-xs-12">          
                <div class="box box-primary">
                    <div class="box-header">
                        <h3 class="box-title">Mentors</h3>
                    </div>
                    <!-- /.box-header -->
                    <div class="box-body">
                        <table id="Mentor List" class="table table-bordered table-striped">
                            <thead>
                                <tr>
                                    <th>Mentor Name</th>
                                    <th>Age</th>
                                    <th>Gender</th>
                                    <th>Availability</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:if test="${not empty mentorList}">
                            <c:forEach items="${mentorList}" var="mentor">
                                <tr>
                                    <td><a href="${contextPath}/organization/mentor/${mentor.name}">${mentor.name}</a></td>
                                    <td>${mentor.age}</td>
                                    <td>${mentor.gender}</td>
                                    <td><span class="label label-success">Assigned</span></td>
                                </tr>
                            </c:forEach>
                             </c:if>
                            <c:if test="${not empty availableMentorList}">
                             <c:forEach items="${availableMentorList}" var="availableMentor">
                                <tr>
                                    <td><a href="${contextPath}/organization/mentor/${availableMentor.name}">${availableMentor.name}</a></td>
                                    <td>${availableMentor.age}</td>
                                    <td>${availableMentor.gender}</td>
                                    <td><span class="label label-info">Available</span></td>
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
