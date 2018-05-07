package org.cjh.javabasic.narrowcast;

public class Cat extends AbstractAinimal {

	
	/* 
	 * 子类override父类方法，
	 * 返回类型可以narrow cast(因为子类型肯定是属于父类型,所以可以说子类型的返回值肯定是父类型)
	 * 但是,不能narrow子类方法的看见范围(因为子类肯定是属于父类型,父类型的可见性肯定适用于子类,所以子类的方法可见性不比父类小)
	 */
	@Override
	public Cat product() {
		
		return new Cat();
	}

	/* 
	 * Cannot reduce the visibility of the inherited method from AbstractAinimal
	 * 
	 */
	@Override
	public Cat simle() {
		return null;
	}
}
