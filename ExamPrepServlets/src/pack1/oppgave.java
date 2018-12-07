package pack1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class oppgave
 */
@WebServlet("/anmelde")
public class oppgave extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie kjeks = CookieHjelper.getCookie("nick");
		String redirectURL = "";
		if(kjeks == null) {
			redirectURL = "registrering";
		}else {}
		
		
		
//_________________________________________________________________________________
		String feilkode = request.getParameter("feilkode");
		if(feilkode.equals("1")) {
			feilkode = "tekst";
		}
		request.setAttribute("feilkode", feilkode);
		request.getRequestDispatcher("jspnavn.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
