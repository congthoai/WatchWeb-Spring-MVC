<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div id="sidebar"
	class="sidebar                  responsive                    ace-save-state">

	<div class="sidebar-shortcuts">
		<div class="sidebar-shortcuts-large">
			<button class="btn btn-success">
				<i class="ace-icon fa fa-signal"></i>
			</button>

			<button class="btn btn-info">
				<i class="ace-icon fa fa-pencil"></i>
			</button>

			<button class="btn btn-warning">
				<i class="ace-icon fa fa-users"></i>
			</button>

			<button class="btn btn-danger">
				<i class="ace-icon fa fa-cogs"></i>
			</button>
		</div>
		<div class="sidebar-shortcuts-mini">
			<span class="btn btn-success"></span> <span class="btn btn-info"></span>

			<span class="btn btn-warning"></span> <span class="btn btn-danger"></span>
		</div>
	</div>

	<ul class="nav nav-list">
		<li><a href="#" class="dropdown-toggle"> <i
				class="menu-icon fa fa-cube"></i> <span class="menu-text"></span>
				SẢN PHẨM <b class="arrow fa fa-angle-down"></b>
		</a> <b class="arrow"></b>
			<ul class="submenu">
				<li><a href="<c:url value='/quan-tri/dong-ho/danh-sach?page=1&limit=2'/>">
						<i class="menu-icon fa fa-caret-right"></i>Đồng hồ
				</a> <b class="arrow"></b></li>
				<li><a href="<c:url value='/quan-tri/thuong-hieu/danh-sach?page=1&limit=2'/>">
						<i class="menu-icon fa fa-caret-right"></i> Thương hiệu
				</a> <b class="arrow"></b></li>
				<li><a href="<c:url value='/quan-tri/loai-dong-ho/danh-sach?page=1&limit=2'/>">
						<i class="menu-icon fa fa-caret-right"></i> Thể loại
				</a> <b class="arrow"></b></li>
				<li><a href="<c:url value='/quan-tri/loai-dong-ho/danh-sach?page=1&limit=2'/>">
						<i class="menu-icon fa fa-caret-right"></i> Phản hồi
				</a> <b class="arrow"></b></li>
				<li><a href="<c:url value='/quan-tri/loai-dong-ho/danh-sach?page=1&limit=2'/>">
						<i class="menu-icon fa fa-caret-right"></i> Đơn đặt hàng
				</a> <b class="arrow"></b></li>

			</ul></li>
	</ul>
	
	<ul class="nav nav-list">
		<li><a href="#" class="dropdown-toggle"> <i class="menu-icon fa fa-user"></i>
		<span class="menu-text"></span> TÀI KHOẢN <b class="arrow fa fa-angle-down"></b>
		</a> <b class="arrow"></b>
			<ul class="submenu">
				<li><a href="<c:url value='/quan-tri/nguoi-dung/danh-sach?page=1&limit=2'/>">
						<i class="menu-icon fa fa-caret-right"></i>Ban quản trị
				</a> <b class="arrow"></b></li>
				<li><a href="<c:url value='/quan-tri/nguoi-dung/danh-sach?page=1&limit=2'/>">
						<i class="menu-icon fa fa-caret-right"></i> Thành viên
				</a> <b class="arrow"></b></li>

			</ul></li>
	</ul>

	<ul class="nav nav-list">
		<li><a href="#" class="dropdown-toggle"> <i
				class="menu-icon fa fa-list"></i> <span class="menu-text"></span>
				NỘI DUNG <b class="arrow fa fa-angle-down"></b>
		</a> <b class="arrow"></b>
			<ul class="submenu">
				<li><a href="<c:url value='/quan-tri/dong-ho/danh-sach?page=1&limit=2'/>">
						<i class="menu-icon fa fa-caret-right"></i>Slide
				</a> <b class="arrow"></b></li>
				<li><a href="<c:url value='/quan-tri/bai-viet/danh-sach?page=1&limit=2'/>">
						<i class="menu-icon fa fa-caret-right"></i> Tin tức
				</a> <b class="arrow"></b></li>
				<li><a href="<c:url value='/quan-tri/bai-viet/danh-sach?page=1&limit=2'/>">
						<i class="menu-icon fa fa-caret-right"></i> Danh mục tin
				</a> <b class="arrow"></b></li>

			</ul></li>
	</ul>

	<ul class="nav nav-list">
		<li><a href="#" class="dropdown-toggle"> <i
				class="menu-icon fa fa-phone"></i> <span class="menu-text"></span>
				HỖ TRỢ VÀ LIÊN HỆ<b class="arrow fa fa-angle-down"></b>
		</a> <b class="arrow"></b>
			<ul class="submenu">
				<li><a href="<c:url value='/quan-tri/dong-ho/danh-sach?page=1&limit=2'/>">
						<i class="menu-icon fa fa-caret-right"></i>Hỗ trợ
				</a> <b class="arrow"></b></li>
				<li><a href="<c:url value='/quan-tri/thuong-hieu/danh-sach?page=1&limit=2'/>">
						<i class="menu-icon fa fa-caret-right"></i>Liên hệ
				</a> <b class="arrow"></b></li>

			</ul></li>
	</ul>
	<div class="sidebar-toggle sidebar-collapse">
		<i class="ace-icon fa fa-angle-double-left ace-save-state"
			data-icon1="ace-icon fa fa-angle-double-left"
			data-icon2="ace-icon fa fa-angle-double-right"></i>
	</div>
</div>