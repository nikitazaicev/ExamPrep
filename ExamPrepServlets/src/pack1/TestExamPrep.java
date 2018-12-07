package pack1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestExamPrep<MockHttpServletResponse, MockHttpServletRequest> {
	private CookieHjelper cookiehjelper;
	 private MockHttpServletRequest request;
	 private MockHttpServletResponse response;
	@Test
	public void testAlt() {
		assertTrue(erGyldig(""));
		assertFalse(erGyldig("as"));
		assertTrue(erGyldig("ass"));
		assertFalse(erGyldig("assssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss"));
		assertTrue(erGyldig(""));
		assertFalse(erGyldig("as asd"));
	
	}
	@Test
	public void testMock() {
		
	}
	private Boolean erGyldig(String string) {
		// TODO Auto-generated method stub
		return true;
	}

}
