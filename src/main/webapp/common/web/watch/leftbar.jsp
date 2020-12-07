<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ page import="com.watch.util.SecurityUtils"%>


<script>
	$("#sort").change(function(){
		var sort = $(this).val();
		$("#orderby").attr("value", sort);
	});
	
</script>


<form:form method="GET" class="form" id="formFilter" modelAttribute="model">
	<input type="hidden" value="${model.page }" id="page" name="page" /> 
	<input type="hidden" value="${model.limit }" id="limit" name="limit" />
	<input type="hidden" id="orderby" name="orderby" value="">

	<div class="label" style="margin-top: 19px">
		THƯƠNG HIỆU
		<form:select path="brandId" id="brandId" style="width: 90%; margin: 10px 0; font-size: 1.3em;">
			<form:option value=""/>
			<form:options items="${brands}" />
		</form:select>
	</div>

	<div class="label" style="margin-top: 19px">
		LOẠI ĐỒNG HỒ
		<form:select path="typeId" id="typeId" style="width: 90%; margin: 10px 0; font-size: 1.3em;">
			<form:option value=""/>
			<form:options items="${types}" />
		</form:select>
	</div>

	<div class="label">
		GIỚI TÍNH 
		<form:select path="gender"
			style="width: 90%; margin: 10px 0; font-size: 1.3em;">
			<option value=""></option>
			<form:options items="${genders}" />
		</form:select>
	</div>


	<div class="label">
		KHOẢNG GIÁ<br> <input type="text" class="khoanggia"
			name="beginPrice" id=""
			value="${beginPrice }">
		<span> - </span> <input type="text" class="khoanggia"
			name="duePrice" id=""
			value="${duePrice }">
	</div>


	<input type="submit" value="Lọc sản phẩm" class="redB" name="CapNhat" id="productFilter"
		style="padding: 7px 18px 8px 18px; float: right; margin-right: 17px;">
</form:form>

