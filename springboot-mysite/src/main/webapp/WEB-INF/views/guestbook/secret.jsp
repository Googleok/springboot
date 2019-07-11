<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page import="com.cafe24.mysite.vo.ModalVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%pageContext.setAttribute("newLine","\n");%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Bootstrap</title>

<script src="https://code.jquery.com/jquery-3.4.1.js"
	integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
	crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath }/assets/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

<link href="${pageContext.request.contextPath }/assets/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath }/assets/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<style>
body {
  color: #6a6c6f;
  background-color: #f1f3f6;
  margin-top: 30px;
}

.container {
  max-width: 960px;
}

.table>tbody>tr.active>td,
.table>tbody>tr.active>th,
.table>tbody>tr>td.active,
.table>tbody>tr>th.active,
.table>tfoot>tr.active>td,
.table>tfoot>tr.active>th,
.table>tfoot>tr>td.active,
.table>tfoot>tr>th.active,
.table>thead>tr.active>td,
.table>thead>tr.active>th,
.table>thead>tr>td.active,
.table>thead>tr>th.active {
  background-color: #fff;
}

.table-bordered > tbody > tr > td,
.table-bordered > tbody > tr > th,
.table-bordered > tfoot > tr > td,
.table-bordered > tfoot > tr > th,
.table-bordered > thead > tr > td,
.table-bordered > thead > tr > th {
  border-color: #e4e5e7;
}

.table tr.header {
  font-weight: bold;
  background-color: #fff;
  cursor: pointer;
  -webkit-user-select: none;
  /* Chrome all / Safari all */
  -moz-user-select: none;
  /* Firefox all */
  -ms-user-select: none;
  /* IE 10+ */
  user-select: none;
  /* Likely future */
}

.table tr:not(.header) {
  display: none;
}

.table .header td:after {
  content: "\002b";
  position: relative;
  top: 1px;
  display: inline-block;
  font-family: 'Glyphicons Halflings';
  font-style: normal;
  font-weight: 400;
  line-height: 1;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  float: right;
  color: #999;
  text-align: center;
  padding: 3px;
  transition: transform .25s linear;
  -webkit-transition: -webkit-transform .25s linear;
}

.table .header.active td:after {
  content: "\2212";
}
</style>
<script>
	$(document).ready(function() {
	  //Fixing jQuery Click Events for the iPad
	  var ua = navigator.userAgent,
	    event = (ua.match(/iPad/i)) ? "touchstart" : "click";
	  if ($('.table').length > 0) {
	    $('.table .header').on(event, function() {
	      $(this).toggleClass("active", "").nextUntil('.header').css('display', function(i, v) {
	        return this.style.display === 'table-row' ? 'none' : 'table-row';
	      });
	    });
	  }
	})
</script>
</head>
<body>

	<div class="container">

		<div class="row">
			<div class="col-md-12">

				<div class="page-header">
					<h1>연남동</h1>
					<h2>디저트</h2>
				</div>

				<a href="#dialog" role="button" class="btn btn-default"
					data-toggle="modal">방명록 달기</a>

				<div class="modal fade" id="dialog" role="dialog"
					aria-labelledby="dlogLabel" aria-hidden="true">

					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h4 class="modal-title" id="dlogLabel">연남동 갈사람!</h4>
							</div>
							<div class="modal-body">
								<form class="form-horizontal" id="frm" role="form" action="${pageContext.servletContext.contextPath }/guestbook/secret" method="post">
									<div class="form-group">
										<label for="email" class="col-xs-2 col-lg-2 control-label">이름</label>
										<div class="col-xs-10 col-lg-10">
											<input type="text" class="form-control" id="email" name="email" placeholder="이름">
										</div>
									</div>
									<div class="form-group">
										<label for="Password" class="col-sm-2 col-lg-2 control-label">비밀번호</label>
										<div class="col-sm-10 col-lg-10">
											<input type="password" class="form-control"
												id="inputPassword" name="password" placeholder="Password">
										</div>
									</div>
									<div class="form-group">
										<label for="text" class="col-xs-2 col-lg-2 control-label">Message</label>
										<div class="col-xs-10 col-lg-10">
											<input class="form-control" type="text" id="inputText" name="content" placeholder="message">
										</div>
									</div>
								</form>
							</div>
							<div class="modal-footer">
								<a href="#" role="button" class="btn btn-primary"
									data-dismiss="modal" id="submit">Submit</a>
								<a href="#" role="button" class="btn btn-default"
									data-dismiss="modal">Close</a>
							</div>
						</div>

					</div>

				</div>

			</div>
		</div>
		<br>
		<table class="table table-bordered">
			<c:set var ='count' value ='${fn:length(modalList) }' />
			<c:forEach items = '${modalList }' var = 'vo' varStatus = 'status'>
			<tr class="header">
				<td colspan="2">${vo.email}</td>
			</tr>
			<tr>
				<td style="width: 700px;">${fn:replace(vo.contents,newLine,"<br>") }</td>
				<td style="width: 230px;">${vo.regDate}</td>
			</tr>
			</c:forEach>
		</table>

	</div>

</body>
<script type="text/javascript">
$('#submit').on('click', function () {
	var email = $('#email').val()
	var password = $('#inputPassword').val();
	$('#frm').submit();
	console.log('전송완료');	
});
</script>
</html>