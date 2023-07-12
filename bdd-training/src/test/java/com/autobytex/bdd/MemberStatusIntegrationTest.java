package com.autobytex.bdd;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.autobytex.bdd.model.MemberGrade.Bronze;
import static com.autobytex.bdd.model.MemberGrade.Silver;

/**
 * thanks to this web for solving my problem caused by
 * <a href="https://www.springcloud.io/post/2022-07/inaccessibleobjectexception/#gsc.tab=0">JDK9 Module System</a>
 */
@RunWith(SerenityRunner.class)
public class MemberStatusIntegrationTest {

	@Steps
	private MemberStatusSteps memberSteps;

	@Test
	public void membersShouldStartWithBronzeStatus() {
		memberSteps.aClientJoinsTheMemberProgram();
		memberSteps.theMemberShouldHaveAStatusOf(Bronze);
	}

	@Test
	public void membersStartWithSilverStatus() {
		memberSteps.aMemberHasPointsOf(3500);
		memberSteps.theMemberShouldHaveAStatusOf(Silver);
	}

	@Test
	public void memberShouldSpendMoneyToBeASilverStatus() {
		memberSteps.aClientJoinsTheMemberProgram();
		memberSteps.theMemberShouldHaveAStatusOf(Bronze);
		memberSteps.theMemberSpends(35000);
		memberSteps.theMemberShouldHaveAStatusOf(Silver);
	}
}