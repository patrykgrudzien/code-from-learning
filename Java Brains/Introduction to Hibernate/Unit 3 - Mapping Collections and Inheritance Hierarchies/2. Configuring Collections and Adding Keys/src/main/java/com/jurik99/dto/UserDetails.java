package com.jurik99.dto;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "USER_DETAILS_3_2_configuring_collections_and_adding_keys")
public class UserDetails
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	private String userName;

	/*
	 * In this lecture we're gonna explore some ADVANCE options of persisting collections.
	 *
	 * First thing is the name of the table. Hibernate by default gave us table name like "UserDetails_listOfAddresses".
	 * It's className + fieldName. We can change it by adding another annotation:
	 * @JoinTable (join table is that "UserDetails_listOfAddresses" table). It's an OPTIONAL annotation.
	 *
	 * HIBERNATE: insert into USER_ADDRESS (UserDetails_userId, CITY_NAME, PIN_CODE, STATE_NAME, STREET_NAME)
	 * values (?, ?, ?, ?, ?)
	 *
	 * But we still have ugly name of foreign key in "USER_ADDRESS" table like "UserDetails_userId". It can be
	 * changed by adding additional attribute inside @JoinTable like:
	 * @JoinTable(joinColumns = @JoinColumn(name = "COLUMN_NAME"))
	 *
	 * Hibernate: insert into USER_ADDRESS (USER_ID, CITY_NAME, PIN_CODE, STATE_NAME, STREET_NAME)
	 * values (?, ?, ?, ?, ?)
	 */
	@ElementCollection
	/*
	 * @JoinTable is used in the mapping of associations. It's specified on the OWNING SIDE of an association.
	 * @JoinTable = połącz ze sobą 2 tabele, stwórz "połączoną tabelę" - (główną oznaczoną @Entity i "poboczną"
	 * utworzoną przez @ElementCollection) kluczem podstawowym i obcym oraz nazwij kolumny przy pomocy
	 * atrybutu (name = " ").
	 *
	 * ----- PROFESSIONAL JAVA for WEB APPLICATIONS -----
	 *
	 * @JoinTable - you place this annotation only on the OWNER side of the relationship (the opposite side that you
	 * specify "mappedBy"). In addition to the table name and other details, this annotation contains "joinColumns"
	 * and "inverseJoinColumns" attributes. You use "joinColumns" to specify one or more @JoinColumn(s) that indicate
	 * which column or columns "THIS" (the owning) entity's primary key maps to.
	 * Likewise, you use "inverseJoinColumns" to specify one or more @JoinColumn(s) that indicate which column or
	 * columns the other (owned) entity's primary key maps to.
	 *
	 * ----- PROFESSIONAL JAVA for WEB APPLICATIONS -----
	 *
	 * When a join table is used in mapping a relationship with an embeddable class on the owning side of the
	 * relationship, the CONTAINING ENTITY rather than the EMBEDDABLE class is considered THE OWNER of the relationship.
	 *
	 * "joinColumns" is optional. The foreign key columns of the join table (USER_ADDRESS) which reference the
	 * primary table of the entity owning the association.
	 *
	 * Now we have in "USER_ADDRESS" table foreign key "USER_ID" but this table HAS NO (primary key).
	 * In order to have INDEX column we need to have DATA TYPE that SUPPORTS index. We cannot use the HashSet because
	 * there is no index support in HashSet. We have to use some implementation of Collection inferface e.g. ARRAYLIST.
	 *
	 * Having arraylist, we need to provide configuration for PRIMARY KEY.
	 * The way we do that is to use another annotation:
	 * @CollectionId (it's unique and NOT JPA annotation, it's provided ONLY by Hibernate, we don't find it in JPA !!!)
	 * it comes from:
	 * "org.hibernate.annotations.CollectionId"
	 * NOT FROM
	 * "javax.persistence"
	 * so we have to be VERY careful while changing JPA implementation !!!
	 *
	 * @GenericGenerator
	 * strategy = "sequence" (sequence is common generator type which Hibernate supplies)
	 * Previous one "hilo" is not supported ANYMORE !!!
	 *
	 * @CollectionId
	 * columns -> columns of primary key
	 * type -> type of primary key
	 * generator -> how primary key is generated
	 *
	 * HIBERNATE ANNOTATIONS:
	 * org.hibernate.annotations.CollectionId;
	 * org.hibernate.annotations.GenericGenerator;
	 * org.hibernate.annotations.Type;
	 */
	@JoinTable(name = "USER_ADDRESS", joinColumns = @JoinColumn(name = "USER_ID"))
	@GenericGenerator(name = "sequence-gen", strategy = "sequence")
	@CollectionId(
			columns = {@Column(name = "ADDRESS_ID")},
			generator = "sequence-gen",
			type = @Type(type = "long")
	)
	private Collection<Address> listOfAddresses = new ArrayList<>();
	/*
	 * To summarize, in order to have collection of objects as member variable inside our Entity class, first thing
	 * we need to do is to choose data type that supports indexes. The next thing is to define @CollectionId to have
	 * collection objects identifier. @CollectionId has properties which describe what identifier should be. We
	 * define also GENERATOR because we don't have a "ID" field in ADDRESS class and we ask hibernate to generate it
	 * automatically using generator which is "sequence" that Hibernate provides.
	 *
	 * insert into USER_ADDRESS (USER_ID, ADDRESS_ID, CITY_NAME, PIN_CODE, STATE_NAME, STREET_NAME)
	 * values (?, ?, ?, ?, ?, ?)
	 */

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

	public Collection<Address> getListOfAddresses()
	{
		return listOfAddresses;
	}

	public void setListOfAddresses(final Collection<Address> listOfAddresses)
	{
		this.listOfAddresses = listOfAddresses;
	}
}
