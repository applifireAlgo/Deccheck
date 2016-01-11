Ext.define('Project.view.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Project.view.reportui.querycriteria.QueryCriteriaView',
			'Project.view.reportui.datachart.DataChartViewTab',
			'Project.view.reportui.datachart.DataChartViewPanel',
			'Project.view.reportui.ReportViewController' ,
			'Project.view.fw.MainDataPointPanel',
			'Project.view.googlemaps.map.MapPanel'
			],
	xtype : 'reportview',
	controller : 'reportviewController',
	layout : 'border',
	reportWidgets :["1","2","3","4"],
	//autoScroll : true,
	//margin : '3 0 5 0',
	height:500,
	width:"100%",
	listeners : {
		scope : 'controller',
		afterrender : 'renderReport'
	}
});
