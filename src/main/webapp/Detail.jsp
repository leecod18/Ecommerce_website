<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Chi tiết sản phẩm</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
	
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<style>
.gallery-wrap .img-big-wrap img {
	height: 450px;
	width: auto;
	display: inline-block;
	cursor: zoom-in;
}

.gallery-wrap .img-small-wrap .item-gallery {
	width: 60px;
	height: 60px;
	border: 1px solid #ddd;
	margin: 7px 2px;
	display: inline-block;
	overflow: hidden;
}

.gallery-wrap .img-small-wrap {
	text-align: center;
}

.gallery-wrap .img-small-wrap img {
	max-width: 100%;
	max-height: 100%;
	object-fit: cover;
	border-radius: 4px;
	cursor: zoom-in;
}

.img-big-wrap img {
	width: 100% !important;
	height: auto !important;
}
</style>
</head>
<body>
	<jsp:include page="Menu.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="col-sm-3">
				<div class="card bg-light mb-3">
					<div class="card-header bg-primary text-white text-uppercase">
						<i class="fa fa-list"></i> DANH MỤC
					</div>
					<ul class="list-group category_block">
						<c:forEach items="${listCa}" var="o">
							<li class="list-group-item text-white"><a
								href="Category?cid=${o.cid}">${o.cname}</a></li>
						</c:forEach>
					</ul>
				</div>
				<div class="card bg-light mb-3">
					<div class="card-header bg-success text-white text-uppercase">Sản
						phẩm mới</div>
					<div class="card-body">
						<img class="img-fluid" src="${p.image}" />
						<h5 class="card-title">${p.name}</h5>
						<p class="card-text">${p.description}</p>
						<p class="bloc_left_price">${p.price}$</p>
					</div>
				</div>
			</div>
			<div class="col-sm-9">
				<div class="container">
					<div class="card">
						<div class="row">
							<aside class="col-sm-5 border-right">
								<article class="gallery-wrap">
									<div class="img-big-wrap">
										<div>
											<a href="#"><img src="${detail.image}"></a>
										</div>
									</div>
									<!-- slider-product.// 
									<div class="img-small-wrap">
										<div class="item-gallery">
											<img
												src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQCepDDx2BVt6xaS4HE-_i43nybyVabVS6B3d8M33F9BF_YY_jC1xaIZsNuR_o&usqp=CAc">
										</div>
										<div class="item-gallery">
											<img
												src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQCepDDx2BVt6xaS4HE-_i43nybyVabVS6B3d8M33F9BF_YY_jC1xaIZsNuR_o&usqp=CAc">
										</div>
										<div class="item-gallery">
											<img
												src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQCepDDx2BVt6xaS4HE-_i43nybyVabVS6B3d8M33F9BF_YY_jC1xaIZsNuR_o&usqp=CAc">
										</div>
										<div class="item-gallery">
											<img
												src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQCepDDx2BVt6xaS4HE-_i43nybyVabVS6B3d8M33F9BF_YY_jC1xaIZsNuR_o&usqp=CAc">
										</div>
									</div>
									-->
									<!-- slider-nav.// -->
								</article>
								<!-- gallery-wrap .end// -->
							</aside>
							
							<aside class="col-sm-7">
								<article class="card-body p-5">
									<h3 class="title mb-3">${detail.name}</h3>
									<p class="price-detail-wrap">
										<span class="price h3 text-warning"> <span
											class="currency">$</span><span class="num">${detail.price}</span>
										</span>										
									</p>

									<dl class="item-property">
										<dt>Chi tiết: </dt>
										<dd>
											<p>${detail.description}</p>
										</dd>
									</dl>
									<hr>
									 <div class="row">
										<div class="col-sm-5">
											<dl class="param param-inline">
												<dt>Số lượng:</dt>
												<dd>
													   <input value="1" name="id" type="text" size="3" style=" border-radius: 3px; " readonly required>
												</dd>
											</dl>
											<!-- item-property .// -->
										</div>
										<!-- col.// -->

									</div>
								
									
									<!-- row.// -->
									<hr>
									<a href="cart?action=add&id=${detail.id}" class="text-uppercase">
										<button type="button" class="btn btn-primary btn-lg">MUA NGAY</button>	
									</a>
																 
									<a href="cart?action=add&id=${detail.id}" class="text-uppercase">
										<button type="button" class="btn btn-primary btn-lg">THÊM VÀO GIỎ</button>
									</a>
								</article>
								<!-- card-body.// -->
							</aside>
							<!-- col.// -->
						</div>
						<!-- row.// -->
					</div>
					<!-- card.// -->


				</div>
			</div>
		</div>
	</div>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
