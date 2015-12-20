Ext.define('Sales.view.querybuildernewmodel.querystructure.QueryStructureStore', {
    extend: 'Ext.data.Store',
    requires:['Sales.view.querybuildernewmodel.querystructure.QueryStructureModel'],
    autoSync: false,
    model: 'Sales.view.querybuildernewmodel.querystructure.QueryStructureModel',
    filters: []
  
});
