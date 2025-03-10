package servlets;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ModelLogin;


/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public ServletLogin() {

	}

	/* recebe os dados pela url em parâmetros */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/* recebe os dados enviados por um formulário */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		if (login != null && !login.isEmpty() && senha !=null && !senha.isEmpty()) {
			ModelLogin modelLogin = new ModelLogin();
			modelLogin.setLogin(login);
			modelLogin.setSenha(senha);
		} else {
			RequestDispatcher redirecionar = request.getRequestDispatcher("index.jsp");
			request.setAttribute("msg", "informe o login e a senha corretamente!");
			redirecionar.forward(request, response);
		}
		
	}

}
