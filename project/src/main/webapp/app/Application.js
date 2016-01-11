/**
 * The main application class. An instance of this class is created by app.js when it calls
 * Ext.application(). This is the ideal place to handle application launch and initialization
 * details.
 */
Ext.define('Project.Application', {
    extend: 'Ext.app.Application',
    
    name: 'Project',

    requires:['Ext.*','Ext.ux.*'],
    
    views: [
        
    ],

    controllers: [
        'Root'
    ],

    stores: [
            'Project.store.QueryCriteriaWidgetsStore'
    ],
    
    launch: function () {
    }
});

var sessionTimeOutFlag = false;

/**isMultiForm**/ var isMultiTab = true;


Ext.Ajax.on('beforerequest', function(connection,options, eOpts){
	
	if(options.maskEnable){
		if(options.maskEle != null){
			options.maskEle.mask('Request processing...');
		}else{
			Ext.getBody().mask('Request processing...');
		}
	}
});

Ext.Ajax.on('requestcomplete', function(conn, response, options, eOpts){
	
	var responseData = Ext.JSON.decode(response.responseText);
	if(responseData.response ){
		if(responseData.response.exceptionId == 4005 && !sessionTimeOutFlag){
			
			
			sessionTimeOutFlag = true;
			var loginWindow = Ext.create('Project.view.login.SessionLogin').center();
	        loginWindow.currentRequest = options;
	        loginWindow.show();
		}
	}
	
	if(options.maskEnable){
		if(options.maskEle != null){
			options.maskEle.unmask();
		}else{
			Ext.getBody().unmask();
		}
	}
});

Ext.Ajax.on('requestexception', function(conn, response, options, eOpts){

	if(options.maskEnable){
		if(options.maskEle != null){
			options.maskEle.unmask();
		}else{
			Ext.getBody().unmask();
		}
	}
});

