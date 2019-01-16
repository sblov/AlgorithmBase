package com.lov.hash;

import java.util.Arrays;

public class HashTable {

	private StuInfo[] data = new StuInfo[100];
//	
	/**
	 * 通过散列函数运算，获取index值
	 * @param stuInfo
	 */
	public void put(StuInfo stuInfo) {
		
		data[stuInfo.hashCode()] = stuInfo;
		
	}

	/**
	 * @param stuInfo
	 * @return
	 */
	public StuInfo get(StuInfo stuInfo) {
		return data[stuInfo.hashCode()];
	}

	@Override
	public String toString() {
		return "HashTable [data=" + Arrays.toString(data) + "]";
	}
	
	
}
