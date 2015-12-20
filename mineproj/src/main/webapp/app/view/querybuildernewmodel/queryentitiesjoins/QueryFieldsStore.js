Ext.define('Mineproj.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsStore', {
    extend: 'Ext.data.Store',
    requires:['Mineproj.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel'],
    autoSync: false,
    model: 'Mineproj.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel',
    filters: []
  
});
