<?php 
require "conn.php";
$user_name = $_POST["user_name"];
$user_pass = $_POST["password"];
$mysql_qry = "SELECT * from users_data WHERE username='$user_name' and parola='$user_pass';";
$result = mysqli_query($conn, $mysql_qry);
if(mysqli_num_rows($result) > 0){
	echo "Login successful!";
}
else {
	echo "Incorrect username or password.";
}
?>
