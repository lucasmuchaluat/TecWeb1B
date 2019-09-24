package mvc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TarefaDAO {
	private Connection connection = null;
	String url = System.getenv("mysql_url");
	String user = System.getenv("mysql_user");
	String password = System.getenv("mysql_password");
	public TarefaDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(url, user, password);
//			connection = DriverManager.getConnection("jdbc:mysql://localhost/dados_projeto1", "root", "lucasMuchaluat1");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void adicionaTarefa(Tarefa tarefa) throws SQLException {
		String sql = "INSERT INTO Tarefas " + "(user, type, task, date) VALUES (?,?,?,?)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, tarefa.getUser());
		stmt.setString(2, tarefa.getType());
		stmt.setString(3, tarefa.getTask());
		stmt.setDate(4, new java.sql.Date(tarefa.getDate().getTimeInMillis()));
		stmt.execute();
		stmt.close();
	}
	
	public void apagaTarefa(Integer id) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("DELETE FROM Tarefas WHERE id=?");
		stmt.setLong(1, id);
		stmt.execute();
		stmt.close();
		
		if (id == 0) {
			PreparedStatement reset = connection.prepareStatement("ALTER TABLE Tarefas AUTO_INCREMENT = 1");
			reset.execute();
			reset.close();
		}
	}
	
	public void editaTarefa(Tarefa tarefa) throws SQLException {
		String sql = "UPDATE Tarefas SET user=?, type=?, task=?, date=? WHERE id=?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, tarefa.getUser());
		stmt.setString(2, tarefa.getType());
		stmt.setString(3, tarefa.getTask());
		stmt.setDate(4, new java.sql.Date(tarefa.getDate().getTimeInMillis()));
		stmt.setInt(5, tarefa.getId());
		stmt.execute();
		stmt.close();
	}
	
	public List<Tarefa> getTarefas() throws SQLException {
		
		List<Tarefa> tarefas = new ArrayList<Tarefa>();

		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Tarefas");
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {

			Tarefa tarefa = new Tarefa();

			tarefa.setId(rs.getInt("id"));
			tarefa.setUser(rs.getString("user"));
			tarefa.setType(rs.getString("type"));
			tarefa.setTask(rs.getString("task"));
			
			Calendar quando = Calendar.getInstance();
			quando.setTime(rs.getDate("date"));
			tarefa.setDate(quando);
	
			tarefas.add(tarefa);
		}

		rs.close();
		stmt.close();
		return tarefas;
	}

	public void close() throws SQLException {
		connection.close();
	}
}