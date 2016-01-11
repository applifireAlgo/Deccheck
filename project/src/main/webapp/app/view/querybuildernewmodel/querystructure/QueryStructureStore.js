Ext.define('Project.view.querybuildernewmodel.querystructure.QueryStructureStore', {
    extend: 'Ext.data.Store',
    requires:['Project.view.querybuildernewmodel.querystructure.QueryStructureModel'],
    autoSync: false,
    model: 'Project.view.querybuildernewmodel.querystructure.QueryStructureModel',
    filters: []
  
});
