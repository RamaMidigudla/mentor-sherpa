<%-- 
    Document   : register
    Created on : Jun 17, 2016, 4:59:09 PM
    Author     : Sudheer.Parasker@SnapIT.Solutions
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <!-- Bootstrap 3.3.6 -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/themes/AdminLTE/bootstrap/css/bootstrap.min.css">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
        <!-- Ionicons -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/themes/AdminLTE/dist/css/AdminLTE.min.css">
        <!-- iCheck -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/themes/AdminLTE/plugins/iCheck/square/blue.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/themes/AdminLTE/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
        <!-- Theme style -->
        <!-- AdminLTE Skins. Choose a skin from the css/skins
             folder instead of downloading all of them to reduce the load. -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/themes/AdminLTE/dist/css/skins/_all-skins.min.css">
        <!-- daterange picker -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/themes/AdminLTE/plugins/daterangepicker/daterangepicker-bs3.css">
        <!-- bootstrap datepicker -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/themes/AdminLTE/plugins/datepicker/datepicker3.css">
        <!-- iCheck for checkboxes and radio inputs -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/themes/AdminLTE/plugins/iCheck/all.css">
        <!-- Bootstrap Color Picker -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/themes/AdminLTE/plugins/colorpicker/bootstrap-colorpicker.min.css">
        <!-- Bootstrap time Picker -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/themes/AdminLTE/plugins/timepicker/bootstrap-timepicker.min.css">
        <!-- Select2 -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/themes/AdminLTE/plugins/select2/select2.min.css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body class="hold-transition register-page">
        <div class="register-box">
            <div class="register-logo">
                <b><spring:message code="label.mentor" /></b><spring:message code="label.sherpa" />
            </div>
            <div>
                <b>Oops! that email already exists. Please - <a href="${pageContext.request.contextPath}/login" class="text-center">Login</a></b>
                 <a href="${pageContext.request.contextPath}/forgot"><spring:message code="link.label.forgotPassword" /></a><br>

            </div>
    </body>
</html>
