<%-- 
    Document   : leftNav
    Created on : May 28, 2016, 5:32:06 PM
    Author     : Sudheer.Parasker@SnapIT.Solutions
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

  <!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- Sidebar user panel -->
     <%--  <div class="user-panel">
                 <div class="pull-left image">
          <img src="dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
        </div> 
        <div class="pull-left info">
          <p>Mentor Sherpa</p>
          <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
        </div>
      </div>--%>
      <!-- search form 
      <form action="#" method="get" class="sidebar-form">
        <div class="input-group">
          <input type="text" name="q" class="form-control" placeholder="Search...">
              <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                </button>
              </span>
        </div>
      </form>-->
      <!-- /.search form -->
      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu">
        <li class="header">MAIN NAVIGATION</li>
        <!--<li class="active treeview">
          <a href="#">
            <i class="fa fa-list-alt"></i> <span>Programs</span> <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li><a href="index.html"><i class="fa fa-circle-o"></i> Search Programs</a></li>
            <li><a href="index2.html"><i class="fa fa-circle-o"></i> Add Program</a></li>
          </ul>
        </li>-->
        <li class="active treeview">
          <a href="#">
            <i class="fa fa-users"></i>
            <span>Mentors</span>
          </a>
          <ul class="treeview-menu">
            <li><a href="${contextPath}/organization/mentor/list"><i class="fa fa-circle-o"></i> Show Mentors</a></li>
          </ul>
        </li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-users"></i>
            <span>Students</span>
          </a>
          <ul class="treeview-menu">
            <li><a href="${contextPath}/organization/child/list"><i class="fa fa-circle-o"></i> Show Students</a></li>
          </ul>
        </li>
      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>
