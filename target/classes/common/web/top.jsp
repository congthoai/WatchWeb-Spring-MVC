<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ page import="com.watch.util.SecurityUtils"%>



<div class="top">
	<div class="logo">
		<a href="<c:url value='/#'/>" title="UIT"> <img width="120"
			height="40" src="<c:url value='/resources/images/UiTlogo.png'/>"
			alt="linklogo">
		</a>
	</div>

	<div class="menu">
		<ul>
			<c:forEach items="${menu}" var="item">
				<li class="ThuongHieu">
					<a href="<c:url value='${item.getValue().getLink()}'/>" title="${item.getValue().getName()}">${item.getValue().getName()}</a>
					<c:if test="${item.getValue().getSubMenu() != null}">
						<div class="ThuongHieu-dropdown">
							<c:forEach items="${item.getValue().getSubMenu()}" var="subMenu">
									<a href="<c:url value='/${subMenu.getLink()}'/>">${subMenu.getName()}</a>
							</c:forEach>
						</div>
					</c:if>
				</li>
			</c:forEach>
		</ul>
	</div>

	<div class="menu_icon">
		<ul>
			<li class="icon-search"><a class="menuicon" href="#"><i
					id="timkiem" class="fas fa-search"></i></a>
				<ul id="search-dropdown">
					<form class="searchbar">
						<input class="search_input" type="text" name=""
							placeholder="Search..."> <a id="search_click" href=""
							class="search_icon"><i class="fas fa-search"></i></a>
					</form>

				</ul></li>
			<li id="user"><a class="menuicon" href="#"><i id="usericon"
					class="fas fa-user"></i></a>
				<div id="user-dropdown">
					<security:authorize access="isAnonymous()">
						<a href="<c:url value='/dang-nhap'/>">Đăng nhập</a>
						<a href="<c:url value='/dang-ky'/>">Tạo tài khoản</a>
					</security:authorize>

					<security:authorize access="isAuthenticated()">
						<a href="#"><%=SecurityUtils.getPrincipal().getFullName()%></a>
						<a href="<c:url value='/don-hang'/>" >Đơn hàng</a>
						<a href="<c:url value='/thoat'/>" >Đăng xuất</a>
					</security:authorize>
				</div></li>

			<li><a class="menuicon"
				href="<c:url value='/checkout'/>"> <i
					id="view_cart" class="fas fa-shopping-bag"><sup
						id="qty_cart_ajax" style="font-size: 19px; color: #FFF999"></sup></i>
			</a></li>

		</ul>
	</div>

</div>

<script>
        $(document).ready(function() {
            $(window).scroll(function() {
            if($(document).scrollTop() ) {
                $('.top').addClass('shrink');
                    }
            else {
                $('.top').removeClass('shrink');
                    }
            });            
        });
    </script>