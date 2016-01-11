Ext.define('Project.project.web.project.view.location.VillageMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "VillageMainController",
     "restURL": "/Village",
     "defaults": {
          "split": true
     },
     "requires": ["Project.project.shared.project.model.location.VillageModel", "Project.project.web.project.controller.location.VillageMainController", "Project.project.shared.project.model.location.CountryModel", "Project.project.shared.project.model.location.StateModel", "Project.project.shared.project.model.location.RegionModel", "Project.project.shared.project.model.location.DistrictModel", "Project.project.shared.project.model.location.TalukaModel", "Project.project.shared.project.viewmodel.location.VillageViewModel"],
     "communicationLog": [],
     "tabPosition": "bottom",
     "items": [{
          "title": "Data Browser",
          "layout": "border",
          "defaults": {
               "split": true
          },
          "autoScroll": false,
          "customWidgetType": "vdBorderLayout",
          "items": [{
               "xtype": "tabpanel",
               "customWidgetType": "vdTabLayout",
               "margin": "5 0 5 5",
               "border": 1,
               "style": {
                    "borderColor": "#f6f6f6",
                    "borderStyle": "solid",
                    "borderWidth": "1px"
               },
               "displayName": "Village",
               "name": "VillageTreeContainer",
               "itemId": "VillageTreeContainer",
               "restURL": "/Village",
               "autoScroll": false,
               "collapsible": true,
               "titleCollapse": true,
               "collapseMode": "header",
               "collapsed": false,
               "items": [{
                    "xtype": "treepanel",
                    "customWidgetType": "vdTree",
                    "title": "Browse",
                    "useArrows": true,
                    "rootVisible": false,
                    "itemId": "VillageTree",
                    "listeners": {
                         "select": "treeClick"
                    },
                    "tbar": [{
                         "xtype": "triggerfield",
                         "customWidgetType": "vdTriggerField",
                         "emptyText": "Search",
                         "triggerCls": "",
                         "listeners": {
                              "change": "onTriggerfieldChange",
                              "buffer": 250
                         }
                    }, "->", {
                         "xtype": "tool",
                         "type": "refresh",
                         "tooltip": "Refresh Tree Data",
                         "handler": "onTreeRefreshClick"
                    }]
               }, {
                    "title": "Advance Search",
                    "xtype": "form",
                    "customWidgetType": "vdFormpanel",
                    "itemId": "queryPanel",
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "text": "Filter",
                              "handler": "onFilterClick"
                         }]
                    }],
                    "items": []
               }],
               "region": "west",
               "width": "20%"
          }, {
               "region": "center",
               "layout": "border",
               "defaults": {
                    "split": true
               },
               "customWidgetType": "vdBorderLayout",
               "items": [{
                    "customWidgetType": "vdFormpanel",
                    "viewModel": "VillageViewModel",
                    "xtype": "form",
                    "displayName": "Village",
                    "title": "Village",
                    "name": "Village",
                    "itemId": "Village",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "villageId",
                         "itemId": "villageId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Village Id",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Village Id<font color='red'> *<\/font>",
                         "fieldId": "9F68ED10-2CA7-4E4A-BCAA-B8515387448B",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "villageId",
                         "bind": "{villageId}"
                    }, {
                         "name": "villageName",
                         "itemId": "villageName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Village Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Village Name<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "99ECDE66-0FAE-4F25-88E2-2F3092C1260E",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "villageName",
                         "bind": "{villageName}",
                         "columnWidth": 0.5
                    }, {
                         "name": "villageDescription",
                         "itemId": "villageDescription",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "Village Description",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Village Description",
                         "fieldId": "7DBE6E9E-480B-4CCB-9703-BFF9ED3187AD",
                         "bindable": "villageDescription",
                         "bind": "{villageDescription}",
                         "columnWidth": 0.5
                    }, {
                         "name": "villageFlag",
                         "itemId": "villageFlag",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Village taluka",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Village taluka",
                         "fieldId": "EDD44DD7-6B6C-49B0-9EE6-2826CC5D0B7D",
                         "minLength": "0",
                         "maxLength": "64",
                         "bindable": "villageFlag",
                         "bind": "{villageFlag}",
                         "columnWidth": 0.5
                    }, {
                         "name": "countryId",
                         "itemId": "countryId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Country",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Country<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "3713B264-DAC4-4BDD-B69A-0CC7410B3A5B",
                         "restURL": "Country",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Project.project.shared.project.model.location.CountryModel"
                         },
                         "bindable": "countryId",
                         "bind": "{countryId}",
                         "columnWidth": 0.5,
                         "listeners": {
                              "change": "onCountryIdChange"
                         }
                    }, {
                         "name": "stateId",
                         "itemId": "stateId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "State",
                         "margin": "5 5 5 5",
                         "fieldLabel": "State<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "1ADD2E1E-7819-4B8C-B132-6C800D5538DD",
                         "restURL": "State",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Project.project.shared.project.model.location.StateModel"
                         },
                         "bindable": "stateId",
                         "bind": "{stateId}",
                         "columnWidth": 0.5,
                         "listeners": {
                              "change": "onStateIdChange"
                         }
                    }, {
                         "name": "regionId",
                         "itemId": "regionId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Region",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Region<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "178E1828-9493-487F-BD4C-9EF7EF3C6176",
                         "restURL": "Region",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Project.project.shared.project.model.location.RegionModel"
                         },
                         "bindable": "regionId",
                         "bind": "{regionId}",
                         "columnWidth": 0.5,
                         "listeners": {
                              "change": "onRegionIdChange"
                         }
                    }, {
                         "name": "districtId",
                         "itemId": "districtId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "District",
                         "margin": "5 5 5 5",
                         "fieldLabel": "District<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "C11DDC32-D0D4-4F90-B9B8-D9E231F97BCE",
                         "restURL": "District",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Project.project.shared.project.model.location.DistrictModel"
                         },
                         "bindable": "districtId",
                         "bind": "{districtId}",
                         "columnWidth": 0.5,
                         "listeners": {
                              "change": "onDistrictIdChange"
                         }
                    }, {
                         "name": "talukaaId",
                         "itemId": "talukaaId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "talukaa",
                         "margin": "5 5 5 5",
                         "fieldLabel": "talukaa<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "5869D360-270F-480D-B8E4-EEA3F931C81A",
                         "restURL": "Taluka",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Project.project.shared.project.model.location.TalukaModel"
                         },
                         "bindable": "talukaaId",
                         "bind": "{talukaaId}",
                         "columnWidth": 0.5
                    }, {
                         "name": "villageCode",
                         "itemId": "villageCode",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Village Code",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Village Code<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "616D8A29-0BDC-482B-ACAF-2A113D70AB9E",
                         "minLength": "0",
                         "maxLength": "32",
                         "bindable": "villageCode",
                         "bind": "{villageCode}",
                         "columnWidth": 0.5
                    }, {
                         "name": "villageLatitude",
                         "itemId": "villageLatitude",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Village Latitude",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Village Latitude",
                         "fieldId": "BE2F1349-9ECA-4954-B6BC-7D607EA8631F",
                         "minValue": "0",
                         "maxValue": "11",
                         "bindable": "villageLatitude",
                         "bind": "{villageLatitude}",
                         "columnWidth": 0.5
                    }, {
                         "name": "villageLongtitude",
                         "itemId": "villageLongtitude",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Village Longitude",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Village Longitude",
                         "fieldId": "1D4010DB-4CEA-4F12-8043-22B629CD8AE9",
                         "minValue": "0",
                         "maxValue": "11",
                         "bindable": "villageLongtitude",
                         "bind": "{villageLongtitude}",
                         "columnWidth": 0.5
                    }, {
                         "name": "versionId",
                         "itemId": "versionId",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "versionId",
                         "margin": "5 5 5 5",
                         "value": "-1",
                         "fieldLabel": "versionId",
                         "fieldId": "E6931A5F-A9CB-4F46-9A46-E1AA8E83A583",
                         "bindable": "versionId",
                         "bind": "{versionId}",
                         "hidden": true
                    }],
                    "layout": "column",
                    "defaults": {
                         "columnWidth": 0.5,
                         "labelAlign": "left",
                         "labelWidth": 200
                    },
                    "autoScroll": true,
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "ui": "footer",
                         "isDockedItem": true,
                         "parentId": 1,
                         "customId": 475,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 475,
                              "customId": 946
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 475,
                              "customId": 947,
                              "listeners": {
                                   "click": "saveForm"
                              }
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Reset",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "resetFormButton",
                              "parentId": 475,
                              "customId": 948,
                              "listeners": {
                                   "click": "resetForm"
                              }
                         }],
                         "defaults": {}
                    }],
                    "listeners": {
                         "scope": "controller"
                    },
                    "tools": [{
                         "type": "help",
                         "tooltip": "Console",
                         "handler": "onConsoleClick"
                    }, {
                         "type": "refresh",
                         "tooltip": "Refresh Tab",
                         "handler": "init"
                    }],
                    "extend": "Ext.form.Panel",
                    "region": "center"
               }, {
                    "xtype": "gridpanel",
                    "customWidgetType": "vdGrid",
                    "displayName": "Village",
                    "title": "Details Grid",
                    "name": "VillageGrid",
                    "itemId": "VillageGrid",
                    "restURL": "/Village",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "Village Id",
                         "dataIndex": "villageId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryDisplay",
                         "dataIndex": "primaryDisplay",
                         "hidden": true
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "Village Name",
                         "dataIndex": "villageName",
                         "flex": 1
                    }, {
                         "header": "Village Description",
                         "dataIndex": "villageDescription",
                         "flex": 1
                    }, {
                         "header": "Village taluka",
                         "dataIndex": "villageFlag",
                         "flex": 1
                    }, {
                         "header": "Country",
                         "dataIndex": "countryId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "State",
                         "dataIndex": "stateId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Region",
                         "dataIndex": "regionId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "District",
                         "dataIndex": "districtId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "talukaa",
                         "dataIndex": "talukaaId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Village Code",
                         "dataIndex": "villageCode",
                         "flex": 1
                    }, {
                         "header": "Village Latitude",
                         "dataIndex": "villageLatitude",
                         "flex": 1
                    }, {
                         "header": "Village Longitude",
                         "dataIndex": "villageLongtitude",
                         "flex": 1
                    }, {
                         "header": "createdBy",
                         "dataIndex": "createdBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "createdDate",
                         "dataIndex": "createdDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedBy",
                         "dataIndex": "updatedBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedDate",
                         "dataIndex": "updatedDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "versionId",
                         "dataIndex": "versionId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "activeStatus",
                         "dataIndex": "activeStatus",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "txnAccessCode",
                         "dataIndex": "txnAccessCode",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "xtype": "actioncolumn",
                         "customWidgetType": "vdActionColumn",
                         "width": 30,
                         "sortable": false,
                         "menuDisable": true,
                         "items": [{
                              "icon": "images/delete.gif",
                              "tooltip": "Delete Record",
                              "handler": "onDeleteActionColumnClickMainGrid"
                         }]
                    }],
                    "listeners": {
                         "itemclick": "onGridItemClick"
                    },
                    "tools": [{
                         "type": "refresh",
                         "tooltip": "Refresh Grid Data",
                         "handler": "onGridRefreshClick"
                    }],
                    "collapsible": true,
                    "titleCollapse": true,
                    "collapseMode": "header",
                    "region": "south",
                    "height": "40%"
               }]
          }]
     }, {
          "title": "Add New",
          "itemId": "addNewForm",
          "layout": "border",
          "customWidgetType": "vdBorderLayout",
          "autoScroll": false,
          "items": [{
               "customWidgetType": "vdFormpanel",
               "viewModel": "VillageViewModel",
               "xtype": "form",
               "displayName": "Village",
               "title": "Village",
               "name": "Village",
               "itemId": "Village",
               "bodyPadding": 10,
               "items": [{
                    "name": "villageId",
                    "itemId": "villageId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Village Id",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Village Id<font color='red'> *<\/font>",
                    "fieldId": "9F68ED10-2CA7-4E4A-BCAA-B8515387448B",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "villageId",
                    "bind": "{villageId}"
               }, {
                    "name": "villageName",
                    "itemId": "villageName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Village Name",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Village Name<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "99ECDE66-0FAE-4F25-88E2-2F3092C1260E",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "villageName",
                    "bind": "{villageName}",
                    "columnWidth": 0.5
               }, {
                    "name": "villageDescription",
                    "itemId": "villageDescription",
                    "xtype": "textareafield",
                    "customWidgetType": "vdTextareafield",
                    "displayName": "Village Description",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Village Description",
                    "fieldId": "7DBE6E9E-480B-4CCB-9703-BFF9ED3187AD",
                    "bindable": "villageDescription",
                    "bind": "{villageDescription}",
                    "columnWidth": 0.5
               }, {
                    "name": "villageFlag",
                    "itemId": "villageFlag",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Village taluka",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Village taluka",
                    "fieldId": "EDD44DD7-6B6C-49B0-9EE6-2826CC5D0B7D",
                    "minLength": "0",
                    "maxLength": "64",
                    "bindable": "villageFlag",
                    "bind": "{villageFlag}",
                    "columnWidth": 0.5
               }, {
                    "name": "countryId",
                    "itemId": "countryId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Country",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Country<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "3713B264-DAC4-4BDD-B69A-0CC7410B3A5B",
                    "restURL": "Country",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Project.project.shared.project.model.location.CountryModel"
                    },
                    "bindable": "countryId",
                    "bind": "{countryId}",
                    "columnWidth": 0.5,
                    "listeners": {
                         "change": "onCountryIdChange"
                    }
               }, {
                    "name": "stateId",
                    "itemId": "stateId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "State",
                    "margin": "5 5 5 5",
                    "fieldLabel": "State<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "1ADD2E1E-7819-4B8C-B132-6C800D5538DD",
                    "restURL": "State",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Project.project.shared.project.model.location.StateModel"
                    },
                    "bindable": "stateId",
                    "bind": "{stateId}",
                    "columnWidth": 0.5,
                    "listeners": {
                         "change": "onStateIdChange"
                    }
               }, {
                    "name": "regionId",
                    "itemId": "regionId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Region",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Region<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "178E1828-9493-487F-BD4C-9EF7EF3C6176",
                    "restURL": "Region",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Project.project.shared.project.model.location.RegionModel"
                    },
                    "bindable": "regionId",
                    "bind": "{regionId}",
                    "columnWidth": 0.5,
                    "listeners": {
                         "change": "onRegionIdChange"
                    }
               }, {
                    "name": "districtId",
                    "itemId": "districtId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "District",
                    "margin": "5 5 5 5",
                    "fieldLabel": "District<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "C11DDC32-D0D4-4F90-B9B8-D9E231F97BCE",
                    "restURL": "District",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Project.project.shared.project.model.location.DistrictModel"
                    },
                    "bindable": "districtId",
                    "bind": "{districtId}",
                    "columnWidth": 0.5,
                    "listeners": {
                         "change": "onDistrictIdChange"
                    }
               }, {
                    "name": "talukaaId",
                    "itemId": "talukaaId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "talukaa",
                    "margin": "5 5 5 5",
                    "fieldLabel": "talukaa<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "5869D360-270F-480D-B8E4-EEA3F931C81A",
                    "restURL": "Taluka",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Project.project.shared.project.model.location.TalukaModel"
                    },
                    "bindable": "talukaaId",
                    "bind": "{talukaaId}",
                    "columnWidth": 0.5
               }, {
                    "name": "villageCode",
                    "itemId": "villageCode",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Village Code",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Village Code<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "616D8A29-0BDC-482B-ACAF-2A113D70AB9E",
                    "minLength": "0",
                    "maxLength": "32",
                    "bindable": "villageCode",
                    "bind": "{villageCode}",
                    "columnWidth": 0.5
               }, {
                    "name": "villageLatitude",
                    "itemId": "villageLatitude",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Village Latitude",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Village Latitude",
                    "fieldId": "BE2F1349-9ECA-4954-B6BC-7D607EA8631F",
                    "minValue": "0",
                    "maxValue": "11",
                    "bindable": "villageLatitude",
                    "bind": "{villageLatitude}",
                    "columnWidth": 0.5
               }, {
                    "name": "villageLongtitude",
                    "itemId": "villageLongtitude",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Village Longitude",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Village Longitude",
                    "fieldId": "1D4010DB-4CEA-4F12-8043-22B629CD8AE9",
                    "minValue": "0",
                    "maxValue": "11",
                    "bindable": "villageLongtitude",
                    "bind": "{villageLongtitude}",
                    "columnWidth": 0.5
               }, {
                    "name": "versionId",
                    "itemId": "versionId",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "versionId",
                    "margin": "5 5 5 5",
                    "value": "-1",
                    "fieldLabel": "versionId",
                    "fieldId": "E6931A5F-A9CB-4F46-9A46-E1AA8E83A583",
                    "bindable": "versionId",
                    "bind": "{versionId}",
                    "hidden": true
               }],
               "layout": "column",
               "defaults": {
                    "columnWidth": 0.5,
                    "labelAlign": "left",
                    "labelWidth": 200
               },
               "autoScroll": true,
               "dockedItems": [{
                    "xtype ": "toolbar",
                    "customWidgetType": "vdBBar",
                    "dock": "bottom",
                    "ui": "footer",
                    "isDockedItem": true,
                    "parentId": 1,
                    "customId": 475,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 475,
                         "customId": 946
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 475,
                         "customId": 947,
                         "listeners": {
                              "click": "saveForm"
                         }
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Reset",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "resetFormButton",
                         "parentId": 475,
                         "customId": 948,
                         "listeners": {
                              "click": "resetForm"
                         }
                    }],
                    "defaults": {}
               }],
               "listeners": {
                    "scope": "controller"
               },
               "tools": [{
                    "type": "help",
                    "tooltip": "Console",
                    "handler": "onConsoleClick"
               }, {
                    "type": "refresh",
                    "tooltip": "Refresh Tab",
                    "handler": "init"
               }],
               "extend": "Ext.form.Panel",
               "region": "center"
          }]
     }]
});