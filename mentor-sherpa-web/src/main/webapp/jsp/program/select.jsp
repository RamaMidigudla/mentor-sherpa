<%-- 
    Document   : list
    Created on : Jul 18, 2016, 8:29:59 PM
    Author     : Sudheer.Parasker@SnapIT.Solutions
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
        <div class="row">
            <div class="col-xs-12">          
                <div class="box box-primary">
                    <div class="box-header">
                        <h3 class="box-title"><spring:message code="pageTitle.selectAProgram" /></h3>
                    </div>
                    <!-- /.box-header -->
                    <div class="box-body">
                        <table id="Mentor List" class="table table-bordered table-striped">
                            <thead>
                                <tr>
                                    <th><spring:message code="list.table.header.mentorName" /></th>
                                    <th><spring:message code="list.table.header.age" /></th>
                                    <th><spring:message code="list.table.header.gender" /></th>
                                    <th><spring:message code="list.table.header.education" /></th>
                                    <!--<th>Availability</th>-->
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${mentorList}" var="mentor">
                                <tr>
                                    <td><a href="${contextPath}/organization/mentor/${mentor.name}">${mentor.name}</a></td>
                                    <td>${mentor.age}</td>
                                    <td>${mentor.gender}</td>
                                    <td>${mentor.education}</td>
                                    <!--<td><span class="label label-success">Available</span></td>-->
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
