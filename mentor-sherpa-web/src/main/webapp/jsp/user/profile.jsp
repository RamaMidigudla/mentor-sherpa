<%-- 
    Document   : profile
    Created on : Jul 8, 2016, 9:34:40 PM
    Author     : Sudheer.Parasker@SnapIT.Solutions
--%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false"%>



    <div class="row">
          <div class="col-md-3">&nbsp;</div>
        <div class="col-md-3">
          <!-- Profile Image -->
          <div class="box box-primary">
            <div class="box-body box-profile">
              <img class="profile-user-img img-responsive img-circle" src="/mentor-sherpa-web/themes/AdminLTE/dist/img/${user.imageName}" alt="User profile picture">

              <h3 class="profile-username text-center">${user.firstName} &nbsp;  ${user.lastName}</h3>

              <ul class="list-group list-group-unbordered">
               <li class="list-group-item">
                  <b>Email</b> <p class="pull-right text-light-blue">${user.email}</p>
                  
                </li>
                 <li class="list-group-item"> 
                  <b>Date of Birth</b>  <p class="pull-right text-light-blue">${user.dateOfBirth}</p>
                </li>
              </ul>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
          <!-- About Me Box -->
          <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">Info</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body"> 
              <strong><i class="fa fa-home margin-r-5"></i>Address</strong>
              <p class="text-muted text-light-blue">${user.address}</p>
              <strong><i class="fa fa-phone margin-r-5"></i>Phone</strong>
              <p class="text-muted text-light-blue">${user.phoneNumber}</p>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
        </div>
        </div>
      </div>
    
    
