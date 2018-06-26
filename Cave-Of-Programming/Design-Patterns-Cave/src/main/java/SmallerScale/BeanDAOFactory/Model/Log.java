package SmallerScale.BeanDAOFactory.Model;

import java.util.Date;

public class Log {

	private int id;
	private Date date;
	private String message;

	public int getId() {
		return id;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(final Date date) {
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(final String message) {
		this.message = message;
	}
}
