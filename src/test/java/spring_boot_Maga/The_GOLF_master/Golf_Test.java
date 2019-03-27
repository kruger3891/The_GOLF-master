package spring_boot_Maga.The_GOLF_master;

import org.junit.Assert;
import org.junit.Test;
import se.lexicon.The_GOLF_master.Shot;

public class Golf_Test {
	@Test
	public void countTest() {
		Shot test= new Shot(45,56);
		int expected=320;
		Assert.assertEquals(expected, test.count(), 0);
	}

}
