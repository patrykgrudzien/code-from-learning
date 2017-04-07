package com.jurik99.messenger.helpers;

import com.jurik99.messenger.model.Link;

public class LinkHelper
{
	public static Link createLink(final String linkUri, final String reference)
	{
		final Link link = new Link();
		link.setLink(linkUri);
		link.setReference(reference);
		return link;
	}
}
