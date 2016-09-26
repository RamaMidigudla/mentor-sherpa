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
                                    <th>Programs</th>
                                    <th>Status</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>
                             <c:if test="${not empty unsignedUpOrgList}">
                            <c:forEach items="${unsignedUpOrgList}" var="entry">
                                <tr>
                                    <td>${entry.key.organizationName}</td>
                                    <td>
                                    ${entry.value}
                                    </td>
                                    <td>
                                    <label class="text-aqua">Available for Signup</label>
                                    </td>
                                    <td>
                                        <a href="${contextPath}/${mentorStudent}/signup/${entry.key.id}"><span class="btn btn-info btn-xs">Signup</span></a>
                                    </td>
                                </tr>
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
                                     <label class="text-green"><i class="fa fa-check"></i>Signed Up</label>
                                     </td>
                                    <td> 
                                        <a href="${contextPath}/${mentorStudent}/viewResponse"><span class="btn btn-success btn-xs">View Response</span></a>
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
