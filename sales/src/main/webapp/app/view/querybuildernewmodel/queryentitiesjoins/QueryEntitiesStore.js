Ext.define('Sales.view.querybuildernewmodel.queryentitiesjoins.QueryEntitiesStore', {
    extend: 'Ext.data.Store',
   // requires:['Sales.view.querybuildernewmodel.queryentitiesjoins.QueryEntitiesModel'],
    autoSync: false,
    model: 'Sales.view.querybuildernewmodel.queryentitiesjoins.QueryEntitiesModel',
    data:[]
});
