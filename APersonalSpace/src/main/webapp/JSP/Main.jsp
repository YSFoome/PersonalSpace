<%@page import="JavaBean.userSendMsg"%>
<%@page import="javax.jws.soap.SOAPBinding.Use"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="JavaBean.LeaveMsgInfo"%>
<%@page import="java.util.Vector"%>
<%@page import="JavaBean.GetLeaveMsg"%>
<%@page import="JavaBean.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
	<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Main.css">
    <title>个人空间-主页</title>

    <%!UserInfo userInfo;%>
    <%userInfo=(UserInfo)session.getAttribute("userInfo");
    	Vector<UserInfo> userinfos=(Vector<UserInfo>)application.getAttribute("alluser");
    	Map<String,String> idtonameMap=new HashMap<>();
    	for(UserInfo userInfo :userinfos){
    	idtonameMap.put(userInfo.getId(),userInfo.getName());
    	}
    %>
        <!-- 切换网页 -->
    <script type="text/javascript">
    	function changepage(j){
    		var page=new Array();
    		page=document.getElementsByName("content1");
    		input=document.getElementById("contentinput");
    		for (var i = 0; i < page.length; i++) {
				if(i==j){
					page[i].style.display="block";
					if(j==0)
					input.style.display="block";
					else
						input.style.display="none";
				}else{
					page[i].style.display="none";
					
				}
			}  		
    		
    	}
    </script>
    <script type="text/javascript">
     function deleteinput(obj){
    	 
    	 var z=obj.parentElement.parentElement;
    	 var stridone=z.id;
    	 var zc=z.childNodes;
    	 var nameandtime=zc[1].innerText.split(" ");
    	 var time=nameandtime[1];
    	 var texts=zc[3].innerText;
    	 if(z!=null){
    		 z.parentNode.removeChild(z);
    	 }
    	xmlhttpReques=new XMLHttpRequest();
 	   	xmlhttpReques.onreadystatechange=function()
 	   	{
 	   	   	if (xmlhttpReques.readyState==4 && xmlhttpReques.status==200)
 	   	    {
 	   	        var data=xmlhttpReques.responseText;
 	   	        return true;
 	   	    }
 	   	}
 	   	var randoms=Math.random();
    	    xmlhttpReques.open( "post","/APersonalSpace/delContentMsgServlet",true);
    		xmlhttpReques.setRequestHeader("content-Type" , "application/x-www-form-urlencoded");
    	 	xmlhttpReques.send("userid="+"<%=userInfo.getId()%>"+"&time="+time+"&contentEl="+texts+"&random="+randoms);

    	 
     }
    </script>
    <script type="text/javascript">
     function submits(){
    	var username="<%=userInfo.getName()%>";
    	var contentEl=document.getElementById("content").innerText;
    	if(contentEl=="")
    		{
    		document.getElementById("content").innerText="请输入内容！";
    		return;
    		}
    	 var datenow=new Date();
    	var nian = datenow.getFullYear();
   	   	var yue  = datenow.getMonth() + 1;
    	var  ri = datenow.getDate();
   	    var shi = datenow.getHours();
   	    var fen = datenow.getMinutes();
   	    var time  =  nian + "-" + yue + "-" + ri + "-" + shi + ":" + fen;
   	    xmlhttpRequest=new XMLHttpRequest();
	   	xmlhttpRequest.onreadystatechange=function()
	   	{
	   	   	if (xmlhttpRequest.readyState==4 && xmlhttpRequest.status==200)
	   	    {
	   	        var data=xmlhttpRequest.responseText;
	   	        return true;
	   	    }
	   	}
   	    xmlhttpRequest.open( "post","/APersonalSpace/saveContentMsgServlet",true);
   		xmlhttpRequest.setRequestHeader("content-Type" , "application/x-www-form-urlencoded");
   	 	xmlhttpRequest.send( "username="+"<%=userInfo.getId()%>"+"&time="+time+"&contentEl="+contentEl);
		
   	 	var boxs='<div class="main-content-one" id="contentone"><div class="main-content-onepeopleinfo"><span class="span1">'+username+' '+time+'</span><div id="delete" onclick="deleteinput(this)">删除</div></div>'+
   	 	'<span class="span2">'+contentEl+'</span></div>';
		var htmls=document.getElementById("contentmsg");
		htmls.innerHTML=boxs+htmls.innerHTML;
     }
     </script>
    <script type="text/javascript">
      function sendleavemsg(){
    	  var targetid=document.getElementById("contentselect").value;
    	  var text=document.getElementById("contenttextareaid").innerText;
    	  xmlhttpRequest=new XMLHttpRequest();
  	   	xmlhttpRequest.onreadystatechange=function()
  	   	{
  	   	   	if (xmlhttpRequest.readyState==4 && xmlhttpRequest.status==200)
  	   	    {
  	   	        var data=xmlhttpRequest.responseText;
  	   	        return true;
  	   	    }
  	   	}
     	    xmlhttpRequest.open( "post","/APersonalSpace/sendLeaveMsg",true);
     		xmlhttpRequest.setRequestHeader("content-Type" , "application/x-www-form-urlencoded");
     	 	xmlhttpRequest.send("id="+"<%=userInfo.getId()%>"+"&targetid="+targetid+"&text="+text);
  			alert("留言成功！");
      }
     </script>
    
</head>
<body>
	
    <div class="main">
        <div class="top-menu">
        	<div class="top-menu-main"><a href="${pageContext.request.contextPath}/JSP/Login.jsp">返回登陆</a></div> 
            <div class="top-menu-main"><a href="javascript:location.reload();">首页</a></div> 
            <ul class="top-menu-items"><!--菜单-->
                <li><div onclick="changepage(0)">说说</div></li>
                <li><div onclick="changepage(1)">留言</div></li>
            </ul>
        </div>
        <div class="main-userinfo">
            <div>
                <img src="" alt="">
            </div>
            <div>
                <table>
                    <tr><td><%=userInfo.getName()%></td></tr>
                    <tr><td><%=userInfo.getText()%></td></tr>
                </table>
            </div>
        </div>
        <div class="main-content-input" id="contentinput" style="display:block;">
          	<div class="contenttextarea" contenteditable="true" placeholder="说想说的" id="content"></div>
           	<div class="Submit" onclick="submits()">发布</div>
        </div>
        <div id="contentmsg" class="main-content" name="content1" style="display: block;">
            <%
            GetLeaveMsg getLeaveMsg=new GetLeaveMsg();
            Vector<userSendMsg> results1=getLeaveMsg.getSendMsgs();
            if(results1!=null)
            for(userSendMsg usersendmsg:results1){
            	%>
            	 <div class="main-content-one" id="contentone">
                <div class="main-content-onepeopleinfo">
                    <span class="span1"><%=idtonameMap.get(usersendmsg.getId())+" "+usersendmsg.getTime()%></span>
            		<%if(usersendmsg.getId().equals(userInfo.getId())){ %>
            		<div id="delete" onclick="deleteinput(this)">删除</div>
            		<% }%>
                </div>
                <span class="span2"><%=usersendmsg.getSendmsg() %></span>
            </div>
            <%
            }
            %>
        </div>
        <div class="main-content2" name="content1" >
            <select id="contentselect">
                <%
                for(UserInfo userinfo :userinfos){  	
               	if(!userinfo.getId().equals(userInfo.getId())){
               	%>
                	<option value="<%=userinfo.getId()%>"><%="ID:"+userinfo.getId()+"	昵称:"+userinfo.getName()%></option>
				<%
                }
                }
                %>
            </select>
            <div class="contenttextarea" contenteditable="true" id="contenttextareaid" placeholder="对ta一些想说的话"></div>页
        	<div class="contentbutton" onclick="sendleavemsg()">留言</div>
        </div>
        
        <span id="spanmsg">留言板</span>
        <div class="main-personinfo">
            <%
            Vector<LeaveMsgInfo> results2=getLeaveMsg.getmsg(userInfo.getId());
            if(results2!=null)
            for(LeaveMsgInfo leaveMsgInfo:results2){
            	%>
            	    <div class="othermsg">
		                <table>
		                    <tr><td><%=idtonameMap.get(leaveMsgInfo.getId())+" "%></td></tr>
		                    <tr><td>留言:</td></tr>
		                    <tr><td><%=leaveMsgInfo.getText()%></td></tr>
		                </table>
		            </div>
            	<%
            }
            %>
        </div>
    </div>
</body>
</html>