package me.jurik99.dto.named_queries;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "UserDetails.byId", query = "from UserDetails where userId = ?")
@NamedNativeQuery(name = "UserDetails.byName",
		query = "SELECT * FROM user_details WHERE user_name = ?",
		resultClass = UserDetails.class)
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
