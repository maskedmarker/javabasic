package org.cjh.javabasic.klass;

/**
 * 类的生命周期是:加载->验证->准备->解析->初始化->使用->卸载,只有在准备阶段和初始化阶段才会涉及类变量的初始化和赋值,
 * 因此只针对这两个阶段进行分析;
 * 
 * 类的准备阶段需要做是为类变量分配内存并设置默认值,因此类变量st为null、b为0;
 * 需要注意的是如果类变量是final,编译时javac将会为value生成ConstantValue属性,
 * 在准备阶段虚拟机就会根据ConstantValue的设置将变量设置为指定的值,而不是默认值.
 * 类的初始化会调用<cinit>方法，对象的初始化调用<init>方法，这些方法都是编译器合成方法。
 * <cinit>方法的作用是将静态语句块和类变量的赋值语句按语句在源码中的顺序执行。
 * <init>方法的作用是将对象语句块和对象变量的赋值语句按语句在源码中的顺序执行。
 * 调用对象的构造方法，首先执行<init>初始化方法，然后执行构造方法中的语句。
 */
public class ClassInitTest {
    
    public static void main(String[] args) {
        staticMethod();
    }

    static ClassInitTest st = new ClassInitTest();

    static {
        System.out.println("1");
    }

    {
        System.out.println("2");
//        System.out.println("d=" + d); //Cannot reference a field before it is defined
        instanceMethod();
    }

    ClassInitTest() {
        System.out.println("3");
        System.out.println(String.format("instanceFieldA=%s,classFieldB=%s,classFieldC=%s,instanceFieldD=%s", instanceFieldA, classFieldB, classFieldC, instanceFieldD));
    }

    public static void staticMethod() {
        System.out.println("4");
    }
    

    int instanceFieldA = 110;
    
    static int classFieldB = 112;
    
    static final int classFieldC = 113;
    
    final int instanceFieldD = 114;
    
    public void instanceMethod() {
        System.out.println(String.format("instanceFieldA=%s,classFieldB=%s,classFieldC=%s,instanceFieldD=%s", instanceFieldA, classFieldB, classFieldC, instanceFieldD));
    }
}
