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

            <div class="nav-tabs-custom">
                <ul class="nav nav-tabs" id="navTabs">
                    <li class="active"><a href="#mentor" data-toggle="tab"><spring:message code="label.tile.header.mentor" /></a></li>
                    <li><a href="#student" data-toggle="tab"><spring:message code="label.tile.header.student" /></a></li>
                </ul>
                <div class="tab-content">
                    <div class="active tab-pane" id="mentor">
                        <form:form commandName="mentorRegisterForm" action="${pageContext.request.contextPath}/register/mentor" method="post">
                            <div class="register-box-body">
                                <spring:bind path="*">
                                    <c:if test="${not empty status.errorMessages}">

                                        <div class="alert alert-danger alert-dismissible">
                                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                            <h4><i class="icon fa fa-ban"></i> <spring:message code="error.label.header.alert" /></h4>
                                            <form:errors path="*" />
                                        </div>
                                    </c:if>
                                </spring:bind>
                                <h2><b><spring:message code="label.mentor" /></b> <spring:message code="label.registration" /></h2>

                                <div class="register-box-body">
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                    <div class="form-group has-feedback">
                                        <input type="text" class="form-control" name="firstName" placeholder="First name">
                                        <span class="glyphicon glyphicon-user form-control-feedback"></span>
                                    </div>
                                    <div class="form-group has-feedback">
                                        <input type="text" class="form-control" name="lastName" placeholder="Last name">
                                        <span class="glyphicon glyphicon-user form-control-feedback"></span>
                                    </div>
                                    <div class="form-group has-feedback">
                                        <form:radiobutton class="minimal" path="gender" name="optionsRadios" id="optionsRadios" value="male" />  <spring:message code="label.radiobutton.male" /> 
                                        <form:radiobutton class="minimal" path="gender" name="optionsRadios" id="optionsRadios" value="female" />  <spring:message code="label.radiobutton.female" /> 
                                    </div>
                                    <div class="form-group has-feedback">
                                        <div class="input-group date">
                                            <input type="text" class="form-control pull-right" name="dateOfBirth" placeholder="Date Of Birth" id="datepicker">
                                            <div class="input-group-addon">
                                                <i class="fa fa-calendar"></i>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group has-feedback">
                                        <div class="input-group">
                                            <input type="text" class="form-control" name="phoneNumber" data-inputmask='"mask": "(999)-999-9999"' data-mask>
                                            <div class="input-group-addon">
                                                <i class="fa fa-phone"></i>
                                            </div>
                                        </div>
                                    </div>
                                     <div class="form-group has-feedback">
                                        <input type="address1" class="form-control" name="address1" placeholder="Address E.g. 2125 Chestnut St Apt 1">
                                        <span class="glyphicon glyphicon-home form-control-feedback"></span>
                                    </div>
                                    <div class="form-group has-feedback">
                                        <input type="city" class="form-control" name="city" placeholder="City/Town">
                                        <span class="glyphicon glyphicon-home form-control-feedback"></span>
                                    </div>
                                     <div class="form-group has-feedback">
                                        <input type="state" class="form-control" name="state" placeholder="State E.g. CA/WA">
                                        <span class="glyphicon glyphicon-home form-control-feedback"></span>
                                    </div>
                                    <div class="form-group has-feedback">
                                        <input type="zipCode" class="form-control" name="zipCode" placeholder="Zip Code 5 digits">
                                        <span class="glyphicon glyphicon-home form-control-feedback"></span>
                                    </div>
                                    <div class="form-group has-feedback">
                                        <input type="email" class="form-control" name="emailId" placeholder="Email">
                                        <span class="glyphicon glyphicon-email form-control-feedback"></span>
                                    </div>
                                    <div class="form-group has-feedback">
                                        <input type="password" class="form-control" name="password" placeholder="Password">
                                        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                                    </div>
                                    <div class="form-group has-feedback">
                                        <input type="password" class="form-control" name="confirmPassword" placeholder="Retype password">
                                        <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
                                    </div>
                                        <!-- /.col -->
                                        <div  class="col-xs-4">
                                            <button type="submit" class="btn btn-primary btn-block btn-flat"><spring:message code="button.label.register" /></button>
                                        </div>
                                        <!-- /.col -->
                                </form:form>
                                <a href="${pageContext.request.contextPath}/login" class="text-center"><spring:message code="link.label.member" /></a>
                            </div>
                            <!-- /.form-box -->
                        </div>
                    </div> <!-- tab-pane -->
                    <div class="tab-pane" id="student">
                        <form:form commandName="studentRegisterForm" action="${pageContext.request.contextPath}/register/student" method="post">
                            <div class="register-box-body">
                                <spring:bind path="*">
                                    <c:if test="${not empty status.errorMessages}">

                                        <div class="alert alert-danger alert-dismissible">
                                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                            <h4><i class="icon fa fa-ban"></i> Alert!</h4>
                                            <form:errors path="*" />
                                        </div>
                                    </c:if>
                                </spring:bind>
                                <h2><b>Student/Mentee</b> Registration</h2>

                                <div class="register-box-body">
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                    <div class="form-group has-feedback">
                                        <input type="text" class="form-control" name="firstName" placeholder="First name">
                                        <span class="glyphicon glyphicon-user form-control-feedback"></span>
                                    </div>
                                    <div class="form-group has-feedback">
                                        <input type="text" class="form-control" name="lastName" placeholder="Last name">
                                        <span class="glyphicon glyphicon-user form-control-feedback"></span>
                                    </div>
                                    <div class="form-group has-feedback">
                                        <form:radiobutton class="minimal" path="gender" name="optionsRadios" id="optionsRadios" value="male" />  Male 
                                        <form:radiobutton class="minimal" path="gender" name="optionsRadios" id="optionsRadios" value="female" />  Female 
                                    </div>
                                    <div class="form-group has-feedback">
                                        <div class="input-group date">
                                            <input type="text" class="form-control pull-right" name="dateOfBirth" placeholder="Date Of Birth" id="datepicker1">
                                            <div class="input-group-addon">
                                                <i class="fa fa-calendar"></i>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group has-feedback">
                                        <div class="input-group">
                                            <input type="text" class="form-control" name="phoneNumber" data-inputmask='"mask": "(999)-999-9999"' data-mask>
                                            <div class="input-group-addon">
                                                <i class="fa fa-phone"></i>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group has-feedback">
                                        <input type="address1" class="form-control" name="address1" placeholder="Address E.g. 2125 Chestnut St Apt 1">
                                        <span class="glyphicon glyphicon-home form-control-feedback"></span>
                                    </div>
                                    <div class="form-group has-feedback">
                                        <input type="city" class="form-control" name="city" placeholder="City/Town">
                                        <span class="glyphicon glyphicon-home form-control-feedback"></span>
                                    </div>
                                     <div class="form-group has-feedback">
                                        <input type="state" class="form-control" name="state" placeholder="State E.g. CA/WA">
                                        <span class="glyphicon glyphicon-home form-control-feedback"></span>
                                    </div>
                                    <div class="form-group has-feedback">
                                        <input type="zipCode" class="form-control" name="zipCode" placeholder="Zip Code 5 digits">
                                        <span class="glyphicon glyphicon-home form-control-feedback"></span>
                                    </div>
                                    <div class="form-group has-feedback">
                                        <input type="email" class="form-control" name="emailId" placeholder="Email">
                                        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
                                    </div>
                                    <div class="form-group has-feedback">
                                        <input type="password" class="form-control" name="password" placeholder="Password">
                                        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                                    </div>
                                    <div class="form-group has-feedback">
                                        <input type="password" class="form-control" name="confirmPassword" placeholder="Retype password">
                                        <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
                                    </div>
                                    <div class="row">
                                        <!-- /.col -->
                                        <div class="col-xs-4">
                                            <button type="submit" class="btn btn-primary btn-block btn-flat"><spring:message code="button.label.register" /></button>
                                        </div>
                                        <!-- /.col -->
                                    </div>
                                </form:form>
                                <a href="${pageContext.request.contextPath}/login" class="text-center"><spring:message code="link.label.member" /></a>
                            </div>
                            <!-- /.form-box -->

                        </div>
                    </div>
                </div>
            </div>
            <%--
            <div class="social-auth-links text-center">
              <p>- OR -</p>
              <a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i class="fa fa-facebook"></i> Sign up using
                Facebook</a>
              <a href="#" class="btn btn-block btn-social btn-google btn-flat"><i class="fa fa-google-plus"></i> Sign up using
                Google+</a>
            </div>
            --%>
        </div>
        <!-- /.register-box -->

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
        <!-- Select2 -->
        <script src="${pageContext.request.contextPath}/themes/AdminLTE/plugins/select2/select2.full.min.js"></script>
        <!-- InputMask -->
        <script src="${pageContext.request.contextPath}/themes/AdminLTE/plugins/input-mask/jquery.inputmask.js"></script>
        <script src="${pageContext.request.contextPath}/themes/AdminLTE/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
        <script src="${pageContext.request.contextPath}/themes/AdminLTE/plugins/input-mask/jquery.inputmask.extensions.js"></script>
        <!-- date-range-picker -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.2/moment.min.js"></script>
        <script src="${pageContext.request.contextPath}/themes/AdminLTE/plugins/daterangepicker/daterangepicker.js"></script>
        <!-- bootstrap datepicker -->
        <script src="${pageContext.request.contextPath}/themes/AdminLTE/plugins/datepicker/bootstrap-datepicker.js"></script>
        <!-- bootstrap color picker -->
        <script src="${pageContext.request.contextPath}/themes/AdminLTE/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
        <!-- bootstrap time picker -->
        <script src="${pageContext.request.contextPath}/themes/AdminLTE/plugins/timepicker/bootstrap-timepicker.min.js"></script>
        <!-- SlimScroll 1.3.0 -->
        <script src="${pageContext.request.contextPath}/themes/AdminLTE/plugins/slimScroll/jquery.slimscroll.min.js"></script>
        <!-- iCheck 1.0.1 -->
        <script src="${pageContext.request.contextPath}/themes/AdminLTE/plugins/iCheck/icheck.min.js"></script>
        <!-- FastClick -->
        <script src="${pageContext.request.contextPath}/themes/AdminLTE/plugins/fastclick/fastclick.js"></script>
        <!-- AdminLTE App -->
        <script src="${pageContext.request.contextPath}/themes/AdminLTE/dist/js/app.min.js"></script>
        <!-- AdminLTE for demo purposes -->
        <script src="${pageContext.request.contextPath}/themes/AdminLTE/dist/js/demo.js"></script>
        <!-- Page script -->
<script> //<!-- Holding onto the tab after Submit if there are errors -->
    $(function() { 
    // for bootstrap 3 use 'shown.bs.tab', for bootstrap 2 use 'shown' in the next line
    $('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
        // save the latest tab; use cookies if you like 'em better:
        localStorage.setItem('lastTab', $(this).attr('href'));
    });

    // go to the latest tab, if it exists:
    var lastTab = localStorage.getItem('lastTab');
    if (lastTab) {
        $('[href="' + lastTab + '"]').tab('show');
    }
});
</script>
<script>
            $(function () {
                //Initialize Select2 Elements
                $(".select2").select2();

                //Datemask dd/mm/yyyy
                $("#datemask").inputmask("dd/mm/yyyy", {"placeholder": "dd/mm/yyyy"});
                //Datemask2 mm/dd/yyyy
                $("#datemask2").inputmask("mm/dd/yyyy", {"placeholder": "mm/dd/yyyy"});
                //Money Euro
                $("[data-mask]").inputmask();

                //Date range picker
                $('#reservation').daterangepicker();
                //Date range picker with time picker
                $('#reservationtime').daterangepicker({timePicker: true, timePickerIncrement: 30, format: 'MM/DD/YYYY h:mm A'});
                //Date range as a button
                $('#daterange-btn').daterangepicker(
                        {
                            ranges: {
                                'Today': [moment(), moment()],
                                'Yesterday': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
                                'Last 7 Days': [moment().subtract(6, 'days'), moment()],
                                'Last 30 Days': [moment().subtract(29, 'days'), moment()],
                                'This Month': [moment().startOf('month'), moment().endOf('month')],
                                'Last Month': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
                            },
                            startDate: moment().subtract(29, 'days'),
                            endDate: moment()
                        },
                        function (start, end) {
                            $('#daterange-btn span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'));
                        }
                );

                //Date picker
                $('#datepicker').datepicker({
                    autoclose: true
                });
                $('#datepicker1').datepicker({
                    autoclose: true
                });

                //iCheck for checkbox and radio inputs
                $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
                    checkboxClass: 'icheckbox_minimal-blue',
                    radioClass: 'iradio_minimal-blue'
                });
                //Red color scheme for iCheck
                $('input[type="checkbox"].minimal-red, input[type="radio"].minimal-red').iCheck({
                    checkboxClass: 'icheckbox_minimal-red',
                    radioClass: 'iradio_minimal-red'
                });
                //Flat red color scheme for iCheck
                $('input[type="checkbox"].flat-red, input[type="radio"].flat-red').iCheck({
                    checkboxClass: 'icheckbox_flat-green',
                    radioClass: 'iradio_flat-green'
                });

                //Colorpicker
                $(".my-colorpicker1").colorpicker();
                //color picker with addon
                $(".my-colorpicker2").colorpicker();

                //Timepicker
                $(".timepicker").timepicker({
                    showInputs: false
                });
            });
        </script>

    </body>
</html>
