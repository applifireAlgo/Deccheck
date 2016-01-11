Ext.define('Project.view.databrowsercalendar.DBCalendar', {
	extend : 'Project.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Project.view.databrowsercalendar.DBCalendarController',
	             'Project.view.databrowsercalendar.DBCalendarView'],
	controller : 'databrowsercalendar',
	items : [ ],
	listeners : {
		afterrender : 'loadData',
		scope : "controller"
	}
});
