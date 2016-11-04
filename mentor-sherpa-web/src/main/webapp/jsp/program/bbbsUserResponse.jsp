   
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>
 <div class="col-md-3">&nbsp;</div>
<div class="container">   
    <div class="col-md-12">
        <!-- Horizontal Form -->
        <div class="box box-info">
            <div class="box-header with-border">
                <b class="box-title">Your response to ${mentorAndStudentResponse.programName} program</b>
                <br>
                <br>
                <!-- Post -->
                <c:forEach  items="${mentorAndStudentResponse.questionAndResponses}" var="questionAndResponse"> 
                <div class="post">
                  <div class="user-block">
                    <div class="post">   
                          <h4 class="box-title text-olive">${questionAndResponse.question}</h4>
                      </div>
                  </div>
                 <c:forEach  items="${questionAndResponse.response}" var="answer">    
                           <ul>
                            <li>${answer}</li>
                            </ul> 
  
                       </c:forEach>
                  
                </div>
                      </c:forEach>
              </div>
            </div>
          </div>
            </div>

                  