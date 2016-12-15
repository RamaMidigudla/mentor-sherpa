<%-- 
    Document   : list
    Created on : Sep 10, 2016, 8:40:06 PM
    Authvor     : Sudheer.Parasker@SnapIT.Solutions
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<sec:authentication var="user" property="principal" />
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<div id="find_keyword">
    <label><spring:message code="label.search" /></label>
    <div class="ui-widget"><input id="searchQuery" size="40" placeholder="Enter a Name to Search..." type="text" name="tagQuery"  onFocus="inputFocus(this)" onBlur="inputBlur(this)"></div>
</div>

<br/>
<br/>

<div class="row">
    <div class="col-xs-12">          
        <div class="box box-primary">
            <div class="box-header">
                <h3 class="box-title"><spring:message code="label.tile.header.mentor" /></h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
                <table id="Mentor List" class="table table-bordered table-striped">
                    <thead>
                        <tr>
                            <th><spring:message code="list.table.header.mentorName" /></th>
                            <th><spring:message code="list.table.header.age" /></th>
                            <th><spring:message code="list.table.header.gender" /></th>
                            <th><spring:message code="list.table.header.assignedTo" /></th>
                            <th><spring:message code="list.table.header.action" /></th>
                        </tr>
                    </thead>
                    <tbody><c:if test="${not empty assignedMentorInfoMap}">
                            <c:forEach items="${assignedMentorInfoMap}" var="entry">
                                <tr> 
                                    <td>
                                     <a href="${contextPath}/organization/viewProfile/${entry.key.userObjectId}">${entry.key.name}</a>
                                    </td>
                                    <td>${entry.key.age}</td>
                                    <td>${entry.key.gender}</td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${not empty entry.value}">
                                                <label class="text-green"><b><spring:message code="label.assignedTo"/></b></label>
                                                <br>
                                                <c:forEach items="${entry.value}" var="assignedStudent">
                                                    <ul style="padding-left: 10px;">
                                                      <a href="${contextPath}/organization/viewProfile/${assignedStudent.userObjectId}">${assignedStudent.name}</a>
                                                      &rarr; &nbsp;
                                                      <a href="${pageContext.request.contextPath}/organization/${entry.key.userObjectId}/remove/${assignedStudent.userObjectId}">
                                                          <span class="btn btn-xs btn-danger"><spring:message code="link.label.unassign"/></span>  
                                                      </a>
                                                    </ul>
                                                </c:forEach> 
                                            </c:when>
                                            <c:otherwise>
                                                <label class="text-red"><b><spring:message code="label.noStudentsAssigned"/></b></label>
                                            </c:otherwise>
                                        </c:choose>
                                     </td>
                                     <td>
                                     <sec:authorize access="hasRole('ORG_ADMIN') OR hasRole('ORG_USER')">
                                     <a href="${pageContext.request.contextPath}/organization/${entry.key.id}/assign">
                                         <c:choose>
                                             <c:when test="${not empty entry.value}">
                                               <span class="btn bg-olive btn-sm margin"><spring:message code="link.label.assignMoreStudent"/></span>  
                                             </c:when>
                                             <c:otherwise>
                                                <span class="btn bg-blue btn-sm margin"><spring:message code="link.label.assignStudent"/></span> 
                                             </c:otherwise>
                                         </c:choose>  
                                     </a>
                                     </sec:authorize>
                                         
                                     </td>
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
                        
<script>var ctx = "${pageContext.request.contextPath}"</script>

<script type="text/javascript">
	function inputFocus(i){
		if(i.value==i.defaultValue){ i.value=""; i.style.color="#000"; }
	}
	function inputBlur(i){
		if(i.value==""){ i.value=i.defaultValue; i.style.color="#848484"; }
	}
</script>

<script type="text/javascript">
	$(document).ready(function() {
    //attach autocomplete
    $("#searchQuery").autocomplete({
        minLength: 1,
        delay: 500,
        //define callback to format results
        source: function (request, response) {
            $.getJSON("${contextPath}/organization/auto/mentor", request, function(result) {
                response($.map(result, function(item) {
                    return {
                        // following property gets displayed in drop down
                        label: item.name,
                        // following property gets entered in the textbox
                        value: item.name,
                        
                        profile_url: ctx + "/organization/viewProfile/" + item.objectId
                       
                    }
                }));
            });
        },
                 select: function( event, ui ) {
                     
        window.location.href = ui.item.profile_url;
    }
    }); 
});
</script>
