Ext.define('Project.view.querybuildernewmodel.queryentitiesjoins.EntityJoinStore', {
    extend: 'Ext.data.Store',
    requires:['Project.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel'],
    autoSync: false,
    model: 'Project.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel',
    data:[]
});
