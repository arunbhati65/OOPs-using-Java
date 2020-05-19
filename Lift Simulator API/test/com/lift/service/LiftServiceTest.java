package com.lift.service;

import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.lift.beans.Lift;
import com.lift.beans.LiftRequest;
import com.lift.enums.LiftType;
import com.lift.enums.UserRequestDirection;

public class LiftServiceTest {
	
	LiftService liftService=new LiftService();
	
	@Test
	public void getAllLifts_Test(){
		Set<Lift> lifts=liftService.getAllLifts();
		Assert.assertTrue(lifts.size()==5);
	}
	
	@Test
	public void getAllRequests_Test(){
		Set<LiftRequest> liftRequests=liftService.getAllLiftRequests();
		Assert.assertTrue(liftRequests.size()==12);
	}
	
	@Test
	public void liftAvailability_test(){
		LiftRequest liftRequest=new LiftRequest(2, LiftType.NORMAL, UserRequestDirection.UP);
		Assert.assertTrue(liftService.liftAvailability(liftService.getAllLifts(),liftRequest));
	}
	
	
}
