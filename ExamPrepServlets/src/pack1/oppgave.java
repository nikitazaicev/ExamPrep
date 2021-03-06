package pack1;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class oppgave
 */
@EJB

Databasehjelper dbh = new Databasehjelper();

@WebServlet("/anmelde")
public class oppgave extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private Map<String, String> feilmeldinger = new HashMap<>();
	
	@Override
	public void init(){
	feilmeldinger.put("ugyldigRequest", "Ugyldig forespørsel");
	// ... evt. flere feilmeldinger
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response){
		
	String bok_id = request.getParameter("bok_id");
	
	if(!isGyldigBokId(bok_id)) {
		response.sendRedirect("feilservlet?feilmelding=feilwhatever");
	}else {
		Bruker bok = BokDaoUsingJpa.finnBok(Integer.parseInt(bok_id));
		if(bok!=null){
			request.setAttribute("bok", bok);
			request.getRequestDispatcher("jsp.jsp").forward(request, response);
			return;
		}else {
			response.sendRedirect("feilservlet?feilmelding=eksistererikke");
		}	
	}
	
	
		
//__________________________________________________________________________________
	String aarsak = request.getParameter("aarsak");
	String feilmeldingstekst = feilmeldinger.get(aarsak);
	if (feilmeldingstekst == null) {
	feilmeldingstekst = "Ooops. Noe gikk galt";
	}
	request.setAttribute("feilmeldingstekst", feilmeldingstekst);
	request.getRequestDispatcher("WEB-INF/feilmelding.jsp")
	 .forward(request, response);
	
		
//__________________________________________________________________________________

		
	String feilmelding = Feilmeldinger.finnFeilmeldingFraURL(request);
	request.setAttribute("felmalding", feilmelding);
	
	request.getRequestDispatcher("jsp.jsp").forward(request, response);	
		
//_________________________________________________________________________________		
		Cookie kjeks = CookieHjelper.getCookie("nick");
		String redirectURL = "";
		Boolean FinnesActivitet;
		if(kjeks == null) {
			redirectURL = "registrering";
			response.sendRedirect(redirectURL);
		}else { 
			Student stud = dbh.finnStudent(kjeks.getValue());
			if(!dbh.finnesAktivitetForStudent(stud)){
				FinnesActivitet = false;
			} else {FinnesActivitet = true;}
			request.setAttribute("finnesaktivitet", FinnesActivitet);
		}
			
			request.getRequestDispatcher("jsp").forward(request, response);
		
//_________________________________________________________________________________
		String feilkode = request.getParameter("feilkode");
		if(feilkode.equals("1")) {
			feilkode = "tekst";
		}
		request.setAttribute("feilkode", feilkode);
		request.getRequestDispatcher("jspnavn.jsp").forward(request, response);
		
	}

	private boolean isGyldigBokId(String bok_id) {
		// TODO Auto-generated method stub
		return false;
	}

	@EJB
	EAO eao;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String mobil = request.getParameter("mobil");
		
		if(eao.finnBrukerMedMobil(mobil)==null) {
			response.sendRedirect("registreringskjema");
		}else {
			String pass = request.getParameter("pass");
			Bruker bruker = eao.finnBrukerMedMobil(mobil);
			
			if(PassordUtil.krypterPassord(pass).equals(bruker.getPass)) {
				response.sendRedirect("/meldinger");
			}else response.sendRedirect("/login?feilmelding=feilPass");
		}
//________________________________________________________________________________________________		
		
		if(LoggInntUtil.erInnlogget(request)) {
			request.getRequestDispatcher("jsp.jsp").forward(request, response);
		}else response.sendRedirect("login?feilmelding=WHATEVER");
		List<Melding> meldinger = meldingEAO.hentNSisteMeldinger(VISNINGSANTALL);
		request.setAttribute("meldinger", meldinger);
		

//__________________________________________________________________________________________________
		String nick = request.getParameter("nick");
		
		if(!gyldig(nick)) {
			request.setAttribute("feilkode", "1");

			response.sendRedirect("refresh");
		}
		if(Eksistere(nick)) {
			request.setAttribute("feilkode", "2");
			
			response.sendRedirect("refresh");
		}
		
		request.setAttribute("nick", nick);
		String klasse = request.getParameter("select");
		request.setAttribute("nick", nick);
		request.setAttribute("klasse", klasse);
		response.sendRedirect("servletHvisaltErFint");
	}

	private boolean Eksistere(String nick) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean gyldig(String nick) {
		// TODO Auto-generated method stub
		return false;
	}

	private void logginn(HttpServletRequest request, Bruker bruker) {
	
		HttpSession s = request.getSession(false);
		
		if(s != null) {
			s.invalidate();
		}
		
		s = request.getSession(true);
		s.setAttribute("bruker", bruker);

	}
	
}
