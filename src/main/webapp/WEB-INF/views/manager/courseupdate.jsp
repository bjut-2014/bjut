<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE>
<html>
<jsp:include page="../header/header.jsp" />
<link href="styles/lib/font-awesome.css" rel="stylesheet" />
<link href="styles/lib/bootstrap-reset.css"  rel="stylesheet" />
<link href="styles/publishinfo.css" rel="stylesheet"/>
<body>
<jsp:include page="../nav/nav.jsp" />
<div class="container-fluid">
    <div class="row">
        <div class="sidebar col-sm-3 col-md-2">
            <jsp:include page="../sidebar/sidebar-admin.jsp" />
        </div>   
    </div>
    
    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 mymain">
    		<div class="row">
                <div class="col-sm-12">             	
                    <div class="panel panel-default">
                    	<div class="panel-heading">
                    		<h3 class="panel-title">课程 Course</h3>
                    	</div>
                    	<div class="panel-body">     		
                             	<div class="form">
                             		<form class="cmxform form-horizontal tasi-form" id="commentForm" action="admin-update-course" method="post" >
                             			<input type="hidden" name="courseId" value="<s:property value="#request.course.courseId"/>">
                             			<div class="form-group">
                             				<label class="control-label col-lg-2">课程名称</label>
                             				<div class="col-lg-10">
                             					<input name="ctitle" class="form-control" id="ctitle" type="text" aria-required="true"  value="<s:property value="#request.course.name"/>"/>
                             				</div>
                             			</div>
                             			<div class="form-group">
                             				<label class="control-label col-lg-2">老师</label>
                             				<div class="col-lg-10">
                             					<select name="cteacher" class="form-control" id="cteacher"  aria-required="true" >
                             						<option></option>
                             						<s:iterator value="#request.teachers" var="tch">
                             							<option value="<s:property value="#tch.teacherId" />"><s:property value="#tch.name" /></option>
                             						</s:iterator>
                             					</select>
                             				</div>
                             			</div>
                             			<div class="form-group">
                             				<label class="control-label col-lg-2">时间</label>
                             				<div class="col-lg-10">
                             					<input name="ctime" class="form-control" id="ctime" type="text" aria-required="true" value="<s:property value="#request.course.courseDate"/>"/>
                             				</div>
                             			</div>
                             			<div class="form-group">
                             				<label class="control-label col-lg-2">地点</label>
                             				<div class="col-lg-10">
                             					<input name="caddress" class="form-control" id="caddress" type="text" aria-required="true" value="<s:property value="#request.course.coursePlace"/>"/>
                             				</div>
                             			</div>                            			
                             			<div class="form-group">
                             				
                             				<div class="col-lg-offset-2 col-lg-10">
                             					<button type="submit" class="btn btn-success">保存</button>
                             					<button type="button" class="btn btn-default">取消</button>
                             				</div>
                             			</div>
                             			
                             		
                             		</form>                   	
                    				     
	                 				
                   				</div>
                   			</div>
                    	</div>
               		</div>
        		</div>
  </div>
</div>
<jsp:include page="../footer/footer.jsp" />
</body>
</html>