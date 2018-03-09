<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/style/basic_layout.css" rel="stylesheet" type="text/css">
<link href="/style/common_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/js/jquery/jquery.js"></script>
<script src="/js/plugins/artDialog/jquery.artDialog.js?skin=blue"></script>
<script type="text/javascript" src="/js/commonAll.js"></script>
<title>PSS-账户管理</title>
<style>
	.alt td{ background:black !important;}
</style>
</head>
<body>
	<form id="searchForm" action="/employee/query.do" method="post">
			<div class="ui_content">
				<div class="ui_text_indent">
					<div id="box_border">
						<div id="box_top">搜索</div>
						<div id="box_center">
							姓名/邮箱
							<input type="text" name="keyword" value="${qo.keyword}" class="ui_input_txt02">
							所属部门
							<select id="dept" name="deptId" class="ui_select01">
								<option value="-1">所有部门</option>
								<c:forEach items="${depts}" var="d">
									<option value="${d.id}">${d.name}</option>
								</c:forEach>
							</select>
							<script type="text/javascript">
								$.each($("#dept option"), function(index, item) {
									if (item.value == ${qo.deptId}) {
										item.selected = true;
									}
								});
							</script>
						</div>
						<div id="box_bottom">
							<input type="button" value="查询" class="ui_input_btn01 btn_page" data-page="1"/>
							<input type="button" value="新增" class="ui_input_btn01 btn_redirect" data-url="/employee/input.do"/>
						</div>
					</div>
				</div>
			</div>
			<div class="ui_content">
				<div class="ui_tb">
					<table class="table" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
						<tr>
							<th width="30"><input type="checkbox" id="all" /></th>
							<th>编号</th>
							<th>用户名</th>
							<th>EMAIL</th>
							<th>年龄</th>
							<th>所属部门</th>
							<th></th>
						</tr>
						<tbody>
							<c:forEach var="entity" items="${result.list}">
								<tr>
									<td><input type="checkbox" name="IDCheck" class="acb" autocomplete="off"/></td>
									<td>${entity.id}</td>
									<td>${entity.name}</td>
									<td>${entity.email}</td>
									<td>${entity.age}</td>
									<td>${entity.dept.name}</td>
									<td>
										<a href="/employee/input.do?id=${entity.id}">编辑</a>
										<a href="javascript:" class="btn_delete" data-url="/employee/delete.do?id=${entity.id}">删除</a>
									</td>

								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<!-- 分页操作 -->
				<%@ include file="/WEB-INF/views/common/common_page.jsp" %>
			</div>
		</div>
	</form>
	<script type="text/javascript">
		
	</script>
</body>
</html>
    
