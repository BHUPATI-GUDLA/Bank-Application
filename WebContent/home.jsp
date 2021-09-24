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
	background: #FFF5EB;
}

.flex-container {
	display: flex;
	/* border: 2px solid red; */
	height: 40vh;
	justify-content: space-around;
}

.flexItem {
	border: 2px solid black;
	margin: 15vh;
	width: 30vh;
	height: 20vh;
	border-radius: 25px;
}

#headline {
	text-align: center;
	border: 1px solid black;
	padding: auto;
	margin-top: 6vh;
	background-color: #bfd8b8;
	margin-top: 0px;
	height: 5vh;
	text-align: center;
}

h1 {
	text-align: center;
	/* border: 1px solid black; */
	padding: auto;
	margin-top: 6vh;
}

.head-button {
	display: flex;
	justify-content: space-around;
}

.topnav {
	overflow: hidden;
background-color: #333; 
	margin-top: -10px;
	margin-left: -9px;
	margin-right: -8px;
}

.topnav a {
	float: left;
	color: #f2f2f2;
	text-align: center;
	padding: 5px;
	text-decoration: none;
	font-size: 44px;
}

.topnav a:hover {
	background-color: #ddd;
	color: black;
}

.topnav a.active {
	/* background-color: #04aa6d; */
	color: white;
	width: 20%
}

.topnav-right {
	float: right;
}

.avatar {
	vertical-align: middle;
	width: 50px;
	height: 50px;
	border-radius: 50%;
}
</style>


<body>

	<%
		//String name = (String) request.getAttribute("username");
		String name = (String) session.getAttribute("uname");
		String acc_number = (String) session.getAttribute("acc_number");

		String ac_type = (String) session.getAttribute("acc_type");

		session.setAttribute("ac", ac_type);
	%>

	
	<div class="topnav">
		<a class="active" href="#" >Mon-Bank</a>
		<a href="Profile.jsp"><img src="image\profile.png" alt="Avatar"
				class="avatar" style="float: right; margin-left: 10px; margin-right: 10px;"></a>
		<div class="topnav-right">

			<a href="login.html">Logout</a>
		</div>
	</div>

	<h1>
		Welcome
		</h1>

	<div class="flex-container">
		<div class="flexItem" style="background-color: #fdfce5;">
			<a href="show_balance.jsp">
				<h1>Show Balance</h1>
			</a>
		</div>
		<div class="flexItem" style="background-color: #f4d19b;">
			<a href="Transfer_balance.jsp">
				<h1>Transfer</h1>
			</a>
		</div>

		<div class="flexItem" style="background-color: #fdfce5;">
			<a href="mini_statement.jsp">
				<h1>Mini Statement</h1>
			</a>
		</div>

	</div>

	<div class="flex-container">



		<div class="flexItem" style="background-color: #d7e9f7;">
			<a href="add_balance.jsp">
				<h1>Deposit</h1>
			</a>
		</div>

		<div class="flexItem" style="background-color: #f4d19b;">
			<a href="withdraw_balance.jsp">
				<h1>Withdraw</h1>
			</a>
		</div>


	</div>






</body>
</html>