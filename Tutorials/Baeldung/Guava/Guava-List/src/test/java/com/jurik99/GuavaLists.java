package com.jurik99;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GuavaLists {

	// --- Creating a new ArrayList ---
	private List<String> names = Lists.newArrayList("John", "Adam", "Jane");

	// --- Reverse a List ---
	@Test
	public void whenReverseList_thenReversed() {

		ArrayList<String> names = Lists.newArrayList("John", "Adam", "Jane");

		List<String> reversed = Lists.reverse(names);
		assertThat(reversed, contains("Jane", "Adam", "John"));
	}

	// --- Generate Character List from a String ---
	@Test
	public void whenCreateCharacterListFromString_thenCreated() {

		List<Character> chars = Lists.charactersOf("John");

		assertEquals(4, chars.size());
		assertThat(chars, contains('J', 'o', 'h', 'n'));
	}

	// --- Partition a List ---
	@Test
	public void whenPartitionList_thenPartitioned() {

		List<String> names = Lists.newArrayList("John", "Jane", "Adam", "Tom", "Viki", "Tyler");

		List<List<String>> result = Lists.partition(names, 2);  // each NEW list contains 2 elements (created 3 smaller lists)

		assertEquals(3, result.size());
		assertThat(result.get(0), contains("John", "Jane"));
		assertThat(result.get(1), contains("Adam", "Tom"));
		assertThat(result.get(2), contains("Viki", "Tyler"));
	}

	// --- Remove Duplicates From List ---
	@Test
	public void whenRemoveDuplicatesFromList_thenRemoved() {

		List<Character> chars = Lists.newArrayList('h', 'e', 'l', 'l', 'o');
		assertEquals(5, chars.size());

		List<Character> result = ImmutableSet.copyOf(chars).asList();
		assertThat(result, contains('h', 'e', 'l', 'o'));
	}

	// --- Remove Null Values from List ---
	@Test
	public void whenRemoveNullFromList_thenRemoved() {

		List<String> names = Lists.newArrayList("John", null, "Adam", null, "Jane");
		Iterables.removeIf(names, Objects::isNull);

		assertEquals(3, names.size());
		assertThat(names, contains("John", "Adam", "Jane"));
	}

	// --- Convert a List to an ImmutableList ---
	@Test
	public void whenCreateImmutableList_thenCreated() {

		List<String> names = Lists.newArrayList("John", "Adam", "Jane");

		names.add("Tom");
		assertEquals(4, names.size());

		ImmutableList<String> immutable = ImmutableList.copyOf(names);
		assertThat(immutable, contains("John", "Adam", "Jane", "Tom"));
	}
}
