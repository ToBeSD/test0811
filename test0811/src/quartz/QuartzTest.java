package quartz;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzTest {
	public static Scheduler sched; 
	
	public QuartzTest () throws Exception {
		SchedulerFactory sf = new StdSchedulerFactory();
		sched = sf.getScheduler();
		
		JobDetail job = JobBuilder.newJob(MyJob.class)
					.withIdentity("myjob", "group1")
					.build();
		
		Trigger trigger = TriggerBuilder.newTrigger()
					.withIdentity("myTrigger", "group1")
					.startNow()
					.withSchedule(SimpleScheduleBuilder.simpleSchedule()
							.withIntervalInSeconds(3)
							.repeatForever())
					.build();

		sched.scheduleJob(job, trigger);
	}
	
	public void start() throws Exception {
		System.out.println("<< 포인트 스케줄러가 시작되었습니다. >>");
		sched.start();
	}
	
}







