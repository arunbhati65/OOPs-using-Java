package com.lift.service;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.Predicate;

import com.lift.beans.Lift;
import com.lift.beans.LiftRequest;
import com.lift.enums.LiftDirection;
import com.lift.enums.LiftType;
import com.lift.enums.UserRequestDirection;

public class LiftService {

	public Set<Lift> getAllLifts() {
		Set<Lift> lifts = new HashSet<Lift>();
		lifts.add(new Lift(101, LiftType.NORMAL, 5, LiftDirection.DOWN));
		lifts.add(new Lift(102, LiftType.NORMAL, 5, LiftDirection.UP));
		lifts.add(new Lift(103, LiftType.NORMAL, 5, LiftDirection.DOWN));
		lifts.add(new Lift(103, LiftType.NORMAL, 5, LiftDirection.DOWN));
		lifts.add(new Lift(104, LiftType.NORMAL, 5, LiftDirection.STILL));
		lifts.add(new Lift(105, LiftType.SERVICE, 5, LiftDirection.STILL));

		System.out.println(lifts.size());
		return lifts;

	}

	public Set<LiftRequest> getAllLiftRequests() {
		Set<LiftRequest> liftRequests = new LinkedHashSet<LiftRequest>();
		liftRequests.add(new LiftRequest(5, LiftType.SERVICE,
				UserRequestDirection.DOWN));
		liftRequests.add(new LiftRequest(8, LiftType.NORMAL,
				UserRequestDirection.UP));
		liftRequests.add(new LiftRequest(9, LiftType.NORMAL,
				UserRequestDirection.DOWN));
		liftRequests.add(new LiftRequest(1, LiftType.SERVICE,
				UserRequestDirection.UP));
		liftRequests.add(new LiftRequest(0, LiftType.NORMAL,
				UserRequestDirection.DOWN));
		liftRequests.add(new LiftRequest(4, LiftType.NORMAL,
				UserRequestDirection.UP));
		liftRequests.add(new LiftRequest(5, LiftType.SERVICE,
				UserRequestDirection.UP));
		liftRequests.add(new LiftRequest(8, LiftType.SERVICE,
				UserRequestDirection.DOWN));
		liftRequests.add(new LiftRequest(7, LiftType.NORMAL,
				UserRequestDirection.UP));
		liftRequests.add(new LiftRequest(6, LiftType.NORMAL,
				UserRequestDirection.UP));
		liftRequests.add(new LiftRequest(3, LiftType.NORMAL,
				UserRequestDirection.DOWN));
		liftRequests.add(new LiftRequest(2, LiftType.NORMAL,
				UserRequestDirection.UP));
		liftRequests.add(new LiftRequest(2, LiftType.NORMAL,
				UserRequestDirection.UP));// duplicate
		liftRequests.add(new LiftRequest(2, LiftType.NORMAL,
				UserRequestDirection.UP));// duplicate

		return liftRequests;
	}

	Predicate<Lift> liftWeightConditionCheck = (l) -> {
		Double futureWeight = l.getCurrentWeight() + LiftRequest.getAvgweight();

		if (futureWeight < Lift.getMaxWeight()) {
			return true;
		}
		return false;

	};

	public boolean liftAvailability(Set<Lift> lifts, LiftRequest liftRequest) {
		Lift lift = null;
		try {
			lift = lifts.stream().filter(liftWeightConditionCheck).findAny()
					.get();
		} catch (NullPointerException e) {
			System.out.println("Lift Not Available");
		}

		return lift !=null;
	}

}
