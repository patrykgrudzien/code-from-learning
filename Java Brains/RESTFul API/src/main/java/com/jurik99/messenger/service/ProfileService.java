package com.jurik99.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.jurik99.messenger.database.DatabaseClass;
import com.jurik99.messenger.model.Profile;

public class ProfileService
{
	private Map<String, Profile> profiles = DatabaseClass.getProfiles();

	public ProfileService()
	{
		profiles.put("jurik99", new Profile(1L, "JuRik99", "Patryk", "December"));
	}

	public List<Profile> getAllProfiles()
	{
		return new ArrayList<>(profiles.values());
	}

	public Profile getProfile(final String profileName)
	{
		return profiles.get(profileName);
	}

	public Profile addProfile(final Profile profile)
	{
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}

	public Profile updateProfile(final Profile profile)
	{
		if (profile.getProfileName().isEmpty())
		{
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}

	public Profile removeProfile(final String profileName)
	{
		return profiles.remove(profileName);
	}
}
