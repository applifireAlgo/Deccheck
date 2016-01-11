Ext.define('Project.view.fw.component.DateFields',{
	extend:'Ext.form.Date',
	xtype:'datefields',
	
	getValue:function()
	{
		if(this.value){
			if(this.value.constructor == Date){
				return this.value.getTime();
			}else{
				try{
					var d = new Date(this.value);
					return d.getTime();
				}catch(ee){
					return new Date().getTime();				
				}
			}
		}
			
	}
});