<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="styles.css">
        <script type="text/javascript" src="check.js"></script>
        <title>Sign Up</title>
    <link rel="shortcut icon" href="icon.jpeg" />

    </head>
<body>
	<div class="middle" id="signup-data">
            <form autocomplete="off">

            <table>
                <tr height="80px">
                    <td>Enter New Username:</td>
                    <td><input type="text" id="newUname" class="textbox" autocomplete="off"></td>
                </tr>
                <tr height="20px">
                    <td>Enter New Password:</td>
                    <td><input type="password" id="newPw" class="textbox"></td>
                </tr>
                <tr height="20px">
                    <td>Repeat Password:</td>
                    <td><input type="password" id="repPw" class="textbox"></td>
                </tr>
                <tr>
                    <td><input type="button" value="Sign Up" class="circle" onclick="signUp();"></td>
                    <td><div id="loading-icon"></div></td>
                </tr>
            </table>
            </form>
        </div>
</body>
</html>