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

    <title>음식</title>

    <!-- Bootstrap core CSS -->
    <link href="<%=contextPath%>/resources/bootstrap-4.1.1/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="<%=contextPath%>/resources/bootstrap-4.1.1/dashboard.css" rel="stylesheet">

</head>
  
  <body>
    <div class="container-fluid">
      <div class="row">
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4"><div class="chartjs-size-monitor" style="position: absolute; left: 0px; top: 0px; right: 0px; bottom: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;"><div class="chartjs-size-monitor-expand" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div></div><div class="chartjs-size-monitor-shrink" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:200%;height:200%;left:0; top:0"></div></div></div>
         <h2 class="mt-3">사용자음식</h2>
          <div class="col-md-8 table-responsive">
          	<div class="float-right mt-3 mb-3">
				<div class="form-inline">
				<!-- 검색 start  -->
                   	<form:form modelAttribute="searchVO" action="${ contextPath }/admin/food/list" name="searchFrm">
		            <div>
		            	<select class="form-control" id="searchCondition" name="searchCondition" >
					        <option value="foodNm" selected="selected">음식명</option>
<!-- 					        <option value="codeValue">코드명</option> -->
					    </select>
						<input type="hidden" id="pageIndex" name="pageIndex" value="${pni.pageIndex}" />
		                <input type="text" class="form-control search" id="searchKeyword" name="searchKeyword" placeholder="검색어"  value="${pni.searchKeyword}" onkeydown="$event.keyCode===13&&fnSearch()"/>
		                <button type="button" onclick="fnSearch()" class="btn btn-secondary" >검색</button>
		            </div>
		            </form:form>
		        </div>
          	</div>
            <table class="table">
              <thead>
                <tr>
                  <th>번호</th>
                  <th>음식종류</th>
                  <th>음식명</th>
                  <th>제공량</th>
                  <th>칼로리</th>
                </tr>
              </thead>
              <tbody>
              	<c:if test="${fn:length(resultList)!=0}">
                 	<c:forEach var="result" items="${ resultList }" varStatus="status">
		                <tr onclick="fnRegist('${result.foodId }','${result.foodNm }','${result.servingSize }','${result.kilocalorie }')">
		                  <td>${ pni.totalRecordCount - (((pni.pageIndex - 1) * pni.recordCountPerPage) + (status.index)) }</td>
		                  <td>${result.foodType }</td>
		                  <td>${result.foodNm }</td>
		                  <td>${result.servingSize }</td>
		                  <td>${result.kilocalorie }</td>
		                </tr>
                 	</c:forEach>
              	</c:if>
              	<c:if test="${fn:length(resultList)==0}">
	                <tr>
	                  <td colspan="5" class="text-center"> 검색결과가 존재하지 않습니다.</td>
	                </tr>
              	</c:if>
              </tbody>
            </table>
            
			  <ul id="pagination" class="pagination-sm justify-content-center"></ul>
          </div>

          
        </main>
      </div>
    </div>
    
    <script src="<%=contextPath%>/resources/jquery-3.1.0.js"></script>
    <script src="<%=contextPath%>/resources/jquery.twbsPagination.min.js"></script>
    <script src="<%=contextPath%>/resources/bootstrap-4.1.1/js/bootstrap.min.js"></script>
    
	<script type="text/javascript">
	var contextPath = "${ pageContext.request.contextPath }";
	$(function(){
		
		var totalPage = ${pni.totalPage};
		var searchCondition = "${pni.searchCondition}";
		if(searchCondition!=""){
			$("#searchCondition").val("${pni.searchCondition}");
		}
		
		if(totalPage>0){
		    $('#pagination').twbsPagination({
		        totalPages: totalPage,
		        startPage: ${pni.pageIndex} ,
		        visiblePages: ${pni.pageSize},
		        initiateStartPageClick:false,
		        onPageClick: function (event, page) {
		            fnLinkPage(page);
		        }
		    });
		}
		
	})
	/**
	 *  게시판 리스트 검색
	 */
	function fnSearch(){
		document.searchFrm.pageIndex.value = 1;
		document.searchFrm.action = contextPath + "/admin/userfood/popupFoodList";
		document.searchFrm.submit();
	}
	
	/**
	 *  게시판 리스트 페이지 이동
	 */
	function fnLinkPage(pageNo){
		document.searchFrm.pageIndex.value = pageNo;
		document.searchFrm.action = contextPath + "/admin/userfood/popupFoodList";
		document.searchFrm.submit();
	}
	
	function fnRegist(id,name,servingSize,cal){
		opener.setFoodValue(id,name,servingSize,cal);
		window.close();
	}
	
	</script>
</body>

</html>
