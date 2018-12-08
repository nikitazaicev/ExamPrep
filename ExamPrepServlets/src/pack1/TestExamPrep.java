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
	
	@Test
	public void cookieSkalKunneHentesUtDekodetFraRequest() {
	//Arrange
	 request.setCookies(
	new Cookie[]{new Cookie("User", "Atle+Patle")});
	//Act
	String cookie
	= cookiehjelper.getCookieFromRequest(request, "User");
	//Assert
	assertEquals("Atle Patle", cookie);
	}
	
	@Test
	public void cookieBlirLagretKodetOgTidsmerket() {
	//Act
	cookiehjelper.addCookieToResponse(
	response, "User", "Atle Patle");
	//Assert
	Cookie cookie = response.getCookies()[0];
	assertEquals("User", cookie.getName());
	assertEquals("Atle+Patle", cookie.getValue());
	assertEquals(60*60*24*365, cookie.getMaxAge());
	}

}
