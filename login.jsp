<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="css/bootstrap.css"></link>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Sofia">
<style>
  body {
    background-color: #f8f9fa;
    background-image: url("https://images.pexels.com/photos/821649/pexels-photo-821649.jpeg?auto=compress&cs=tinysrgb&w=1600");
    background-repeat: no-repeat;
    background-size: cover;
  }
  .h{
  font-family: "Sofia", sans-serif;
  text-shadow: 3px 3px 3px #ababab;
  text-align: center;
  }
  .container {
    max-width: 400px;
    margin: 100px auto;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 5px;
    background-color: #fff;
  }
  
  .form-control {
    margin-bottom: 10px;
  }
  
  .btn {
    width: 100%;
  }
</style>
</head>
<body>
<div class="container">
<h1 class="h">Login</h1>
<form action="LoginServlet" method="post" id="frm">
<div class="form-group">
  <label for="txtName">Username:</label>
  <input type="text" class="form-control" name="txtName" id="txtName">
</div>
<div class="form-group">
  <label for="txtpwd">Password:</label>
  <input type="password" class="form-control" name="txtpwd" id="txtpwd">
</div>
<div class="row">
  <div class="col">
    <input type="submit" class="btn btn-danger text-white" value="Login">
  </div>
  <div class="col">
    <input type="reset" class="btn btn-danger" value="Reset">
  </div>
</div>
</form>
</div>
</body>
</html>