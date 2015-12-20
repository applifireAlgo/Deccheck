Ext.define('Mineproj.view.mobileview.reportui.datachart.DataChartViewTab', {
	extend : 'Ext.tab.Panel',
	requires : [ 'Mineproj.view.mobileview.reportui.datachart.DataChartTController',
			'Mineproj.view.mobileview.reportui.datachart.datagrid.DataGridView','Mineproj.view.mobileview.reportui.datachart.chart.ChartTabView','Mineproj.view.mobileview.reportui.datachart.ChartPointView' ],
	controller : 'datacharttController',
	xtype : 'datachart-tabpanel',
	tabPosition : 'bottom',
	bodyStyle : 'background:#D8D8D8',

	margin : '0 0 0 0',
	initComponent : function() {
		/*this.items */

		this.callParent(arguments);
	},
	listeners : {
		scope : "controller",
		tabchange : 'tabchange'
	}

});