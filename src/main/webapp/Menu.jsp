                                     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
	<div class="container">
		<a class="navbar-brand" href="Home">Trang chủ</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault"
			aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
			<ul class="navbar-nav m-auto">
				<c:if test="${sessionScope.acc.isAdmin == 1}">
					<li class="nav-item"><a class="nav-link" href="#">Quản lí tài khoản</a></li>
				</c:if>
				<c:if test="${sessionScope.acc.isSell == 1}">
					<li class="nav-item"><a class="nav-link" href="manager">Quản lí sản phẩm</a></li>
				</c:if>
				<c:if test="${sessionScope.acc != null}">
					<li class="nav-item"><a class="nav-link" href="logout">Đăng xuất</a></li>
					<li class="nav-item">
					<a class="nav-link" href="Account.jsp"><i class="fa fa-user-o" aria-hidden="true"></i> <b>${sessionScope.acc.user} </b></a>
					</li> 
				</c:if> 	
				<c:if test="${sessionScope.acc == null}">
					<li class="nav-item"><a class="nav-link" href="Login.jsp?action=sigin">Đăng nhập</a></li>
				</c:if>
			</ul>

			<form action="Search" method="post" class="form-inline my-2 my-lg-0">
				<div class="input-group input-group-sm">
					<input value="${txtS}" name="txt" type="text" class="form-control" aria-label="Small"
						aria-describedby="inputGroup-sizing-sm" placeholder="Tìm kiếm...">
					<div class="input-group-append">
						<button type="submit" class="btn btn-secondary btn-number">
							<i class="fa fa-search"></i>
						</button>
					</div>
				</div>
				<a class=" ml-3" href="Cart.jsp" style=""> <i class="fa fa-shopping-cart" aria-hidden="true" style="font-size:24px ; color: white"></i> </a>
				<span data-auto-id="cart-count"></span>				
					
			</form>
		</div>
	</div>
</nav>
<section class="jumbotron text-center">
	<div class="container">
		<h1 class="jumbotron-heading">QM Sneaker</h1>
		<p class="lead text-muted mb-0">Hãy tự bảo vệ đôi chân của bạn bằng những đôi giày cực kì chất lượng của chúng tôi</p>
	</div>
</section>