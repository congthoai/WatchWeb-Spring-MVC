<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.watch.util.SecurityUtils"%>
<c:url var="orderAPI" value="/api/order" />
<c:url var="orderDetailAPI" value="/api/orderdetail" />
<c:url var="removeCartUrl" value="/xoa-gio-hang" />
<c:url var="orderUrl" value="/tao-don-hang" />

<html>
<head>
<meta charset="UTF-8">
<title>Đặt hàng</title>
	<content tag="css">
		<link rel="stylesheet" href="<c:url value='/template/web/css/style_3.css' />" type="text/css">
		<link rel="stylesheet" href="<c:url value='/template/web/css/pay.css'/>" type="text/css">
	</content>
</head>
<body>
		<div id="main">
		
			<div class="title" >
				<a style="color:gray;text-decoration: none;" href="<c:url value='/#' />">Trang Chủ  </a> 
				/  ĐẶT HÀNG
							
				
			</div>
			
			<div id="content">
				<c:if test="${not empty message}">
					Đơn hàng của ban đã được tạo thành công, chờ duyệt!<br><strong>Xem đơn hàng</strong>
				</c:if>
    			<c:if test="${totalQuantityCart == 0 && empty message}">
						<br><br><h3 style='color:#ff9999'>KHÔNG CÓ SẢN PHẨM NÀO TRONG GIỎ HÀNG!</h3>
				</c:if>
				<c:if test="${totalQuantityCart > 0}">
				<div id="thongtinthanhtoan">			
					<form class="thongtin" method="post" acction="" id="formThanhToan">
				            <h5><strong>THÔNG TIN ĐẶT HÀNG</strong></h5>
				            <input type="hidden" name="userId" value="${SecurityUtils.getPrincipal().getUser().getId()}">
				            <input type="hidden" name="status" value="PENDING">
				            Họ tên:
				            <input type="text" placeholder="Họ" class="input-BD" name="name" value="${SecurityUtils.getPrincipal().getFullName()}">
				            <br>
				            Số điện thoại:
				            <input type="text" placeholder="Số điện thoại" class="input-BD" name="phone" value="${SecurityUtils.getPrincipal().getUser().getPhone()}">
				            <br>   
				            Email:
				            <input type="text" placeholder="Email" class="input-BD" name="email" value="${SecurityUtils.getPrincipal().getUser().getEmail()}">
				            <br>  
				            Địa Chỉ:
				            <input type="text" placeholder="Địa chỉ" class="input-BD" name="address" value="">
				            <br> 
				            Ghi chú:
				            <input type="text" placeholder="Ghi chú về đơn hàng của bạn" class="input-BD" name="message" >
				            <br>   
				             
				            <input type="submit" id="addOrder" value="Đặt hàng" name="dathang" style="padding: 3px;  margin: 30px auto;">
					    </form>
				</div>
			
				<div class="donhang">
					<table class="total_cart">
						<tr>
							<th colspan='2' style="padding-left: 50px">ĐƠN HÀNG CỦA BẠN</th>
						</tr>
						<tr>
							<td>Sản phẩm</td>
							<td>Số tiền</td>
						</tr>
	
						<c:forEach var="item" items="${cart}">
							<tr>
								<td>${item.value.watch.name} &nbsp&nbsp&nbsp&nbsp x ${item.value.quantity}</td>
								<td>
									<fmt:formatNumber type="number" groupingUsed="true" value="${item.value.totalPrice }"/>
								</td>
							</tr>
						</c:forEach>
	
							<tr>
								<td>Tổng tiền sản phẩm</td>
								<td>
									<fmt:formatNumber type="number" groupingUsed="true" value="${totalPriceCart}"/> vnđ
								</td>
							</tr>
							<tr>
								<td>Phí vận chuyển</td>
								<td>FreeShip</td>
							</tr>
							<tr style="background: yellow">
								<td>Tổng tiền</td>
								<td>
									<fmt:formatNumber type="number" groupingUsed="true" value="${totalPriceCart}"/> vnđ
								</td>
							</tr>
					</table>
				</div>
				</c:if>

		</div>
	
		</div>

		<script>
			$('#addOrder').click(function(e) {
				e.preventDefault();
				var aa = ${cartToJson};
				handleAddOrder();			
			});
			
			async function handleAddOrder() {				
				var data = {};
				var formData = $('#formThanhToan').serializeArray();
				$.each(formData, function(i, v) {
					data["" + v.name + ""] = v.value;
				});
		
				let orderId = await addOrder(data);
				if(orderId != null ) {
					var cartJson = ${cartToJson};
					$.each(cartJson, async function(i, val) {
						val["orderId"] = orderId;
						console.log(val);
						await addOrderDetail(val);
					});
					await removeCart();
					window.location.href = "${orderUrl}?message=insert_success";
				}
				else {
					window.location.href = "${orderUrl}?message=error_system";
				}
			}
					
			function addOrder(data) {
				return new Promise(resolve => {
					$.ajax({
						url : '${orderAPI}',
						type : 'POST',
						contentType : 'application/json',
						data : JSON.stringify(data),
						dataType : 'json',
						success : function(result) {
							resolve(result["id"]);
						},
						error : function(error) {
							resolve(null);
						}
					});
				});
			}
			
			function addOrderDetail(data) {
				return new Promise(resolve => {
					$.ajax({
						url : '${orderDetailAPI}',
						type : 'POST',
						contentType : 'application/json',
						data : JSON.stringify(data),
						dataType : 'json',
						success : function(result) {
							resolve(result["id"]);
						},
						error : function(error) {
							resolve(null);
						}
					});
				});
			}
			
			function removeCart() {
				return new Promise(resolve => {
					$.ajax({
						url : '${removeCartUrl}',
						type : 'GET',
						contentType : 'application/json',
						success : function(result) {
							resolve(1);
						},
						error : function(error) {
							resolve(null);
						}
					});
				});
			}
		</script>
</body>
</html>