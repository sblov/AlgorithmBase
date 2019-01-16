package com.lov.hash;

public class HashTest {

	public static void main(String[] args) {
		StuInfo stu1 = new StuInfo(16, 3);
		StuInfo stu2 = new StuInfo(17, 3);
		StuInfo stu3 = new StuInfo(18, 3);
		StuInfo stu4 = new StuInfo(19, 3);
		StuInfo stu5 = new StuInfo(20, 3);
		
		HashTable hTable = new HashTable();
		
		hTable.put(stu1);
		hTable.put(stu2);
		hTable.put(stu3);
		hTable.put(stu4);
		hTable.put(stu5);
		System.out.println(hTable);
		StuInfo stuInfo = new StuInfo(16);
		
		System.out.println(hTable.get(stuInfo));
	}
	
}
