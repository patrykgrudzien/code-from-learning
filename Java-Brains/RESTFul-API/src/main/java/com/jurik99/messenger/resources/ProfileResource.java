package com.jurik99.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.List;

import com.jurik99.messenger.model.Profile;
import com.jurik99.messenger.service.ProfileService;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource
{
	private ProfileService profileService = new ProfileService();

	@GET
	public List<Profile> getProfiles()
	{
		return profileService.getAllProfiles();
	}

	@POST
	public Profile addProfile(final Profile profile)
	{
		return profileService.addProfile(profile);
	}

	@GET
	@Path("/{profileName}")
	public Profile getProfile(@PathParam("profileName") final String profileName)
	{
		return profileService.getProfile(profileName);
	}

	@PUT
	@Path("/{profileName}")
	public Profile updateProfile(@PathParam("profileName") final String profileName, final Profile profile)
	{
		profile.setProfileName(profileName);
		return profileService.updateProfile(profile);
	}

	@DELETE
	@Path("/{profileName}")
	public void deteleProfile(@PathParam("profileName") final String profileName)
	{
		profileService.removeProfile(profileName);
	}
}
