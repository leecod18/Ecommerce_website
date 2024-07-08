<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Giỏ hàng </title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css">


</head>

<body>
	<jsp:include page="Menu.jsp"></jsp:include>
	<div class="shopping-cart">
		<div class="px-4 px-lg-0">
			<div class="pb-5">
				<div class="container">
					<div class="row">
						<div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">

							<!-- Shopping cart table -->
							<div class="table-responsive">
								<table class="table">
									<thead>
										<tr>
											<th scope="col" class="border-0 bg-light">
												<div class="p-2 px-3 text-uppercase">Sản Phẩm</div>
											</th>
											<th scope="col" class="border-0 bg-light">
												<div class="py-2 text-uppercase">Đơn Giá</div>
											</th>
											<th scope="col" class="border-0 bg-light">
												<div class="py-2 text-uppercase">Số Lượng</div>
											</th>
											<th scope="col" class="border-0 bg-light">
												<div class="py-2 text-uppercase">Xóa</div>
											</th>
										</tr>
									</thead>
									<tbody>
										<c:set var="total" value="0"></c:set>
										<c:forEach items="${sessionScope.cart}" var="item">
											
											<c:set var="total" value="${total + (item.quantity * item.product.price) }"></c:set>
											<tr>
												<th scope="row">
													<div class="p-2">
														<img src="" alt="" width="70" class="img-fluid rounded shadow-sm">
														<div class="ml-3 d-inline-block align-middle">
															<h5 class="mb-0">
																<a href="#" class="text-dark d-inline-block">${item.product.name}</a>
															</h5>
															<span class="text-muted font-weight-normal font-italic"></span>
														</div>
													</div>
												</th>
												<td class="align-middle"><strong>${item.product.price}</strong></td>
												<td class="align-middle">
													<a href="quantity?action=dec&id=${item.product.id}">
														<button style="width: 30px"> - </button>
													</a>
													<input type="text" value="${item.quantity}" size="6" name="quantity">
													<a href="quantity?action=inc&id=${item.product.id}">										
														<button style="width: 30px">+</button>
													</a>
												</td>
												<td class="align-middle">
												<a href="cart?action=remove&id=${item.product.id}" class="text-dark">													
													<button type="button" class="btn btn-danger"><i class="fa fa-trash"></i></button>
												</a>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<!-- End -->
						</div>
					</div>

					<div class="row py-5 p-4 bg-white rounded shadow-sm">
						<div class="col-lg-6">
							<div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Voucher</div>
							<div class="p-4">
								<div class="input-group mb-4 border rounded-pill p-2">
									<input type="text" placeholder="Nhập Voucher" aria-describedby="button-addon3" class="form-control border-0">
									<div class="input-group-append border-0">
										<button id="button-addon3" type="button" class="btn btn-dark px-4 rounded-pill">
											<i class="fa fa-gift mr-2"></i>Sử dụng
										</button>
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-6">
							<div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Thành tiền</div>
							<div class="p-4">
								<ul class="list-unstyled mb-4">
									<li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Tổng
											tiền hàng</strong><strong>${total} $</strong></li>
									<li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Phí vận
											chuyển</strong><strong>Free ship</strong></li>
									<li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">VAT</strong><strong>10%</strong></li>
									<li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Tổng
											thanh toán</strong>
										<h5 class="font-weight-bold">${total*1.1}</h5></li>
								</ul>
								<a href="buy" class="btn btn-dark rounded-pill py-2 btn-block">Mua hàng</a>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
	<script>
	</script>
</body>
</html>

