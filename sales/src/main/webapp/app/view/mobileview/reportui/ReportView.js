Ext.define('Sales.view.mobileview.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Sales.view.mobileview.reportui.querycriteria.QueryCriteriaView',
			'Sales.view.mobileview.reportui.datachart.DataChartViewTab',
			'Sales.view.mobileview.reportui.datachart.DataChartViewPanel',
			'Sales.view.mobileview.reportui.ReportViewController' ,
			'Sales.view.mobileview.fw.DataPointPanel',
			'Sales.view.mobileview.googlemaps.map.MapPanel'
			],
	xtype : 'reportview',
	controller : 'reportviewController',
	layout : 'border',
	reportWidgets :["1","2","3","4"],
	//autoScroll : true,
	//margin : '3 0 5 0',

	listeners : {
		scope : 'controller',
		afterrender : 'renderReport'
	}
});
