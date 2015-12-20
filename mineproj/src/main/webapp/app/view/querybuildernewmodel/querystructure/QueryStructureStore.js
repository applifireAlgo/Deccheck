Ext.define('Mineproj.view.querybuildernewmodel.querystructure.QueryStructureStore', {
    extend: 'Ext.data.Store',
    requires:['Mineproj.view.querybuildernewmodel.querystructure.QueryStructureModel'],
    autoSync: false,
    model: 'Mineproj.view.querybuildernewmodel.querystructure.QueryStructureModel',
    filters: []
  
});
