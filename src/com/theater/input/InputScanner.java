package com.theater.input;

import java.util.List;
import java.util.StringTokenizer;

public class InputScanner {
	List<String> listInput = null;
	private TheaterMap tm;
	
	public List<String> getListInput() {
		return listInput;
	}


	public void setListInput(List<String> listInput, TheaterMap tm) {
		this.listInput = listInput;
		this.tm = tm;
	}


	public void procesScanner() {
		for (String x: listInput) {
			StringTokenizer st = new StringTokenizer(x, " ");
			String name = st.nextToken();
			int  count = new Integer(st.nextToken()).intValue();
			assignSeats(name, count);
			
		}
		

	}


	private void assignSeats(String name, int count) {
		String message = tm.assign(count, name);
		message = name + message;
		System.out.println(message);
		
	}

}
