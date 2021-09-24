<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
body {
	background-color: #e2c2b9;
}

* {
	box-sizing: border-box;
}

.container {
	position: relative;
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px 0 30px 0;
}

input, .btn {
	width: 100%;
	padding: 12px;
	border: none;
	border-radius: 4px;
	margin: 5px 0;
	opacity: 0.85;
	display: inline-block;
	font-size: 17px;
	line-height: 20px;
	text-decoration: none;
}

input:hover, .btn:hover {
	opacity: 1;
}

input[type='submit'] {
	background-color: #04aa6d;
	color: white;
	cursor: pointer;
}

input[type='submit']:hover {
	background-color: #45a049;
}

.col {
	float: left;
	width: 50%;
	margin: auto;
	padding: 0 50px;
	margin-top: 6px;
}

.row:after {
	content: '';
	display: table;
	clear: both;
}

.center {
	margin: auto;
	width: 60%;
	border: 3px solid #73ad21;
	padding: 10px;
}

/* vertical line */
.vl {
	position: absolute;
	left: 50%;
	transform: translate(-50%);
	border: 2px solid #ddd;
	height: 175px;
}

.inner {
	position: absolute;
	top: 50%;
	transform: translate(-50%, -50%);
	background-color: #f1f1f1;
	border: 1px solid #ccc;
	border-radius: 50%;
	padding: 8px 10px;
}

.hide-md-lg {
	display: none;
}

.bottom-container {
	text-align: center;
	background-color: #666;
	border-radius: 0px 0px 4px 4px;
	column-gap: 40px;
	margin: 20px;
}

@media screen and (max-width: 650px) {
	.col {
		width: 100%;
		margin-top: 0;
		align-content: center;
	}
	.vl {
		display: none;
	}
	.hide-md-lg {
		display: block;
		text-align: center;
	}
}
</style>

<body>

	<center>
		<h1>Transfer Money</h1>
	</center>

	<%
		String name = (String) session.getAttribute("uname");

		session.setAttribute("uname", name);
	%>
	<center>
		<h1><%=name%></h1>
	</center>
	<div class="container">
		<form action="Transfer_balance" method="post">
			<div class="row">
				<div class="center">
					<div class="hide-md-lg"></div>

					<input type="text" name="username" placeholder="Enter Username"
						required /> <input type="number"
						name="Account_number" placeholder="Enter Account Number" required />


					<input type="number" name="amount" placeholder="Enter Amount"
						required /> <input type="submit"
						value="Transfer Money" /> <a href="home.jsp"><input
						type="button" value="Back" style="cursor: pointer;" /></a>
				</div>
			</div>
		</form>
	</div>

</body>
</html>