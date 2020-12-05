<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html>
<dec:head>
	<meta charset="UTF-8">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
	<title>Trang chủ</title>
	
	<link rel="stylesheet" href="<c:url value='/template/web/css/style.css' />" type="text/css">
	<link rel="stylesheet" href="<c:url value='/template/web/css/style-grid-product.css'/>" type="text/css">
	<link rel="stylesheet" href="<c:url value='/template/web/font/fontawesome/css/all.min.css'/>" type="text/css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<script language="javascript" src="<c:url value='/template/web/js/jquery-3.3.1.min.js'/>"></script>

   
</dec:head>


<body>


	<div id='wrapper'>

		<div class='top2'>
			<%@ include file="/common/web/top.jsp"%>
		</div>

		<dec:body></dec:body>

		<br>
		<br>

		<%@ include file="/common/web/footer.jsp"%>

	</div>


</body>
</html>