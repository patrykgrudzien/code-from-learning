package com.jurik99.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_DETAILS_2_4")
public class UserDetails
{
	/*
	 * NATURAL KEY - let's say we have in our application column that we know for sure HAS DISTINCT VALUES AND IT'S
	 * MANDATORY e.g. "User registration" application where we have people registering by giving "email_address",
	 * "first name", "last name" ... Later on, we have some business rules that EVERY USER needs to have an
	 * "email_ID" and every user has to provide a DISTINCT UNIQUE "email_ID" during registration. We cannot have
	 * duplicated "email_ID". In that case, we can have "email_address" as PRIMARY KEY. We simple assign one of the
	 * column to be a primary key and such keys ARE CALLED "NATURAL KEYS".
	 *
	 * SURROGATE KEY (substytut) - in that case we don't know if any column can be marked as UNIQUE or it can be
	 * changed in the future. To solve it, we simply ADD NEW COLUMN. The purpose of that column is to entirely act as
	 * PRIMARY KEY ALONE with NO BUSINESS RULES.
	 *
	 * -----------------------------------------
	 *
	 * PRIMARY KEY is a special constraint on a column or set of columns. A primary key constraint ensures that the
	 * column(s) so designated have no NULL values, and that every value is unique. Physically, a primary key is
	 * implemented by the database system using a unique index, and all the columns in the primary key must have
	 * been declared NOT NULL. A table may have only ONE PRIMARY KEY, but it may be composite (consist of more than
	 * one column).
	 *
	 * SURROGATE KEY is any column or set of columns that can be declared as the primary key INSTEAD OF a "real" or
	 * natural key. Sometimes thare can be several natural keys that could be declared as the primary key, and these
	 * are all called CANDIDATE KEYS. So a surrogate is a candidate key. A table could actually have more than one
	 * surrogate key, although this would be unusual. The most common type of surrogate key is an incrementing
	 * integer, such as an "auto_increment" column in MySQL, or a sequence in Oracle, or a identity column in SQL
	 * Server.
	 *
	 * -----------------------------------------
	 *
	 * The PRIMARY KEY is a unique key in your table that you choose that best uniquely identifies a record in the
	 * table. All tables should have a primary key, because if you even need to update or delete a record you need to
	 * know how to uniquely indentify it.
	 *
	 * SURROGATE KEY is an artifically generated key. They're useful when your records essentially have no natural
	 * key (such as a "Person" table, since it's possible for two people born on the same date to have the same name)
	 * or records in a log, since it's possible for two events to happen such they carry the same timestamp. Most
	 * often you'll see these implemented as integers in an automatically incrementing field.
	 *
	 * The main advantage of the surrogate key is that they're easy to guarantee as unique. The main disadvantage is
	 * that they don't have any meaning. There's no meaning that "28" is Wisconsin, for example, but when you see
	 * "WI" in the State column of your Address table, you know what state you're talking about without needing to
	 * look up which state is which in your State table.
	 */

	/*
	 * If the "userId" is specifically for the purpose of declaring a primary key and it HAS NO business usage - then
	 * YES, it would be a surrogate key.
	 *
	 * But if it HAS business usage or if it's a "login_ID" for example - then it would be a NATURAL KEY.
	 *
	 * ------------------ IMPORTANT ------------------
	 * If we have NATURAL KEY, it makes sense for us to provide a value. We need to be able to control it.
	 * If it's a SURROGATE KEY, we can ask Hibernate to do a job for us.
	 * ------------------ IMPORTANT ------------------
	 *
	 * If we don't need "userId" for any other reasons than using it as "ID", we can ask in that case Hibernate to
	 * generate that value for us every time when do an insert.
	 * Hibernate can automatically generate "ID" for us and we don't need to worry about last inserted index.
	 * We have to only annotate our primary key by:
	 * @GeneratedValue
	 * Hibernate is looking at type of my primary key and in that case generating INTEGER.
	 *
	 * @GeneratedValue has an attribute called STRATEGY  ->
	 * @GeneratedValue(strategy = GenerationType.IDENTITY || AUTO || SEQUENCE || TABLE)
	 * When we don't specify strategy it's going to be default one "AUTO".
	 *
	 * AUTO (recommended) generation type - it means that we let Hibernate make a decision to what strategy it
	 * needs to use
	 *
	 * IDENTITY generation type - it means that Hiberate is going to use identity columns (it's provided by some of
	 * the Databases, it's not a generic feature which is available in all databases)
	 *
	 * SEQUENCE generation type - it uses the "Sequence" object in the database in order to come up with unique ID.
	 * It is something which databases manage by themselves.
	 *
	 * TABLE generation type - Hibernate creates separate table and that table will have a record of what is the last
	 * used primary key so it can be incremented and we can get the next value.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String userName;

	public int getUserId()
	{
		return userId;
	}

	public void setUserId(final int userId)
	{
		this.userId = userId;
	}

	public String getUserName()
	{
		return userName + " from getter";
	}

	public void setUserName(final String userName)
	{
		this.userName = userName;
	}
}
