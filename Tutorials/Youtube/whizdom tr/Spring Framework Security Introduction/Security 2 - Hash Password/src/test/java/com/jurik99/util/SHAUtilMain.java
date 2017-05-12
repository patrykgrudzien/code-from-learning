package com.jurik99.util;

import java.security.NoSuchAlgorithmException;

import com.jurik99.utils.SHAUtil;

public class SHAUtilMain
{
	public static void main(final String[] args)
			throws NoSuchAlgorithmException
	{
		System.out.println(SHAUtil.sha2("password"));
	}
}
