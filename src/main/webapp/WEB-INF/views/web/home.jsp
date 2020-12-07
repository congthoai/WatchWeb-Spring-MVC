<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="addCartURL" value="/them-gio-hang" />
<html>

<head>
	<meta charset="UTF-8">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
	<title>Trang chủ</title>
	
	<content tag="css">
		<link rel="stylesheet" href="<c:url value='/template/web/css/style.css' />" type="text/css">
		<link rel="stylesheet" href="<c:url value='/template/web/css/style-grid-product.css'/>" type="text/css">
	</content>
</head>

<body>
	<%@ include file="/common/web/banner.jsp"%>
	<div id="main">

		<div id="DH-nam" class="grid-dh">
			<div class="title-grid">
				<h3>SẢN PHẨM BÁN CHẠY</h3>
			</div>
			<div id="p-float">
				<c:forEach var="manWatch" items="${watchMan}" begin="0" end="9">
					<div class="p-float">
						<div class="p-float-in">
							<a href="1"></a> <img class="p-img"
								src="<c:url value='${manWatch.thumbnail }'/>">
							<div class="p-name">${manWatch.name}</div>
							<div class="p-final-price">${manWatch.price-manWatch.discount}</div>
							<div class="p-price">${manWatch.price}</div>
							<button class="p-add" value="${manWatch.id}">
								<i class="fas fa-cart-plus"></i>
							</button>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>

		<br> <br>
		<div style="width: 1028px; margin: 0px auto">
			<a href="#"> <img
				src="<c:url value='/resources/images/quangcao1.png'/>"
				style="width: 100%; height: 100px;">
			</a>
		</div>


		<div id="DH-nu" class="grid-dh">
			<div class="title-grid">
				<h3>SẢN PHẨM ĐƯỢC XEM NHIỀU</h3>
			</div>

			<div id="p-float">
				<c:forEach var="ladyWatch" items="${watchLady}" begin="0" end="9">
					<div class="p-float">
						<div class="p-float-in">
							<a href="1"></a> <img class="p-img"
								src="<c:url value='${ladyWatch.thumbnail }'/>">
							<div class="p-name">${ladyWatch.name}</div>
							<div class="p-final-price">${ladyWatch.price-ladyWatch.discount}</div>
							<div class="p-price">${ladyWatch.price}</div>
							<button class="p-add" value="${ladyWatch.id}">
								<i class="fas fa-cart-plus"></i>
							</button>
						</div>
					</div>
				</c:forEach>
			</div>

		</div>

	</div>


	<script>
		$(".p-add").click(function(){
			var isLogin = $('#isLogin').val();
			if(isLogin == "true"){
				var id_add_cart = $(this).val();
		        //alert(id_add);
		    	$.get("${addCartURL}/"+id_add_cart,function(data,status){
		        	$("#qty_cart_ajax").html(data);
		    	});
			}
			else
				alert("Bạn cần đăng nhập để mua hàng!");
		});
	</script>
</body>
</html>