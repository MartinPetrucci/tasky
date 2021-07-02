package com.tasky.utils;

import java.util.List;

public class TaskyUtils<T> {

	public T getLast(List<T> list) {
		return list.get(list.size() - 1);
	}
	
	
}
