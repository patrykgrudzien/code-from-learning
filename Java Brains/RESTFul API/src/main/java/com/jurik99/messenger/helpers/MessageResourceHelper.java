package com.jurik99.messenger.helpers;

import javax.ws.rs.core.UriInfo;

public class MessageResourceHelper
{
	public static String createLinkPath(final UriInfo uriInfo)
	{
		return uriInfo.getAbsolutePath().toString();
	}
}
