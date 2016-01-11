Ext.define('Project.view.mainleftmenutree.TopPanel.TopPanel', {
	extend : 'Ext.toolbar.Toolbar',
	xtype : 'menuTopPanel',
	requires : [ 'Project.view.mainleftmenutree.TopPanel.TopPanelController' ],
	controller : 'menuTopPanelController',
	style : {
		backgroundColor: "#fff"
	},
	margin : '0 0 2 0',
	layout :'hbox',
	items : [{
		xtype : 'button',
		icon : 'images/menu/menu.png', 
		style : {
			backgroundColor: "transparent",
			border : 0
		},
		scale : 'medium',		
		action : 'menuBtnToggle',
		itemId: 'appplicationMainMenuBtn',
		pressed : true,
		tooltip : 'Menu',
		enableToggle : true
	},{
		xtype:'textfield',
		itemId:'searchField',
		emptyText:'Search',
		width:'35%',
		height:30
	},{
		xtype:'combobox',
		itemId : 'Lang',
		//fieldLabel:'Language',
		width:'8%',
		height:30,
		valueField : 'value',
		displayField : 'name',
		//labelWidth:70,
		store : Ext.create('Ext.data.ArrayStore',{
					fields : [ {
						name : 'name',
						type : 'string'
					}, {
						name : 'value',
						type : 'string',
					} ],
					proxy : {
						type : 'ajax',
						url : 'secure/SearchEngineController/getAvailableLanguages',
						reader : {
							type : 'json'
						}
					}
		}),
		listeners : {
			'afterrender' : function(combo) {
				combo.store.load({
					scope : this,
					callback : function(records,
							operation, success) {

						 this.setValue(records[0].data.value);
					}
				});
			}
		}
	},
	{
		xtype : 'button',
		name : 'img',
		itemId : 'voice',
		icon : 'images/menu/mic.png',
		scale : 'medium',
		tooltip:'voice search',
		style : {
			backgroundColor: "transparent",
			border : 0
		},
		listeners:{
			click:'onVoiceSearchClick'
		}
	},{
		xtype:'button',
		icon:'images/menu/search.png',
		style : {
			backgroundColor: "transparent",
			border : 0
		},
		scale:'medium',
		tooltip:'search',
		listeners : {
			click : 'onSearchClick'
		}
	},{
		xtype: 'tbfill'
	}, '->',
	{
		xtype:'displayfield',
		itemId:'userNameDField'
	},{
		xtype:'splitbutton',
		itemId:'userDp',
		//icon:'images/user/userdp.png',
		height:48,
		width:48,
		cls:'topToolbarSplitBtnAfter',
		scale: "large",
		style: "border:0;background-color:#fff;padding-bottom:0px;border-radius: 50%;background-image: url('images/user/userdp.png');background-repeat: no-repeat;",
		menu:[
		      {
		    	  text:'My Profile',
		    	  icon:'images/menu/myprofile.png',
		    	  listeners:{
						click:'onMyProfileClick',
		    	  }
		      },{
		    	  text:'Change Password',
		    	  icon:'images/menu/pwdReset.png',
		    	  listeners:{
						click:'onChangePwdClick',
		    	  }
		      },'-',
		      {
		    	  text:'Cloud Drive',
		    	  icon:'images/menu/clouddrive.png',
		    	  listeners:{
						click:'onCloudClick',
		    	  }
		      },'-',
		      {
		    	  text:'Log Out',
		    	  icon:'images/menu/logout.png',
		    	  listeners:{
						click:'onLogoutClick',
		    	  }
		      }]
	}],
	listeners:{
		scope:'controller',
		afterrender:'afterTopPanelRender'
	}
});