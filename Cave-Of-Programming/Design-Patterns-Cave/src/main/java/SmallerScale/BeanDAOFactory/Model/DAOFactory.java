package SmallerScale.BeanDAOFactory.Model;

import SmallerScale.BeanDAOFactory.Model.MySQL.MySQLDAOFactory;
import SmallerScale.BeanDAOFactory.Model.Oracle.OracleDAOFactory;

public abstract class DAOFactory {

	public static final int MYSQL = 0;
	public static final int ORACLE = 1;

	public abstract PersonDAOInterface getPersonDAO();

	public abstract LogDAOInterface getLogDAO();

	public static DAOFactory getFactory(final int type) {
		switch (type) {
			case MYSQL:
				return new MySQLDAOFactory();
			case ORACLE:
				return new OracleDAOFactory();
			default:
				return null;
		}
	}
}
