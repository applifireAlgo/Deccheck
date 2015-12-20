/*
 * This file is generated and updated by Sencha Cmd. You can edit this file as
 * needed for your application, but these edits will have to be merged by
 * Sencha Cmd when upgrading.
 */
Ext.application({
    name: 'Sales',

    extend: 'Sales.Application',
    
/**AppPathDetails**/autoCreateViewport: (Ext.os.deviceType=='Desktop')?'Sales.view.mainleftmenutree.MainPanel':'Sales.view.mobileview.login.Login',
    //autoCreateViewport: (Ext.os.deviceType=='Desktop')?'Sales.view.login.LoginPage':'Sales.view.mobileview.login.LoginPage',//'Sales.view.login.Login'
    	
    //-------------------------------------------------------------------------
    // Most customizations should be made to Sales.Application. If you need to
    // customize this file, doing so below this section reduces the likelihood
    // of merge conflicts when upgrading to new versions of Sencha Cmd.
    //-------------------------------------------------------------------------
});
