<%-- 
    Document   : list
    Created on : Jul 8, 2016, 10:11:51 PM
    Author     : Sudheer.Parasker@SnapIT.Solutions
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
                        <h3 class="box-title"><spring:message code="pageTitle.organization" /></h3>
                    </div>
                    <!-- /.box-header -->
                    <div class="box-body">
                        <table id="Mentor List" class="table table-bordered table-striped">
                            <thead>
                                <tr>
                                    <th><spring:message code="list.table.header.organizationName" /></th>
                                    <th><spring:message code="list.table.header.programs" /></th>
                                    <th><spring:message code="list.table.header.status" /></th>
                                    <th><spring:message code="list.table.header.action" /></th>
                                </tr>
                            </thead>
                            <tbody>
                             <c:if test="${not empty unsignedUpOrgList}">
                            <c:forEach items="${unsignedUpOrgList}" var="entry">
                                 <form:form class="form-horizontal" commandName="programSignupForm">
                                 <form:hidden path="organizationId" value="${entry.key.id}" /> 
                                 <form:hidden path="selectedProgramName" value="${entry.value}"/> 
                                <tr>
                                    <td>${entry.key.organizationName}</td>
                                    <td>
                                    ${entry.value}
                                    </td>
                                    <td>
                                    <label class="text-aqua"><spring:message code="label.availableForSignup" /></label>
                                    </td>
                                    <td>
                                        <button type="submit" class="btn btn-info btn-xs"><spring:message code="button.label.signup" /></button>
                                    </td>
                                </tr>
                                </form:form>
                            </c:forEach>
                             </c:if>
                            <c:if test="${not empty signedUpOrgList}">
                            <c:forEach items="${signedUpOrgList}" var="entry">
                                <tr>
                                    <td>${entry.key.organizationName}</td>
                                    <td>
                                    ${entry.value}
                                    </td>
                                    <td>
                                     <label class="text-green"><i class="fa fa-check"></i><spring:message code="label.signedUp" /></label>
                                     </td>
                                    <td> 
                                        <a href="${contextPath}/${mentorStudent}/viewResponse/${user.userId}"><span class="btn btn-success btn-xs"><spring:message code="link.label.viewResponse" /></span></a>
                                    </td>
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
