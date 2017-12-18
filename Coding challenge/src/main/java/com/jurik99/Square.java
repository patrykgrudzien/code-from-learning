package com.jurik99;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Square {

	boolean createSquare(int[] point1, int[] point2, int[] point3, int[] point4) {
		boolean result = false;
		if (point1 == null || point2 == null || point3 == null || point4 == null) {
			return result;
		}
		if ((point1[0] == 0 && point1[1] == 0) &&
		    (point2[0] == 0 && point2[1] == 0) &&
		    (point3[0] == 0 && point3[1] == 0) &&
		    (point4[0] == 0 && point4[1] == 0)) {
			return result;
		}
		if (checkSquare(point1, point2, point3, point4)) {
			result = true;
		}
		return result;
	}

	int[] createSquarePoint(final int x, final int y) {
		int END_RANGE = 10000;
		int START_RANGE = -10000;

		if (x >= END_RANGE && x <= START_RANGE || y >= END_RANGE && y <= START_RANGE) {
			throw new CoordinatesException("Input coordinates are out of range.");
		}
		else {
			int[] point = new int[2];
			point[0] = x;
			point[1] = y;
			return point;
		}
	}

	private double distance(int[] point1, int[] point2) {
		final int xCoordinates = Math.abs(point2[0] - point1[0]) * Math.abs(point2[0] - point1[0]);
		final int yCoordinates = Math.abs(point2[1] - point1[1]) * Math.abs(point2[1] - point1[1]);
		int sum = xCoordinates + yCoordinates;
		return Math.sqrt((double) sum);
	}

	private boolean checkSquare(int[] point1, int[] point2, int[] point3, int[] point4) {
		final List<int[]> sortedPoints = sortXCoordinates(point1, point2, point3, point4);

		int[] sortedPoint1 = sortedPoints.get(0);
		int[] sortedPoint2 = sortedPoints.get(1);
		int[] sortedPoint3 = sortedPoints.get(2);
		int[] sortedPoint4 = sortedPoints.get(3);

		return distance(sortedPoint1, sortedPoint2) > 0
		       && distance(sortedPoint1, sortedPoint2) == distance(sortedPoint3, sortedPoint4)
		       && distance(sortedPoint1, sortedPoint3) == distance(sortedPoint2, sortedPoint4)
		       && distance(sortedPoint1, sortedPoint4) == distance(sortedPoint3, sortedPoint2)
		       && distance(sortedPoint1, sortedPoint4) == distance(sortedPoint1, sortedPoint3) * Math.sqrt(2)
		       && distance(sortedPoint3, sortedPoint2) == distance(sortedPoint3, sortedPoint1) * Math.sqrt(2);
	}

	private List<int[]> sortXCoordinates(int[] point1, int[] point2, int[] point3, int[] point4) {
		List<int[]> points = Arrays.asList(point1, point2, point3, point4);
		points.sort(Comparator.comparingInt(point -> point[0]));
		return points;
	}
}

class Main {
	public static void main(final String[] args) {

		Square square = new Square();
		final int[] pointA = square.createSquarePoint(1, 3);
		final int[] pointB = square.createSquarePoint(3, 5);
		final int[] pointC = square.createSquarePoint(5, 3);
		final int[] pointD = square.createSquarePoint(3, 1);

		final boolean isCreated = square.createSquare(pointA, pointB, pointC, pointD);
		System.out.println(isCreated);
	}
}

class CoordinatesException extends RuntimeException {

	private static final long serialVersionUID = 3517888943076773299L;

	public CoordinatesException() {
		super();
	}

	public CoordinatesException(final String message) {
		super(message);
	}

	public CoordinatesException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public CoordinatesException(final Throwable cause) {
		super(cause);
	}

	protected CoordinatesException(final String message, final Throwable cause, final boolean enableSuppression,
	                               final boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}