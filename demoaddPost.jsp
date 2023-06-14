<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>post survey</title>
<link rel="stylesheet" href="css/bootstrap.css"></link>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Sofia">
<style>
  #frm{
     margin-top:70px;
  }
  body {
    background-image: url("https://images.pexels.com/photos/821649/pexels-photo-821649.jpeg?auto=compress&cs=tinysrgb&w=1600");
    background-repeat: no-repeat;
    background-size: cover;
  }
  .h{
  font-family: "Sofia", sans-serif;
  text-shadow: 3px 3px 3px #ababab;
  text-align: center;
  }
</style>

</head>
<body class ="bg-dark">
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
<h2 class="h" style="margin:25px">Publish Survey</h2>
<div id ="frm" class="container border border-dark rounded bg-light pb-3 pt-2">
<div class="row">
<div class ="col-md-12">
<form action="AddPost" method="post">
  <div class="form-group">
    <label for="exampleInputEmail1">Enter Question</label>
    <input type="text" class="border border-dark rounded form-control" name="question" id="question">
  </div>
  <label for="exampleInputEmail1">Answer Type</label>
  <div>
  <input class="form-group" type="radio" name="anstype" id="anstype" value="Text box">
  <label class="form-check-label" for="exampleRadios1">
    Text box
  </label>
</div>
<div >
  <input class="form-group" type="radio" name="anstype" id="anstype" value="Yes or No">
  <label class="form-check-label" for="exampleRadios2">
   Yes or No
  </label>
  </div>
  <div class="container text-center">
  <button type="submit" onclick="sendMessage()" class = "btn btn-danger ">Post</button>
  </div>
</form>
</div>
</div>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
  <script>
    function sendMessage() {
      localStorage.setItem('notification', 'New Survey Posted');
    }
  </script>
</body>
</html>