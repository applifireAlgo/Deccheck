/*
 * This file is generated and updated by Sencha Cmd. You can edit this file as
 * needed for your application, but these edits will have to be merged by
 * Sencha Cmd when upgrading.
 */
Ext.application({
    name: 'Mineproj',

    extend: 'Mineproj.Application',
    
/**AppPathDetails**/autoCreateViewport: (Ext.os.deviceType=='Desktop')?'Mineproj.view.mainleftmenutree.MainPanel':'Mineproj.view.mobileview.login.Login',
    //autoCreateViewport: (Ext.os.deviceType=='Desktop')?'Mineproj.view.login.LoginPage':'Mineproj.view.mobileview.login.LoginPage',//'Mineproj.view.login.Login'
    	
    //-------------------------------------------------------------------------
    // Most customizations should be made to Mineproj.Application. If you need to
    // customize this file, doing so below this section reduces the likelihood
    // of merge conflicts when upgrading to new versions of Sencha Cmd.
    //-------------------------------------------------------------------------
});
