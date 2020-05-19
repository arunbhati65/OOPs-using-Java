package com.lift.beans;

import com.lift.enums.LiftType;
import com.lift.enums.UserRequestDirection;

public class LiftRequest {
	private static final Double avgWeight = 70.5;// Kg
	private int requestFloor;
	private LiftType liftType;
	private UserRequestDirection userRequestDirection;

	public LiftRequest() {
	}

	public LiftRequest(int requestFloor, LiftType liftType,
			UserRequestDirection userRequestDirection) {
		this.requestFloor = requestFloor;
		this.liftType = liftType;
		this.userRequestDirection = userRequestDirection;
	}

	public int getRequestFloor() {
		return requestFloor;
	}

	public void setRequestFloor(int requestFloor) {
		this.requestFloor = requestFloor;
	}

	public LiftType getLiftType() {
		return liftType;
	}

	public void setLiftType(LiftType liftType) {
		this.liftType = liftType;
	}

	public UserRequestDirection getUserRequestDirection() {
		return userRequestDirection;
	}

	public void setUserRequestDirection(
			UserRequestDirection userRequestDirection) {
		this.userRequestDirection = userRequestDirection;
	}

	public static Double getAvgweight() {
		return avgWeight;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((liftType == null) ? 0 : liftType.hashCode());
		result = prime * result + requestFloor;
		result = prime
				* result
				+ ((userRequestDirection == null) ? 0 : userRequestDirection
						.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LiftRequest other = (LiftRequest) obj;
		if (liftType != other.liftType)
			return false;
		if (requestFloor != other.requestFloor)
			return false;
		if (userRequestDirection != other.userRequestDirection)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LiftRequests [requestFloor=" + requestFloor + ", liftType="
				+ liftType + ", userRequestDirection=" + userRequestDirection
				+ "]";
	}

}
