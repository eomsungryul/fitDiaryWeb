<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:set value="${pageContext.request.contextPath}" var="contextPath" />
<c:set value="${ requestScope['javax.servlet.forward.servlet_path'] }" var="requestUri" />
<head>
<%
  String contextPath = (String)request.getContextPath();
%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>Dashcode Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="<%=contextPath%>/resources/bootstrap-4.1.1/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<%=contextPath%>/resources/bootstrap-4.1.1/dashboard.css" rel="stylesheet">
    <link href="<%=contextPath%>/resources/bootstrap-4.1.1/parsley.css" rel="stylesheet">
    <link href="<%=contextPath%>/resources/css/jquery-ui.min.css" rel="stylesheet">
    
    <style>
    .form-control{
	    display: inline; width: 75%; vertical-align: middle;
    }
    body{
    overflow-y: scroll; 
    }
    </style>
    
</head>
  <body>
  	
	<c:import charEncoding="utf-8" url="/inc/incHeader">
		<c:param name="path" value="${requestUri}" />
	</c:import>

    <div class="container-fluid">
      <div class="row">
        
        <!-- aside start -->
 		<c:import charEncoding="utf-8" url="/inc/incLeft">
 			<c:param name="path" value="${requestUri}" />
 		</c:import>
		<!-- aside end -->	    
		
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4"><div class="chartjs-size-monitor" style="position: absolute; left: 0px; top: 0px; right: 0px; bottom: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;"><div class="chartjs-size-monitor-expand" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div></div><div class="chartjs-size-monitor-shrink" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:200%;height:200%;left:0; top:0"></div></div></div>
         <h2 class="mt-3">사용자 인바디 등록</h2>
          <div class="row mt-3">
	        <div class="col-md-8 order-md-1">
	        
	        
           	<c:if test="${result==null}">
            <div class="row">
	            <div class="col-md-12 mb-3"> 사용자 인바디 사진이 존재하지않습니다.
	            </div>
	        </div>
           	</c:if>
            <c:if test="${result!=null}">
          	<form:form modelAttribute="userHealth" id="registFrm" name="registFrm"  data-toggle="validator">
       		<input type="hidden" name="userHealthId" id="userHealthId" value="${ result.userHealthId }"/>
				  <div class="row">
		            <div class="col-md-12 mb-3">
					    <label for="codeCategory" class="">인바디사진</label>
					    <div class="col-md-12">
							<img src="${result.firebaseDownloadUrl }" class="col-md-12">	
					    </div>
		             </div>
				  </div>
				  <div id="buttonList"  class="row float-right">
					  <div class="row float-right">
					    <div>
				        	<button type="button" class="btn btn-primary" onclick="fnUpdate(); return false;">등록</button>
					    </div>
					  </div>
				  </div>
				  <br/>
				  <br/>
				  <div>
					  <div class="row mt-3">
			             <div class="col-md-6 mb-3">
			               <label for="foodNm">체중</label>
			               <div>
			               <input type="text" class="form-control" name="weight" id="weight" required="" data-parsley-type="number">
				           </div>
			             </div>
			             <div class="col-md-6 mb-3">
			               <label for="servingSize">체지방량</label>
			               <div>
			               <input type="text" class="form-control" name="fat" id="fat" required="" data-parsley-type="number">
			               </div>
			             </div>
			             <div class="col-md-6 mb-3">
			               <label for="foodNm">근육량</label>
			               <div>
			               <input type="text" class="form-control" name="muscle" id="muscle" required="" data-parsley-type="number">
				           </div>
			             </div>
			           </div>
		           </div>
				</form:form>
             	</c:if>

	        </div>
	      </div>
        </main>
      </div>
    </div>
    
    <script src="<%=contextPath%>/resources/jquery-3.1.0.js"></script>
    <script src="<%=contextPath%>/resources/js/jquery-ui.js"></script>
    <script src="<%=contextPath%>/resources/js/jquery-migrate-3.0.0.min.js"></script>
    <script src="<%=contextPath%>/resources/jquery.twbsPagination.min.js"></script>
    <script src="<%=contextPath%>/resources/bootstrap-4.1.1/js/bootstrap.min.js"></script>
    <script src="<%=contextPath%>/resources/Parsley.js-2.8.1/parsley.js"></script>
    <script src="<%=contextPath%>/resources/ESR23Common_debug.js"></script>
    
    <script type="text/javascript">
	var contextPath = "${ pageContext.request.contextPath }";
	
	function keyupEvent(event,target){
		if(event.keyCode===13){
			//enter
			fnUpdate();
		}		
	}
	
	
	/**
	 *  음식 등록 
	 */
	function fnUpdate(){
		
		if($('#registFrm').parsley().validate()){
			if(!confirm("사용자 인바디 정보를 등록 하겠습니까?")) return;
			document.registFrm.action = contextPath + "/admin/userHealth/update";
			document.registFrm.submit();
		}else{
			alert("작성 시 모든 입력란에 입력해주세요.");
		}
	}
	</script>
</body>

</html>
