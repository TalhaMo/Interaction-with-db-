<%@ include file="include/header.jsp"%>


<title><%=request.getAttribute("title") %></title>
	<div class="container mtb">
		<div class="row">
			<h1>Update user</h1>
			<form action="<%=request.getContextPath()%>/operation" method="post">
				User name: <input type="text" name="username" value="${param.username }" required="required"/>
				Email: <input type="email" name="email" value="${param.email}" required="required"/>
				<input type="hidden" name="userId" value="${param.userId}"/>
				<input type="hidden" name="form" value="updateUserOperation"/>
				<input type="submit" value="UPDATE USER"/>
			</form>
		</div>
	</div>
<%@ include file="include/footer.jsp"%>