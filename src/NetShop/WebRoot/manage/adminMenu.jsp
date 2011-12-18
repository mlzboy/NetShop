<%@ page language="java" pageEncoding="UTF-8"%>
<HTML>
	<HEAD>
		<TITLE>New Document</TITLE>
		<meta http-equiv=Expires content=0>
		<meta http-equiv=Pragma content=no-cache>
		<meta http-equiv=Cache-Control content=no-cache>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<link type="text/css" rel="stylesheet" href="css/xtree2.css">
		<script type="text/javascript" src="js/xtree2.js"></script>
		<!-- xloadtree2.js鏂囦欢渚濊禆xtree2.js鏂囦欢銆� -->
		<script type="text/javascript" src="js/xloadtree2.js"></script>
	</HEAD>
  
<body>
<base target="mainFrame">
<script type="text/javascript">
var baseTarget="mainFrame";
var tree=new WebFXTree("管理菜单");
//tree.setTarget(baseTarget);
menu1=new WebFXTreeItem("产品管理");
menu1.setTarget(baseTarget);
menu2=new WebFXTreeItem("分类管理");
menu3=new WebFXTreeItem("用户管理");
menu4=new WebFXTreeItem("帮助文档");
menu7=new WebFXTreeItem("导航");
menu6=new WebFXTreeItem("登出","login.jsp");
menu6.setTarget(baseTarget);
menu5=new WebFXTreeItem("退出","logout.jsp");
menu5.setTarget(baseTarget);
tree.add(menu1);
tree.add(menu2);
tree.add(menu3);
tree.add(menu4);
tree.add(menu7);
tree.add(menu6);
tree.add(menu5);


menu11=new WebFXTreeItem("产品列表","productList.do?act=list");
menu11.setTarget(baseTarget);
menu1.add(menu11);
menu12=new WebFXTreeItem("产品添加","productAdd.jsp");
menu12.setTarget(baseTarget);
menu1.add(menu12);

menu21=new WebFXTreeItem("分类列表","categoryList.jsp");
menu21.setTarget("_blank");
menu2.add(menu21);

menu22=new WebFXTreeItem("分类添加","categoryAdd.jsp");
menu22.setTarget(baseTarget);
menu2.add(menu22);

menu23=new WebFXTreeItem("字典添加","dictionaryAdd.jsp");
menu23.setTarget(baseTarget);
menu2.add(menu23);


menu31=new WebFXTreeItem("用户列表","userList.do");
menu31.setTarget(baseTarget);
menu3.add(menu31);

menu32=new WebFXTreeItem("用户添加","userAdd.jsp");
menu32.setTarget(baseTarget);
menu3.add(menu32);

menu33=new WebFXTreeItem("修改密码","userMod.jsp");
menu33.setTarget(baseTarget);
menu3.add(menu33);

menu41=new WebFXTreeItem("帮助文档1","help1.html");
menu41.setTarget(baseTarget);
menu4.add(menu41);

menu42=new WebFXTreeItem("帮助文档2","help2.html");
menu42.setTarget(baseTarget);
menu4.add(menu42);

menu43=new WebFXTreeItem("帮助文档3","help3.html");
menu43.setTarget(baseTarget);
menu4.add(menu43);

menu44=new WebFXTreeItem("帮助文档4","help4.html");
menu44.setTarget(baseTarget);
menu4.add(menu44);

menu71=new WebFXTreeItem("网站首页","../index.htm");
menu71.setTarget("_blank");
menu7.add(menu71);

menu72=new WebFXTreeItem("总产品列表","../manufactureList.do");
menu72.setTarget("_blank");
menu7.add(menu72);

tree.write();
tree.expandAll();
</script>

</body>
</html>