<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<body>

	<div id="main">

		<div id="DH-nam" class="grid-dh">
			<div class="title-grid">
				<h3>SẢN PHẨM BÁN CHẠY</h3>
			</div>
			<div id="p-float">
				<c:forEach var="manWatch" items="${watch_man_list}" begin="0" end="9">
					<div class="p-float">
						<div class="p-float-in">
							<a href="1"></a> <img class="p-img"
								src="<c:url value='${manWatch.imageLink }'/>">
							<div class="p-name">${manWatch.name}</div>
							<div class="p-final-price">${manWatch.price-manWatch.discount}</div>
							<div class="p-price">${manWatch.price}</div>
							<button class="p-add" value="1">
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
				<c:forEach var="ladyWatch" items="${watch_lady_list}" begin="0" end="9">
					<div class="p-float">
						<div class="p-float-in">
							<a href="1"></a> <img class="p-img"
								src="<c:url value='${ladyWatch.imageLink }'/>">
							<div class="p-name">${ladyWatch.name}</div>
							<div class="p-final-price">${ladyWatch.price-ladyWatch.discount}</div>
							<div class="p-price">${ladyWatch.price}</div>
							<button class="p-add" value="1">
								<i class="fas fa-cart-plus"></i>
							</button>
						</div>
					</div>
				</c:forEach>
			</div>

		</div>

	</div>



</body>
</html>