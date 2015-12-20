Ext.define('Mineproj.view.querybuildernewmodel.queryentitiesjoins.EntityJoinStore', {
    extend: 'Ext.data.Store',
    requires:['Mineproj.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel'],
    autoSync: false,
    model: 'Mineproj.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel',
    data:[]
});
