<%-- 
    Document   : newjsp
    Created on : May 28, 2016, 1:16:50 PM
    Author     : Sudheer.Parasker@SnapIT.Solutions
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="../../favicon.ico">

        <title>Organization Registration</title>

        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <!-- Bootstrap 3.3.6 -->
        <link rel="stylesheet" href="../../themes/AdminLTE/bootstrap/css/bootstrap.min.css">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
        <!-- Ionicons -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="../../themes/AdminLTE/dist/css/AdminLTE.min.css">
        <!-- AdminLTE Skins. Choose a skin from the css/skins
             folder instead of downloading all of them to reduce the load. -->
        <link rel="stylesheet" href="../../themes/AdminLTE/dist/css/skins/_all-skins.min.css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>

    <body>

        <div class="container">

            <div class="col-md-8">
                <!-- Horizontal Form -->
                <div class="box box-info">
                    <div class="box-header with-border">
                        <h3 class="box-title">Organization Registration</h3>
                    </div>
                    <!-- /.box-header -->
                    <!-- form start -->
                    <form class="form-horizontal">
                        <div class="box-body">
                            <div class="form-group">
                                <label for="inputEmail" class="col-sm-4 control-label">Email Address</label>

                                <div class="col-sm-8">
                                    <input type="email" class="form-control" id="inputEmail" placeholder="Email Address">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="orgName" class="col-sm-4 control-label">Organization Name</label>

                                <div class="col-sm-8">
                                    <input type="text" id="orgName" class="form-control" placeholder="Your Organization Name" required autofocus>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="orgAddress" class="col-sm-4 control-label">Organization Address</label>

                                <div class="col-sm-8">
                                    <input type="text" id="orgAddress" class="form-control" placeholder="Your Organization Address" required autofocus> 
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="orgCity" class="col-sm-4 control-label">Organization City</label>

                                <div class="col-sm-8">
                                    <input type="text" id="orgCity" class="form-control" placeholder="Enter Organization City" required autofocus>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="orgState" class="col-sm-4 control-label">Organization State</label>


                                <div class="col-sm-8">
                                    <input type="text" id="orgState" class="form-control" placeholder="Enter Organization State" required autofocus>     
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="orgZip" class="col-sm-4 control-label">Organization Zip</label>


                                <div class="col-sm-8">
                                    <input type="text" id="orgZip" class="form-control" placeholder="Enter Organization Zip" required autofocus>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputPassword" class="col-sm-4 control-label">Password</label>

                                <div class="col-sm-8">
                                    <input type="password" class="form-control" id="inputPassword" placeholder="Password">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="retypedPassword" class="col-sm-4 control-label">Re-Type Password</label>

                                <div class="col-sm-8">
                                    <input type="password" id="retypedPassword" class="form-control" placeholder="Re-Type your password" required>

                                </div>
                            </div>

                        </div>
                        <!-- /.box-body -->
                        <div class="box-footer">
                            <button type="submit" class="btn btn-default">Cancel</button>
                            <button type="submit" class="btn btn-info pull-right">Register</button>
                        </div>
                        <!-- /.box-footer -->
                    </form>
                </div>



            </div> <!-- /container -->


            <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
            <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
    </body>
</html>
