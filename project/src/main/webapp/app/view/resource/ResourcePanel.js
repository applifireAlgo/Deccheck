Ext.define('Project.view.resource.ResourcePanel', {
	extend : 'Ext.panel.Panel',
	xtype : 'resourcePanel',
	itemId : 'resourcePanel',
	requires : ['Project.view.resource.ResourcePanelController'],
	controller : 'resourcePanelController',
	cls:'resourcePanelStyle',
	title:'<p style="color:#fff;font-weight:bold;font-size:20px;margin:0px;padding:0%;"><img src="resources/css/images/logo.png" width="60" height="60" align="center" hspace="5" style="border-radius:60%;">project</p>',
    resizable:false,
	listeners:{
		scope:'controller',
		afterrender:'onResourcePanelAfterRender'
	}
});
