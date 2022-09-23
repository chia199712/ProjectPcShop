<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="author" content="after1299">
    <meta name="robots" content="index, follow">
    <meta name="description" content="">
    <title>登入</title>
    <!-- google font -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC:wght@300;400;500&display=swap" rel="stylesheet">
    <!-- font awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
    <!-- this page css -->
    <link rel="stylesheet" href="../css/header.css">
    <link rel="stylesheet" href="../css/loginPage.css">
</head>
<body>
	<header>
        <div class="header-con">
            <div class="logo-icon">
                <a href=""><i class="fa-solid fa-desktop"></i></a>
            </div>
            <div class="r-icon">
                <a href=""><i class="fa-solid fa-cart-shopping"></i></a>
                <a href=""><i class="fa-solid fa-circle-user"></i></a>
            </div>
        </div>
    </header>
    <div class="body-container">
        <form action="" class="form-container">
            <h1>登入</h1>
            <div class="input-container">
                <div class="input-con">
                    <input class="form-in" type="email" name="email" id="email" placeholder=" " required>
                    <label for="email">Email</label>
                </div>
                <div class="input-con">
                    <input class="form-in" type="password" name="password" id="password" placeholder=" " required>
                    <label for="password">Password</label>
                </div>
            </div>
            <input id="btnsub" type="submit" value="登入"></input>
            <p>
                <span>還沒有會員嗎?&nbsp;</span><a href="./registerPage.jsp">馬上註冊</a>
            </p>
            <p>
                <span>忘記密碼?&nbsp;</span><a href="">更換密碼</a>
            </p>
        </form>
    </div>
</body>
</html>