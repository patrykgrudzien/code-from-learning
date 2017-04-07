package com.jurik99.messenger.helpers;

import javax.ws.rs.core.UriInfo;

import com.jurik99.messenger.resources.MessageResource;

public class MessageResourceHelper
{
	public static String getPathToMessageLink(final UriInfo uriInfo, final long messageId)
	{
		return uriInfo.getAbsolutePathBuilder().path(MessageResource.class).path(String.valueOf(messageId)).build()
		              .toString();
	}
}
