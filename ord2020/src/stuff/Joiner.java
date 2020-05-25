package stuff;

import java.util.ArrayList;
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
        var strList = new ArrayList<String>();
        strings.forEachRemaining(s -> strList.add(s));

        var size = strList.size();
        var lastSep = lastSeparator == null ? mainSeparator : lastSeparator;

        if (size == 0) {
            return "";
        } else if (size == 1) {
            return strList.get(0);
        } else if (size == 2) {
            return String.join(lastSep, strList);
        } else {
            var firstPart = strList.subList(0, size - 1);
            var firstStr = String.join(mainSeparator, firstPart);
            var lastStr = strList.get(size - 1);
            var result = String.join(lastSep, firstStr, lastStr);

            return result;
        }
    }

    private final String mainSeparator;
    private final String lastSeparator;

    /**
     * Initialises this Joiner with the provided separators.
     * @param mainSeparator the separator to use between all but the last two elements
     * @param lastSeparator the separator to use between the last two elements
     */
    public Joiner(final String mainSeparator, final String lastSeparator) {
        this.mainSeparator = mainSeparator;
        this.lastSeparator = lastSeparator;
    }

    /**
     * Initialises this Joiner with the provided separator.
     * @param separator the separator to use between all elements
     */
    public Joiner(final String separator) {
        this.mainSeparator = separator;
        this.lastSeparator = null;
    }

    /**
     * Joins strings with the provided mainSeparator and lastSeparator
     * @param strings the strings to join
     * @return the joined strings
     */
    public String join(final Iterator<String> strings) {
        return join(strings, mainSeparator, lastSeparator);
    }

    /**
     * Joins strings with the provided mainSeparator and lastSeparator
     * @param strings the strings to join
     * @return the joined strings
     */
    public String join(final Iterable<String> strings) {
        return join(strings.iterator());
    }

    /**
     * Joins strings with the provided mainSeparator and lastSeparator
     * @param strings the strings to join
     * @return the joined strings
     */
    public String join(final String... strings) {
        var list = new ArrayList<String>();
        for (var s : strings) {
            list.add(s);
        }

        return join(list.iterator());
    }

}
