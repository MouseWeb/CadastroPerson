package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.LoginBean;
import dao.LoginDao;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
        private LoginDao loginDao = new LoginDao();
        
    public LoginServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginBean loginBean = new LoginBean();
		
	String login = request.getParameter("login");
	String senha = request.getParameter("senha");
		
        try {
                
            if (loginDao.validarLogin(login, senha)) {  // ACESSO OK
                RequestDispatcher dispatcher = request.getRequestDispatcher("acessoliberado.jsp");
                dispatcher.forward(request, response);
            } else {  // ACESSO NEGADO
                RequestDispatcher dispatcher = request.getRequestDispatcher("acessonegado.jsp");
                dispatcher.forward(request, response);
            }
                
        } catch (Exception ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, "Erro: " + ex);
        }
		
    }

}
