Ext.define('Project.project.web.project.view.customers.AppCustomerMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "AppCustomerMainController",
     "restURL": "/AppCustomer",
     "defaults": {
          "split": true
     },
     "requires": ["Project.project.shared.project.model.customers.AppCustomerModel", "Project.project.web.project.controller.customers.AppCustomerMainController", "Project.project.shared.project.model.contacts.CoreContactsModel", "Project.project.shared.project.model.customers.AppCustomerTypeModel", "Project.project.shared.project.model.customers.AppCustomerCategoryModel", "Project.project.shared.project.viewmodel.customers.AppCustomerViewModel"],
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
               "displayName": "AppCustomer",
               "name": "AppCustomerTreeContainer",
               "itemId": "AppCustomerTreeContainer",
               "restURL": "/AppCustomer",
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
                    "itemId": "AppCustomerTree",
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
                    "items": [{
                         "name": "customerName",
                         "itemId": "customerName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Name",
                         "fieldId": "B4785A68-631A-4E8F-A4B6-7A67C81F9AB2",
                         "minLength": "0",
                         "maxLength": "65535"
                    }]
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
                    "viewModel": "AppCustomerViewModel",
                    "xtype": "form",
                    "displayName": "AppCustomer",
                    "title": "AppCustomer",
                    "name": "AppCustomer",
                    "itemId": "AppCustomer",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "appCustomerId",
                         "itemId": "appCustomerId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "AppCustomer Id",
                         "margin": "5 5 5 5",
                         "fieldLabel": "AppCustomer Id<font color='red'> *<\/font>",
                         "fieldId": "9B0F1EED-B8CA-4304-B7B5-CC6284BE10A4",
                         "hidden": true,
                         "value": "",
                         "bindable": "appCustomerId",
                         "bind": "{appCustomerId}"
                    }, {
                         "name": "customerName",
                         "itemId": "customerName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Name<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "B4785A68-631A-4E8F-A4B6-7A67C81F9AB2",
                         "minLength": "0",
                         "maxLength": "65535",
                         "bindable": "customerName",
                         "bind": "{customerName}",
                         "columnWidth": 0.5
                    }, {
                         "name": "contactId",
                         "itemId": "contactId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Contact",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Contact<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "AB8E57AF-C5CE-49B7-8967-B1330C46AB2C",
                         "restURL": "CoreContacts",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Project.project.shared.project.model.contacts.CoreContactsModel"
                         },
                         "bindable": "contactId",
                         "bind": "{contactId}",
                         "columnWidth": 0.5
                    }, {
                         "name": "appCustomerType",
                         "itemId": "appCustomerType",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Customer Type",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Customer Type<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "BF0BF2F7-64A7-41A2-BED4-5F088B178F9B",
                         "restURL": "AppCustomerType",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Project.project.shared.project.model.customers.AppCustomerTypeModel"
                         },
                         "bindable": "appCustomerType",
                         "bind": "{appCustomerType}",
                         "columnWidth": 0.5
                    }, {
                         "name": "appCustomerCategory",
                         "itemId": "appCustomerCategory",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Customer Category",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Customer Category<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "A8E02C42-6F0C-4D25-941C-72975CAEE33B",
                         "restURL": "AppCustomerCategory",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Project.project.shared.project.model.customers.AppCustomerCategoryModel"
                         },
                         "bindable": "appCustomerCategory",
                         "bind": "{appCustomerCategory}",
                         "columnWidth": 0.5
                    }, {
                         "name": "deploymentModel",
                         "itemId": "deploymentModel",
                         "xtype": "checkbox",
                         "customWidgetType": "vdCheckbox",
                         "displayName": "Deployment Model",
                         "margin": "5 5 5 5",
                         "value": "1",
                         "inputValue": true,
                         "fieldLabel": "Deployment Model<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "69DF08C6-5937-44F6-9340-5C609BFA4AE2",
                         "bindable": "deploymentModel",
                         "bind": "{deploymentModel}",
                         "columnWidth": 0.5
                    }, {
                         "name": "customerStatus",
                         "itemId": "customerStatus",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Customer Status",
                         "margin": "5 5 5 5",
                         "value": "1",
                         "fieldLabel": "Customer Status<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "AF58BDB1-B3E7-4582-8DD1-7EF0F1A14534",
                         "minValue": "0",
                         "maxValue": "1",
                         "bindable": "customerStatus",
                         "bind": "{customerStatus}",
                         "columnWidth": 0.5
                    }, {
                         "name": "userRequested",
                         "itemId": "userRequested",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "User Requested",
                         "margin": "5 5 5 5",
                         "value": "1",
                         "fieldLabel": "User Requested<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "4F49247D-CC76-47E9-A892-0CD2ABD3F291",
                         "minValue": "-2147483648",
                         "maxValue": "2147483647",
                         "bindable": "userRequested",
                         "bind": "{userRequested}",
                         "columnWidth": 0.5
                    }, {
                         "name": "evalTimePeriod",
                         "itemId": "evalTimePeriod",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Eval Time Period",
                         "margin": "5 5 5 5",
                         "value": "60",
                         "fieldLabel": "Eval Time Period<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "C433891A-76C1-4C8F-A1A0-4DEB629317C2",
                         "minValue": "-2147483648",
                         "maxValue": "2147483647",
                         "bindable": "evalTimePeriod",
                         "bind": "{evalTimePeriod}",
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
                         "fieldId": "0DF0D6EF-1FFF-41C5-BAFC-B19F557079FC",
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
                         "customId": 931,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 931,
                              "customId": 775
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 931,
                              "customId": 776,
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
                              "parentId": 931,
                              "customId": 777,
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
                    "displayName": "AppCustomer",
                    "title": "Details Grid",
                    "name": "AppCustomerGrid",
                    "itemId": "AppCustomerGrid",
                    "restURL": "/AppCustomer",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "AppCustomer Id",
                         "dataIndex": "appCustomerId",
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
                         "header": "Name",
                         "dataIndex": "customerName",
                         "flex": 1
                    }, {
                         "header": "Contact",
                         "dataIndex": "contactId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Customer Type",
                         "dataIndex": "appCustomerType",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Customer Category",
                         "dataIndex": "appCustomerCategory",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Deployment Model",
                         "dataIndex": "deploymentModel",
                         "flex": 1
                    }, {
                         "header": "Customer Status",
                         "dataIndex": "customerStatus",
                         "flex": 1
                    }, {
                         "header": "User Requested",
                         "dataIndex": "userRequested",
                         "flex": 1
                    }, {
                         "header": "Eval Time Period",
                         "dataIndex": "evalTimePeriod",
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
               "viewModel": "AppCustomerViewModel",
               "xtype": "form",
               "displayName": "AppCustomer",
               "title": "AppCustomer",
               "name": "AppCustomer",
               "itemId": "AppCustomer",
               "bodyPadding": 10,
               "items": [{
                    "name": "appCustomerId",
                    "itemId": "appCustomerId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "AppCustomer Id",
                    "margin": "5 5 5 5",
                    "fieldLabel": "AppCustomer Id<font color='red'> *<\/font>",
                    "fieldId": "9B0F1EED-B8CA-4304-B7B5-CC6284BE10A4",
                    "hidden": true,
                    "value": "",
                    "bindable": "appCustomerId",
                    "bind": "{appCustomerId}"
               }, {
                    "name": "customerName",
                    "itemId": "customerName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Name",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Name<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "B4785A68-631A-4E8F-A4B6-7A67C81F9AB2",
                    "minLength": "0",
                    "maxLength": "65535",
                    "bindable": "customerName",
                    "bind": "{customerName}",
                    "columnWidth": 0.5
               }, {
                    "name": "contactId",
                    "itemId": "contactId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Contact",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Contact<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "AB8E57AF-C5CE-49B7-8967-B1330C46AB2C",
                    "restURL": "CoreContacts",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Project.project.shared.project.model.contacts.CoreContactsModel"
                    },
                    "bindable": "contactId",
                    "bind": "{contactId}",
                    "columnWidth": 0.5
               }, {
                    "name": "appCustomerType",
                    "itemId": "appCustomerType",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Customer Type",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Customer Type<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "BF0BF2F7-64A7-41A2-BED4-5F088B178F9B",
                    "restURL": "AppCustomerType",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Project.project.shared.project.model.customers.AppCustomerTypeModel"
                    },
                    "bindable": "appCustomerType",
                    "bind": "{appCustomerType}",
                    "columnWidth": 0.5
               }, {
                    "name": "appCustomerCategory",
                    "itemId": "appCustomerCategory",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Customer Category",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Customer Category<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "A8E02C42-6F0C-4D25-941C-72975CAEE33B",
                    "restURL": "AppCustomerCategory",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Project.project.shared.project.model.customers.AppCustomerCategoryModel"
                    },
                    "bindable": "appCustomerCategory",
                    "bind": "{appCustomerCategory}",
                    "columnWidth": 0.5
               }, {
                    "name": "deploymentModel",
                    "itemId": "deploymentModel",
                    "xtype": "checkbox",
                    "customWidgetType": "vdCheckbox",
                    "displayName": "Deployment Model",
                    "margin": "5 5 5 5",
                    "value": "1",
                    "inputValue": true,
                    "fieldLabel": "Deployment Model<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "69DF08C6-5937-44F6-9340-5C609BFA4AE2",
                    "bindable": "deploymentModel",
                    "bind": "{deploymentModel}",
                    "columnWidth": 0.5
               }, {
                    "name": "customerStatus",
                    "itemId": "customerStatus",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Customer Status",
                    "margin": "5 5 5 5",
                    "value": "1",
                    "fieldLabel": "Customer Status<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "AF58BDB1-B3E7-4582-8DD1-7EF0F1A14534",
                    "minValue": "0",
                    "maxValue": "1",
                    "bindable": "customerStatus",
                    "bind": "{customerStatus}",
                    "columnWidth": 0.5
               }, {
                    "name": "userRequested",
                    "itemId": "userRequested",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "User Requested",
                    "margin": "5 5 5 5",
                    "value": "1",
                    "fieldLabel": "User Requested<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "4F49247D-CC76-47E9-A892-0CD2ABD3F291",
                    "minValue": "-2147483648",
                    "maxValue": "2147483647",
                    "bindable": "userRequested",
                    "bind": "{userRequested}",
                    "columnWidth": 0.5
               }, {
                    "name": "evalTimePeriod",
                    "itemId": "evalTimePeriod",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Eval Time Period",
                    "margin": "5 5 5 5",
                    "value": "60",
                    "fieldLabel": "Eval Time Period<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "C433891A-76C1-4C8F-A1A0-4DEB629317C2",
                    "minValue": "-2147483648",
                    "maxValue": "2147483647",
                    "bindable": "evalTimePeriod",
                    "bind": "{evalTimePeriod}",
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
                    "fieldId": "0DF0D6EF-1FFF-41C5-BAFC-B19F557079FC",
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
                    "customId": 931,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 931,
                         "customId": 775
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 931,
                         "customId": 776,
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
                         "parentId": 931,
                         "customId": 777,
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