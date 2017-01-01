<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="js/twitter.js" type="text/javascript"></script>
<link href="css/twitter.css" type="text/css" rel="stylesheet">
<title>Twitter Bar</title>
</head>
<body>
	<div class="container-fluid">
		<nav class="navbar navbar-inverse "> <!-- <nav class="navbar navbar-default"> -->
		<ul class="nav navbar-nav" id="navul">
			<li class="active"><a id="romance" href="javascript:void(0)"
				class="keyword" data-value="romance">Romance</a></li>
			<li><a id="comedy" href="javascript:void(0)" class="keyword"
				data-value="comedy">Comedy</a></li>
			<li><a id="sports" href="javascript:void(0)" class="keyword"
				data-value="sports">Sports</a></li>
			<li><a id="politics" href="javascript:void(0)" class="keyword"
				data-value="politics">Politics</a></li>
			<li><a id="scienceFiction" href="javascript:void(0)"
				class="keyword" data-value="sciencefiction">Science Fiction</a></li>
		</ul>
		<ul class="navbar-nav navbar-right">
			<li><a id="seetrends" href="javascript:void(0)" class="keyword"
				data-value="seetrends">See Trends</a></li>
				<li><a id="gMap" href="GoogleAPI.jsp" class="googleMap"
				data-value="GoogleMap">Location Tweets</a></li>
		</ul>
		</nav>
	</div>
	<div id="content-here"></div>
</body>
</html>
