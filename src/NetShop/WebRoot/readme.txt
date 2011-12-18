http://localhost:8080/NetShop/manage/categoryAdd.do?act=builddictionaries生成字典的xml文件
没有使用延迟加载
http://localhost:8080/NetShop/manage/dictionaryList.do?act=show输出字典xml流
在http://localhost:8080/NetShop/manage/categoryList.jsp中isMultinest的勾选框在勾选的情况下不起作用，主要是在源码中设置了checked=true的缘故，因此需要再设置一个隐藏的文本框使用js记录值，
http://localhost:8080/NetShop/manage/productList.do?act=list产品列表
删除字典会级联删除该字典下的所有分类
删除某个分类会级联删除该分类下的所有子类
