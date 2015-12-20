Ext.define('Mineproj.view.art.masterform.MasterFormPanel',
{
	extend :'Ext.form.Panel',
	xtype: 'masterFormPanel',
	itemId : 'masterFormPanel',
	
	requires: ['Mineproj.view.art.masterform.MasterFormModel','Mineproj.view.art.masterform.MasterFormViewModel','Mineproj.view.art.masterform.MasterFormPanelController'],

	//viewModel: 'masterFormViewModel',
	
	controller: 'masterFormPanelController'

});
	