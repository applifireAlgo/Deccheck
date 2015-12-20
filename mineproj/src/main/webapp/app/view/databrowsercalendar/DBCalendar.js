Ext.define('Mineproj.view.databrowsercalendar.DBCalendar', {
	extend : 'Mineproj.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Mineproj.view.databrowsercalendar.DBCalendarController',
	             'Mineproj.view.databrowsercalendar.DBCalendarView'],
	controller : 'databrowsercalendar',
	items : [ ],
	listeners : {
		afterrender : 'loadData',
		scope : "controller"
	}
});
