package mvc.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import mvc.model.Cadastro;
import mvc.model.CadastroDAO;

@Controller
public class CadastrosController {
	@RequestMapping("entrar")
	public String login() {
		return "login";
	}

	@RequestMapping("cadastrar")
	public String signin() {
		return "signin";
	}
	
	@RequestMapping("fazerLogin")
	public String login(Cadastro user, HttpSession session, HttpServletRequest request) throws ClassNotFoundException {
		try {
			CadastroDAO dao = new CadastroDAO();
			
//			user.setUser(request.getParameter("user"));
//			user.setPassword(request.getParameter("password"));

			if (dao.verificaUser(user)) {
				session.setAttribute("user", user.getUser());
				return "crud";
			}
			dao.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "erroLogin";
	}

	@RequestMapping("signin")
	public String signin(Cadastro user, @ModelAttribute("password") String password, @ModelAttribute("password_check") String password_check, HttpSession session) {
		CadastroDAO dao = new CadastroDAO();
			try {
				if (password.contentEquals(password_check)) {
					dao.adicionaUser(user);
					session.setAttribute("user", user.getUser());
					return "redirect:entrar";
				}
				dao.close();
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "erroSignin";
		
		}

	@RequestMapping("fazLogout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:entrar";
	}
}