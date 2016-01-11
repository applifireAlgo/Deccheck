Ext.define('Project.view.querybuildernewmodel.queryentitiesjoins.QueryEntitiesStore', {
    extend: 'Ext.data.Store',
   // requires:['Project.view.querybuildernewmodel.queryentitiesjoins.QueryEntitiesModel'],
    autoSync: false,
    model: 'Project.view.querybuildernewmodel.queryentitiesjoins.QueryEntitiesModel',
    data:[]
});
