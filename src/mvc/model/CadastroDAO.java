package mvc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CadastroDAO {
	private Connection connection = null;
	String url = System.getenv("mysql_url");
	String user = System.getenv("mysql_user");
	String password = System.getenv("mysql_password");
	public CadastroDAO() {
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

	public boolean verificaUser(Cadastro pessoa) throws SQLException {
		boolean st = false;
		String sql = "SELECT * FROM Cadastro WHERE user=? and password=?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, pessoa.getUser());
		stmt.setString(2, pessoa.getPassword());
		ResultSet rs = stmt.executeQuery();
		st = rs.next();
		stmt.execute();
		stmt.close();
		return st;
	}

	public void adicionaUser(Cadastro pessoa) throws SQLException {
		String sql = "INSERT INTO Cadastro" + "(user, password) VALUES (?,?)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, pessoa.getUser());
		stmt.setString(2, pessoa.getPassword());
		stmt.execute();
		stmt.close();
	}
	
	public List<Cadastro> getCadastros() throws SQLException {
		
		List<Cadastro> cadastros = new ArrayList<Cadastro>();

		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Cadastro");
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {

			Cadastro user = new Cadastro();

			user.setId(rs.getInt("id"));
			user.setUser(rs.getString("user"));
			user.setPassword(rs.getString("password"));
			cadastros.add(user);
		}

		rs.close();
		stmt.close();
		return cadastros;
	}

	public void close() throws SQLException {
		connection.close();
	}
}