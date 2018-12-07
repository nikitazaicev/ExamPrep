package pack1;

import java.io.IOException;
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

}
