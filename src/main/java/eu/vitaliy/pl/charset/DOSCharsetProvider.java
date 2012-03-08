package eu.vitaliy.pl.charset;

import java.nio.charset.Charset;
import java.nio.charset.spi.CharsetProvider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author  Vitaliy Oliynyk
 */
public class DOSCharsetProvider extends CharsetProvider {

    public static final String MAZOVIA_CHARSET_NAME = "CP-896";
    public static final String LATIN_2_CHARSET_NAME = "CP-852";
    public final static String[] MAZOVIA_ALIASES = new String[]{
        "Mazovia",
        "Mazovia",
        "mazovia",
        "CP896",
        "cp896",
        "cp-896",
        "CP620",
        "cp620",
        "CP-620",
        "cp-620",
        "CP790",
        "cp790",
        "CP-790",
        "cp-790",
        "CP-896"
    };
    private static List<Charset> charsets;

    @Override
    public Iterator<Charset> charsets() {
        if (charsets == null || charsets.isEmpty()) {
            charsets = new ArrayList<Charset>(2);
            charsets.add(new MazoviaCharset(MAZOVIA_CHARSET_NAME, MAZOVIA_ALIASES));
            charsets.add(new IBMLatinCharset(LATIN_2_CHARSET_NAME, null));
        }

        return charsets.iterator();
    }

    @Override
    public Charset charsetForName(String charsetName) {

        List<String> mazoviaList = Arrays.<String>asList(MAZOVIA_ALIASES);
        if (mazoviaList.contains(charsetName.trim())) {
            return new MazoviaCharset(MAZOVIA_CHARSET_NAME, MAZOVIA_ALIASES);
        } else if (charsetName.trim().equalsIgnoreCase(LATIN_2_CHARSET_NAME)) {
            return new IBMLatinCharset(LATIN_2_CHARSET_NAME, null);
        } else {
            return null;
        }
    }
}
