package org.cjh.javabasic.syntax.array;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/**
 * 注解对象的初始化, 即会用到初始化常量(基本数据类型的常量,对象常量,数组常量)
 * 
 */
public class AnnotationInitTest {

	@Target({ElementType.METHOD})
	@Retention(RetentionPolicy.RUNTIME)
	private static @interface TaskInfo {
		String name();

		String[] candidates();

		int amount();
		
		int beginTime() default 0; //0表示从现在开始
		int endTime() default -1; //-1表示未知
	}

	private static interface Job {
		void doJob();
	}

	private static class EarnMoney implements Job {

		@Override
		@TaskInfo(name = "earn money", candidates = { "male", "female" }, amount = 100)
		public void doJob() {
			System.out.println("earn many money");
		}
	}

	private static class Marry implements Job {

		@Override
		@TaskInfo(name = "marry", candidates = { "male" }, amount = 1)
		public void doJob() {
			System.out.println("marry a person");
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		Job earn = new EarnMoney();
		Job marry = new Marry();
		
		Method e = earn.getClass().getMethod("doJob", new Class[] {});
		Method m = marry.getClass().getMethod("doJob", new Class[] {});
		
		TaskInfo ti = e.getAnnotation(TaskInfo.class);
		System.out.println(ti);
		ti = m.getAnnotation(TaskInfo.class);
		System.out.println(ti);
	}
}
