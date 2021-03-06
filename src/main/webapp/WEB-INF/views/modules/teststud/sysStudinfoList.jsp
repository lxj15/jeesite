<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>学生管理管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/teststud/sysStudinfo/">学生管理列表</a></li>
		<shiro:hasPermission name="teststud:sysStudinfo:edit"><li><a href="${ctx}/teststud/sysStudinfo/form">学生管理添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="sysStudinfo" action="${ctx}/teststud/sysStudinfo/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>学生学号：</label>
				<form:input path="studNum" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>学生姓名：</label>
				<form:input path="studName" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>班级名称</th>
				<th>学生学号</th>
				<th>学生姓名</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="teststud:sysStudinfo:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sysStudinfo">
			<tr>
				<td><a href="${ctx}/teststud/sysStudinfo/form?id=${sysStudinfo.id}">
					${sysStudinfo.studNum}
				</a></td>
				<td>
					${sysStudinfo.studName}
				</td>
				<td>
					<fmt:formatDate value="${sysStudinfo.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${sysStudinfo.remarks}
				</td>
				<shiro:hasPermission name="teststud:sysStudinfo:edit"><td>
    				<a href="${ctx}/teststud/sysStudinfo/form?id=${sysStudinfo.id}">修改</a>
					<a href="${ctx}/teststud/sysStudinfo/delete?id=${sysStudinfo.id}" onclick="return confirmx('确认要删除该学生管理吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>