                                                    Struts2 �ܽ�

>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>1>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
Struts2.0  web.xml ����

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

Struts2.1 web.xml����

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


------------------2.0 �� 2.1 ���� ---------------------------------
	2.1 �����п��Բ��� .action
--------------------------------------------------------------------
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>2>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

struts2  struts.xml����

<struts>

      <constant name="struts.devMode" value="true">       <!--����ģʽ Ĭ��Ϊfalse-->
      <constant name="struts.i18n.encoding" value="GBK">  <!--�����������-->
    <!--struts2.0 begin-->
         
	<package name="struts2" extends="struts-default" namespace="/"><!--�����ռ�--> 
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

���� ���̣�Struts2_0100_Introduction
�����ռ� ���̣�Struts2_0200_Namespace
·�� ���̣�Struts2_0400_Path
----------------------����struts.xml �ַ���ʾ-----------------------------------
��window-->preferences-->catalog-->XML Catalog-->��� ��struts-core-2.1.6.jar ��ѹ struts-2.0.dtd �ļ�
 location : ѡ��struts-2.0.dtd �ļ����ص�ַ
 key type :ѡ�� uri
 key      : http://struts.apache.org/dtds/struts-2.0.dtd
--------------------------------------------------------------------------------

Action �� �̳�  ActionSupport �� ʵ�� Action �ӿ� (ע��action������� public)

������ͼ�ķ��ؿ������û��Լ������Action������ 
������ֶ��Ǹ��ݷ��ص��ַ����ҵ���Ӧ���������������ͼ������<br />
����Action��ʵ�ֿ�����һ����ͨ��java�࣬������public String execute�������� 
����ʵ��Action�ӿ� 
������õ��Ǵ�ActionSupport�̳У��ô����ڿ���ֱ��ʹ��Struts2��װ�õķ��� 

���̣�Struts2_0300_Action

>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>3>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

��̬���÷�������:  �����̣�Struts2_0500_ActionMethod��

   ---------------- ����һ������actionʱ �ã� �ӷ�����

 
   <struts> 
	<package name="struts2" extends="struts-default" namespace="/user"> <!--�����ռ�-->
		<action name="user" class="com.test.action.UserAction"> <!--����ʱuser/userAdd.action -����UserAction �� add()-->
			<result name="success">/success.jsp</result> 
		</action>  
	</package> 
   </struts>
�� com.test.action.UserAction �У�add();delete;.....

����Ϊ�� user/user!add  ----> ���� add();����
����Ϊ�� user/user!delete  ----> ���� delete();����

 

    ----------------�������� ActionMethod_DMI  

   <struts> 
	<package name="struts2" extends="struts-default" namespace="/user"> 
		<action name="userAdd" class="com.test.action.UserAction" method="add" > <!--����ʱuser/userAdd.action -����UserAction �� add()-->
			<result name="success">/success.jsp</result> 
		</action> 
		<action name="userDelete" class="com.test.action.UserAction" method="delete" > <!--����ʱuser/userDelete.action -����UserAction �� delete()-->
			<result name="success">/success.jsp</result> 
		</action> 
	</package> 
   </struts>

    ----------------�������� ͨ������� (ע�⣺ͨ��������ܰ˸� * ���ζ���)(���̣�Struts2_0600_ActionWildcard)

   <struts> 
	<package name="struts2" extends="struts-default" namespace="/user"> 
		<action name="user*" class="com.test.action.UserAction" method="{1}" > 
			<result name="success">/user{1}_success.jsp</result> 
		</action>  
	</package> 
   </struts>
  
 
                   ---------------�ڶ������÷�ʽ------------------
   <struts> 
	<package name="struts2" extends="struts-default" namespace="/user"> 
		<action name="*_*" class="com.test.action.UserAction" method="{2}"> 
			<result name="success">/{1}{2}_success.jsp</result> 
		</action>  
	</package> 
   </struts>
   ----------------------------------------------------
   ���ַ�ʽ ����ͨ������ñ�򻯣���Ҫ��Լ����Խ���ã������淶����Ŀ�����üӰѾ��� �Ǻǣ�
   ----------------------------------------------------

>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>4>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
Action ���Խ��ղ���

 ---------------��һ�ַ�ʽ------------------(���̣�Struts2_0700_ActionAttrParamInput)
 ֱ�Ӷ�Ӧ���е�ÿ�����ԣ��ṩget,set����
 ---------------*�ڶ��ַ�ʽ------------------��*���õķ�����(���̣�Struts2_0800_DomainModelParamInput)
    Struts2  DomainModel �����ݴ��� ����

    1.����Model----------------------------------UserModel;(ע������Ҫ��get,set)
    2.��Action�ж���UserModel--------------------UserAction:private UserModel userModel;(ע������Ҫ��get,set)
    3.������ Ҫ�� userModel.���� �ύ������
    ���磺http://localhost:8080/Struts2_DomainModel/user/user.action?userModel.name=tom&userModel.password=123&
---------------�����ַ�ʽ------------------(���̣�Struts2_0900_ModelDrivenParamInput)
     ModelDriven �����ݴ��� ����
     1.����Model----------------------------------UserModel;(ע������Ҫ��get,set)
     2.Action �̳� ActionSupport ʵ��ModelDriven<E> �ӿ�--
     3.
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>5>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
struts2 �������� (���� Struts2_1000_CharacterEncoding)

>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>5>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
������֤

   ����һ����дvalidate()����  (����:Struts_1150_DataValiationAction)
     1.-- public void validate() {
		System.out.println("-----------LoginAction validate()-------------");
		if (!"tom".equals(userForm.getName())) {  
			this.addFieldError("nameError", "��������tom");
			this.addActionError("��½ʧ�ܣ�");
			this.addActionError("�û�������ȷ��");
		} else { 
			this.addActionMessage("��½�ɹ�!"); 
		} 
	   }
      2.--��struts.xml ���� input
                <action name="login" class="com.baishui.struts2.actions.user.LoginAction"> 
			<result name="success">/login_success.jsp</result> 
			<result name="input">/error.jsp</result>
		</action>
      3.--��error.jsp��ʹ�ñ�ǩ��ʾ��������Ϣ
    <%@taglib uri="/struts-tags" prefix="s" %>
     s:fielderror|<s:fielderror fieldName="nameError" /> <br>
     s:actionerror|<s:actionerror/><br>
     s:property -value="actionErrors"|<s:property value="actionErrors[0]"/><br>
     s:property -value="actionErrors"|<s:property value="actionErrors[1]"/><br>
     s:property -value="errorMessages"|<s:property value="errorMessages[0]"/><br>
     s:property -value="errorMessages"|<s:property value="errorMessages[1]"/><br>
    <s:debug/>
      4.�ɹ�ҳ��
         <s:actionmessage name="message[1]"/>
         <s:property value="actionMessages[0]"/>
         <s:debug /> 
 -------------------------------------------------------------------------
    ��������ֱ����execute��������� ������Ϣ (���̣�Struts2_1100_SimpleDataValiation)
     1.this.addFieldError("nameError", "��������tom");
       return ERROR;
     2.�ڴ�����Ϣҳ����struts2 ��ǩ��ʾ������Ϣ
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>5>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

-----------------------------------����web Ԫ��----------------------------------------------------------------------

����web Ԫ��     MAP���� request,session,application (����:Struts2_1200_AccessWebElements)

       ����һ������������ 
            1����Action����  ����java.util.Map��������request,session,application
	    2������ com.opensymphony.xwork2.ActionContext
	             request = (Map)com.opensymphony.xwork2.ActionContext.getContext().get("request");
                     session = (Map)com.opensymphony.xwork2.ActionContext.getContext().get("session");
                     application = (Map)com.opensymphony.xwork2.ActionContext.getContext().get("application");
	    3��request.put("key","value");
	       session.put("key","value");
	       application.put("key","value");
            4����ǰ̨ҳ����ã������ַ���
	              a:<s:property value = "#request.key">
		        <s:property value = "#session.key">
			<s:property value = "#application.key"> 
                      -----------------------------------------------------------
		      ע��ʹ��struts��ǩʱ����#ֱ�ӷ���ActionContext �еĶ�������ܷ��ʣ�
		      -----------------------------------------------------------

		      b:<%=request.getAttribute("key")%>
		        <%=session.getAttribute("key")%>
			<%=application.getAttribute("key")%>
                      -----------------------------------------------------------
		      ע��ʹ��jsp��������ʱ����ֱ��getAttribute("key")�������ã�ԭ����Struts2�� �Ѿ� ��Map�Ͷ�Ӧ�Ķ������ 
		      -----------------------------------------------------------
       ��������(��õķ���)IOC��inverse of control  ��ת���ƣ� 
              1����Action���� ʵ�� orj.apache.interceptor.RequestAware,orj.apache.interceptor.SessionAware,orj.apache.interceptor.ApplicationAware
              2����Action����  ����java.util.Map��������request,session,application
                            Map<String,Object> request;
                            Map<String,Object> session;
			    Map<String,Object> application;
              3����Action���ж��� setRequest(Map<String,Object> request);
	                          setSession(Map<String,Object> session);
				  setApplication(Map<String,Object> application;
		      -----------------------------------------------------------
		      ע��struts2 �л��Զ����÷�����ʵ�ֶ�Ӧӳ��
		      -----------------------------------------------------------
	      4��request.put("key","value");
	         session.put("key","value");
	         application.put("key","value");
	      5����ǰ̨ҳ����ã������ַ���
	              a:<s:property value = "#request.key">
		        <s:property value = "#session.key">
			<s:property value = "#application.key"> 
                      -----------------------------------------------------------
		      ע��ʹ��struts��ǩʱ����#ֱ�ӷ���ActionContext �еĶ�������ܷ��ʣ�
		      -----------------------------------------------------------

		      b:<%=request.getAttribute("key")%>
		        <%=session.getAttribute("key")%>
			<%=application.getAttribute("key")%>

����web Ԫ��   ��ʵ���ͣ�HttpServletRequest,HttpSession,ServletContext


       ����һ������������ 
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
  
         ��������IOC��inverse of control  ��ת���ƣ�


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

   struts.xml �������� Action �����ļ� (���̣�Struts2_1300_IncludeModules)
 ����˿�����Ŀʱ���ֿ����ã�
  <struts> 
      <constant name="struts.devMode" value="true">     <!--����ģʽ Ĭ��Ϊfalse-->
      <constant name="struts.i18n.encoding" value="GBK">  <!--�����������-->
      <include file="login.xml"/>  <!--���������ļ�-->
    <!--struts2.0 begin--> 
	<package name="struts2" extends="struts-default" namespace="/"><!--�����ռ�-->

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

 Ĭ��Action  (���̣�Struts2_1400_DefaultAction)

    <struts> 
      <constant name="struts.devMode" value="true">     <!--����ģʽ Ĭ��Ϊfalse-->
      <constant name="struts.i18n.encoding" value="GBK">  <!--�����������-->
      <include file="login.xml"/>  <!--���������ļ�-->
    <!--struts2.0 begin--> 
	<package name="struts2" extends="struts-default" namespace="/"><!--�����ռ�-->
                <default-action-ref  name="login" ></default-action-ref><!--Ĭ�ϵ�action-->
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


    1.ͨ�ñ�ǩ 
     a)property��ǩ- 
      ��ֵվ��ȡֵ��username:<s:property value="username"/> -----------OGNL���ʽ
      ȡֵΪ�ַ�����<s:property value="'username'"/>  -----------------��ͨ���ַ���
      �趨Ĭ��ֵ��  <s:property value="admin" default="����Ա"/> ------
      �趨HTML: <s:property value="'<hr/>'" escape="true"/>  ---------- 
     b)set��ǩ (���� id  name scope value var) 
      �趨adminNameֵ��Ĭ��Ϊrequest �� ActionContext��: </h4><s:set var="adminname" value="username"/>
      ��request��ȡֵ<s:property value="#request.adminname"/>
      ��ActionContext��ȡֵ<s:property value="#adminname"/> 
      ע��debug request�в���ʾadminname ʱ������Ϊ��û�ŵ�request��debug�Ѿ��γ�
          struts2�ĵ�bug vaule  ���� ����String �Ƕ���object 
        1.scope  Ĭ��action  ����   application session request page or action
        2.var   ��2.0 �� �趨var ��ActionContext �л���� var ��ֵ����2.1�� ��Ϊname ��var �ظ����Է��� name 

          ע�� 2.0�� ָ��name ��scope ʱ����������actionContext ʱ����ָ��var,��2.1 ����ָ��var,ͬʱָ��scope ʱ Ҳ�������ActionContext��
 
     c)bean��ǩ
        <s:bean name="com.baishui.struts2.tags.Love" var="love1">
            <s:param name="myLove" value="'xr'"></s:param>
        </s:bean>
        �鿴bean param<s:property value="#love1.myLove"/> 

   
     d)include��ǩ 
       1.<s:include value="/include1.jsp"></s:include></li>
       2.����include��ǩ�� value���� ΪString���� ���Բ��ܽ���OGNL���ʽ�����õ��ǿ���%{}����ǿ��ת��ΪOGNL���ʽ
              <s:set var="page" value="'/include3.jsp'"></s:set>
              ǿ��ת��%{OGNL���ʽ}---<s:include value="%{#page}"></s:include> 




      e)fielderror��ǩ
         1.��Action �� this.addFieldError("fielderror.test","wrong")
         2.<s:fielderror value="fielderror.test"/> 

     2 ���Ʊ�ǩ
      a)if elseif else��ǩ
     
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
    �Զ���list
    <s:iterator value="{'aaa','bbb','ccc'}" status="status">
    <s:property/>|
               ��ǰѭ��������<s:property value="#status.count"/>|
               ��ǰԪ���±꣺<s:property value="#status.index"/>|
               ��ǰԪ���ǲ���ż������<s:property value="#status.even"/>|
               ��ǰԪ���ǲ�����������<s:property value="#status.odd"/>|
               ��ǰԪ���ǲ��ǵ�һ����<s:property value="#status.first"/>|
               ��ǰԪ���ǲ������һ����<s:property value="#status.last"/>
    
   </s:iterator> 
    �Զ���map 
   <s:iterator value="#{1:'a',2:'b',3:'c'}" var="x">
       <s:property value="#x.key"/>|<s:property value="#x.value"/> 
   </s:iterator> 

   ע������map ʱ ��#

>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


struts2 I18N 


  I18N�����ļ������淶:  app_zh_CN.properties            //��app ����𣬺��������ôд�� �ļ�ͷ_����_����.properties

                                       app_en_US.properties

ResourceBundle res =  ResourceBundle.getBundle("app",Locale.CHINA);
res.getString("welcome.msg")

--------------------------------------- struts2 ��i18n ---------------------------------------------------------
����һ struts ��Դ�ļ���Action ����(���� �� struts2_3100_I18N)

   1 struts2.xml ������
    <package name="index" extends="struts-default" namespace="/">
	   <action name="login" class="com.baishui.i18n.admin.Login" method="login">    //���ʻ��ļ�����Action֮��ſ��ԣ����� �ļ��͸������ͬ�ļ�����
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

   2 ���ʻ��ļ�  ��ע�⣺�����淶 1  ǰ����Action������ͬ_����_����.properties ���磺Login_en_US.properties��
           admin.username=����Ա�û�����
           admin.password=��  ¼  ��  �� ��
           admin.login=��  ¼
    3 ��ҳ����ȡ���ʻ��ı���ֵ  getText("���ʻ��ı���KEY") 
    <s:property value="getText('admin.username')"/>  // ���õ��� Login   Action �е� getText() ����
--------------------------------------- struts2 ��i18n ---------------------------------------------------------
������ struts ��Դ�ļ���package ����
        ����ͬ����Action������ʹ�ã���Դ�ļ�������  package_en_US.properties 


--------------------------------------- struts2 ��i18n ---------------------------------------------------------
������ struts ��Դ�ļ���app���� (���)
       1. ����Action������ʹ�ã���Դ�ļ�����  ���Զ��壩_en_US.properties 
       2. struts2 �� ����app ���ʻ���Դ�ļ����������ο� default.properties �ļ� #struts.custom.i18n.resources��
                          
                   <constant name="struts.customer.i18n.resources" value="�Զ���"/>
--------------------------------------- struts2 ��i18n ---------------------------------------------------------

���� ���ʻ���Դ�ļ��еĲ��� 

   1.����Դ�ļ��� �� ��0�� ռλ����ʶ ����
        welcome.msg=��ӭ����{0}
        ע�� �����д�0��ʼһ�����У�
   2.��ҳ���� ��̬ ָ������
          <s:property value="getText('welcome.msg')"/><br>
          <s:text name="welcome.msg"><br>
              <s:param value="adminname"></s:param>
          </s:text>
          <s:debug></s:debug>
--------------------------------------- struts2 ��i18n ---------------------------------------------------------
 ��̬�����л� 
   �ؼ��㣺 request_locale=en_US   (�Թر�session ֮ǰ����Ч)


>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
  Struts2 ������  
      
      �Զ��������� 

      1. ʵ�� com.opensymphony.xwork2.interceptor.Interceptor; �ӿ�
      2. ʵ�ֳ��󷽷� 
       
           public String intercept(ActionInvocation) throws Exctption{
	       long start =System.currentTimeMillis();
		
		String r =invocation.invoke(); 
		
		long end = System.currentTimeMillis();
		
		System.out.println("����ʱ�䣺"+(end-start));
		
		return r;
	        
	   }

	3.��struts.xml �� �����Զ��� ������ 

        <package name="struts2" extends="struts-default" namespace="/"> 
	    
	    <interceptors>
	       <interceptor name="my" class="com.baishui.interceptor.MyInterceptor"></interceptor>          //�����Զ���������
	    </interceptors> 

		<action name="hello"> 
			<result>/hello.jsp</result> 
			<interceptor-ref name="my"></interceptor-ref>                                                                   // �����Զ���������
			<interceptor-ref name="defaultStack"></interceptor-ref>                                                   //���Ĭ�ϵ�������
		</action> 
	</package> 
      
           ע������Զ���������ʱ�������ε�struts2 ��Ĭ�������� �������ں�������� defaultStack
       
-------------------------------------------------------------------------------
  Ĭ�������ظ��ύ�� token ������

     1. ����struts.xml
      <package name="index" extends="struts-default" namespace="/"> 
		<action name="index"> 
			<result>/login.jsp</result>   
		</action> 
	</package>
	<package name="front" extends="struts-default" namespace="/"> 
		<action name="login" class="com.baishui.interceptor.Login" > 
			<result>/hello.jsp</result>  
			<interceptor-ref name="defaultStack"></interceptor-ref>                             //����Ĭ��defaultStack ������
			<interceptor-ref name="token"></interceptor-ref>                                         //����token ������
			<result name="invalid.token">/error.jsp</result>                                             //�ظ�ˢ��ʱ ����
		</action> 
	</package>

     2.�� ��ֹ�ظ��ύҳ���� ��� s:token ��ǩ

       <%@taglib prefix="s" uri="/struts-tags" %>
        <s:token></s:token>


������������������������������������������������������������������������������������������������������������������������������������������������

����ת��  

         ���ڴ��� ������ת��





--------------------------------------------------------------------------------------------------------------

BBS2009 ��Ŀ��ϰ


 ���빤��   BBS2009_0001


 
1 ---Struts2 ��������

//Ĭ�ϵ�indexAction
<package name="struts2" extends="struts-default" namespace="/"> 
	<default-action-ref name="index"> 
	</default-action-ref> 
		<action name="index"> 
			<result>/index.jsp</result> 
		</action>  
	</package>

	//���Ե�action���ģʽ
<package name="admin" extends="struts-default" namespace="/admin">
	    <action name="*_*" class="com.baishui.bbs.action.{1}Action" method="{2}">
		  <result name="success">/{1}_{2}.jsp</result>
	   </action> 
		
		<!--�ڶ������÷�����ȡ������ƣ��������������ø���
		<action name="Category" class="com.baishui.bbs.CategoryAction">
		  <result name="success">/Category_list.jsp</result>
		   <result name="update">/Category_update.jsp</result>
		    <result name="delete">/Category_delete.jsp</result> 
		     <result name="add">/Category_add.jsp</result>
		</action> 
	    -->
</package>



���ݿ����ӳ�  ���������ģʽ��

Dao���ģʽ ���������ģʽ service�� ʡ�ԣ�

      













