<%-- 
    Document   : studentMentorAssoc
    Created on : Jun 28, 2016, 7:06:47 PM
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
          <div class="col-md-3">&nbsp;</div>
        <div class="col-md-3">

          <!-- Profile Image -->
          <div class="box box-primary">
            <div class="box-body box-profile">
              <img class="profile-user-img img-responsive img-circle" src="/mentor-sherpa-web/themes/AdminLTE/dist/img/user5-128x128.jpg" alt="User profile picture">

              <h3 class="profile-username text-center">${student.name}</h3>
            <!-- /.box-header -->
            <div class="box-body">
              <strong><i class="fa fa-book margin-r-5"></i> Education</strong>

              <p class="text-muted">
                5th Grade
              </p>
              <strong><i class="fa fa-pencil margin-r-5"></i>Interests</strong>
              <p>
                <span class="label label-danger">Cooking</span>
                <span class="label label-success">Coding</span>
                <span class="label label-warning">Sports</span>
              </p>
           </div>
            <!-- /.box-body -->

            </div>
            <!-- /.box-body -->
          </div>
        </div>
      </div>


  <c:forEach  items="${testModel.match}" var="entry">  
    <div class="row">
         <div class="col-md-3">

          <!-- Profile Image -->
          <div class="box box-primary">
            <div class="box-body box-profile">
              <img class="profile-user-img img-responsive img-circle" src="/mentor-sherpa-web/themes/AdminLTE/dist/img/graham.jpeg" alt="User profile picture">

              <h3 class="profile-username text-center">${entry.key.name}</h3>
            <!-- /.box-header -->
            <div class="box-body text-center">
                <span><b>Match Score</b></span>
            </div>    
            <div class="box-body text-center">
                <span class="fa-stack fa-4x">
                  <i class="fa fa-circle fa-stack-2x icon-background4"></i>
                  <i class="fa fa-circle-thin fa-stack-2x icon-background6"></i>
                  <strong class="fa-stack-1x text-primary">${entry.value}</strong>
                </span>
            </div>
            <a href="${pageContext.request.contextPath}/organization/${student.id}/save/${entry.key.id}" class="btn btn-primary btn-block"><b>Assign</b></a>
          </div>
          </div>
        </div>
 </c:forEach>  
  
        
 
    
         

        