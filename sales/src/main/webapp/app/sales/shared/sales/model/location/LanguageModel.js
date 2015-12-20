Ext.define('Sales.sales.shared.sales.model.location.LanguageModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "languageId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "language",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "languageType",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "languageDescription",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "languageIcon",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "alpha2",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "alpha3",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "alpha4",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "alpha4parentid",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "versionId",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "entityAudit",
          "reference": "EntityAudit"
     }, {
          "name": "primaryDisplay",
          "type": "string",
          "defaultValue": ""
     }]
});