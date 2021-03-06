<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
	<title>task8-技能树首页</title>
	<meta charset="utf-8" name="viewport" content="width=device-width" initial-scale=1  maximum-scale=1  minimum-scale=1  user-scalable=no>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/task8-home.css">
	<!-- <script src="http://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script> -->
	<link href="http://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
	<!-- <script src="http://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script> -->
</head>
<body>
	<header>
		<div class="top">
			<p>客服电话:010-594-78634</p>
			<p2>
				<c:choose>
					<c:when test="${loginstudent!=null}">
						欢迎你!${loginstudent.studentName} ,您本次登录时间为<fmt:formatDate value="${time}" type="both"></fmt:formatDate>&nbsp;&nbsp;
						<a href="${pageContext.request.contextPath}/studentList">查看所有用户</a>&nbsp;&nbsp;
						<a href="${pageContext.request.contextPath}/student/${loginstudent.studentId}">个人中心</a>&nbsp;&nbsp;
						<a href="${pageContext.request.contextPath}/desk">退出登录</a>&nbsp;&nbsp;
					</c:when>
					<c:otherwise>
						<a href="${pageContext.request.contextPath}/studentUI">注册</a> &nbsp;&nbsp;
						<a href="${pageContext.request.contextPath}/loginUI">登录</a>
					</c:otherwise>
				</c:choose>
			</p2>
			<div class="top-right">
				<div class="wexin"></div>
				<div class="qq"></div>
				<div class="sina"></div>
			</div>
		</div>
		<div class="header-center">
			<div class="center-right">
				<a href="${pageContext.request.contextPath}/">首页</a>
				<a href="#">职业</a>
				<a href="#">推荐</a>
				<a href="#">关于</a>
			</div>
		</div>
	</header>

	<main>
      <!-- 轮播图 -->
		<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
		  <!-- Indicators -->
		  <ol class="carousel-indicators">
		    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
		    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
		    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
		    <li data-target="#carousel-example-generic" data-slide-to="3"></li>
		  </ol>

		  <!-- Wrapper for slides -->
		  <div class="carousel-inner" role="listbox">

		    <div class="item active">
		    	<img src="${pageContext.request.contextPath}/image/home/banner.png" >
		    </div>

		    <div class="item">
		    	<img src="${pageContext.request.contextPath}/image/home/banner.png" >
		    </div>

		    <div class="item">
		    	<img src="${pageContext.request.contextPath}/image/home/banner.png" >
		    </div>

		    <div class="item">
		    	<img src="${pageContext.request.contextPath}/image/home/banner.png" >
		    </div>

		  </div>

		  <!-- Controls -->
		  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
		    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
		  </a>

		  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
		    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
		  </a>
		</div>
      <!--  特色内容,高效学习  -->
			<div class="container ">

	    		<div class="row features">

	        		<div class="col-xs-3 main-media">
	        			<div class="main-one">
	        				<img src="${pageContext.request.contextPath}/image/home/main-one.png" height="50" width="35" >
	        				<p class="topic">高效</p>
	        			</div>
						<div class="tip">将五年到七年的成长时间 , 缩短到一年到三年</div>
	        			</div>
	        		<div class="col-xs-3 main-media">
	        			<div class="main-two">
	        				<img src="${pageContext.request.contextPath}/image/home/main-two.png" height="50" width="60" >
	        				<p class="topic">规范</p>
	        			</div>
						<div class="tip">标准的实战教程 , 不会走弯路。</div>
	        			</div>
	        		<div class="col-xs-3 main-media">
	        			<div class="main-three">
	        				<img src="${pageContext.request.contextPath}/image/home/main-three.png" height="50" width="50" >
	        				<p class="topic">人脉</p>
	        			</div>
						<div class="tip">同班好友 , 同院学长 , 技术大师 , 入学就混入职脉圈 , 为以后铺平道路。</div>
	        			</div>
	        		<div class="col-xs-3 main-two-end main-media">
	        			<div class="main-fire">
	        				<img src="${pageContext.request.contextPath}/image/home/main-fire.png" height="13">20485
	        			</div>
						<div class="tip-end">累计在线学习人数</div>
						<div class="main-fire-bottom">
							<img src="${pageContext.request.contextPath}/image/home/main-fire.png" height="13">20485
	        			</div>
						<div class="tip-end">学员已找到满意工作</div>
	        			</div>
					</div>
	    		</div>

			</div>
      <!--  如何学习  -->
			<div class="container">
				<p class="how-top">如何学习</p>

	    		<div class="row">

	        		<div class="col-xs-3 how">
	        			<div class="how-1">1</div>
	        			<p>匹配你现在的个人情况寻找适合自己的岗位</p>
	        		</div>
	        		<div class="col-xs-3 how">
	        			<div class="how-1">2</div>
	        			<p>了解职业前景薪金待遇、竞争压力等</p>
	        		</div>
	        		<div class="col-xs-3 how">
	        			<div class="how-1">3</div>
	        			<p>掌握行业内顶级技能</p>
	        		</div>
	        		<div class="col-xs-3 how-end">
	        			<div class="how-1">4</div>
	        			<p>查看职业目标任务</p>
	        		</div>

	    		</div>

			</div>

			<div class="container">

	    		<div class="row">

	        		<div class="col-xs-3 how">
	        			<div class="how-1">5</div>
	        			<p>参考学习资源、掌握技能点，逐个完成任务</p>
	        		</div>
	        		<div class="col-xs-3 how">
	        			<div class="how-1">6</div>
	        			<p>加入班级，和小伙伴们互帮互助，一块学习</p>
	        		</div>
	        		<div class="col-xs-3 how">
	        			<div class="how-1">7</div>
	        			<p>选择导师，一路引导，加速自己成长</p>
	        		</div>
	        		<div class="col-xs-3 how-end-2">
	        			<div class="how-1">8</div>
	        			<p>完成职业技能，升级业界大牛</p>
	        		</div>

	    		</div>

			</div>

		  <!--  优秀学员展示  -->
			<p class="student-show">优秀学员展示</p>

			<div class="container">

	    		<div class="row row-1">

	        		<div class="col-xs-3 student-1">
	        			<img src="${pageContext.request.contextPath}/image/home/a.png" alt="不高兴一号">
	        			<b>技术顾问：一般般</b>
	        			<p>不高兴技术总监：互联网基础服务领域，从事虚拟主机，云服务器、域名，曾任新网高级技术精力，负责技术研发、团队管理和建设。</p>
	        		</div>
	        		<div class="col-xs-3 student-2">
	        			<img src="${pageContext.request.contextPath}/image/home/b.png" alt="不高兴一号">
	        			<b>技术顾问：勉勉强</b>
	        			<p>不高兴技术总监：互联网基础服务领域，从事虚拟主机，云服务器、域名，曾任新网高级技术精力，负责技术研发、团队管理和建设。</p>
	        		</div>
	        		<div class="col-xs-3 student-3">
	        			<img src="${pageContext.request.contextPath}/image/home/c.png" alt="不高兴一号">
	        			<b>技术顾问：无所谓</b>
	        			<p>不高兴技术总监：互联网基础服务领域，从事虚拟主机，云服务器、域名，曾任新网高级技术精力，负责技术研发、团队管理和建设。</p>
	        		</div>
	        		<div class="col-xs-3 student-4">
	        			<img src="${pageContext.request.contextPath}/image/home/d.png" alt="不高兴一号">
	        			<b>技术顾问：还可以</b>
	        			<p>不高兴技术总监：互联网基础服务领域，从事虚拟主机，云服务器、域名，曾任新网高级技术精力，负责技术研发、团队管理和建设。</p>
	        		</div>
	    		</div>

			</div>

		  <!--战略合作企业-->
		<div class="container ">
		    <div class="row">
		        <div class="col-xs-12 title">战略合作企业</div>
		    </div>
		    <div class="row spel-all">
		        <div class="col-xs-1 spel">
		        	<a href="#" class="al"></a>
		        </div>
		        <div class="col-xs-1 spel">
		        	<a href="#" class="js"></a>
		        </div>
		        <div class="col-xs-1 spel">
		        	<a href="#" class="hx"></a>
		        </div>
		        <div class="col-xs-1 spel">
		        	<a href="#" class="rl"></a>
		        </div>
		        <div class="col-xs-1 spel">
		        	<a href="#" class="qn"></a>
		        </div>
			</div>
			<!--友情链接-->
		    <div id="link">
		    	<p class="link-title">友情链接</p>
		    	<ul class="link">
		    		<li>
						<div class="li-left"></div>
						<a href="#">手机软件</a>
					</li>

		    		<li>
						<div class="li-left"></div>
						<a href="#">教师招聘</a>
					</li>

		    		<li>
						<div class="li-left"></div>
						<a href="#">找工作</a>
					</li>

		    		<li>
						<div class="li-left"></div>
						<a href="#">手机软件</a>
					</li>

		    		<li>
						<div class="li-left"></div>
						<a href="#">教师招聘</a>
					</li>

		    		<li>
						<div class="li-left"></div>
						<a href="#">找工作</a>
					</li>

		    		<li>
						<div class="li-left"></div>
						<a href="#">手机软件</a>
					</li>

		    		<li>
						<div class="li-left"></div>
						<a href="#">教师招聘</a>
					</li>

		    		<li>
						<div class="li-left"></div>
						<a href="#">找工作</a>
					</li>

					<li>
						<div class="li-left"></div>
						<a href="#">找工作</a>
					</li>

		    	</ul>

		    	<ul class="link-2">
		    		<li>
						<div class="li-left"></div>
						<a href="#">手机软件</a>
					</li>

		    		<li>
						<div class="li-left"></div>
						<a href="#">教师招聘</a>
					</li>

		    		<li>
						<div class="li-left"></div>
						<a href="#">找工作</a>
					</li>

		    		<li>
						<div class="li-left"></div>
						<a href="#">手机软件</a>
					</li>

		    		<li>
						<div class="li-left"></div>
						<a href="#">教师招聘</a>
					</li>

		    		<li>
						<div class="li-left"></div>
						<a href="#">找工作</a>
					</li>

		    		<li>
						<div class="li-left"></div>
						<a href="#">手机软件</a>
					</li>

		    		<li>
						<div class="li-left"></div>
						<a href="#">教师招聘</a>
					</li>

		    		<li>
						<div class="li-left"></div>
						<a href="#">找工作</a>
					</li>

					<li>
						<div class="li-left"></div>
						<a href="#">找工作</a>
					</li>

		   		</ul>
		   	</div>
		</div>

	</main>
	<!--footer-->

			<footer>
				<div class="footer-top">
					<div class="footer-top-left">
						<div class="footer-top-left-1">
							<h4>技能树——改变你我</h4>
							<div>
								<a href="#">关于我们</a>
								|
								<a href="#">联系我们</a>
								|
								<a href="#">友情链接</a>
							</div>
						</div>
						<div class="footer-top-left-2">
							<h4>旗下网站</h4>
							<div>
								<a href="#">草船云孵化器</a>
								<a href="#">最强IT特训营</a>
							</div>
							<div>
								<a href="#">葡萄藤轻游戏</a>
								<a href="#">桌游精灵</a>
							</div>
						</div>
					</div>
					<div class="footer-top-right">微信公众平台</div>
				</div>

			</footer>
			<div class="footer-end">Copyright@2015技能树www.jnshu.com ALL Rights
				Reserved丨京ICP备13005880号</div>
</body>
</html>
