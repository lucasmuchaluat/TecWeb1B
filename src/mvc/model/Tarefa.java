package mvc.model;

import java.util.Calendar;

public class Tarefa {
	private Integer id;
	private String user;
	private String type;
	private String task;
	private Calendar date;
	
	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTask() {
		return this.task;
	}

	public void setTask(String task) {
		this.task = task;
	}
	
	public Calendar getDate() {
		return this.date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

}
