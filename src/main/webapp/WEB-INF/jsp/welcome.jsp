<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>MyBusiness - Our Services</title>

    <link href="${contextPath}/resources/css/bootstrap1.min.css" rel="stylesheet">
</head>
<body>

<!-- Start header -->
    <header class="top-header bg-primary text-white">
        <nav class="navbar header-nav navbar-expand-lg">
            <div class="container-fluid">
                <a class="navbar-brand" href=""><img src="" alt="image"></a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar-wd" aria-controls="navbar-wd" aria-expanded="false" aria-label="Toggle navigation">
                    <span></span>
                    <span></span>
                    <span></span>
                </button>
                <div class="collapse navbar-collapse justify-content-end" id="navbar-wd">
                    <ul class="navbar-nav">
                    <c:if test="${pageContext.request.userPrincipal.name != null}">
                    	<li class="mt-2"><p class="text-dark">Logged In As: ${pageContext.request.userPrincipal.name}</p></li>
                    </c:if>
                        <li><a class="nav-link active text-white" href="/">Home</a></li>
                        <li><a class="nav-link text-white" href="/about">AboutUs</a></li>
                        <li><a class="nav-link text-white" href="/services">Services</a></li>
                        <li><a class="nav-link text-white" href="/contact">Contact Us</a></li>
                        <li><a href="" class="nav-link">Logout</a></li>
                        <li><a onclick="document.forms['logoutForm'].submit()" class="nav-link">Logout</a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>
    <!-- End header -->

<div class="container mt-5">

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
		<h2>Our Services Page</h2>
    </c:if>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
