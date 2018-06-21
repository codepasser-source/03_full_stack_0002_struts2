<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>北京尚学堂BBS2009论坛管理平台</title>
<link rel="stylesheet" type="text/css" href="ext3.0/resources/css/ext-all.css" />
<!-- GC -->
<!-- LIBS -->
<script type="text/javascript" src="ext3.0/adapter/ext/ext-base.js"></script>
<!-- ENDLIBS -->
<script type="text/javascript" src="ext3.0/ext-all.js"></script>
<script type="text/javascript" src="ext3.0/ext-lang-zh_CN.js"></script>


<style type="text/css">
html,body {
	font: normal 12px verdana;
	margin: 0;
	padding: 0;
	border: 0 none;
	overflow: hidden;
	height: 100%;
}

.empty .x-panel-body {
	padding-top: 0;
	text-align: center;
	font-style: italic;
	color: gray;
	font-size: 11px;
}

.x-btn button {
	font-size: 14px;
}

.x-panel-header {
	font-size: 14px;
}
</style>
<script type="text/javascript">
	Ext.onReady( function() {
		//Ext.Msg.alert('ext','welcome you!');
		var addPanel = function(btn, event) {
			var n;
			n = tabPanel.getComponent(btn.id);
			if(n) {
				tabPanel.setActiveTab(n);
				return;
			}
			n = tabPanel.add( {
				id : btn.id,
				title : btn.id,
				html : '<iframe width=100% height=100% src=' + btn.id + ' />',
				//autoLoad : '',
				closable : 'true'
			});
			tabPanel.setActiveTab(n);
		}

		var item1 = new Ext.Panel( {
			title : 'Category管理',
			//html : '&lt;empty panel&gt;',
			cls : 'empty',
			items : [ 
				new Ext.Button({
					id : 'admin/Category_list',
					text : 'Category列表',
					width : '100%',
					listeners : {
						click : addPanel
					} 
				}),

				new Ext.Button({
					id : 'test',
					text : 'Test',
					width : '100%',
					listeners : {
						click : addPanel
					} 
				})

			]

		});

		var item2 = new Ext.Panel( {
			title : 'Accordion Item 2',
			html : '&lt;empty panel&gt;',
			cls : 'empty'
		});

		var item3 = new Ext.Panel( {
			title : 'Accordion Item 3',
			html : '&lt;empty panel&gt;',
			cls : 'empty'
		});

		var item4 = new Ext.Panel( {
			title : 'Accordion Item 4',
			html : '&lt;empty panel&gt;',
			cls : 'empty'
		});

		var item5 = new Ext.Panel( {
			title : 'Accordion Item 5',
			html : '&lt;empty panel&gt;',
			cls : 'empty'
		});

		var accordion = new Ext.Panel( {
			region : 'west',
			margins : '5 0 5 5',
			split : true,
			width : 210,
			layout : 'accordion',
			items : [ item1, item2, item3, item4, item5 ]
		});

		var tabPanel = new Ext.TabPanel( {
		    id:'index',
			region : 'center',
			enableTabScroll : true,
			deferredRender : false,
			activeTab : 0,
			items : [ {  
				title : 'index', 
				//html : 'aaaaaa'
				autoLoad : 'Category_add.jsp'
			} ]
		});

		var viewport = new Ext.Viewport( {
			layout : 'border',
			items : [ accordion, tabPanel ]
		});

	});
</script>
	</head>
	<body> 
		<!-- EXAMPLES -->
	</body>
</html>
