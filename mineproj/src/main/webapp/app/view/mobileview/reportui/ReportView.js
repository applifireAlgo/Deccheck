Ext.define('Mineproj.view.mobileview.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Mineproj.view.mobileview.reportui.querycriteria.QueryCriteriaView',
			'Mineproj.view.mobileview.reportui.datachart.DataChartViewTab',
			'Mineproj.view.mobileview.reportui.datachart.DataChartViewPanel',
			'Mineproj.view.mobileview.reportui.ReportViewController' ,
			'Mineproj.view.mobileview.fw.DataPointPanel',
			'Mineproj.view.mobileview.googlemaps.map.MapPanel'
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
