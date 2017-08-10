package me.jurik99.domain;

import java.util.LinkedHashMap;

public class Student
{
	private String firstName;
	private String lastName;
	private String country;
	private LinkedHashMap<String, String> countryOptions;
	private String favoriteLanguage;
	private String[] operatingSystem;

	public Student()
	{
		// --- populate country options: used ISO country code ---
		countryOptions = new LinkedHashMap<>();
		countryOptions.put("BR", "Brazil");
		countryOptions.put("PL", "Poland");
		countryOptions.put("FR", "France");
		countryOptions.put("DE", "Germany");
	}

	public String[] getOperatingSystem()
	{
		return operatingSystem;
	}

	public void setOperatingSystem(final String[] operatingSystem)
	{
		this.operatingSystem = operatingSystem;
	}

	public String getFavoriteLanguage()
	{
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(final String favoriteLanguage)
	{
		this.favoriteLanguage = favoriteLanguage;
	}

	public LinkedHashMap<String, String> getCountryOptions()
	{
		return countryOptions;
	}

	public String getCountry()
	{
		return country;
	}

	public void setCountry(final String country)
	{
		this.country = country;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(final String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(final String lastName)
	{
		this.lastName = lastName;
	}
}
