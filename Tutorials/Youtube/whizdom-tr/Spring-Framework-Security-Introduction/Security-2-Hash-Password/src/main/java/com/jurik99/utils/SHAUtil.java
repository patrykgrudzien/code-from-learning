package com.jurik99.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHAUtil
{
	public static String sha2(final String input)
			throws NoSuchAlgorithmException
	{
		final MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
		final byte[] result = messageDigest.digest(input.getBytes());
		final StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < result.length; i++)
		{
			stringBuilder.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
		}
		return stringBuilder.toString();
	}
}
