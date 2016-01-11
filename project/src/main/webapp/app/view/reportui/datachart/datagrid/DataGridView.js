Ext.define('Project.view.reportui.datachart.datagrid.DataGridView',{
	extend : 'Ext.grid.Panel',
	requires : [ 'Project.view.reportui.datachart.datagrid.DataGridController' ],
	xtype : 'data-grid-view',
	controller:'datagridController',
	autoscroll:true,
	columnLines:true,
	/*viewConfig: { 
	        stripeRows: true 
	},*/
	cls: 'aa', 
	itemId : 'data-grid-view',
	width : "100%",
	listeners : {
		scope:'controller',
		cellclick : 'dataGridCellClick',
		itemcontextmenu : 'dataGridRightClick',
	}
});
