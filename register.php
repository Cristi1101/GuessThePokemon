<?php 
require "conn.php";
$user_name = $_POST["user_name"];
$user_pass = $_POST["password"];
$mysql_qry = "insert into users_data (username, parola) values('$user_name','$user_pass')";

if($conn->query($mysql_qry) === TRUE) {
	echo "Register successful!";
}
else {
	echo "Error: " . $mysql_qry . "<br>" . $conn->error;
}
$conn->close();
?>
