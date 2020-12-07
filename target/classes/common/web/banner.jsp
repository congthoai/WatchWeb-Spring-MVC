<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<div id="banner">

	<div id="demo" class="carousel slide" data-ride="carousel" data-interval="1000">


		<ul class="carousel-indicators">
						<li data-target="#demo" data-slide-to="0" class="active"></li>
						<li data-target="#demo" data-slide-to="1" class=""></li>
						<li data-target="#demo" data-slide-to="2" class=""></li>
						<li data-target="#demo" data-slide-to="3" class=""></li>
						<li data-target="#demo" data-slide-to="4" class=""></li>
					</ul>


		<div class="carousel-inner">

			<c:forEach var="item" items="${banners}" varStatus="loop">
				<div class="carousel-item  <c:if test="${loop.index == 0 }"> active</c:if>">
					<a href=""> <img src="<c:url value='${item.link }'/>"></a>
				</div>
			</c:forEach>

			
		</div>


		<a class="carousel-control-prev" href="#demo" data-slide="prev"> <span class="carousel-control-prev-icon"></span>
		</a> <a class="carousel-control-next" href="#demo" data-slide="next">
			<span class="carousel-control-next-icon"></span>
		</a>
	</div>


</div>