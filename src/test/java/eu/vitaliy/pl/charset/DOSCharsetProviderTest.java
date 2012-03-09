package eu.vitaliy.pl.charset;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.nio.charset.Charset;
import java.nio.charset.spi.CharsetProvider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.fest.assertions.Assertions.*;
import static junitparams.JUnitParamsRunner.*;

/**
 * Created by IntelliJ IDEA.
 * User: xaoc
 * Date: 08.03.12
 * Time: 16:55
 * To change this template use File | Settings | File Templates.
 */
@RunWith(JUnitParamsRunner.class)
public class DOSCharsetProviderTest {


    private CharsetProvider charsetProvider;

    @Before
    public void before() {
        charsetProvider = new DOSCharsetProvider();
    }

    @Test
    @Parameters(method = "charsetValues")
    public void charsetForNameTest(String charsetName) {
        //given

        //when
        Charset charset = charsetProvider.charsetForName(charsetName);

        //then
        assertThat(charset).isNotNull();
    }

    private Object[] charsetValues() {
        List<Object[]> charsets = new ArrayList<Object[]>((DOSCharsetProvider.MAZOVIA_ALIASES.length + 2) * 3);

        String[] aliases = DOSCharsetProvider.MAZOVIA_ALIASES;

        for (int i = 0;i < aliases.length; i++) {
            charsets.add( $(aliases[i]) );
            charsets.add( $(aliases[i].toLowerCase() ));
            charsets.add( $(aliases[i].toUpperCase()));
        }
        charsets.add( $(DOSCharsetProvider.MAZOVIA_CHARSET_NAME ));
        charsets.add( $(DOSCharsetProvider.MAZOVIA_CHARSET_NAME.toLowerCase()));
        charsets.add( $(DOSCharsetProvider.MAZOVIA_CHARSET_NAME.toUpperCase()));
        charsets.add( $(DOSCharsetProvider.LATIN_2_CHARSET_NAME));
        charsets.add( $(DOSCharsetProvider.LATIN_2_CHARSET_NAME.toLowerCase()));
        charsets.add( $(DOSCharsetProvider.LATIN_2_CHARSET_NAME.toUpperCase()));
        return charsets.toArray();

    }
}
