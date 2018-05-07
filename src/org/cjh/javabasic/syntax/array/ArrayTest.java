package org.cjh.javabasic.syntax.array;

/**
 * 记录数组的不同写法.
 * 关键词:初始化数组常量
 *
 */
public class ArrayTest {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		String[] msgs = new String[3];  //这种写法,相当于new了一个数组对象,里面的元素都未初始化,即默认值null
		System.out.println(msgs.length);
		for (int i = 0; i < msgs.length; i++) {
			System.out.println(msgs[i]);
		}
		
		//更上一种写法唯一的不同是,里面的元素都已经被初始化了,{}中的值就是用来初始化的常量
		String[] nations = new String[] { "china", "jap", "usa"}; 
		
		String[] days = { "mon", "tu", "wen" }; // 是上一种 的简写,因为是初始化的常量,所以只能在初始化时使用
		
		//下面是赋值语句,不是初始化,所以不能使用
//		days = { "", "", "" }; //Array constants can only be used in initializers
		
		
		
		//---------------数组常量的元素类型可以是任意的----------------------
		Object[] persons = new Object[] {new Object(), new Object(), new Object()};
		byte[] ops = new byte[] {0, 1, 127};
		short[] ages = new short[] {5, 80, 200};
		int[] scores = new int[] {50, 60, 70};
		long[] amounts = new long[] {50, 60, 70};
		float[] weights = new float[] {50, 60, 70};
		double[] lengths = new double[] {50, 60, 70};
		
		
		System.out.println("main exit");
	}
}
