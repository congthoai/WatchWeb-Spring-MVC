<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="watchURL" value="/quan-tri/dong-ho/danh-sach" />
<c:url var="editwatchURL" value="/quan-tri/dong-ho/chinh-sua" />
<c:url var="watchAPI" value="/api/watch" />
<html>
<head>
<title>Chỉnh sửa bài viết</title>
</head>
<body>
	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs" id="breadcrumbs">

				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a href="<c:url value='/quan-tri/trang-chu'/>">Trang quản trị</a>
					</li>

					<li><a href="${watchURL}?page=1&limit=2">Danh sách</a></li>
					<li class="active">Chi tiết</li>
				</ul>
				<!-- /.breadcrumb -->
			</div>
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">
						<c:if test="${not empty message}">
							<div class="alert alert-${alert}">${message}</div>
						</c:if>
						<form:form class="form-horizontal" role="form" id="formSubmit" modelAttribute="model" enctype="multipart/form-data">
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="form-field-1">Tên</label>
								<div class="col-sm-9">
									<form:input path="name" cssClass="col-xs-10 col-sm-5" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1">Hình ảnh</label>
								<div class="col-sm-9">
									<img id='watchimg' width="150" height="150" alt="150x150" src="<c:url value='${model.thumbnail }' />">
										<div class="text">
											<input type="file" class="col-xs-10 col-sm-5" id="file" name="file" />
										</div>
								</div>
							</div>
							<div class="form-group">
								  <label for="typeId" class="col-sm-3 control-label no-padding-right">Loại đồng hồ</label>
								  <div class="col-sm-9">
								  	 <form:select path="typeId" id="typeId">
								  	 	<form:option value="" label="-- Chọn loại --"/>
								  	 	<form:options items="${types}"/>
								  	 </form:select>
								  </div>
							</div>
							<div class="form-group">
								  <label for="brandId" class="col-sm-3 control-label no-padding-right">Thương hiệu</label>
								  <div class="col-sm-9">
								  	 <form:select path="brandId" id="brandId">
								  	 	<form:option value="" label="-- Chọn thương hiệu --"/>
								  	 	<form:options items="${brands}"/>
								  	 </form:select>
								  </div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="form-field-1">Size</label>
								<div class="col-sm-9">
									<form:input type="number" path="size" cssClass="col-xs-10 col-sm-5" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="form-field-1">Giá gốc</label>
								<div class="col-sm-9">
									<form:input path="price" cssClass="col-xs-10 col-sm-5" />
								</div>
							</div>
							<div class="form-group">
								<label for="shortDescription" class="col-sm-3 control-label no-padding-right">Giảm giá</label>
								<div class="col-sm-9">
									<form:input path="discount" cssClass="col-xs-10 col-sm-5" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="form-field-1">Bảo hành</label>
								<div class="col-sm-9">
									<form:input type="number" path="warranty" cssClass="col-xs-10 col-sm-5" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="form-field-1">Chống nước</label>
								<div class="col-sm-9">
									<form:input type="number" path="waterproof" cssClass="col-xs-10 col-sm-5" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="form-field-1">Tồn kho</label>
								<div class="col-sm-9">
									<form:input type="number" path="stock" cssClass="col-xs-10 col-sm-5" />
								</div>
							</div>
							
							<form:hidden path="id" id="newId" />
							<form:hidden path="thumbnail" id="thumbnail" />
							<div class="clearfix form-actions">
								<div class="col-md-offset-3 col-md-9">
									<c:if test="${not empty model.id}">
										<button class="btn btn-info" type="button"
											id="btnAddOrUpdateNew">
											<i class="ace-icon fa fa-check bigger-110"></i> Cập nhật bài
											viết
										</button>
									</c:if>
									<c:if test="${empty model.id}">
										<button class="btn btn-info" type="button"
											id="btnAddOrUpdateNew">
											<i class="ace-icon fa fa-check bigger-110"></i> Thêm bài viết
										</button>
									</c:if>

									&nbsp; &nbsp; &nbsp;
									<button class="btn" type="reset">
										<i class="ace-icon fa fa-undo bigger-110"></i> Hủy
									</button>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script>
	
		 function saveMedia(dataFile) {
	         console.log("form data " + dataFile);
	         $.ajax({
	             url : "http://localhost:8080/watch-mvc/quan-tri/dong-ho/chinh-sua",
	             data : dataFile,
	             processData : false,
	             contentType : false,
	             type : 'POST',
	             success : function(data) {
	            	 if(data != null) {
		            	 $('#watchimg').attr("src", "/"+window.location.pathname.split("/")[1]+"/resources/images/watch/"+data);;
		                 $('#thumbnail').val("/resources/images/watch/" + data); 
	            	 }
	             },
	             error : function(err) {
	                 console.log(err);
	             }
	         });
	    }
		 
		$('#file').change(function() {
			var formData = new FormData();
	        formData.append('file', $('#file')[0].files[0]);
			saveMedia(formData);
		});
		
 		$('#btnAddOrUpdateNew').click(function(e) {
			e.preventDefault();
			var data = {};
			var formData = $('#formSubmit').serializeArray();
			$.each(formData, function(i, v) {
				data["" + v.name + ""] = v.value;
			});
			var id = $('#newId').val();
			var thumbnail = $('#thumbnail').val();
			if (id == "") {
				addNew(data);
			} else {
				updateNew(data);
			}
		}); 

		function addNew(data) {
			$.ajax({
						url : '${watchAPI}',
						type : 'POST',
						contentType : 'application/json',
						data : JSON.stringify(data),
						dataType : 'json',
						success : function(result) {
							window.location.href = "${editwatchURL}?id="
									+ result.id + "&message=insert_success";
						},
						error : function(error) {
							window.location.href = "${watchURL}?page=1&limit=2&message=error_system";
						}
					});
		}

		function updateNew(data) {
			$.ajax({
				url : '${watchAPI}',
				type : 'PUT',
				contentType : 'application/json',
				data : JSON.stringify(data),
				dataType : 'json',
				success : function(result) {
					window.location.href = "${editwatchURL}?id=" + result.id
							+ "&message=update_success";
				},
				error : function(error) {
					window.location.href = "${watchURL}?page=1&limit=2&message=error_system";
				}
			});
		}
	</script>
</body>
</html>
