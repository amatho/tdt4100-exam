package stuff;

import java.util.Iterator;

public class Joiner {

	/**
	 * Joins the strings together, where all elements but the two last are separated by mainSeparator, and
	 * the two last are separated by lastSeparator. If lastSeparator is null, mainSeparator is used between all elements.
	 * E.g. if you join the strings "one", "two", "three" with mainSeparator as ", " and lastSeparator as " and ",
	 * you should get "one, to and three".
	 * If strings contains only one element, that element is returned, if it contains no elements, the empty string is returned.
	 * @param strings the strings to join
	 * @param mainSeparator the separator used between all but the two last elements
	 * @param lastSeparator the separator used between the last two elements
	 * @return strings joined with the provided separators
	 */
	public static String join(final Iterator<String> strings, final String mainSeparator, final String lastSeparator) {
		// TODO
	}

	// TODO: necessary declarations

	/**
	 * Initialises this Joiner with the provided separators.
	 * @param mainSeparator the separator to use between all but the last two elements
	 * @param lastSeparator the separator to use between the last two elements
	 */
	public Joiner(final String mainSeparator, final String lastSeparator) {
		// TODO
	}

	/**
	 * Initialises this Joiner with the provided separator.
	 * @param separator the separator to use between all elements
	 */
	public Joiner(final String separator) {
		// TODO
	}

	/**
	 * Joins strings with the provided mainSeparator and lastSeparator
	 * @param strings the strings to join
	 * @return the joined strings
	 */
	public String join(final Iterator<String> strings) {
		// TODO
	}

	/**
	 * Joins strings with the provided mainSeparator and lastSeparator
	 * @param strings the strings to join
	 * @return the joined strings
	 */
	public String join(final Iterable<String> strings) {
		// TODO
	}

	/**
	 * Joins strings with the provided mainSeparator and lastSeparator
	 * @param strings the strings to join
	 * @return the joined strings
	 */
	public String join(final String... strings) {
		// TODO
	}

}
