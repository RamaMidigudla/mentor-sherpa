<%-- 
    Document   : list
    Created on : Jun 28, 2016, 6:22:56 PM
    Author     : Sudheer.Parasker@SnapIT.Solutions
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <div class="row">
            <div class="col-xs-12">          
                <div class="box box-primary">
                    <div class="box-header">
                        <h3 class="box-title">Student</h3>
                    </div>
                    <!-- /.box-header -->
                    <div class="box-body">
                        <table id="Mentor List" class="table table-bordered table-striped">
                            <thead>
                                <tr>
                                    <th>Student Name</th>
                                    <th>Age</th>
                                    <th>Gender</th>
                                    <th>Interests</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${childList}" var="child">
                                <tr>
                                    <td>${child.name}</td>
                                    <td>${child.age}</td>
                                    <td>${child.gender}</td>
                                    <td><c:forEach items="${child.intrests}" var="interest">${interest}</br></c:forEach></td>
                                </tr>
                            </c:forEach>
                               
                            </tbody>
                            <tfoot>
                                <tr>
                                    <th>Student Name</th>
                                    <th>Age</th>
                                    <th>Gender</th>
                                    <th>Interests</th>
                                </tr>
                            </tfoot>
                        </table>
                    </div>
                    <!-- /.box-body -->
                </div>
                <!-- /.box -->
            </div>
        </div>
