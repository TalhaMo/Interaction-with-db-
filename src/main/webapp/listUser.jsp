<%@ include file="include/header.jsp"%>
<%@ page import="java.util.List" %>
<%@ page import="org.studyeasy.entity.User" %>

<title><%=request.getAttribute("title") %></title>
	<div class="container mtb">
		<div class="row">
			<h1>list user</h1>
			<table class="table table-bordered">
			  <thead>
				    <tr>
				     
				      <th scope="col">User ID</th>
				      <th scope="col">Users name</th>
				      <th scope="col">Email</th>
				      <th scope="col">Operation</th>
				    </tr>
				  </thead>
		
			<% 
			List<User> listUsers=(List)request.getAttribute("listUsers");
			String tempURL;
			for(int i=0;i<listUsers.size();i++){
				
				out.print("<tr>");
						out.print("<td>"+listUsers.get(i).getUsers_id() +"</td>");
						out.print("<td>"+listUsers.get(i).getUsersname() +"</td>");
						out.print("<td>"+listUsers.get(i).getEmail() +"</td>");
						tempURL=request.getContextPath()+"/operation?page=updateUser"+
								"&userId="+listUsers.get(i).getUsers_id()+
								"&username="+listUsers.get(i).getUsersname()+
								"&email="+listUsers.get(i).getEmail();
						out.print("<td><a href="+tempURL+">update</a></td>");
				out.print("</tr>");
				
			
			}
			
			%>
			</table>
		</div>
	</div>
<%@ include file="include/footer.jsp"%>