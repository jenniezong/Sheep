package dataStructure.sort;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class TestSort {

	@SuppressWarnings("deprecation")
	@Test
	public void testBinarySearch1() {

		int[] a = {4,5,6,6,10,10,11,12,13,14};
		int result = SortPractise.binarySearch(a, 0, 9, 5);
		Assert.assertEquals(result, 1);
		
	}
	
	@Test
	public void testBinarySearch2() {

		int[] a = {5,6,7,9,10,10,11,12,13,14};
		int result = SortPractise.binarySearch(a, 0, 9, 5);
		Assert.assertEquals(result, 0);
		
	}
	
	@Test
	public void testBinarySearch3() {

		int[] a = {4,5,6,6,10,10,11,12,13,14};
		int result = SortPractise.binarySearch(a, 0, 9, 14);
		Assert.assertEquals(result, 9);
		
	}
	
	

}
