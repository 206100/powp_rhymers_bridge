package edu.kis.vh.nursery;

import edu.kis.vh.nursery.collections.IntArrayCollection;
import org.junit.Assert;
import org.junit.Test;

public class RhymersJUnitTest {

	private static final int TEST_VALUE = 4;

	@Test
	public void testCountIn() {
		DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
		
		rhymer.countIn(TEST_VALUE);

		int result = rhymer.peekaboo();
		Assert.assertEquals(TEST_VALUE, result);
	}

	@Test
	public void testCallCheck() {
		DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
		boolean result = rhymer.callCheck();
		Assert.assertTrue(result);

		rhymer.countIn(888);

		result = rhymer.callCheck();
		Assert.assertFalse(result);
	}

	@Test
	public void testIsFull() {
		DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
		int STACK_CAPACITY = 12;

		for (int i = 1; i < STACK_CAPACITY; i++) {
			boolean result = rhymer.isFull();
			Assert.assertFalse(result);
			rhymer.countIn(888);
		}

		if (rhymer.collectionImpl instanceof IntArrayCollection) {
			boolean result = rhymer.isFull();
			Assert.assertTrue(result);
		}
	}

	@Test
	public void testPeekaboo() {
		DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
		int EMPTY_STACK_VALUE = 0;

		int result = rhymer.peekaboo();
		Assert.assertEquals(EMPTY_STACK_VALUE, result);

		rhymer.countIn(TEST_VALUE);

		result = rhymer.peekaboo();
		Assert.assertEquals(TEST_VALUE, result);
		result = rhymer.peekaboo();
		Assert.assertEquals(TEST_VALUE, result);
	}

	@Test
	public void testCountOut() {
		DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
		int EMPTY_STACK_VALUE = 0;

		int result = rhymer.countOut();
		Assert.assertEquals(EMPTY_STACK_VALUE, result);

		rhymer.countIn(TEST_VALUE);

		result = rhymer.countOut();
		Assert.assertEquals(TEST_VALUE, result);
		result = rhymer.countOut();
		Assert.assertEquals(EMPTY_STACK_VALUE, result);
	}

}
