<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath }/CSS/Register.css">
    <title>个人空间-注册</title>
    <script type="text/javascript">
 function Register(){
    	var userid=document.getElementById("userid").value;
	  var username=document.getElementById("username").value;
	  var userpasswd=document.getElementById("userpasswd").value;
	  if(userid==""||username==""||userpasswd==""){
	  if(userid==""){
		  document.getElementById("userid").setAttribute("placeholder","请输入id!");
		  document.getElementById("userid").setAttribute("placeholder","请输入id!");
		  
	  }
	  if(username==""){
		  document.getElementById("username").setAttribute("placeholder","请输入昵称!");
		  document.getElementById("username").setAttribute("placeholder","请输入昵称!");
		  
	  }
	  if(userpasswd==""){
		  document.getElementById("userpasswd").setAttribute("placeholder","请输入密码!");
		  document.getElementById("userpasswd").setAttribute("placeholder","请输入密码!");
		  
	  }
	  return;
	  }
	  xmlhttpRequest=new XMLHttpRequest();
   	xmlhttpRequest.onreadystatechange=function()
   	{
   	   	if (xmlhttpRequest.readyState==4 && xmlhttpRequest.status==200)
   	    {
   	        var data=xmlhttpRequest.responseText;
   	       if(data=="true"){
   	    		alert("注册成功");
   	    	　	window.location.href="Login.jsp";
   	       }else{
   	    	   alert("注册失败，id重复！");
   	       }
   	       
   	    }
   	}
	    xmlhttpRequest.open( "post","/APersonalSpace/registerServlet",true);
		xmlhttpRequest.setRequestHeader("content-Type" , "application/x-www-form-urlencoded");
	 	xmlhttpRequest.send("userid="+userid+"&username="+username+"&userpasswd="+userpasswd);
 }
    
    </script>
</head>
<body>
    <div class="login">
        <!-- <div class="left"></div> -->
        <div class="right">
           <form>
                <h1>注册</h1>
                <input class="userinfo" type="text" id="userid" placeholder="账号"/>
                <input class="userinfo" type="text" id="username" placeholder="昵称"/>
                <input class="userinfo" type="password" id="userpasswd" placeholder="密码"/>
                <input class="submit" type="button" value="注册" onclick="Register()"/>
           </form>
           <div class="help">
				<a href="Login.jsp">返回登陆</a> 
			</div>
        </div>
    </div>
</body>
</html>