import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Whatever {

	public static void main(String[] args) {
	List<Integer> l = Arrays.asList(1,2,3,4,5);
	
	Collections.sort(l, new Comparator<Integer>() {

		@Override
		public int compare(Integer arg0, Integer arg1) {
			
			return 0;
		}
		
	});
	Collections.sort(l, (x1,x2) -> x1.compareTo(x2));
}
}
/* Notater/to know:
 *Hva egenlig er EJB?
 *	@EJB
 *___________________________________________________________________ 
 *Start på doGet/ samme dritt med doPost:	
 *protected void doGet(
 	HttpServletRequest request, HttpServletResponse response)
 	throws ServletException, IOException {
  _____________________________________________________________________
 *Request gjennom jsp:	
 *request.getRequestDispatcher("WEB-INF/RegistrerBrukerSkjema.jsp")
 								.forward(request, response);
 *___________________________________________________________________
 *JSP ting i beggynelsen av documentet:	
 *<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 *___________________________________________________________________
 *Eksempel på form tag i HTML:
 *<form method="post">
 <fieldset>
 <legend>Opprette ny bruker:</legend>
 <p>Nick: <input type="text" name="nick">
 *___________________________________________________________________
 *Ny måte å adde cookies på?
 *CookieHjelper.addCookieToResponse(response, "nick", nick);
 *___________________________________________________________________
 *
 *
 *___________________________________________________________________
 * 
 * 
 * 
 */
