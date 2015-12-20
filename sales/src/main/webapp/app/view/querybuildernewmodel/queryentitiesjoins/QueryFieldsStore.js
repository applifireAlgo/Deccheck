Ext.define('Sales.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsStore', {
    extend: 'Ext.data.Store',
    requires:['Sales.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel'],
    autoSync: false,
    model: 'Sales.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel',
    filters: []
  
});
