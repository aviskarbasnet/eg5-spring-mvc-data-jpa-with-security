<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login | Sign Up</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/bulma.min.css" />
</head>
<body>

	<section class="hero is-fullheight">
		<div class="hero-body">
			<div class="container">
				<div class="columns is-centered">
					<div class="column is-6-tablet is-5-desktop is-4-widescreen">
						<h1 class="title">Login Form</h1>
						<c:if test="${param.error != null}">
							<div class="notification is-danger">Email and password
								doesn't match.</div>
						</c:if>
						<c:if test="${param.logout != null}">
							<div class="notification is-info">You've been successfully
								logged out.</div>
						</c:if>
						<c:if test="${param.signup != null}">
							<div class="notification is-primary">
								You've been successfully registered as user. Now, you can
								<strong>login</strong>
								.
							</div>
						</c:if>
						<form:form method="POST" cssClass="box">
							<div class="field">
								<label class="label">Email</label>
								<div class="control">
									<input type="email" name="username"
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
									class="button is-primary is-outlined is-rounded is-fullwidth">Login</button>
								<a href="<%=request.getContextPath()%>/sign-up"
									class="button is-link is-outlined is-rounded is-fullwidth">Sign
									Up</a>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</section>

</body>
</html>