<%@ include file="include/header.jsp"%>


<title><%=request.getAttribute("title") %></title>
	<div class="container mtb">
		<div class="row">
			<h1>Add user</h1>
			<form action="<%=request.getContextPath()%>/operation" method="post">
				User name: <input type="text" name="username" required="required"/>
				Email: <input type="email" name="email" required="required"/>
				<input type="hidden" name="form" value="addUserOperation"/>
				<input type="submit" value="ADD USER"/>
			</form>
		</div>
	</div>
<%@ include file="include/footer.jsp"%>