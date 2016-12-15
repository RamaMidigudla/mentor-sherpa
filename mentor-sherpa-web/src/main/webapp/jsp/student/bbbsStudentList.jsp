<%-- 
    Document   : list
    Created on : Jun 28, 2016, 4:56:49 PM
    Author     : Sudheer.Parasker@SnapIT.Solutions
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
            $.getJSON("${contextPath}/organization/auto/student", request, function(result) {
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