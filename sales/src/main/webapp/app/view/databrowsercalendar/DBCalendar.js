Ext.define('Sales.view.databrowsercalendar.DBCalendar', {
	extend : 'Sales.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Sales.view.databrowsercalendar.DBCalendarController',
	             'Sales.view.databrowsercalendar.DBCalendarView'],
	controller : 'databrowsercalendar',
	items : [ ],
	listeners : {
		afterrender : 'loadData',
		scope : "controller"
	}
});
