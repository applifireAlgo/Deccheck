Ext.define('Sales.view.querybuildernewmodel.queryentitiesjoins.EntityJoinStore', {
    extend: 'Ext.data.Store',
    requires:['Sales.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel'],
    autoSync: false,
    model: 'Sales.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel',
    data:[]
});
