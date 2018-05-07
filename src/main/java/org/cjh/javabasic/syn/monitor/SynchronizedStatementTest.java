package org.cjh.javabasic.syn.monitor;


/**
 * 观察java compiler对synchronized语句的字节码的改变.
 * synchronized method不适用,仅仅synchronized statement适用(这是jvm中关于java的说明)
 * 
 * java compiler会在恰当的地方插入monitorenter/monitorexit,来实现jls中描述的acquire/release monitor lock
 * synchronized保护的区域加锁/解锁会被成对执行,这是java compiler作出的对java中synchronized语义的实现.
 * 但是这个语义是java的规定,并不适用于jvm,jvm和java是独立的概念.
 * jvm提供的monitorenter/monitorexit指令是可以单独使用的,不必成执行.关于指令的解释参考jvm specification文档
 *
 */
public class SynchronizedStatementTest {

	private static Object lock = new Object();
	private static int counter = 0;
	
	/**
	  private static void foo();
	    flags: ACC_PRIVATE, ACC_STATIC
	    Code:
	      stack=3, locals=1, args_size=0
	         0: getstatic     #15                 // Field lock:Ljava/lang/Object;
	         3: dup           
	         4: astore_0      
	         5: monitorenter  
	         6: getstatic     #30                 // Field java/lang/System.out:Ljava/io/PrintStream;
	         9: getstatic     #17                 // Field counter:I
	        12: iconst_1      
	        13: iadd          
	        14: dup           
	        15: putstatic     #17                 // Field counter:I
	        18: invokevirtual #36                 // Method java/io/PrintStream.println:(I)V
	        21: aload_0       
	        22: monitorexit   
	        23: goto          29
	        26: aload_0       
	        27: monitorexit   
	        28: athrow        
	        29: return        
	      Exception table:
	         from    to  target type
	             6    23    26   any
	            26    28    26   any
	 */
	private static void foo() {
		synchronized(lock) {
			counter++;
			System.out.println(++counter);
		}
	}
	
	public static void main(String[] args) {
		foo();
	}
}
