package com.jurik99.messenger.helpers;

import javax.ws.rs.core.UriInfo;

import com.jurik99.messenger.model.Link;

public class LinkHelper
{
	public static String createLinkPath(final UriInfo uriInfo, final Class<?> classResource, final Object reference)
	{
		return uriInfo.getBaseUriBuilder().path(classResource).path(String.valueOf(reference)).build().toString();
	}

	public static Link createLink(final String linkUri, final String reference)
	{
		final Link link = new Link();
		link.setLink(linkUri);
		link.setReference(reference);
		return link;
	}
}
