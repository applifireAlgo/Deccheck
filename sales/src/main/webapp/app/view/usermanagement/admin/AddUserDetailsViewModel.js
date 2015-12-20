Ext.define('Sales.view.usermanagement.admin.AddUserDetailsViewModel',
{
	extend : 'Ext.app.ViewModel',
	
	alias : 'viewmodel.addUserModel',

	model: "AddUserDataModel",
	 
	requires:['Sales.model.AddUserDataModel'],

});