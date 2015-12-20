Ext.define('Mineproj.view.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Mineproj.view.reportui.querycriteria.QueryCriteriaView',
			'Mineproj.view.reportui.datachart.DataChartViewTab',
			'Mineproj.view.reportui.datachart.DataChartViewPanel',
			'Mineproj.view.reportui.ReportViewController' ,
			'Mineproj.view.fw.MainDataPointPanel',
			'Mineproj.view.googlemaps.map.MapPanel'
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
