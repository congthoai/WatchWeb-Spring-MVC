<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:url var="newAPI" value="/api/new" />
<c:url var="newURL" value="/quan-tri/bai-viet/danh-sach" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Đồng hồ</title>

<link rel="stylesheet"
	href="<c:url value='/template/web/css/style_2.css' />" type="text/css">
<link rel="stylesheet"
	href="<c:url value='/template/web/css/style-grid-product_2.css'/>"
	type="text/css">
<link rel="stylesheet"
	href="<c:url value='/template/web/font/fontawesome/css/all.min.css'/>"
	type="text/css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script language="javascript"
	src="<c:url value='/template/web/js/jquery-3.3.1.min.js'/>"></script>

<script
	src="<c:url value='/template/admin/paging/jquery.twbsPagination.js' />"></script>
</head>

<body>

	<div id='wrapper'>

		<div id="main">

			<div class="title"
				style="height: 50px; font-weight: bold; padding: 13px">
				<a style="color: gray; text-decoration: none;"
					href="<c:url value='/#' />">Trang Chủ </a> / Đồng Hồ
				<?php if(isset($_GET['gender']) && $_GET['gender']!=NULL) ECHO $_GET['gender'];?>

				<select id="sort" name="sort" style="font-size: 1.3em; float: right">
            			<option value="" >Thứ tự mặc định</option>
            			<option value=" order by price asc">Thứ tự theo giá: thấp đến cao</option>
            			<option value=" order by price desc">Thứ tự theo giá: cao xuống thấp</option>        
            			<option value=" order by view desc">Thứ tự theo có nhiều lượt xem nhất</option> 
				</select>

			</div>

			<div id='left'>
				<%@ include file="/common/web/watch/leftbar.jsp"%>
			</div>

			<div id='content'>

				<div id="DH-nam" class="grid-dh">

					<div id="p-float">

						<c:forEach var="item" items="${model.listResult}">
							<div class="p-float">
								<div class="p-float-in">
									<a href=""></a> <img class="p-img"
										src="<c:url value='${item.thumbnail }'/>">
									<div class="p-name">${item.name}</div>
									<div class="p-final-price">${item.price - item.discount}
									</div>
									<div class="p-price">
										<c:if test="${item.discount != 0}">${item.price}</c:if>
									</div>
									<button class="p-add" value="${item.id}">
										<i class="fas fa-cart-plus"></i>
									</button>
								</div>
							</div>
						</c:forEach>

						<c:if test="${model.listResult.size()==0}">
							<br>
							<h4>Không tìm được kết quả phù hợp!</h4>
						</c:if>
					</div>

				</div>

				<ul class="pagination" id="pagination"></ul>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		var totalPages = ${model.totalPage} ? ${model.totalPage} : 1 ;
		var currentPage = ${model.page} ? ${model.page} : 1;
		$(function() {
			window.pagObj = $('#pagination').twbsPagination({
				totalPages : totalPages,
				visiblePages : totalPages,
				startPage : currentPage,
				onPageClick : function(event, page) {
					if (currentPage != page) {
						$('#limit').val(8);
						$('#page').val(page);
						$('#formFilter').submit();
					}
				}
			});
		});
		
		$("#productFilter").click(function(){
			$("#page").val(1);
			$("#formFilter").submit();
		})
	</script>

</body>

</html>