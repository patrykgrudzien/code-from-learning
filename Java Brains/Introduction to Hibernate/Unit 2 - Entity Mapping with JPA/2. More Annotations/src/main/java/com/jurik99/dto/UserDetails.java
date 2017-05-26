package com.jurik99.dto;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import java.util.Date;

/*
 * Difference between @Entity and @Table is that
 * @Entity(name = "") - specify the Entity name itself (btw. table name). By default it is the name of Java class.
 * @Table(name = "") - specify the Table name WITOHUT changing entity name. Entity name remains the same as Java class.
 *
 * When we'll be writing Hibernate SQL, we'll be using ENTITY NAME.
 */
@Entity
@Table(name = "USER_DETAILS_MORE_ANNOTATIONS")
public class UserDetails
{
	@Id
	private int userId;

	/*
	 * @Basic annotation treats as a field that should be persisted and applies HIBERNATE DEFAULT type.
	 * Even without that annotation, Hibernate treats "userName" as a field that should be persisted and applies
	 * DEFAULT type.
	 *
	 * We would use @Basic to configure a few other things because there are a couple of properties.
	 * @Basic(fetch = FetchType.EAGER || FetchType.LAZY)
	 * @Basic(optional = true || false)
	 *
	 * It's simply an OPTIONAL ANNOTATION.
	 */
	@Basic
	private String userName;

	/*
	 * Let's say we want only to save DATE in "joineddate" column WITHOUT TIME.
	 * In such case we have to use:
	 * @Temporal(TemporalType.DATE || TemporalType.TIME || TemporalType.TIMESTAMP)  annotation
	 */
	@Temporal(TemporalType.DATE)
	private Date joinedDate;

	/*
	 * If we mark some field as TRANSIENT, we say to hibernate NOT TO PERSIST that field.
	 * Hibernate will NOT create column for that field !!!
	 */
	@Transient
	private String address;

	/*
	 * Let's say we want to write some HUGE description without being scared of length.
	 * By default Hibernate specifies for (String description) column like:
	 * "character varying(255)"
	 *
	 * If we wanna add as long description as we want we have to use:
	 * @Lob     annotation (large objects)
	 *
	 * In most databases we can have 2 types of LOB:
	 * 1) CLOB (character large objects)
	 * 2) BLOB (byte stream large objects)
	 *
	 * By annotating field @Lob, we give Hibernate a choice to take one of type specified above.
	 */
	@Lob
	private String description;

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

	public Date getJoinedDate()
	{
		return joinedDate;
	}

	public void setJoinedDate(final Date joinedDate)
	{
		this.joinedDate = joinedDate;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(final String address)
	{
		this.address = address;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(final String description)
	{
		this.description = description;
	}
}
