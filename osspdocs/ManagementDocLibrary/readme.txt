                                                    Struts2 总结

>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>1>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
Struts2.0  web.xml 配置

         <filter>
		<filter-name>struts2</filter-name>
		<filter-class>
			org.apache.struts2.dispatcher.FilterDispatcher
		</filter-class>
	</filter>

	<filter-mapping>
		<filter-name>struts2</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>

Struts2.1 web.xml配置

        <filter>
		<filter-name>struts2</filter-name>
		<filter-class>
			org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter
		</filter-class>
	</filter>

	<filter-mapping>
		<filter-name>struts2</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>


------------------2.0 和 2.1 区别 ---------------------------------
	2.1 请求中可以不加 .action
--------------------------------------------------------------------
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>2>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

struts2  struts.xml配置

<struts>

      <constant name="struts.devMode" value="true">       <!--开发模式 默认为false-->
      <constant name="struts.i18n.encoding" value="GBK">  <!--解决中文问题-->
    <!--struts2.0 begin-->
         
	<package name="struts2" extends="struts-default" namespace="/"><!--命名空间--> 
		<action name="login" class="com.test.action.LoginAction">
			<result name="input">/login2.jsp</result>
			<result name="success">/result.jsp</result>
			<result name="failer">/login2.jsp</result>
		</action> 
		
		<action name="register" class="com.test.action.RegisterAction">
			<result name="success">/success.jsp</result>
			<result name="input">/register.jsp</result>
		</action>
      
	</package>
	 <!--struts2.0 end-->
</struts>

配置 例程：Struts2_0100_Introduction
命名空间 例程：Struts2_0200_Namespace
路径 例程：Struts2_0400_Path
----------------------配置struts.xml 字符提示-----------------------------------
点window-->preferences-->catalog-->XML Catalog-->添加 ：struts-core-2.1.6.jar 解压 struts-2.0.dtd 文件
 location : 选择struts-2.0.dtd 文件本地地址
 key type :选择 uri
 key      : http://struts.apache.org/dtds/struts-2.0.dtd
--------------------------------------------------------------------------------

Action 类 继承  ActionSupport 或 实现 Action 接口 (注：action类必须是 public)

具体视图的返回可以由用户自己定义的Action来决定 
具体的手段是根据返回的字符串找到对应的配置项，来决定视图的内容<br />
具体Action的实现可以是一个普通的java类，里面有public String execute方法即可 
或者实现Action接口 
不过最常用的是从ActionSupport继承，好处在于可以直接使用Struts2封装好的方法 

例程：Struts2_0300_Action

>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>3>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

动态调用方法配置:  （例程：Struts2_0500_ActionMethod）

   ---------------- 方法一：调用action时 用！ 加方法名

 
   <struts> 
	<package name="struts2" extends="struts-default" namespace="/user"> <!--命名空间-->
		<action name="user" class="com.test.action.UserAction"> <!--调用时user/userAdd.action -调用UserAction 的 add()-->
			<result name="success">/success.jsp</result> 
		</action>  
	</package> 
   </struts>
类 com.test.action.UserAction 中：add();delete;.....

请求为： user/user!add  ----> 调用 add();方法
请求为： user/user!delete  ----> 调用 delete();方法

 

    ----------------方法二： ActionMethod_DMI  

   <struts> 
	<package name="struts2" extends="struts-default" namespace="/user"> 
		<action name="userAdd" class="com.test.action.UserAction" method="add" > <!--调用时user/userAdd.action -调用UserAction 的 add()-->
			<result name="success">/success.jsp</result> 
		</action> 
		<action name="userDelete" class="com.test.action.UserAction" method="delete" > <!--调用时user/userDelete.action -调用UserAction 的 delete()-->
			<result name="success">/success.jsp</result> 
		</action> 
	</package> 
   </struts>

    ----------------方法三： 通配符配置 (注意：通配符最多接受八个 * 依次队列)(例程：Struts2_0600_ActionWildcard)

   <struts> 
	<package name="struts2" extends="struts-default" namespace="/user"> 
		<action name="user*" class="com.test.action.UserAction" method="{1}" > 
			<result name="success">/user{1}_success.jsp</result> 
		</action>  
	</package> 
   </struts>
  
 
                   ---------------第二种配置方式------------------
   <struts> 
	<package name="struts2" extends="struts-default" namespace="/user"> 
		<action name="*_*" class="com.test.action.UserAction" method="{2}"> 
			<result name="success">/{1}{2}_success.jsp</result> 
		</action>  
	</package> 
   </struts>
   ----------------------------------------------------
   此种方式 利用通配符配置变简化，但要求约定优越配置，命名规范，项目经理还得加把劲啊 呵呵！
   ----------------------------------------------------

>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>4>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
Action 属性接收参数

 ---------------第一种方式------------------(例程：Struts2_0700_ActionAttrParamInput)
 直接对应表单中的每个属性；提供get,set方法
 ---------------*第二种方式------------------（*常用的方法）(例程：Struts2_0800_DomainModelParamInput)
    Struts2  DomainModel 表单数据传输 配置

    1.创建Model----------------------------------UserModel;(注：属性要有get,set)
    2.在Action中定义UserModel--------------------UserAction:private UserModel userModel;(注：属性要有get,set)
    3.表单属性 要以 userModel.属性 提交表单数据
    例如：http://localhost:8080/Struts2_DomainModel/user/user.action?userModel.name=tom&userModel.password=123&
---------------第三种方式------------------(例程：Struts2_0900_ModelDrivenParamInput)
     ModelDriven 表单数据传输 配置
     1.创建Model----------------------------------UserModel;(注：属性要有get,set)
     2.Action 继承 ActionSupport 实现ModelDriven<E> 接口--
     3.
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>5>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
struts2 编码问题 (例程 Struts2_1000_CharacterEncoding)

>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>5>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
数据验证

   方法一：复写validate()方法  (例程:Struts_1150_DataValiationAction)
     1.-- public void validate() {
		System.out.println("-----------LoginAction validate()-------------");
		if (!"tom".equals(userForm.getName())) {  
			this.addFieldError("nameError", "必须输入tom");
			this.addActionError("登陆失败！");
			this.addActionError("用户名不正确！");
		} else { 
			this.addActionMessage("登陆成功!"); 
		} 
	   }
      2.--在struts.xml 配置 input
                <action name="login" class="com.baishui.struts2.actions.user.LoginAction"> 
			<result name="success">/login_success.jsp</result> 
			<result name="input">/error.jsp</result>
		</action>
      3.--在error.jsp中使用标签显示出错误信息
    <%@taglib uri="/struts-tags" prefix="s" %>
     s:fielderror|<s:fielderror fieldName="nameError" /> <br>
     s:actionerror|<s:actionerror/><br>
     s:property -value="actionErrors"|<s:property value="actionErrors[0]"/><br>
     s:property -value="actionErrors"|<s:property value="actionErrors[1]"/><br>
     s:property -value="errorMessages"|<s:property value="errorMessages[0]"/><br>
     s:property -value="errorMessages"|<s:property value="errorMessages[1]"/><br>
    <s:debug/>
      4.成功页面
         <s:actionmessage name="message[1]"/>
         <s:property value="actionMessages[0]"/>
         <s:debug /> 
 -------------------------------------------------------------------------
    方法二：直接在execute方法中添加 错误信息 (例程：Struts2_1100_SimpleDataValiation)
     1.this.addFieldError("nameError", "必须输入tom");
       return ERROR;
     2.在错误信息页面用struts2 标签显示错误信息
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>5>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

-----------------------------------访问web 元素----------------------------------------------------------------------

访问web 元素     MAP类型 request,session,application (例程:Struts2_1200_AccessWebElements)

       方法一：依赖于容器 
            1、在Action类中  定义java.util.Map类型属性request,session,application
	    2、利用 com.opensymphony.xwork2.ActionContext
	             request = (Map)com.opensymphony.xwork2.ActionContext.getContext().get("request");
                     session = (Map)com.opensymphony.xwork2.ActionContext.getContext().get("session");
                     application = (Map)com.opensymphony.xwork2.ActionContext.getContext().get("application");
	    3、request.put("key","value");
	       session.put("key","value");
	       application.put("key","value");
            4、在前台页面调用，有两种方法
	              a:<s:property value = "#request.key">
		        <s:property value = "#session.key">
			<s:property value = "#application.key"> 
                      -----------------------------------------------------------
		      注：使用struts标签时，加#直接访问ActionContext 中的对象否则不能访问；
		      -----------------------------------------------------------

		      b:<%=request.getAttribute("key")%>
		        <%=session.getAttribute("key")%>
			<%=application.getAttribute("key")%>
                      -----------------------------------------------------------
		      注：使用jsp隐含对象时，可直接getAttribute("key")方法调用，原因是Struts2中 已经 将Map和对应的对象关联 
		      -----------------------------------------------------------
       方法二：(最常用的方法)IOC（inverse of control  反转控制） 
              1、在Action类中 实现 orj.apache.interceptor.RequestAware,orj.apache.interceptor.SessionAware,orj.apache.interceptor.ApplicationAware
              2、在Action类中  定义java.util.Map类型属性request,session,application
                            Map<String,Object> request;
                            Map<String,Object> session;
			    Map<String,Object> application;
              3、在Action类中定义 setRequest(Map<String,Object> request);
	                          setSession(Map<String,Object> session);
				  setApplication(Map<String,Object> application;
		      -----------------------------------------------------------
		      注：struts2 中会自动调用方法，实现对应映射
		      -----------------------------------------------------------
	      4、request.put("key","value");
	         session.put("key","value");
	         application.put("key","value");
	      5、在前台页面调用，有两种方法
	              a:<s:property value = "#request.key">
		        <s:property value = "#session.key">
			<s:property value = "#application.key"> 
                      -----------------------------------------------------------
		      注：使用struts标签时，加#直接访问ActionContext 中的对象否则不能访问；
		      -----------------------------------------------------------

		      b:<%=request.getAttribute("key")%>
		        <%=session.getAttribute("key")%>
			<%=application.getAttribute("key")%>

访问web 元素   真实类型：HttpServletRequest,HttpSession,ServletContext


       方法一：依赖于容器 
public class LoginAction3 extends ActionSupport {
	
	private HttpServletRequest request;
	private HttpSession session;
	private ServletContext application;
	
	public LoginAction3() {
		request = ServletActionContext.getRequest();
		session = request.getSession();
		application = session.getServletContext();
	}
	
	public String execute() {
		request.setAttribute("r1", "r1");
		session.setAttribute("s1", "s1");
		application.setAttribute("a1", "a1");
		return SUCCESS; 
	}
	
}
  
         方法二：IOC（inverse of control  反转控制）


public class LoginAction4 extends ActionSupport implements ServletRequestAware {
	
	private HttpServletRequest request;
	private HttpSession session;
	private ServletContext application; 
	
	public String execute() {
		request.setAttribute("r1", "r1");
		session.setAttribute("s1", "s1");
		application.setAttribute("a1", "a1");
		return SUCCESS; 
	}



	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		this.session = request.getSession();
		this.application = session.getServletContext();
	}
	
}


<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<6<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

   struts.xml 包含其他 Action 配置文件 (例程：Struts2_1300_IncludeModules)
 多个人开发项目时，分开配置；
  <struts> 
      <constant name="struts.devMode" value="true">     <!--开发模式 默认为false-->
      <constant name="struts.i18n.encoding" value="GBK">  <!--解决中文问题-->
      <include file="login.xml"/>  <!--包含配置文件-->
    <!--struts2.0 begin--> 
	<package name="struts2" extends="struts-default" namespace="/"><!--命名空间-->

		<action name="login" class="com.test.action.LoginAction">
			<result name="input">/login.jsp</result>
			<result name="success">/result.jsp</result>
			<result name="failer">/login.jsp</result>
			<result name="error">/error.jsp</result>
		</action> 
	</package>
	 <!--struts2.0 end-->
  </struts>
        
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>7>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

 默认Action  (例程：Struts2_1400_DefaultAction)

    <struts> 
      <constant name="struts.devMode" value="true">     <!--开发模式 默认为false-->
      <constant name="struts.i18n.encoding" value="GBK">  <!--解决中文问题-->
      <include file="login.xml"/>  <!--包含配置文件-->
    <!--struts2.0 begin--> 
	<package name="struts2" extends="struts-default" namespace="/"><!--命名空间-->
                <default-action-ref  name="login" ></default-action-ref><!--默认的action-->
		<action name="login" class="com.test.action.LoginAction">
			<result name="input">/login.jsp</result>
			<result name="success">/result.jsp</result>
			<result name="failer">/login.jsp</result>
			<result name="error">/error.jsp</result>
		</action> 
	</package> 
    <!--struts2.0 end-->
    </struts>
    

<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

  struts2 Tags


    1.通用标签 
     a)property标签- 
      在值站中取值：username:<s:property value="username"/> -----------OGNL表达式
      取值为字符串：<s:property value="'username'"/>  -----------------普通的字符串
      设定默认值：  <s:property value="admin" default="管理员"/> ------
      设定HTML: <s:property value="'<hr/>'" escape="true"/>  ---------- 
     b)set标签 (属性 id  name scope value var) 
      设定adminName值（默认为request 和 ActionContext）: </h4><s:set var="adminname" value="username"/>
      从request中取值<s:property value="#request.adminname"/>
      从ActionContext中取值<s:property value="#adminname"/> 
      注：debug request中不显示adminname 时这是因为还没放到request中debug已经形成
          struts2文档bug vaule  类型 不是String 是而是object 
        1.scope  默认action  其他   application session request page or action
        2.var   在2.0 中 设定var 在ActionContext 中会存入 var 的值，在2.1中 因为name 和var 重复所以废弃 name 

          注： 2.0中 指定name 和scope 时，如果想放入actionContext 时必须指定var,而2.1 就算指定var,同时指定scope 时 也不会放入ActionContext中
 
     c)bean标签
        <s:bean name="com.baishui.struts2.tags.Love" var="love1">
            <s:param name="myLove" value="'xr'"></s:param>
        </s:bean>
        查看bean param<s:property value="#love1.myLove"/> 

   
     d)include标签 
       1.<s:include value="/include1.jsp"></s:include></li>
       2.由于include标签中 value属性 为String类型 所以不能解析OGNL表达式，如用到是可用%{}符号强制转换为OGNL表达式
              <s:set var="page" value="'/include3.jsp'"></s:set>
              强制转换%{OGNL表达式}---<s:include value="%{#page}"></s:include> 




      e)fielderror标签
         1.在Action 中 this.addFieldError("fielderror.test","wrong")
         2.<s:fielderror value="fielderror.test"/> 

     2 控制标签
      a)if elseif else标签
     
      <s:property value="#parameters.age[0]"/></li>
          <s:set var="age" value="#parameters.age[0]"></s:set>
      <s:if test="#age<0">
           age is wrong!
      </s:if>
      <s:elseif test="#age<20">
           too young!
      </s:elseif>
      <s:else>
        is right now!
      </s:else>
      
     b)
    自定义list
    <s:iterator value="{'aaa','bbb','ccc'}" status="status">
    <s:property/>|
               当前循环次数：<s:property value="#status.count"/>|
               当前元素下标：<s:property value="#status.index"/>|
               当前元素是不是偶数个：<s:property value="#status.even"/>|
               当前元素是不是奇数个：<s:property value="#status.odd"/>|
               当前元素是不是第一个：<s:property value="#status.first"/>|
               当前元素是不是最后一个：<s:property value="#status.last"/>
    
   </s:iterator> 
    自定义map 
   <s:iterator value="#{1:'a',2:'b',3:'c'}" var="x">
       <s:property value="#x.key"/>|<s:property value="#x.value"/> 
   </s:iterator> 

   注：定义map 时 用#

>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


struts2 I18N 


  I18N配置文件命名规范:  app_zh_CN.properties            //（app 随便起，后面必须那么写） 文件头_语言_国家.properties

                                       app_en_US.properties

ResourceBundle res =  ResourceBundle.getBundle("app",Locale.CHINA);
res.getString("welcome.msg")

--------------------------------------- struts2 中i18n ---------------------------------------------------------
方法一 struts 资源文件在Action 级别(例程 ： struts2_3100_I18N)

   1 struts2.xml 中配置
    <package name="index" extends="struts-default" namespace="/">
	   <action name="login" class="com.baishui.i18n.admin.Login" method="login">    //国际化文件经过Action之后才可以，并且 文件和该类放在同文件夹下
	      <result name="admin">/adminLogin.jsp</result>
	      <result name="user">/userLogin.jsp</result>
	   </action> 
	</package>
 
	<package name="login" extends="struts-default" namespace="/login"> 
	   <action name="*_*" class="com.baishui.i18n.admin.AdminLogin" method="{2}">
	       <result name="success">/index.jsp</result>
	       <result name="input">/{2}_fail.jsp</result>
	   </action> 
	</package>

   2 国际化文件  （注意：命名规范 1  前面与Action命名相同_语言_国家.properties 例如：Login_en_US.properties）
           admin.username=管理员用户名：
           admin.password=登  录  密  码 ：
           admin.login=登  录
    3 在页面上取国际化文本键值  getText("国际化文本中KEY") 
    <s:property value="getText('admin.username')"/>  // 调用的是 Login   Action 中的 getText() 方法
--------------------------------------- struts2 中i18n ---------------------------------------------------------
方法二 struts 资源文件在package 级别
        所有同包中Action都可以使用，资源文件必须是  package_en_US.properties 


--------------------------------------- struts2 中i18n ---------------------------------------------------------
方法三 struts 资源文件在app级别 (最常用)
       1. 所有Action都可以使用，资源文件命名  （自定义）_en_US.properties 
       2. struts2 中 配置app 国际化资源文件的命名（参考 default.properties 文件 #struts.custom.i18n.resources）
                          
                   <constant name="struts.customer.i18n.resources" value="自定义"/>
--------------------------------------- struts2 中i18n ---------------------------------------------------------

处理 国际化资源文件中的参数 

   1.在资源文件中 用 ｛0｝ 占位符标识 参数
        welcome.msg=欢迎您：{0}
        注意 ：｛中从0开始一次排列｝
   2.在页面上 动态 指定参数
          <s:property value="getText('welcome.msg')"/><br>
          <s:text name="welcome.msg"><br>
              <s:param value="adminname"></s:param>
          </s:text>
          <s:debug></s:debug>
--------------------------------------- struts2 中i18n ---------------------------------------------------------
 动态语言切换 
   关键点： request_locale=en_US   (对关闭session 之前都有效)


>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
  Struts2 拦截器  
      
      自定义拦截器 

      1. 实现 com.opensymphony.xwork2.interceptor.Interceptor; 接口
      2. 实现抽象方法 
       
           public String intercept(ActionInvocation) throws Exctption{
	       long start =System.currentTimeMillis();
		
		String r =invocation.invoke(); 
		
		long end = System.currentTimeMillis();
		
		System.out.println("运行时间："+(end-start));
		
		return r;
	        
	   }

	3.在struts.xml 中 配置自定义 拦截器 

        <package name="struts2" extends="struts-default" namespace="/"> 
	    
	    <interceptors>
	       <interceptor name="my" class="com.baishui.interceptor.MyInterceptor"></interceptor>          //声明自定义拦截器
	    </interceptors> 

		<action name="hello"> 
			<result>/hello.jsp</result> 
			<interceptor-ref name="my"></interceptor-ref>                                                                   // 引用自定义拦截器
			<interceptor-ref name="defaultStack"></interceptor-ref>                                                   //添加默认的拦截器
		</action> 
	</package> 
      
           注：添加自定义拦截器时，会屏蔽掉struts2 的默认拦截器 ，所以在后面添加上 defaultStack
       
-------------------------------------------------------------------------------
  默认拦截重复提交的 token 拦截器

     1. 配置struts.xml
      <package name="index" extends="struts-default" namespace="/"> 
		<action name="index"> 
			<result>/login.jsp</result>   
		</action> 
	</package>
	<package name="front" extends="struts-default" namespace="/"> 
		<action name="login" class="com.baishui.interceptor.Login" > 
			<result>/hello.jsp</result>  
			<interceptor-ref name="defaultStack"></interceptor-ref>                             //引入默认defaultStack 拦截器
			<interceptor-ref name="token"></interceptor-ref>                                         //引入token 拦截器
			<result name="invalid.token">/error.jsp</result>                                             //重复刷新时 拦截
		</action> 
	</package>

     2.在 禁止重复提交页面上 添加 s:token 标签

       <%@taglib prefix="s" uri="/struts-tags" %>
        <s:token></s:token>


《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《

类型转换  

         日期处理 的类型转换





--------------------------------------------------------------------------------------------------------------

BBS2009 项目练习


 代码工程   BBS2009_0001


 
1 ---Struts2 基础配置

//默认的indexAction
<package name="struts2" extends="struts-default" namespace="/"> 
	<default-action-ref name="index"> 
	</default-action-ref> 
		<action name="index"> 
			<result>/index.jsp</result> 
		</action>  
	</package>

	//简略的action设计模式
<package name="admin" extends="struts-default" namespace="/admin">
	    <action name="*_*" class="com.baishui.bbs.action.{1}Action" method="{2}">
		  <result name="success">/{1}_{2}.jsp</result>
	   </action> 
		
		<!--第二种配置方法，取决于设计，这种清晰但配置复杂
		<action name="Category" class="com.baishui.bbs.CategoryAction">
		  <result name="success">/Category_list.jsp</result>
		   <result name="update">/Category_update.jsp</result>
		    <result name="delete">/Category_delete.jsp</result> 
		     <result name="add">/Category_add.jsp</result>
		</action> 
	    -->
</package>



数据库连接池  （单子设计模式）

Dao设计模式 （单子设计模式 service层 省略）

      













