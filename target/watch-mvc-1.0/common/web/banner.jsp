<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<div id="banner">

	<div id="demo" class="carousel slide" data-ride="carousel" data-interval="4000">


		<ul class="carousel-indicators">
						<li data-target="#demo" data-slide-to="0" class="active"></li>
						<li data-target="#demo" data-slide-to="1" class=""></li>
						<li data-target="#demo" data-slide-to="2" class=""></li>
						<li data-target="#demo" data-slide-to="3" class=""></li>
					</ul>


		<div class="carousel-inner">


        	<div class="carousel-item active">
				<a href=""> <img src="<c:url value='/resources/images/slide/slide1.png'/>" alt="" ></a>
			</div>
			
			<div class="carousel-item">
				<a href=""> <img src="<c:url value='/resources/images/slide/jisoo.jpg'/>" alt="" ></a>
			</div>

			<div class="carousel-item">
				<a href=""> <img src="<c:url value='/resources/images/slide/slide2.png'/>" alt="" ></a>
			</div>

			<div class="carousel-item">
				<a href=""> <img src="<c:url value='/resources/images/slide/slide3.png'/>" alt="" ></a>
			</div>

			
		</div>


		<a class="carousel-control-prev" href="#demo" data-slide="prev"> <span class="carousel-control-prev-icon"></span>
		</a> <a class="carousel-control-next" href="#demo" data-slide="next">
			<span class="carousel-control-next-icon"></span>
		</a>
	</div>


</div>