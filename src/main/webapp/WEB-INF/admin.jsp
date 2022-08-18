<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="/WEB-INF/include/head.jsp" />

<body>
	<jsp:include page="/WEB-INF/include/header.jsp" />

	<div id=pageHeader
		class="container-fluid p-2 bg-primary text-white text-center">
		<h2>Site Administration</h2>
	</div>

	<div id=main class="container-fluid">

		<div id="playdateList" class="container my-5 ">

			<%-- 
		    <c:if test="${successMsg != null}">
			    <div class="alert alert-success alert-dismissible fade show" role="alert">
				  ${successMsg}
				  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
				</div>
			</c:if> 
			--%>

			<h3>User List</h3>
			<!-- <a href= "/playdate/new"><button class="btn btn-primary">Create New Playdate</button></a> -->
			<table
				class="table table-striped table-hover table-bordered table-responsive mt-2">
				<thead>
					<tr>
						<!-- <th scope="col">id</th> -->
						<th scope="col">Name</th>
						<th scope="col">Email</th>
						<th scope="col">User Group</th>
						<th scope="col">Action(s)</th>
						<!-- <th scope="col">Date/Time</th> -->
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${userList}" var="record">
						<tr>
							<%-- <td>${record.id}</td> --%>
							<td>${record.firstName}${record.lastName}</td>
							<%-- <td><a class="text-decoration-none" href="/profile/${record.userMdl.id}">${record.userMdl.userName}</a></td> --%>
							<td>${record.email}</td>
							<td>${record.roleMdl.get(0).name}</td>
							
								<%-- <fmt:formatDate value="${record.eventDate}" pattern="MMMM dd"/>, <fmt:formatDate value="${record.eventDate}" pattern="yyyy"/> @ ${record.startTimeTxt}
							</td> --%> 
								<c:if
									test="${currentUser.roleMdl.get(0).name.contains('ROLE_SUPER_ADMIN')}">
									<td>
										<a href="/delete/${record.id}">Delete</a> 
										<a href="/admin/${record.id}">Make Admin</a>
									</td>
								</c:if> 
								<c:if test="${currentUser.roleMdl.get(0).name.contains('ROLE_ADMIN')}">
									<c:if test="${record.roleMdl.get(0).name.contains('ROLE_USER')}">
										<td>
											<a href="/delete/${record.id}">Delete</a> 
											<a href="/admin/${record.id}">Make Admin</a>
										</td>
									</c:if>
									<c:if
										test="${record.roleMdl.get(0).name.contains('ROLE_ADMIN')}">
										<td>Admin</td>
									</c:if>
								</c:if>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>
		<!-- end playdateList -->

	</div>
	<!-- end main -->
	<jsp:include page="/WEB-INF/include/footerbuffer.jsp" />
	<jsp:include page="/WEB-INF/include/footer.jsp" />
</body>
</html>