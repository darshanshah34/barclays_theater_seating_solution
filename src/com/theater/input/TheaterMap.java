package com.theater.input;

public class TheaterMap {
	int[][] theaterMap = { { 6, 6, 0, 0, 12 }, { 3, 5, 5, 3, 16 }, { 4, 6, 6, 4, 18 }, { 2, 8, 8, 2, 20 },
			{ 6, 6, 0, 0, 12 }, { 0, 0, 0, 0, 0 } };

	private static int numSeatsOccupied = 0;
	private static int totalCapacity = 0;
	private static boolean fisrtAssianed = false;
	private int ROWS = 6;
	private int COLUMNS = 4;
	private int maxPartySize = 0;

	public int[][] getTheaterMap() {
		return theaterMap;

	}

	public void setTheaterMap(int[][] theaterMap) {
		this.theaterMap = theaterMap;
	}

	public int getNumSeatsOccupied() {
		return numSeatsOccupied;
	}

	public void setNumSeatsOccupied(int numSeatsOccupied) {
		TheaterMap.numSeatsOccupied = numSeatsOccupied;
	}

	public int getTotalCapacity() {
		return totalCapacity;
	}

	public void setTotalCapacity(int totalCapacity) {
		this.totalCapacity = totalCapacity;
	}

	/*
	 * 6 6 3 5 5 3 4 6 6 4 2 8 8 2 6 6
	 */
	public TheaterMap() {
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLUMNS; j++) {
				totalCapacity += theaterMap[i][j];
				if (maxPartySize < theaterMap[i][j]) {					
					maxPartySize = theaterMap[i][j];
				}
			}
		}
	}

	public String assign(int count, String name) {
		if (count > totalCapacity) {
			return " Sorry, we can't handle your party.";
		}
		int currentRow = 0;
		if (fisrtAssianed) {
			if (count > maxPartySize) {
				return " Call to split party.";
			}
			String str = assignExact(count, name);
			if (str != null) {
				return str;
			}
		}
		for (int i = 0; i < ROWS; i++) {
			for (int k = 0; k < COLUMNS; k++) {

				int leftOverCount = count;
				if (currentRow == 0 && k == 0 && theaterMap[i][4] >= count) {
					if (!fisrtAssianed) {
						return handleFirstRequest(count, i, k, leftOverCount);
					} else {
						return returnRowAndSection(count, i, k, leftOverCount);
					}
				} else if (currentRow == i && theaterMap[i][4] < count) {
					leftOverCount = count;
					i = i + 1;
					int m = k;
					int section = 0;
					for (m = k; m < COLUMNS; m++) {
						section = splitPartyInSameRowSection(i, leftOverCount, m, section);
					}
					return " Row " + (i + 1) + " Section " + (section + 1) + " ";
				} else {
					return " Call to split party.";
				}
			}
		}
		return null;
	}

	private String handleFirstRequest(int count, int i, int k, int leftOverCount) {
		leftOverCount = leftOverCount - theaterMap[i][k];
		theaterMap[i][4] = theaterMap[i][4] - count;
		theaterMap[i][k] = theaterMap[i][k] - count;
		fisrtAssianed = true;
		return " Row " + (i + 1) + " Section " + (k + 1);
	}

	private int splitPartyInSameRowSection(int i, int leftOverCount, int m, int section) {
		if (leftOverCount > 0) {
			if (leftOverCount < theaterMap[i][m])
				return section;
			leftOverCount = leftOverCount - theaterMap[i][m];
			theaterMap[i][4] = theaterMap[i][4] - theaterMap[i][m];
			theaterMap[i][m] = 0;
			if (leftOverCount == 0) {
				section = m;
			}
		} else
			return section;
		return section;
	}

	private String returnRowAndSection(int count, int i, int k, int leftOverCount) {
		if (theaterMap[i][4] - count >= 0) {
			for (int m = k; m < COLUMNS; m++) {

				if (theaterMap[i][m] >= count) {
					theaterMap[i][4] = theaterMap[i][4] - count;
					theaterMap[i][m] = theaterMap[i][m] - count;
					leftOverCount = leftOverCount - count;
					return " Row " + (i + 1) + " Section " + (m + 1);
				}
			}
		}
		return " Row " + (i + 1) + " Section " + (k + 1);
	}

	private String assignExact(int count, String name) {
		for (int i = 0; i < ROWS; i++) {
			for (int k = 0; k < COLUMNS; k++) {
				if (count == theaterMap[i][k]) {
					totalCapacity = totalCapacity - count;
					theaterMap[i][4] = theaterMap[i][4] - count;
					theaterMap[i][k] = 0;
					return " Row " + (i + 1) + " Section " + (k + 1);
				}
			}
		}
		return null;
	}
}