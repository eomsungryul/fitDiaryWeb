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
    <style>
    .form-control{
	    display: inline; width: 75%; vertical-align: middle;
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
       		<input type="hidden" name="searchCondition" id="searchCondition" value="${ searchVO.searchCondition}" />
       		<input type="hidden" name="searchKeyword" id="searchKeyword" value="${ searchVO.searchKeyword}" />
       		<input type="hidden" name="pageIndex" id="pageIndex" value="${ searchVO.pageIndex }"/>  
      		<c:if test="${flag=='U'}">
	       		<input type="hidden" name="userFoodId" id="userFoodId" value="${ result.userFoodId }"/>
      		</c:if>
<%--       		<c:if test="${flag=='I'}"> --%>
<!-- 				  <div class="form-group row"> -->
<!-- 				    <label for="codeCategory" class="col-sm-2 col-form-label">코드</label> -->
<!-- 				    <div class="col-sm-10"> -->
<%-- 				      <input type="text" class="form-control" id="code" name="code" placeholder="" value="${result.userFoodId }" required="" maxlength="128"> --%>
<!-- 				    </div> -->
<!-- 				  </div> -->
<%--       		</c:if> --%>
				  <div class="row">
		            <div class="col-md-12 mb-3">
					    <label for="codeCategory" class="">음식사진</label>
					    <div class="col-md-12">
							<img src="${result.firebaseDownloadUrl }" class="col-md-12">	
					    </div>
		             </div>
				  </div>
				  
              	<c:if test="${fn:length(detailList)!=0}">
				  <div id="foodDetailList">
				  
                 	<c:forEach var="result" items="${ detailList }" varStatus="status">
					  <div class="row">
			             <div class="col-md-4 mb-3">
			               <label for="foodNm">음식명</label>
			               <div>
			               <input type="text" class="form-control" name="foodNm" id="foodNm_${status.count}" value="${result.foodNm}"  required="">
			               <input type="hidden" class="form-control" name="foodId" id="foodId_${status.count}" value="${result.foodId}" required="">
				           <button type="button" class="btn btn-primary" onclick="fnFoodSearch(this); return false;">검색</button>
				           </div>
			             </div>
			             <div class="col-md-4 mb-3">
			               <label for="servingSize">인분</label>
			               <div>
			               <input type="text" class="form-control" style="width: 100%;" name="servingSize" id="servingSize_1" value="${result.amountDish}" onkeyup="changeKcal(this);" required="" data-parsley-type="number">
			               </div>
			             </div>
			             <div class="col-md-4 mb-3">
			               <label for="kilocalorie">칼로리</label>
			               <div>
			               <input type="text" class="form-control" name="kilocalorie" id="kilocalorie_1" value="${result.kilocalorie}"  required="" data-parsley-type="number" readonly="readonly">
			               <input type="hidden" class="form-control" name="kilocalorie_h" id="kilocalorie_h_1" value="${result.kilocalorie/result.amountDish}"  required="">
				           <button type="button" class="btn btn-primary" onclick="fnDelete(this); return false;">삭제</button>
			               </div>
			             </div>
			           </div>
                 	</c:forEach>
                 	
		           </div>
              	</c:if>
              	<c:if test="${fn:length(detailList)==0}">
				  <div id="foodDetailList">
					  <div class="row">
			             <div class="col-md-4 mb-3">
			               <label for="foodNm">음식명</label>
			               <div>
			               <input type="text" class="form-control" name="foodNm" id="foodNm_1" required="">
			               <input type="hidden" class="form-control" name="foodId" id="foodId_1" required>
				           <button type="button" class="btn btn-primary" onclick="fnFoodSearch(this); return false;">검색</button>
				           </div>
			             </div>
			             <div class="col-md-4 mb-3">
			               <label for="servingSize">인분</label>
			               <div>
			               <input type="text" class="form-control" style="width: 100%;" name="servingSize" id="servingSize_1" onkeyup="changeKcal(this);" required="" data-parsley-type="number">
			               </div>
			             </div>
			             <div class="col-md-4 mb-3">
			               <label for="kilocalorie">칼로리</label>
			               <div>
			               <input type="text" class="form-control" name="kilocalorie" id="kilocalorie_1" required="" data-parsley-type="number" readonly="readonly">
			               <input type="hidden" class="form-control" name="kilocalorie_h" id="kilocalorie_h_1" required="">
				           <button type="button" class="btn btn-primary" onclick="fnDelete(this); return false;">삭제</button>
			               </div>
			             </div>
			           </div>
		           </div>
              	</c:if>



				  <div class="float-right">
				    <div>
              		<c:if test="${flag=='U'}">
              		
			        	<button type="submit" class="btn btn-primary" onclick="fnAdd(); return false;">추가</button>
			        	<button type="submit" class="btn btn-primary" onclick="fnUpdate(); return false;">등록</button>
              		</c:if>
<%--               		<c:if test="${flag=='I'}"> --%>
<!-- 			        	<button type="submit" class="btn btn-primary" onclick="fnInsert();">등록</button> -->
<%--               		</c:if> --%>
				      
				      
				    <button type="submit" class="btn btn-secondary"  onclick="fnLinkPage('${ param.pageIndex }'); return false;">목록</button>
				    </div>
				  </div>
				</form:form>

	        </div>
	      </div>
        </main>
      </div>
    </div>
	
    <script src="<%=contextPath%>/resources/jquery-3.1.0.js"></script>
    <script src="<%=contextPath%>/resources/jquery.twbsPagination.min.js"></script>
    <script src="<%=contextPath%>/resources/bootstrap-4.1.1/js/bootstrap.min.js"></script>
    <script src="<%=contextPath%>/resources/Parsley.js-2.8.1/parsley.js"></script>
    <script src="<%=contextPath%>/resources/ESR23Common_debug.js"></script>
    
    <script type="text/javascript">
	var contextPath = "${ pageContext.request.contextPath }";
	var index = 1;
	/**
	 *  게시판 리스트 페이지 이동
	 */
	function fnLinkPage(pageNo){
		document.registFrm.pageIndex.value = pageNo;
		document.registFrm.action = contextPath + "/admin/userfood/list";
		document.registFrm.submit();
	}
	
	/**
	 *  게시판 등록 
	 */
	function fnAdd(){
		var i = $("#foodDetailList").find(".row").length+1
		data = 
			'<div class="row">'+
			'<div class="col-md-4 mb-3">'+
			'<label for="foodNm">음식명</label>'+
			'<div>'+
			'<input type="text" class="form-control" name="foodNm" id="foodNm_'+i+'" required="">'+
			'<input type="hidden" class="form-control" name="foodId" id="foodId_'+i+'" required="">'+
			' <button type="button" class="btn btn-primary" onclick="fnFoodSearch(this); return false;">검색</button>'+
			'</div>'+
			'</div>'+
			'<div class="col-md-4 mb-3">'+
			'<label for="servingSize">인분</label>'+
			'<div>'+
			'<input type="text" class="form-control" style="width: 100%;" name="servingSize" id="servingSize_'+i+'"  onkeyup="changeKcal(this);" required="" data-parsley-type="number">'+
			'</div>'+
			'</div>'+
			'<div class="col-md-4 mb-3">'+
			'<label for="kilocalorie">칼로리</label>'+
			'<div>'+
			'<input type="text" class="form-control" name="kilocalorie" id="kilocalorie_'+i+'" required="" data-parsley-type="number"  readonly="readonly">'+
			'<input type="hidden" class="form-control" name="kilocalorie_h" id="kilocalorie_h_'+i+'" required="">'+
			' <button type="button" class="btn btn-primary" onclick="fnDelete(this); return false;">삭제</button>'+
			'</div>'+
			'</div>'+
			'</div>';
		$("#foodDetailList").append(data);
		
	}
	
	/**
	 *  게시판 수정 
	 */
	function fnUpdate(){
		
// 		$('#registFrm').parsley().on('field:validated', function() {
// 		})
// 		.on('form:submit', function() {
// 			document.registFrm.action = contextPath + "/admin/code/update";
// 		});

		
		
		if($('#registFrm').parsley().validate()){
			url = contextPath + "/admin/userfood/updateFoodDetail";
			
			var len = $("#foodDetailList").find(".row").length;
	        var eventList = {};
	        var addList =  new Array();
			for (var i=0; i<len; i++){
// 				var foodNm = $($("#foodDetailList").find(".row").get(i)).find('input[name^="foodNm"]').val();
// 				var servingSize = $($("#foodDetailList").find(".row").get(i)).find('input[name^="servingSize"]').val();
// 				var kilocalorie = $($("#foodDetailList").find(".row").get(i)).find('input[name^="kilocalorie"]').val();
				var foodId = $($("#foodDetailList").find(".row").get(i)).find('input[name^="foodId"]').val();
				var amountDish = $($("#foodDetailList").find(".row").get(i)).find('input[name^="servingSize"]').val();
// 				data = {
// 						"foodNm" : foodNm ,
// 						"servingSize" : servingSize ,
// 						"kilocalorie" : kilocalorie,
// 				}
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
// 			alert("작성 시 모든 입력란에 입력해주세요.");
			alert("작성 시 모든 입력란에 입력해주세요.");
		}

		
	}
	
	/**
	 *  게시판 삭제
	 */
	function fnDelete(target){
		$(target).parent().parent().parent().remove();
	}
	
	function fnFoodSearch(target){
		var foodNm = $(target).parent().find("input[name^='foodNm']").val()
		index = $(target).parent().find("input[name^='foodNm']").attr("id").split('_')[1]
		var popUrl = contextPath + "/admin/userfood/popupFoodList?searchCondition=foodNm&searchKeyword="+foodNm;	//팝업창에 출력될 페이지 URL
// 		var popOption = "width=370, height=360, resizable=no, scrollbars=no, status=no;";    //팝업창 옵션(optoin)
		var popOption = "resizable=no, scrollbars=no, status=no; fullscreen= yes;";    //팝업창 옵션(optoin)
			window.open(popUrl,"",popOption);
	
	}
	
	function setFoodValue(id,name,servingSize,cal){
		$("#foodId_"+index).val(id);
		$("#foodNm_"+index).val(name);
// 		$("#servingSize_"+index).val(servingSize);
		$("#servingSize_"+index).val(1);
		$("#kilocalorie_"+index).val(cal);
		$("#kilocalorie_h_"+index).val(cal);
	}
	
	function changeKcal(target){
		var servingSize = $(target).val();
		var kilocalorie = $(target).parent().parent().parent().find("input[name='kilocalorie_h']").val();
		
		totalKcal = servingSize*kilocalorie;
		$(target).parent().parent().parent().find("input[name='kilocalorie']").val(totalKcal);
	}
	
	</script>
	
</body>




</html>
