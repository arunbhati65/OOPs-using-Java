package com.lift.beans;

import java.util.LinkedHashSet;

import com.lift.enums.LiftDirection;
import com.lift.enums.LiftType;

public class Lift{
	
	private static final Double maxWeight = 400.5; // kg
	private Integer liftID;
	private LiftType lifttype;
	private int liftCurrentFloor;// 0-9 9-terrace,0-ground floor
	private Double currentWeight;
	private LiftDirection liftDirection;
	private LinkedHashSet<LiftRequest> liftRequest;

	public Lift() {
	}

	public Lift(Integer liftID,LiftType liftType, int liftCurrentFloor, LiftDirection liftDirection) {
		this.liftID = liftID;
		this.lifttype=liftType;
		this.liftCurrentFloor = liftCurrentFloor;
		this.liftDirection = liftDirection;
	}

	public static Double getMaxWeight() {
		return maxWeight;
	}

	public Integer getLiftID() {
		return liftID;
	}

	public void setLiftID(Integer liftID) {
		this.liftID = liftID;
	}

	public int getLiftCurrentFloor() {
		return liftCurrentFloor;
	}

	public void setLiftCurrentFloor(int liftCurrentFloor) {
		this.liftCurrentFloor = liftCurrentFloor;
	}

	public Double getCurrentWeight() {
		if (currentWeight == null) {
			currentWeight = 0.0;
		}
		return currentWeight;
	}

	public void setCurrentWeight(Double currentWeight) {
		this.currentWeight = currentWeight;
	}

	public LiftDirection getLiftDirection() {
		return liftDirection;
	}

	public void setLiftDirection(LiftDirection liftDirection) {
		this.liftDirection = liftDirection;
	}

	public LinkedHashSet<LiftRequest> getLiftRequests() {
		if (liftRequest == null) {
			liftRequest = new LinkedHashSet<LiftRequest>();
		}
		return liftRequest;
	}

	public void setLiftRequests(LinkedHashSet<LiftRequest> liftRequest) {
		this.liftRequest = liftRequest;
	}

	public LiftType getLifttype() {
		return lifttype;
	}

	public void setLifttype(LiftType lifttype) {
		this.lifttype = lifttype;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((liftID == null) ? 0 : liftID.hashCode());
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
		Lift other = (Lift) obj;
		if (liftID == null) {
			if (other.liftID != null)
				return false;
		} else if (!liftID.equals(other.liftID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Lift [liftID=" + liftID + ", liftCurrentFloor="
				+ liftCurrentFloor + ", currentWeight=" + currentWeight
				+ ", liftDirection=" + liftDirection + ", liftRequest="
				+ liftRequest + "]";
	}

	

}
