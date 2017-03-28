package me.jurik99.dto.transient_persistent_detached;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * If we want to make sure the object has changed before doing an UPDATE
 * we can ask HIBERNATE to first do "SELECT" query and see if the object that we want to update
 * is different then that stored in database table.
 *
 * You can tell HIBERNATE to make an UPDATE query ONLY when the "user" object has changed.
 * Otherwise do nothing.
 *
 * We need to add SPECIAL Hibernate annotation with PARAM (selectBeforeUpdate = true)
 */
@Entity
@Table(name = "USER_DETAILS")
@org.hibernate.annotations.Entity(selectBeforeUpdate = true)
public class UserDetails
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_ID")
	private int userId;

	@Column(name = "user_name")
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
		return userName;
	}

	public void setUserName(final String userName)
	{
		this.userName = userName;
	}
}
