<%-- 
    Document   : updatePassword
    Created on : Aug 9, 2016, 6:35:07 PM
    Author     : Sudheer.Parasker@SnapIT.Solutions
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Mentor Sherpa | Update Password</title>
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

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body class="hold-transition login-page">
        <div class="login-box">
            <div class="login-logo">
                <a href="${pageContext.request.contextPath}/"><b><spring:message code="label.mentor" /></b><spring:message code="label.sherpa" /></a>
            </div>
            <!-- /.login-logo -->
            <div class="login-box-body">
                <p class="login-box-msg"><spring:message code="pageTitle.updatePassword" /></p>

                <form:form always-use-default-target="true" action="updatePassword" method="post">
                        <c:if test="${not empty sessionScope.SPRING_SECURITY_LAST_EXCEPTION}">

                            <div class="alert alert-danger alert-dismissible">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                <h4><i class="icon fa fa-ban"></i> <spring:message code="error.label.header.alert" /></h4>
                                <p>${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}</p>
                            </div>
                        </c:if>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <div class="form-group has-feedback">
                        <input type="password" id="pass" class="form-control" name="password" placeholder="New Password">
                        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                    </div>
                    <div class="form-group has-feedback">
                        <input type="password" id="passConfirm" class="form-control" name="confirmPassword" placeholder="Retype New password">
                        <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
                        <span id="error" class="alert alert-error" style="display:none">
                            <spring:message code="PasswordMatches.user" />
                        </span>
                    </div>
                    <div class="row">
                        <div class="col-xs-8">
                        </div>
                        <!-- /.col -->
                        <div class="col-xs-4">
                            <button type="submit" onclick="savePass()" class="btn btn-primary btn-block btn-flat"><spring:message code="button.label.update" /></button>
                        </div>
                        <!-- /.col -->
                    </div>
                </form:form>
                <%--
                    <div class="social-auth-links text-center">
                      <p>- OR -</p>
                      <a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i class="fa fa-facebook"></i> Sign in using
                        Facebook</a>
                      <a href="#" class="btn btn-block btn-social btn-google btn-flat"><i class="fa fa-google-plus"></i> Sign in using
                        Google+</a>
                    </div>
                    <!-- /.social-auth-links -->
                --%>
                <a href="${pageContext.request.contextPath}/login"><spring:message code="link.label.login" /></a><br>
                <a href="${pageContext.request.contextPath}/register" class="text-center"><spring:message code="link.label.register" /></a>

            </div>
            <!-- /.login-box-body -->
        </div>
        <!-- /.login-box -->

        <!-- jQuery 2.2.0 -->
        <script src="${pageContext.request.contextPath}/themes/AdminLTE/plugins/jQuery/jQuery-2.2.0.min.js"></script>
        <!-- Bootstrap 3.3.6 -->
        <script src="${pageContext.request.contextPath}/themes/AdminLTE/bootstrap/js/bootstrap.min.js"></script>
        <!-- iCheck -->
        <script src="${pageContext.request.contextPath}/themes/AdminLTE/plugins/iCheck/icheck.min.js"></script>
        <script>
            $(function () {
                $('input').iCheck({
                    checkboxClass: 'icheckbox_square-blue',
                    radioClass: 'iradio_square-blue',
                    increaseArea: '20%' // optional
                });
            });
        </script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script type="text/javascript">
function savePass(){
    var pass = $("#pass").val();
    var valid = pass === $("#passConfirm").val();
    if(!valid) {
      $("#error").show();
      return;
    }
    $.post("<c:url value="/updatePassword"></c:url>",{password: pass}, function(data){
        alert("hello");
        window.location.href = "<c:url value="/login"></c:url>" + "?message="+data.message;
    })
    .fail(function(data) {
        window.location.href = 
          "<c:url value="/login"></c:url>" + "?message=" + data.responseJSON.message;
    });
}
</script>
    </body>
</html>
