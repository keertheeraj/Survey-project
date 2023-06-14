<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin page</title>
<link rel="stylesheet" href="css/bootstrap.css"></link>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Sofia">
<style>
  #frm {
    width: 700px;
    margin: auto;
    margin-top: 100px;
  }
  .center {
    text-align: center;
  }
  body {
    background-image: url("https://images.pexels.com/photos/821649/pexels-photo-821649.jpeg?auto=compress&cs=tinysrgb&w=1600");
    background-repeat: no-repeat;
    background-size: cover;
  }
  .h{
  font-family: "Sofia", sans-serif;
  text-shadow: 3px 3px 3px #ababab;
  }
</style>
</head>
<body class="bg-dark">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container">
    <a class="navbar-brand" href="welcome.jsp">Admin</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" href="demoaddPost.jsp">Publish Survey</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="userdata">User Response</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="show">Posted Surveys</a>
        </li>
      </ul>
    </div>
    <a href="login.jsp" class="btn btn-danger ml-auto">Logout</a>
  </div>
</nav>
<div class="container">
  <div class="center">
    <h1 class="h" style="margin: 390px;">Surveys</h1>
  </div>
</div>
</body>
</html>
