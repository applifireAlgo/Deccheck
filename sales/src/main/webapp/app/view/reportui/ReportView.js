Ext.define('Sales.view.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Sales.view.reportui.querycriteria.QueryCriteriaView',
			'Sales.view.reportui.datachart.DataChartViewTab',
			'Sales.view.reportui.datachart.DataChartViewPanel',
			'Sales.view.reportui.ReportViewController' ,
			'Sales.view.fw.MainDataPointPanel',
			'Sales.view.googlemaps.map.MapPanel'
			],
	xtype : 'reportview',
	controller : 'reportviewController',
	layout : 'border',
	reportWidgets :["1","2","3","4"],
	//autoScroll : true,
	//margin : '3 0 5 0',
	height:500,
	width:1000,
	listeners : {
		scope : 'controller',
		afterrender : 'renderReport'
	}
});
