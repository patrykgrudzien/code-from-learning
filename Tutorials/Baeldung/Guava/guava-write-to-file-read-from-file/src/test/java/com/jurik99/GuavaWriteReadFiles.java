package com.jurik99;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.io.ByteSink;
import com.google.common.io.CharSink;
import com.google.common.io.CharSource;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class GuavaWriteReadFiles {

	// --- Write using Files ---
	@Test
	public void whenWriteUsingFiles_thenWritten() throws IOException {

		String expectedValue = "Hello world";
		File file = new File("test.txt");

		Files.write(expectedValue, file, Charsets.UTF_8);
		String result = Files.toString(file, Charsets.UTF_8);

		assertEquals(expectedValue, result);
		// --- Note that we can also append to an existing file using the Files.append() API ---
	}

	// --- Write to File using CharSink ---
	@Test
	public void whenWriteUsingCharSink_thenWritten() throws IOException {

		String expectedValue = "Hello world 2";
		File file = new File("test-2.txt");

		CharSink charSink = Files.asCharSink(file, Charsets.UTF_8);
		charSink.write(expectedValue);

		String result = Files.toString(file, Charsets.UTF_8);
		assertEquals(expectedValue, result);
	}

	/*
	* We can also use CharSink to write multiple lines to a file.
	* In the following example – we write a List of names and we use a space as a line separator:
	*/
	@Test
	public void whenWriteMultipleLinesUsingCharSink_thenWritten() throws IOException {

		List<String> names = Lists.newArrayList("John", "Jane", "Adam", "Tom");
		File file = new File("test-3.txt");

		CharSink charSink = Files.asCharSink(file, Charsets.UTF_8);
		charSink.writeLines(names, " ");

		String result = Files.toString(file, Charsets.UTF_8);

		String expectedValue = Joiner.on(" ").join(names);

		assertEquals(expectedValue, result.trim());
	}

	// --- Write to File using ByteSink ---
	@Test
	public void whenWriteUsingByteSink_thenWritten() throws IOException {

		String expectedValue = "Hello world 4";
		File file = new File("test-4.txt");

		ByteSink byteSink = Files.asByteSink(file);
		byteSink.write(expectedValue.getBytes());

		String result = Files.toString(file, Charsets.UTF_8);
		assertEquals(expectedValue, result);
	}

	// --- Read from File using Files ---
	@Test
	public void whenReadMultipleLinesUsingFiles_thenRead() throws IOException {

		File file = new File("test-5.txt");
		List<String> result = Files.readLines(file, Charsets.UTF_8);

		assertThat(result, contains("John", "Jane", "Adam", "Tom"));
	}

	// --- Read from File using CharSource ---
	@Test
	public void whenReadUsingCharSource_thenRead() throws IOException {

		String expectedValue = "Patrick December";
		File file = new File("test-6.txt");

		CharSource charSource = Files.asCharSource(file, Charsets.UTF_8);
		String result = charSource.read();

		assertEquals(expectedValue, result);
	}
}
