<%-- 
    Document   : studentMentorAssoc
    Created on : Jun 28, 2016, 7:06:47 PM
    Author     : Sudheer.Parasker@SnapIT.Solutions
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false"%>

<div class="container">   
    <div class="col-md-12">
        <!-- Horizontal Form -->
        <div class="box box-info">
            <div class="box-header with-border">
                <b class="box-title">Your response to ${mentorAndStudentResponse.programName} program</b>
                <br>
                <br>
                <c:forEach  items="${mentorAndStudentResponse.questionAndResponses}" var="questionAndResponse">              
                    <div class="box box-primary collapsed-box">
                        <div class="box-header with-border">
                            <h4 class="box-title text-aqua">${questionAndResponse.question}</h4>

                            <div class="box-tools pull-right">
                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i>
                                </button>
                            </div>
                            <!-- /.box-tools -->
                        </div>
                        <!-- /.box-header -->
                        <c:forEach  items="${questionAndResponse.response}" var="answer"> 
                            <div class="box-body">
                                <ul>
                                    <li>${answer}</li>
                                </ul> 
                            </div>
                        </c:forEach>
                        <!-- /.box-body -->
                    </div>  
                    <!-- /.box --> 
                </c:forEach>
            </div>
        </div>
    </div>
</div>






