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
    <title>註冊</title>
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
            <h1>註冊</h1>
            <div class="input-container">
                <div class="input-con">
                    <input class="form-in" type="text" name="uname" id="uname" placeholder=" " required>
                    <label for="uname">Your Name</label>
                </div>
                <div class="input-con">
                    <input class="form-in" type="email" name="email" id="email" placeholder=" " required>
                    <label for="email">Email</label>
                </div>
                <div class="input-con">
                    <input class="form-in" type="password" name="password" id="ps1" placeholder=" " value="" required>
                    <label for="password">Password</label>
                </div>
                <div class="input-con">
                    <input class="form-in" type="password" name="conpassword" id="ps2" placeholder=" " value=""
                        required>
                    <label for="password">Confirm password</label>
                </div>
            </div>
            <input id="btnsub" type="submit" value="註冊"></input>
        </form>
    </div>
    <script>
        document.getElementById("btnsub").onclick = function () {
            let psword = document.getElementById('ps1').value;
            let conpsword = document.getElementById('ps2').value;

            if (psword != conpsword) {
                alert("密碼不一致");
            }
        }
    </script>
</body>

</html>