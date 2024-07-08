 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!------ Include the above in your HEAD tag ---------->
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
<link href="css/login.css" rel="stylesheet" type="text/css" />
<link href='https://unpkg.com/css.gg@2.0.0/icons/css/log-out.css' rel='stylesheet'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Đăng nhập nào =))</title>
</head>
<body>
	<div id="logreg-forms">
		<form class="form-signin" action="change" method="post">
			<h1 class="h3 mb-3 font-weight-normal" style="text-align: center">Mật Khẩu</h1>
			<p style="color: red">${note}</p>
			<input type="hidden" name="user" value="${sessionScope.acc.user}">
			<input name="pass1" type="password" class="form-control" placeholder="Mật khẩu cũ" required>
			<input name="pass2" type="password" class="form-control" placeholder="Mật khẩu mới" required>
			<input name="pass3" type="password" class="form-control" placeholder="Nhập mật khẩu mới" required>
			<button class="btn btn-success btn-block" type="submit">
				<i class="fas fa-sign-in-alt"></i> Đổi mật khẩu		
			</button>

		</form>
		
		</div>
	</body>
</html>