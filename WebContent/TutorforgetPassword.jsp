<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./css/Page_Footer.css">
    <link rel="stylesheet" type="text/css" href="./css/bodystyle.css">
    <link rel="stylesheet" type="text/css" href="./css/dropdownstyle.css">
	
	<link rel="stylesheet" type="text/css" href="./css/formstyle.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	
<script>
	function message()
	{
		var email=document.getElementById("email").value;
		var pat=/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-z]{2,4}$/;
		if(pat.test(email)!=true)
			{
				alert("Input valid email:");
			}
		
	}
</script>
	
<script>
$(document).ready(function(){
	$("#btn9").click(function(){
		
		alert("done");
		
		$.ajax({
			
			type:'POST',
			
			data:{email:$("#email").val()},
				
			url:'Tutorforget',
			success: function(result)
			{
				
				if(result=="OK")
				{
					swal({
					  title: "Good job!",
					  text: "Successfull Registered but verify from email",
					  icon: "success",
					});
				}
				else
				{
					swal({
					  title: "Try Again!",
					  text: "failed",
					  icon: "error",
					});
				}
							
			}
		
			});
		});
});


</script>
</head>
<body>
		<div class="Hero">
			<div class="form-box">
						<!-- Forget-Password-->
						<form  method="post"  class="input_group1">
							<input type="text" id="email" name="email" class="input-field" placeholder="emailid" required>
							<input type="button" id="btn9" class="submit-btn" onclick="message" value="send">
						</form>
						
			</div>

		</div>
		
		
		
</body>
</html>