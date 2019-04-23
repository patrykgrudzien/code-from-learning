package com.jurik99;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Simply put, <b><font color="white">URL encoding</font></b> translates special characters from the URL
 * to a representation that adheres to the spec and can be correctly understood and interpreted.
 *
 * In this example, we'll focus on <b><font color="white">how to encode/decode the URL or form data</font></b>
 * so that it adheres to the spec and transmits over the network correctly.
 *
 * <hr/>
 *
 * A basic <b><font color="white">URI</font></b> can be generalized as:<br>
 * <i>scheme:[//[user:password@]host[:port]][/]path[?query][#fragment]</i>
 */
@SuppressWarnings("DanglingJavadoc")
public class Main {

	private final String testUrl = "http://www.baeldung.com?key1=value+1&key2=value%40%21%242&key3=value%253";

	/**
	 * The first step into encoding a URI is examining its parts and then encoding only the relevant portions.
	 * Let us look at an example of a URI:
	 */
	@Test
	public void givenURL_whenAnalyze_then_Correct() throws URISyntaxException {
		final URI uri = new URI(testUrl);

		assertThat(uri.getScheme(), is("http"));
		assertThat(uri.getHost(), is("www.baeldung.com"));
		assertThat(uri.getRawQuery(), is("key1=value+1&key2=value%40%21%242&key3=value%253"));
	}

	/**
	 * When encoding URI, one of the common pitfalls is encoding the complete URI.
	 * Typically, we need to encode only the query portion of the URI.
	 *
	 * Let’s encode the data using the encode(data, encodingScheme) method of the URLEncoder class.
	 *
	 * <hr/>
	 *
	 * This {@link java.net.URLEncoder#encode(String, String)} method converts the string into:
	 * <b><font color="white">application/x-www-form-urlencoded</font></b> format.
	 */
	private String encodeValue(final String value) {
		try {
			return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
		} catch (final UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}

	@Test
	public void givenRequestParam_whenUTF8Scheme_thenEncode() {
		final Map<String, String> requestParams = new HashMap<>();
		requestParams.put("key1", "value 1");
		requestParams.put("key2", "value@!$2");
		requestParams.put("key3", "value%3");

		final String encodedURL = requestParams.keySet().stream()
		                                       .map(key -> key + "=" + encodeValue(requestParams.get(key)))
		                                       .collect(Collectors.joining("&", "http://www.baeldung.com?", ""));

		assertThat(testUrl, is(encodedURL));
	}
}
