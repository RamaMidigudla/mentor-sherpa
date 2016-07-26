<%-- 
    Document   : profile
    Created on : Jul 8, 2016, 9:34:40 PM
    Author     : Sudheer.Parasker@SnapIT.Solutions
--%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false"%>

<section class="content">

      <div class="row">
        <div class="col-md-3">

          <!-- Profile Image -->
          <div class="box box-primary">
            <div class="box-body box-profile">
            <sec:authentication var="user" property="principal" />
            <c:url var="userProfileImage" value="boxed-bg.png"></c:url>
             <c:if test="${user.male}">
                 <c:url var="userProfileImage" value="avatar5.png"></c:url>
             </c:if>
             <c:if test="${user.female}">
                 <c:url var="userProfileImage" value="avatar2.png"></c:url>
             </c:if>
              <img class="profile-user-img img-responsive img-circle" src="/mentor-sherpa-web/themes/AdminLTE/dist/img/${userProfileImage}" alt="User profile picture">

              <h3 class="profile-username text-center">${student.name}</h3>

              <ul class="list-group list-group-unbordered">
                <li class="list-group-item">
                  <b>Followers</b> <a class="pull-right">1,322</a>
                </li>
                <li class="list-group-item">
                  <b>Following</b> <a class="pull-right">543</a>
                </li>
                <li class="list-group-item">
                  <b>Friends</b> <a class="pull-right">13,287</a>
                </li>
              </ul>

              <a href="#" class="btn btn-primary btn-block"><b>Follow</b></a>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->

          <!-- About Me Box -->
          <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">About Me</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <strong><i class="fa fa-book margin-r-5"></i> Education</strong>

              <p class="text-muted">
                ${student.education}
              </p>

              <hr>

              <strong><i class="fa fa-map-marker margin-r-5"></i> Location</strong>

              <p class="text-muted">Malibu, California</p>

              <hr>

              <c:forEach items="${student.interests}" var="skill">
              <strong><i class="fa fa-pencil margin-r-5"></i> Skills</strong>
              <p>
                <span class="label label-danger">${skill}</span>
                <span class="label label-success">${skill}</span>
                <span class="label label-info">${skill}</span>
                <span class="label label-warning">${skill}</span>
              </p>
              </c:forEach>

              <hr>

              <strong><i class="fa fa-file-text-o margin-r-5"></i> Notes</strong>

              <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam fermentum enim neque.</p>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
        </div>
      </div>
    </section>
    <!-- /.content -->
