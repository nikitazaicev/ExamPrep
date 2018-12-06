package pack1;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

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
}}

/* Notater/to know:
 _________________________________________________________
 Sikkerhet:
 
 _________________________________________________________
 P-problem:
 NP:
 NPC:
 NP-hard:
 _________________________________________________________
  Attribute vs Parameter
  Attribute = kan være object etc, holdes på serveren...
  Parameter = String i Urlen...
 _________________________________________________________ 
  Måter å sende info mellom forespørslene:
  1. Man kan lagre informasjonen på tjeneren og hente den frem ved
fremtidige forespørsler ved at nettlesersesjonen identifiseres med en
sesjonscookie (f.eks. jsessionid)
2. Man kan sende med informasjonen som cookies (Set-Cookie:-headeren)
som klienten lagrer og sender tilbake ved fremtidige forespørsler til
samme nettsted.
3. Ved en redirect (302/303) kan man legge ved den ekstra
informasjonen i redirect-URLen (gitt i Location:-headeren).
______________________________________________________________________	
	Poenget med PRG(Post-Get-Redirect):
	POST brukes ofte til å sende skjemadata som oppdaterer data på
tjeneren. Hvis man trykker "refresh" i webleseren vil den prøve å
POSTe på nytt, det såkalte dobbeltpostings-problemet.

PRG hindrer dette problemet ved at det er GET-forespørselen som
henter siden som vil sendes på nytt ved "refresh".

Bruk av PRG gjør også at man kan bokmerke respons-sider etter
POSTing, f.eks. bestillingsbekreftelser el.l.
___________________________________________________________________
 Hva egenlig er EJB?
	@EJB
___________________________________________________________________ 
Start på doGet/ samme dritt med doPost:	
 protected void doGet(
 HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException {
 _____________________________________________________________________
 *Request gjennom jsp:	
 request.getRequestDispatcher("WEB-INF/RegistrerBrukerSkjema.jsp")
 								.forward(request, response);
 ___________________________________________________________________
 JSP ting i beggynelsen av documentet:	
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 ___________________________________________________________________
 Eksempel på form tag i HTML:
 <form method="post">
 <fieldset>
 <legend>Opprette ny bruker:</legend>
 <p>Nick: <input type="text" name="nick">
 ___________________________________________________________________
 Ny måte å adde cookies på?
 CookieHjelper.addCookieToResponse(response, "nick", nick);
 ___________________________________________________________________
  Lambda ting:
  Predicate<T>: inn -> T ut -> boolean
  Consumer<T>: inn -> T ut -> void
  Supplier<T>: inn -> null ut -> T
  Function<T,T>: inn -> T ut -> T
  public static Function<Double, Double> funksjon(int inc){ 
	return (x -> x*inc);
}
public double endreLonn(Function<Double,Double> f) {
	setAarslonn(f.apply(aarslonn));

	return getAarslonn();
}
private Function<Double, Double> f;
________________________________________________________________
 */
