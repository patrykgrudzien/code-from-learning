package com.jurik99.messenger.helpers;

import javax.ws.rs.core.UriInfo;

import com.jurik99.messenger.model.Link;

public class LinkHelper
{
	public static String createLinkUri(final UriInfo uriInfo, final Class<?> classResource,
			                                  final Object resourceProperty)
	{
		return uriInfo.getBaseUriBuilder().path(classResource).path(String.valueOf(resourceProperty)).build()
		              .toString();
	}

	public static String createLinkUriForSubResource(final UriInfo uriInfo, final Class<?> mainResourceClass,
			                                                final String methodName, final Class<?> subResourceClass,
			                                                final String propertyKey, final Object propertyValue)
	{
		return uriInfo.getBaseUriBuilder().path(mainResourceClass).path(mainResourceClass, methodName).path(
				subResourceClass).resolveTemplate(propertyKey, String.valueOf(propertyValue)).build().toString();
		/*
		 * We have to use "resolveTemplate()" method because to get sub-resource URI we pass
		 * "methodName - getCommentResource()" defined in MessageResource that has "@Path("/{messageId}/comments")"
		 * annotation and Jersey must know what is {messageId}
		 */
	}

	public static Link createLink(final String linkUri, final String reference)
	{
		final Link link = new Link();
		link.setLink(linkUri);
		link.setReference(reference);
		return link;
	}
}
