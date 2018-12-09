package pack1;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

public class Whatever {

	public static void main(String[] args) {
	List<Integer> l = Arrays.asList(1,1,1,1,1,2,3,4,5);
	
	Collections.sort(l, new Comparator<Integer>() {

		@Override
		public int compare(Integer arg0, Integer arg1) {
			
			return 0;
		}
		
	});
	
	Stream s = l.stream().sorted();
	Object nr1 = s.findFirst().get();
	l.stream().filter(x -> x.intValue()==(int)nr1).forEach(x -> System.out.println(x));
	
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
 or an already known database, try {banan,ananas,1234, ...}
 can't prevent those two but can slow it down.

 Lookup tables: pre-computes hashes? from pass dictionaries? 
 searches for hashes? gives u pass if found.
  
 Reverse lookup tables: creates lookup table, maps hash
 from user account database to a list of users with this hash?
 da fuck is that supposed to mean?
 Basically same shit as normal lookup just that u check many users
 hashes at the same time.
 Effective since many users have same passwords many places
 Should be pointless if attacker hasnt hacked anything before but idk
 
 Rainbow tables: smaller lookuptables, can store more hashes
 sacrifices cracking speed. idk
 using less computer processing time and more storage than a brute-force attack 
 
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
 if salt is too short it can be simply bruteforced.
 
 dont Double hash/whacky hash(combining several hashes together): 
 "CAN" make it harder since attacker doesnt know which hash to
 precompute + can take longer time.
 "BUT" attacker usually has source code and knows what to use...
 meh not so important...
 
 Hash collisions:
 since pass can be different length but hash is always the same 
 several inputs can give u same output, SALT can make it more likely
 but even then its collisions are mostly accidential.
 
 rest is irrelevant due to: 
 "Dere vil ikke blitt bedt om å programmere noe her, men må kunne forklare i detalj hvordan ting virker og hvorfor vi gjør de ulike tingene".
 
 side note: if u tell user how long pass has to be its easier
 to crack since hacker knows where to start.
 ___________________________________________________________________________
 GRASP 
 
 info expert: ansvar å hente info om objekt eller avgjøre ansvar
 
 skaper: anvsar for å skape et objekt. Skaper hvis:
Instances of B contain or compositely aggregate instances of A
Instances of B record instances of A
Instances of B closely use instances of A
Instances of B have the initializing information for instances of A and pass it on creation.
 
 kontroller: Bindeledd mellom backend og UI. first object beyond the UI that coordinates a system operation
 
 lav kopling: Minst mulig avhengighet mellom klassene.
 
 Høy samhørighet: Klassene skal kun gjøre ting som de absolut maa.
 
 Polymorphism: different subclasses. 
 
 Fabrication: Lage extra klasser for å forenkle systemet. 
  				made up to achieve low coupling, high cohesion
 
 Indirection: fabrication. supports low coupling 
 
 Protecc from variation: sier seg selv
 ___________________________________________________________________________
 Init parametere og XML?
   
   <context-param>
        <param-name>email</param-name>
        <param-value>admin@example.com</param-value>
    </context-param>

    <servlet>
        <servlet-name>Info Servlet</servlet-name>
        <servlet-class>com.example.InfoServlet</servlet-class>
        <!-- This is a servlet init parameter -->
        <init-param>
            <param-name>name</param-name>
            <param-value>John Doe</param-value>
        </init-param>
    </servlet>
    <servlet-mapping>
        <servlet-name>Info Servlet</servlet-name>
        <url-pattern>/test/ShowInfo.do</url-pattern>
    </servlet-mapping>

Accessing context init parameter in a servlet:
getServletContext().getInitParameter(“email”);
Accessing servlet init parameter in a servlet for which it was defined in the deployment descriptor:
getServletConfig().getInitParameter("name");
 
 __________________________________________________________________________
 Alt er enten avgjørelse problem(ja/nei) eller Optimalisering 
 
 ____________________________________________________________
| Problem Type | Verifiable in P time | Solvable in P time | Increasing Difficulty
___________________________________________________________|           |
| P            |        Yes           |        Yes         |           |
| NP           |        Yes           |     Yes or No *    |           |
| NP-Complete  |        Yes           |      Unknown       |           |
| NP-Hard      |     Yes or No **     |      Unknown ***   |           |
____________________________________________________________           V
 
 P-problem: can be solved in polynomial time. 
 
 NP: kan verifiseres i polynomisktid i.e kan sjekkes i polynomisk tid om løsning er
 korrekt.
 
 NPC: de vanskeligste NP, ikke funnet løsning i polynomisk tid ennå
 reduser problem til NPC for å bevise at det er vanskelig å løse.
 BARE AVJØRELSEPROBLEM fra NP
 
 NP-hard: NPC + annet NPC relatert dritt, men som er ikke med i NP
 alle NPC er NP-harde. trenger IKKE være AVGJØRELSEPROBLEM
 
 If P != NP, then NP-hard problems cannot be solved in polynomial time.
 
 Tilnærmings algoritme: p(n) >= max( C / C* , C* /C ) 
 
 Tilnærmings rate: p(n), 1 = perfekt
 
 NP/NPC/NP-hard problemer som må kunnes?:
 
 NP:
 
 NPC: 
 
 Vertex cover: noder som med sine kanter dekker alle andre noder. 
 Dominating set:: noder som dekker alle andre nabo noder i hele grafen
 Hamiltonian path:  path in an undirected or directed graph that visits each vertex exactly once 
 clique. i.e. Given an undirected graph, 
 			  what is the largest complete graph which is a subgraph of the graph.
 
 NP-hard:
 Traveling salesman shortest possible route that visits each node and returns to the origin node?
 _________________________________________________________
  Attribute vs Parameter
 
  Attribute = kan være object etc, holdes på serveren...
  Parameter = String i Urlen...
 _________________________________________________________ 
  Måter å sende info mellom forespørslene:
  
  1. Man kan lagre informasjonen på tjeneren og hente den frem ved
fremtidige forespørsler ved at nettlesersesjonen identifiseres med en
sesjonscookie (f.eks. sessionid)

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
	bare et objekt man kan bruke som attribut i servleten eller JSP.
	må implementere serializable.
___________________________________________________________________ 
Start på doGet/ samme dritt med doPost:	
 
 protected void doGet(
 HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException {
 
Andre ting:
request got all gets
request got only setAttribute
response got no sets 
session got only set/get Attribute
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
 Eksempel på form tag i HTML:
 <form method="post">
 <fieldset>
 <legend>Opprette ny bruker:</legend>
 <p>Nick: <input type="text" name="nick">
 ___________________________________________________________________
 Ny måte å adde cookies på?
 
 CookieHjelper.addCookieToResponse(response, "nick", nick);
 CookieHjelper.getCookieFromRequest(request, "nick"); type String
 Cookies cookies = new Cookies[]{new cookie("navn", "innhold")}
 
 cookiehjelper.addCookieToResponse(response, "User", "Atle Patle");
 Cookie cookie = response.getCookies()[0];
 
 request.setCookies(
 new Cookie[]{new Cookie("User", "Atle+Patle")});
 String cookie = cookiehjelper.getCookieFromRequest(request, "User");
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
_________________________________________________________________________
Threads:

!!!
_________________________________________________________________________
Streams:

stream.map(x -> x*2) stream blir gjørt om til x ganger 2 istedenfor
stream.map(x -> x.getSomething) stream blir gjørt om til (mapped til)
somthing variabel istedenfor x objektet
_________________________________________________________________________
JSP stuff:

<form action="registrer" method="post"> --- action er navnet på servleten get henter 
jsp fra. method er method brukt i den samme servleten

<c:out value='${skjema.mobil} --- c out escaper HTML 

<c:forEach var = "i" begin="1" end = "5">
<form action="anmelde" method="post"><input type="radio" name="rating" value="${i}"></form>
<img scr="bilder/rating${i}.png"/>
</c:forEach>
<c:set> -  <c:set var = "salary" scope = "session" value = "${2000*2}"/>
<c:if> -  <c:if test = "${salary > 2000}">
<c:choose>/<c:when>/<c:otherwise> - <c:choose><c:when test = "${salary > 1000}"></c:when>
												<c:otherwise></c:otherwise> </c:choose>
<c:out> -   <c:out value = "${'<tag> , &'}"/> escapes HTML tags needs function testing 
meaning mockrequests etc. can be avoided by using String.EscapeHTML and only need unit testing then
meaning assertequals(string, EscapeHTML(String))
_________________________________________________________________________
 */
