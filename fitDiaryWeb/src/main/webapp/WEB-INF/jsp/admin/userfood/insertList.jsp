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
         <h2 class="mt-3">사용자 음식 칼로리 등록</h2>
          <div class="row mt-3">
	        <div class="col-md-8 order-md-1">
	        
          	<form:form modelAttribute="codeVO" id="registFrm" name="registFrm"  data-toggle="validator">
       		<input type="hidden" name="userFoodId" id="userFoodId" value="${ result.userFoodId }"/>
				  <div class="row">
		            <div class="col-md-12 mb-3">
					    <label for="codeCategory" class="">음식사진</label>
					    <div class="col-md-12">
							<img src="${result.firebaseDownloadUrl }" class="col-md-12">	
					    </div>
		             </div>
				  </div>
				  
				  <div id="buttonList"  class="row float-right">
					  <div class="row float-right">
					    <div>
				        	<button type="button" class="btn btn-primary" onclick="fnAdd(); return false;">추가</button>
				        	<button type="button" class="btn btn-primary" onclick="fnUpdate(); return false;">등록</button>
					    </div>
					  </div>
				  </div>
				  <br/>
				  <br/>
				  
				  <div id="foodDetailList">
					  <div class="row mt-3">
			             <div class="col-md-6 mb-3">
			               <label for="foodNm">음식명</label>
			               <div>
			               <input type="text" class="form-control" name="foodNm" id="foodNm_1" required="">
			               <input type="hidden" class="form-control" name="foodId" id="foodId_1" required>
				           </div>
			             </div>
			             <div class="col-md-6 mb-3">
			               <label for="servingSize">인분</label>
			               <div>
			               <input type="text" class="form-control" name="servingSize" id="servingSize_1" onkeyup="keyupEvent(event,this);"  required="" data-parsley-type="number">
			               </div>
			             </div>
			           </div>
		           </div>
				</form:form>

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
	var index = 1;
	var resultList
	var resultDataList = []
	
	$(function(){
		var url = contextPath + "/admin/userfood/searchFoodList";	
		$.ajax({
     		type : "GET",
     		url : url,
	        error:function(request,status,error){
	            alert("code:"+request.status+"\n"+"error:"+error+"\n"+"message:"+request.responseText);
	        },
     		success : function(data){
     			resultList = data.data;
     			resultDataList = []
     			resultData = {}
     			for(var i = 0; i<resultList.length; i++){
     				resultData = {
     						"id" : i,
     						"value" : data.data[i].foodNm,
//      						"servingSize" : data.data[i].servingSize,
//      						"kilocalorie" : data.data[i].kilocalorie,
     				}
     				resultDataList.push(resultData);
     			}

     			addEvent();
     		}
     	});
		
	})
	
	function addEvent(){
		$('input[name^="foodNm"]').each(function(){
			$(this).unbind();
			$(this).autocomplete({
		      minLength: 1,
		      source : resultDataList,
		      focus: function( event, ui ) {
		        return false;
		      },
		      select: function( event, ui ) {
		    	  $(this).parent().find('input[name^="foodId"]').val(ui.item.id);
		      }
		    } );
		});
	}
	
	/**
	 *  게시판 등록 
	 */
	function fnAdd(){
// 		var i = $("#foodDetailList").find(".row").length+1
		var i = $($("#foodDetailList").find(".row").last()).find('input[name^="foodId"]').attr("id").split('_')[1]*1 + 1
		data = 
			'<div class="row">'+
			'<div class="col-md-6 mb-3">'+
			'<label for="foodNm">음식명</label>'+
			'<div>'+
			'<input type="text" class="form-control" name="foodNm" id="foodNm_'+i+'" required="">'+
			'<input type="hidden" class="form-control" name="foodId" id="foodId_'+i+'" required="">'+
			'</div>'+
			'</div>'+
			'<div class="col-md-6 mb-3">'+
			'<label for="servingSize">인분</label>'+
			'<div>'+
			'<input type="text" class="form-control" name="servingSize" id="servingSize_'+i+'"  onkeyup="keyupEvent(event,this);"  required="" data-parsley-type="number">'+
			' <button type="button" class="btn btn-primary" onclick="fnDelete(this); return false;">삭제</button>'+
			'</div>'+
			'</div>'+
// 			'<div class="col-md-4 mb-3">'+
// 			'<label for="kilocalorie">칼로리</label>'+
// 			'<div>'+
// 			'<input type="text" class="form-control" name="kilocalorie" id="kilocalorie_'+i+'" required="" data-parsley-type="number"  readonly="readonly">'+
// 			'<input type="hidden" class="form-control" name="kilocalorie_h" id="kilocalorie_h_'+i+'" required="">'+
// 			'</div>'+
// 			'</div>'+
			'</div>';
		$("#foodDetailList").append(data);
		
		addEvent();
	}
	

	function keyupEvent(event,target){
		if(event.keyCode===13){
			//enter
			fnUpdate();
		}else if(event.keyCode===45){
			fnAdd();
		}
		
	}
	
	
	/**
	 *  음식 등록 
	 */
	function fnUpdate(){
		
		if($('#registFrm').parsley().validate()){
			url = contextPath + "/admin/userfood/updateFoodDetail";
			
			var len = $("#foodDetailList").find(".row").length;
	        var eventList = {};
	        var addList =  new Array();
			for (var i=0; i<len; i++){
				var foodId = $($("#foodDetailList").find(".row").get(i)).find('input[name^="foodId"]').val();
				var amountDish = $($("#foodDetailList").find(".row").get(i)).find('input[name^="servingSize"]').val();
				if(foodId==""){
					alert("음식 검색을 이용하여 기입해주세요.");
					return;
				}

				data = {
						"foodId" : foodId ,
						"amountDish" : amountDish 
				}
				addList.push(data);
			}

			eventList = {"userFoodId":$("#userFoodId").val(),
						 "addList":addList };
			
			if(!confirm("사용자 음식 칼로리를 등록 하겠습니까?")) return;
			$.ajax({
	     		type : "POST",
	     		url : url,
	     		data : {"param":JSON.stringify(eventList)},
		        error:function(request,status,error){
		            alert("code:"+request.status+"\n"+"error:"+error+"\n"+"message:"+request.responseText);
		        },
	     		success : function(data){
	     			location.reload();
	     		}
	     	});
			
			
		}else{
			alert("작성 시 모든 입력란에 입력해주세요.");
		}
	}
	
	/**
	 *  음식 삭제
	 */
	function fnDelete(target){
		$(target).parent().parent().parent().remove();
	}
	
	</script>
</body>

</html>
