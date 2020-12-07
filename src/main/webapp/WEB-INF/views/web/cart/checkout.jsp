<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:url var="editCartURL" value="/chinh-sua-gio-hang" />

<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Đồng hồ</title>
	
	<content tag="css">
		<link rel="stylesheet" href="<c:url value='/template/web/css/style_3.css' />" type="text/css">
		<link rel="stylesheet" href="<c:url value='/template/web/css/cart.css'/>" type="text/css">
	</content>
	
</head>

<body>

	<div id='wrapper'>

		<div id="main">
		
			<div class="title" >
				<a style="color:gray;text-decoration: none;" href="<c:url value='/#' />">Trang Chủ  </a> 
				/  GIỎ HÀNG 
							
				
			</div>
			
			<div id="content">
    		
				<div id="giohang">	
					<form class="cart_detail" action="" method="post">
						<table class="list_cart" cellspacing="0">
								<thead>
									<tr>
										<th class="product-name" colspan="3">Sản phẩm</th>
										<th class="product-price">Giá</th>
										<th class="product-quantity">Số lượng</th>
										<th class="product-subtotal">Tổng cộng</th>
									</tr>
								</thead>
				
								<tbody>
									<c:forEach var="item" items="${cart}">
				    					<tr class="cart_item">			
				    						<td class="product-remove"><a class="removeCart" href="<c:url value='/xoa-gio-hang/${item.value.watch.id }'/>" >X</a></td>
				
				    						<td class="product-thumbnail">
				    							<img width="100" height="100" src="<c:url value='${item.value.watch.thumbnail }'/>" >
				    						</td>
				
				    						<td class="product-name" data-title="Sản phẩm">${item.value.watch.name }
				    						</td>
				
				    						<td class="product-price" data-title="Giá">
				    							<fmt:formatNumber type="number" groupingUsed="true" value="${item.value.watch.price-item.value.watch.discount}"/>
				    						</td>
				
				    						<td > <input class="cartquantity" cartid="${item.key}" type="number" name="qty${item.key }" min="1" max="10" value="${item.value.quantity }"></td>
				
				    						<td class="product-subtotal" data-title="Tổng cộng"><fmt:formatNumber type="number" groupingUsed="true" value="${item.value.totalPrice }"/></td>
				    					</tr>							
									</c:forEach>
									
								</tbody>
							</table>	
<!-- 						<input type="submit" value="Cập nhật" name="CapNhat"
							style="padding: 3px; float: right; margin-right: 17px;"> -->
					</form>	
				</div>
				
    			<div class="tongcong">
				    <form class="form-totalcart">
				        <table class="total_cart" border=1>
				            <tbody><tr>
				                <th colspan='2'>Tổng Giỏ Hàng</th>
				            </tr>
				            <tr>
				                <td>Tổng tiền sản phẩm</td>
				                <td><fmt:formatNumber type="number" groupingUsed="true" value="${totalPriceCart }"/> vnđ</td>
				            </tr>
				            <tr>
				                <td>Phí vận chuyển</td>
				                <td>FreeShip</td>
				            </tr>
				            <tr>
				                <td>Tổng tiền</td>
				                <td><fmt:formatNumber type="number" groupingUsed="true" value="${totalPriceCart}"/> vnđ</td>
				            </tr>
				            <tr>
				                <td colspan="2">Mã giảm giá    <i class="fas fa-tag"></i></td>
				            </tr>
				            <tr>
				                <td colspan="2"><input type="text" placeholder="Nhập mã giảm giá" id="idcoupon"> &nbsp;
				                <button class="">Áp dụng</button></td>		                
				            </tr>
      						<tr>
				                <td colspan="2"><input type="button" class="bt-checkout" value="Thanh Toán">    <i class="fas fa-arrow-right"></i></td>
				            </tr>
				        </tbody></table>
				    </form>
				</div>
    		
    		</div>
	
		</div>

	</div>

	<script type="text/javascript">
		$(".cartquantity").focusout(function() {
			let urlEdit = "${editCartURL}/" + $(this).attr("cartid") + "/" + $(this).val();
	    	$.get(urlEdit,function(data,status){
	    		 location.reload();
	    	});
		});
		
		$(".cart_item").mouseleave(function() {
			let cartQuantity = $(this).find(".cartquantity");
			if(cartQuantity.is(":focus")) {
				cartQuantity.focusout();
			}
		});
	</script>

</body>

</html>