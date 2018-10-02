<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html lang="en">
<head>
<%
  String contextPath = (String)request.getContextPath();
%>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">

    <title>Dashboard Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="<%=contextPath%>/resources/bootstrap-4.1.1/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<%=contextPath%>/resources/bootstrap-4.1.1/dashboard.css" rel="stylesheet">
  <style type="text/css">/* Chart.js */
	@-webkit-keyframes chartjs-render-animation{from{opacity:0.99}to{opacity:1}}@keyframes chartjs-render-animation{from{opacity:0.99}to{opacity:1}}.chartjs-render-monitor{-webkit-animation:chartjs-render-animation 0.001s;animation:chartjs-render-animation 0.001s;}</style></head>
  <body>
  	
  	
	<c:import charEncoding="utf-8" url="/inc/incHeader.do">
		<c:param name="path" value="${requestUri}" />
	</c:import>
  	
    <nav class="navbar navbar-dark fixed-top bg-dark flex-md-nowrap p-0 shadow">
      <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#">Fit Diary</a>
<!--       <input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search"> -->
      <ul class="navbar-nav px-3">
        <li class="nav-item text-nowrap">
          <a class="nav-link" href="#">濡쒓렇 �븘�썐</a>
        </li>
      </ul>
    </nav>

    <div class="container-fluid">
      <div class="row">
        
        <!-- aside start -->
 		<c:import charEncoding="utf-8" url="/inc/incLeft">
 			<c:param name="path" value="${requestUri}" />
 		</c:import>
		<!-- aside end -->	    
		
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4"><div class="chartjs-size-monitor" style="position: absolute; left: 0px; top: 0px; right: 0px; bottom: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;"><div class="chartjs-size-monitor-expand" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div></div><div class="chartjs-size-monitor-shrink" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:200%;height:200%;left:0; top:0"></div></div></div>
         <h2 class="mt-3">寃뚯떆�뙋</h2>
          
          <div class="row mt-10">
	        <div class="col-md-8 order-md-1">
	          <h4 class="mt-3">�벑濡� �뤌</h4>
	          <form>
				  <div class="form-group row">
				    <label for="inputEmail3" class="col-sm-2 col-form-label">Email</label>
				    <div class="col-sm-10">
				      <input type="email" class="form-control" id="inputEmail3" placeholder="Email">
				    </div>
				  </div>
				  <div class="form-group row">
				    <label for="inputPassword3" class="col-sm-2 col-form-label">Password</label>
				    <div class="col-sm-10">
				      <input type="password" class="form-control" id="inputPassword3" placeholder="Password">
				    </div>
				  </div>
				  <div class="form-group row">
				    <label for="codeDesc" class="col-sm-2 col-form-label">肄붾뱶�꽕紐�</label>
				    <div class="col-sm-10">
				 	   <textarea class="form-control" id="codeDesc" rows="3"></textarea>
				    </div>
				  </div>
				  <fieldset class="form-group">
				    <div class="row">
				      <legend class="col-form-label col-sm-2 pt-0">Radios</legend>
				      <div class="col-sm-10">
				        <div class="form-check">
				          <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios1" value="option1" checked>
				          <label class="form-check-label" for="gridRadios1">
				            First radio
				          </label>
				        </div>
				        <div class="form-check">
				          <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios2" value="option2">
				          <label class="form-check-label" for="gridRadios2">
				            Second radio
				          </label>
				        </div>
				        <div class="form-check disabled">
				          <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios3" value="option3" disabled>
				          <label class="form-check-label" for="gridRadios3">
				            Third disabled radio
				          </label>
				        </div>
				      </div>
				    </div>
				  </fieldset>
				  <div class="form-group row">
				    <div class="col-sm-2">Checkbox</div>
				    <div class="col-sm-10">
				      <div class="form-check">
				        <input class="form-check-input" type="checkbox" id="gridCheck1">
				        <label class="form-check-label" for="gridCheck1">
				          Example checkbox
				        </label>
				      </div>
				    </div>
				  </div>
				  <div class="form-group row">
				    <div class="col-sm-10">
				      <button type="submit" class="btn btn-primary">Sign in</button>
				    </div>
				  </div>
				</form>

	        </div>
	      </div>
        </main>
      </div>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
    <script src="../../assets/js/vendor/popper.min.js"></script>
    <script src="<%=contextPath%>/resources/bootstrap-4.1.1/js/bootstrap.min.js"></script>

    <!-- Icons -->
    <script src="https://unpkg.com/feather-icons/dist/feather.min.js"></script>
    <script>
      feather.replace()
    </script>

</body></html>
