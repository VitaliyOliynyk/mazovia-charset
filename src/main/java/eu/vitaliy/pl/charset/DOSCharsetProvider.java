package eu.vitaliy.pl.charset;

import java.nio.charset.Charset;
import java.nio.charset.spi.CharsetProvider;
import java.util.*;

/**
 *
 * @author  Vitaliy Oliynyk
 */
public class DOSCharsetProvider extends CharsetProvider {

    public static final String MAZOVIA_CHARSET_NAME = "mazovia";
    public static final String LATIN_2_CHARSET_NAME = "cp-852";
    public final static String[] MAZOVIA_ALIASES = new String[]{
        "cp-896",
        "cp896",
        "cp620",
        "cp-620",
        "cp790",
        "cp-790"
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

        if(MAZOVIA_CHARSET_NAME.equalsIgnoreCase(charsetName)){
            return new MazoviaCharset(MAZOVIA_CHARSET_NAME, MAZOVIA_ALIASES);
        }

        List<String> mazoviaList = Arrays.asList(MAZOVIA_ALIASES);

        if (mazoviaList.contains(charsetName.toLowerCase().trim())) {
            return new MazoviaCharset(MAZOVIA_CHARSET_NAME, MAZOVIA_ALIASES);
        } else if (charsetName.trim().equalsIgnoreCase(LATIN_2_CHARSET_NAME)) {
            return new IBMLatinCharset(LATIN_2_CHARSET_NAME, null);
        } else {
            return null;
        }
    }
}
