Ext.define('Project.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsStore', {
    extend: 'Ext.data.Store',
    requires:['Project.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel'],
    autoSync: false,
    model: 'Project.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel',
    filters: []
  
});
