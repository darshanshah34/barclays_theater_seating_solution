package com.theater.input;

import java.util.ArrayList;
import java.util.List;

public class ListInputRequest {
	//List<String> listInput = new ArrayList<String>();
	
	public static void main(String[] args) {
		List<String> listInput = new ArrayList<String>();
		listInput.add("Smith 2");
		listInput.add("Jones 5");
		listInput.add("Davis 6");
		listInput.add("Wilson 100");
		listInput.add("Johnson 3");
		listInput.add("Williams 4");
		listInput.add("Brown 8");
		listInput.add("Miller 12");
		listInput.add("Darshan 5");
		listInput.add("Trupti 6");
		listInput.add("Janak 7");
		listInput.add("Mohan 1");
		InputScanner is = new InputScanner();
		TheaterMap tm = new TheaterMap();
		is.setListInput(listInput, tm);
		is.procesScanner();
	}

}
