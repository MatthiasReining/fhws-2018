package de.fhws.app.presentation.ejb;

import java.util.Date;

import javax.ejb.Schedule;
import javax.ejb.Singleton;

@Singleton
public class SchedulerService {

	@Schedule(hour="*", minute="*", second="*/5", persistent=true)
	public void datePrinter() {
		System.out.println("scheduler prints " + new Date());
	}
}
