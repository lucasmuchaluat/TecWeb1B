package mvc.controller;

import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import mvc.model.Tarefa;
import mvc.model.TarefaDAO;

@Controller
public class TarefasController {
	
	@RequestMapping("home")
	public String home() {
		return "crud";
	}
	
	@RequestMapping("adiciona_get")
	public String adicionaGet(Tarefa tarefa, HttpSession session) throws ParseException {
		session.setAttribute("user", tarefa.getUser());
		return "add";
	}
	
	@RequestMapping("adiciona_post")
	public String adicionar(Tarefa tarefa) {
		TarefaDAO dao = new TarefaDAO();
		try {
			dao.adicionaTarefa(tarefa);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "crud";
	}
	
	@RequestMapping("apaga")
	public String remove(Tarefa tarefa) {
		TarefaDAO dao = new TarefaDAO();
		try {
			dao.apagaTarefa(tarefa.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "crud";
	}

	@RequestMapping("edita_get")
	public String editaGet(Tarefa tarefa, HttpSession session) throws ParseException {
		session.setAttribute("id", tarefa.getId());
		session.setAttribute("name", tarefa.getUser());
		session.setAttribute("type", tarefa.getType());
		session.setAttribute("task", tarefa.getTask());
		session.setAttribute("date", tarefa.getDate());
		
		return "editor";
	}
	
	@RequestMapping("edita_post")
	public String editaPost(Tarefa tarefa) throws ParseException {
		TarefaDAO dao = new TarefaDAO();
		try {
			dao.editaTarefa(tarefa);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "crud";
	}
}