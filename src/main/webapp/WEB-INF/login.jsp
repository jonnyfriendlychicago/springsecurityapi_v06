<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="include/head.jsp" />

<body>
	<jsp:include page="include/header.jsp" />
	
	<div id=pageHeader class="container-fluid p-2 bg-primary text-white text-center">
		<h2>Registration and Login</h2>
	</div>
	
	<div id=main class="container-fluid">
		<div class="row mt-3">
			<div class="col">
			</div> <!-- end col -->
			<div class="col-sm-7">
				
				<%-- 
				<c:if test="${validationErrorMsg != null}">
			        <div class="alert alert-danger" role="alert">
			        	${validationErrorMsg}
			        </div>
			    </c:if> 
			    --%>
			    
				<div id="loginCard" class="card p-3 d-md-flex justify-content-center align-items-center" >
					<c:if test="${logoutMessage != null}">
				        <c:out value="${logoutMessage}"></c:out>
				    </c:if>
				    
			        <c:if test="${errorMessage != null}">
				        <c:out value="${errorMessage}"></c:out>
				    </c:if>
    
    				<h1 class="h3 mb-3 fw-normal">Please Login</h1>

					<form:form action='/login' method='post' modelAttribute='user'>
						
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						
						<div class="form-floating mb-3">
							<form:input path="email" type="email" class="form-control" id="email" placeholder="name@example.com"/>
							<form:label path="email" for="email">Email</form:label>
							<p class="text-danger"><form:errors path="email" />
						</div>

						<div class="form-floating mb-3">
							<form:input path="password" type="password" class="form-control" id="password" placeholder="Password"/> 
							<form:label path="password" for="password">Password</form:label>
							<p class="text-danger"><form:errors path="password" />
						</div>

						<button type="submit" class="w-100 btn btn-primary">Login</button>
						
						<p>New user? <a href="/register"><button type="button" class="btn btn-link">Create an account</button></a> 
						
					</form:form>
				</div> <!-- end loginCard -->
			</div> <!-- end col -->
			<div class="col">
			</div> <!-- end col -->
		</div> <!-- end row -->
	</div><!-- end main -->
 

	
	<jsp:include page="include/footer.jsp"/>
			
			
</body>
</html>