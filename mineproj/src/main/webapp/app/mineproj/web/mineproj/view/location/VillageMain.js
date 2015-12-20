Ext.define('Mineproj.mineproj.web.mineproj.view.location.VillageMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "VillageMainController",
     "restURL": "/Village",
     "defaults": {
          "split": true
     },
     "requires": ["Mineproj.mineproj.shared.mineproj.model.location.VillageModel", "Mineproj.mineproj.web.mineproj.controller.location.VillageMainController", "Mineproj.mineproj.shared.mineproj.model.location.CountryModel", "Mineproj.mineproj.shared.mineproj.model.location.StateModel", "Mineproj.mineproj.shared.mineproj.model.location.RegionModel", "Mineproj.mineproj.shared.mineproj.model.location.DistrictModel", "Mineproj.mineproj.shared.mineproj.model.location.TalukaModel", "Mineproj.mineproj.shared.mineproj.viewmodel.location.VillageViewModel"],
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
                         "fieldId": "8EFB5403-BCA4-4ACB-87AB-4BC421E6534A",
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
                         "fieldId": "7D768DA2-8FF0-499F-A993-613D6887C6B6",
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
                         "fieldId": "28CD9F14-425F-4D5F-A635-BC0EC6F9F70A",
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
                         "fieldId": "BD84B88F-BAC0-4EA5-AF35-52DFF0CEBE0F",
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
                         "fieldId": "AEFD41BC-D804-48B4-AE1F-CE0930D68612",
                         "restURL": "Country",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Mineproj.mineproj.shared.mineproj.model.location.CountryModel"
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
                         "fieldId": "3C7F2FFF-187C-4C2A-8F4C-86F2598DBF62",
                         "restURL": "State",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Mineproj.mineproj.shared.mineproj.model.location.StateModel"
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
                         "fieldId": "EA98EBAA-C270-4673-BABC-5917915BECF9",
                         "restURL": "Region",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Mineproj.mineproj.shared.mineproj.model.location.RegionModel"
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
                         "fieldId": "A2C9C49B-871B-4114-B401-6D74FD3DD96F",
                         "restURL": "District",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Mineproj.mineproj.shared.mineproj.model.location.DistrictModel"
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
                         "fieldId": "06669C95-52BF-44B1-B090-4241AB805D18",
                         "restURL": "Taluka",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Mineproj.mineproj.shared.mineproj.model.location.TalukaModel"
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
                         "fieldId": "9B7E07B5-C281-40F4-989D-E22A73388D73",
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
                         "fieldId": "3AC7EC44-1401-41D9-A908-2AC390D5423A",
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
                         "fieldId": "21082FB7-4130-4164-A836-FA7D692B7237",
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
                         "fieldId": "A759D3B1-F8C1-4CE0-9249-CC82140DCA3E",
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
                         "customId": 688,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 688,
                              "customId": 645
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 688,
                              "customId": 646,
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
                              "parentId": 688,
                              "customId": 647,
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
                    "fieldId": "8EFB5403-BCA4-4ACB-87AB-4BC421E6534A",
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
                    "fieldId": "7D768DA2-8FF0-499F-A993-613D6887C6B6",
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
                    "fieldId": "28CD9F14-425F-4D5F-A635-BC0EC6F9F70A",
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
                    "fieldId": "BD84B88F-BAC0-4EA5-AF35-52DFF0CEBE0F",
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
                    "fieldId": "AEFD41BC-D804-48B4-AE1F-CE0930D68612",
                    "restURL": "Country",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Mineproj.mineproj.shared.mineproj.model.location.CountryModel"
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
                    "fieldId": "3C7F2FFF-187C-4C2A-8F4C-86F2598DBF62",
                    "restURL": "State",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Mineproj.mineproj.shared.mineproj.model.location.StateModel"
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
                    "fieldId": "EA98EBAA-C270-4673-BABC-5917915BECF9",
                    "restURL": "Region",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Mineproj.mineproj.shared.mineproj.model.location.RegionModel"
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
                    "fieldId": "A2C9C49B-871B-4114-B401-6D74FD3DD96F",
                    "restURL": "District",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Mineproj.mineproj.shared.mineproj.model.location.DistrictModel"
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
                    "fieldId": "06669C95-52BF-44B1-B090-4241AB805D18",
                    "restURL": "Taluka",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Mineproj.mineproj.shared.mineproj.model.location.TalukaModel"
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
                    "fieldId": "9B7E07B5-C281-40F4-989D-E22A73388D73",
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
                    "fieldId": "3AC7EC44-1401-41D9-A908-2AC390D5423A",
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
                    "fieldId": "21082FB7-4130-4164-A836-FA7D692B7237",
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
                    "fieldId": "A759D3B1-F8C1-4CE0-9249-CC82140DCA3E",
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
                    "customId": 688,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 688,
                         "customId": 645
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 688,
                         "customId": 646,
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
                         "parentId": 688,
                         "customId": 647,
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