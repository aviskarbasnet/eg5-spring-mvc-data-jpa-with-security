<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/bulma.min.css" />
</head>
<body>

	<section class="hero is-fullheight">
		<div class="hero-body">
			<div class="container">
				<div class="columns is-centered">
					<div class="column is-6-tablet is-5-desktop is-4-widescreen">
						<h1 class="title">Sign Up Form</h1>
						<c:if test="${param.invalid != null}">
							<div class="notification is-danger">Both email and password
								field shouldn't be empty.</div>
						</c:if>
						<c:if test="${param.exists != null}">
							<div class="notification is-danger">
								This email is already registered. Try to
								<strong>
									<a href="<%=request.getContextPath()%>/login">login</a>
								</strong>
								with this email.
							</div>
						</c:if>
						<form:form modelAttribute="user" method="POST" cssClass="box">
							<div class="field">
								<label class="label">Email</label>
								<div class="control">
									<input type="email" name="email"
										placeholder="e.g. abc@example.com" class="input" />
								</div>
							</div>
							<div class="field">
								<label class="label">Password</label>
								<div class="control">
									<input type="password" name="password" placeholder="*******"
										class="input" />
								</div>
							</div>
							<div class="field buttons">
								<button type="submit"
									class="button is-primary is-outlined is-rounded is-fullwidth">Submit</button>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</section>

</body>
</html>