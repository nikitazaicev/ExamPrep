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
 
 hash is one way function. Same input gives same output but 
 a tiny change gives completely different result.
 user creates an account -> generated hash saves in database
 -> user logs inn again his input translates to hash and 
 compares to the his hash in database.
 
 How they are hacked:
 
 Brute force: try {aaaa,aaab,aaac...}
 
 Dictionary attack: uses some source of data like dictionary
 or a already known database, try {banan,ananas,1234, ...}
 can't prevent those two but can slow it down.

 Lookup tables: pre-computes hashes? from pass dictionaries? 
 searches for hashes? gives u pass if found.
  
 Reverse lookup tables: creates lookup table, maps hash
 from user account database to a list of users with this hash?
 da fuck is that supposed to mean?
 Basically same shit as normal lookup just that u check many users
 hashes at the ssame time.
 Effective since many users have same passwords many places
 Should be pointless if attacker hasnt hacked anything before but idk
 
 Rainbow tables: smaller lookuptables, can store more hashes
 sacrifices cracking speed. idk
 
 Probably everything im not sure about aint gonna be asked 
 detailed in exam cuz there is no better explanation in he link
 
 Adding salt:
 
 Lookup/Rainbow tables work cuz same input always gives same output
 Can be fixed by appending/prepending a random string (SALT)
 SALT stored in user account database with hash or separately
 No need to hide SALT its point is to randomize hash not make it more complicated
 
 new RANDOM SALT must be generated with every pass change
 
 DONT: 

 dont reuse same SALT:
 with reuse they can just find SALT and adjust lookup tables.
 
 dont use short SALT:
 if salt is tto short it can be simply bruteforced.
 
 dont Double hash/whacky hash(combining several hashes together): 
 "CAN" make it harder since attacker doesnt know which hash to
 precompute + can take longer time.
 "BUT" atacker usually has source code and knows what to use...
 meh not so important...
 
 Hash collisions:
 since pass can be different length but hash is always the same 
 several inputs can give u same output, SALT can make it more likely
 but even then its collisions are mostly accidential.
 
   
 
 side note: if u tell use how long pass has to be its easier
 to crack since hacker knows where to start.
 _________________________________________________________
 P-problem:
 
 NP:
 
 NPC:
 
 NP-hard:
 _________________________________________________________
  Attribute vs Parameter
 
  Attribute = kan v�re object etc, holdes p� serveren...
  Parameter = String i Urlen...
 _________________________________________________________ 
  M�ter � sende info mellom foresp�rslene:
  
  1. Man kan lagre informasjonen p� tjeneren og hente den frem ved
fremtidige foresp�rsler ved at nettlesersesjonen identifiseres med en
sesjonscookie (f.eks. jsessionid)

2. Man kan sende med informasjonen som cookies (Set-Cookie:-headeren)
som klienten lagrer og sender tilbake ved fremtidige foresp�rsler til
samme nettsted.

3. Ved en redirect (302/303) kan man legge ved den ekstra
informasjonen i redirect-URLen (gitt i Location:-headeren).
______________________________________________________________________	
	Poenget med PRG(Post-Get-Redirect):
	
	POST brukes ofte til � sende skjemadata som oppdaterer data p�
tjeneren. Hvis man trykker "refresh" i webleseren vil den pr�ve �
POSTe p� nytt, det s�kalte dobbeltpostings-problemet.

PRG hindrer dette problemet ved at det er GET-foresp�rselen som
henter siden som vil sendes p� nytt ved "refresh".

Bruk av PRG gj�r ogs� at man kan bokmerke respons-sider etter
POSTing, f.eks. bestillingsbekreftelser el.l.
___________________________________________________________________
 Hva egenlig er EJB?
	
	@EJB
___________________________________________________________________ 
Start p� doGet/ samme dritt med doPost:	
 
 protected void doGet(
 HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException {
 _____________________________________________________________________
 Request gjennom jsp:	
 
 request.getRequestDispatcher("WEB-INF/RegistrerBrukerSkjema.jsp")
 								.forward(request, response);
 ___________________________________________________________________
 JSP ting i beggynelsen av documentet:	
 
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 	pageEncoding="ISO-8859-1"%>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 ___________________________________________________________________
 Eksempel p� form tag i HTML:
 <form method="post">
 <fieldset>
 <legend>Opprette ny bruker:</legend>
 <p>Nick: <input type="text" name="nick">
 ___________________________________________________________________
 Ny m�te � adde cookies p�?
 
 CookieHjelper.addCookieToResponse(response, "nick", nick);
 ___________________________________________________________________
  Lambda ting:
 
  Predicate<T>: inn -> T ut -> boolean
  
  Consumer<T>: inn -> T ut -> void
  
  Supplier<T>: inn -> null ut -> T
  
  Function<T,T>: inn -> T ut -> T
  
  public static Function<Double, Double> funksjon(int inc){ 
	return (x -> x*inc);}
	
	public double endreLonn(Function<Double,Double> f) {
	setAarslonn(f.apply(aarslonn));
	return getAarslonn();}
	
	private Function<Double, Double> f;
________________________________________________________________
 */
