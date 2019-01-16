package com.lov.hash;

public class StuInfo {

	private int age;
	private int count;
	
	public StuInfo() {
		super();
	
	}
	@Override
	public String toString() {
		return "StuInfo [age=" + age + ", count=" + count + "]";
	}
	public StuInfo(int age, int count) {
		super();
		this.age = age;
		this.count = count;
	}
	
	public StuInfo(int age) {
		super();
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	/* 
	 * 散列函数 取余法
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return age%10;
	}
	
	
}
