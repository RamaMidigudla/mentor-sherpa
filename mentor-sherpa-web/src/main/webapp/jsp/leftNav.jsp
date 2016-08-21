<%-- 
    Document   : leftNav
    Created on : May 28, 2016, 5:32:06 PM
    Author     : Sudheer.Parasker@SnapIT.Solutions
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authentication var="user" property="principal" />
<c:url var="mentorProfile" value="${pageContext.request.contextPath}/mentor/${user.userId}"></c:url>
<c:url var="studentProfile" value="${pageContext.request.contextPath}/student/${user.userId}"></c:url>
<nav role="navigation">  
<!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <ul class="sidebar-menu">
        <li class="header">MAIN NAVIGATION</li>
        <%-- ORGANIZATION Navigation --%>
        <sec:authorize access="hasRole('ORG_ADMIN') OR hasRole('ORG_USER')">
        <li class="treeview">
          <a href="#mentornav">
            <i class="fa fa-users"></i>
            <span>Mentors</span>
            <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
              <li><a href="${pageContext.request.contextPath}/organization/mentor/list"><i class="fa fa-circle-o"></i> Show Mentors</a></li>
          </ul>
        </li>
        <li class="treeview">
          <a href="#studentnav">
            <i class="fa fa-users"></i>
            <span>Students</span>
            <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
              <li><a href="${pageContext.request.contextPath}/organization/student/list"><i class="fa fa-circle-o"></i> Show Students</a></li>
          </ul>
        </li>
        <li class="treeview">
          <a href="#programnav">
            <i class="fa fa-users"></i>
            <span>Programs</span>
            <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
              <li><a href="${pageContext.request.contextPath}/organization/programs/list"><i class="fa fa-circle-o"></i> Match Mentors</a></li>
          </ul>
        </li>
        </sec:authorize>
        <%-- MENTOR Navigation --%>
        <sec:authorize access="hasRole('MENTOR')">
        <li class="treeview">
          <a href="#programnav">
            <i class="fa fa-users"></i>
            <span>Programs</span>
            <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li><a href="${pageContext.request.contextPath}/mentor/programs/list"><i class="fa fa-circle-o"></i> Sign up</a></li>
          </ul>
<!--          <ul class="treeview-menu">
            <li><a href="${pageContext.request.contextPath}/mentor/programs/bbbs"><i class="fa fa-circle-o"></i> BBBS - Aces</a></li>
          </ul>-->
        </li>
<!--        <li class="treeview">
          <a href="#studentnav">
            <i class="fa fa-users"></i>
            <span>Students</span>
            <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li><a href="${pageContext.request.contextPath}/mentor/student/list"><i class="fa fa-circle-o"></i> My Students</a></li>
          </ul>
        </li>-->
        </sec:authorize>
        <%-- Student Navigation --%>
        <sec:authorize access="hasRole('STUDENT')">
        <li class="treeview">
          <a href="#programnav">
            <i class="fa fa-users"></i>
            <span>Programs</span>
          </a>
          <ul class="treeview-menu">
            <li><a href="${pageContext.request.contextPath}/student/programs/list"><i class="fa fa-circle-o"></i> Sign up</a></li>
          </ul>
        </li>
<!--          <ul class="treeview-menu">
            <li><a href="${pageContext.request.contextPath}/student/programs/bbbs"><i class="fa fa-circle-o"></i> BBBS - Aces</a></li>
          </ul>-->
<!--        <li class="treeview">
          <a href="#mentornav">
            <i class="fa fa-users"></i>
            <span>Mentors</span>
          </a>
          <ul class="treeview-menu">
            <li><a href="${pageContext.request.contextPath}/student/mentor/list"><i class="fa fa-circle-o"></i> My Mentors</a></li>
          </ul>
        </li>-->
        </sec:authorize>
      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>
</nav>
