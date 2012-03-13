package eu.vitaliy.pl.charset;

import org.junit.Before;
import org.junit.Test;

import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

import static org.fest.assertions.Assertions.*;
/**
 * Created by IntelliJ IDEA.
 * User: xaoc
 * Date: 13.03.12
 * Time: 12:26
 * To change this template use File | Settings | File Templates.
 */
public class SPITest {

    private String unicodeString;
    private byte[] mazoviaBytes;

    @Before
    public void before(){
        unicodeString = makeUnicodeTestString();
        mazoviaBytes = makeMazowiaTestBytes();
    }

    @Test
    public void testDecodeFromMazowia(){
        //given
        //byte[] mazowiaBytes = new byte[]{(byte)143, (byte)134, (byte)149};

        //when
        String str2 = new String(mazoviaBytes, Charset.forName("mazovia"));

        //then
        assertThat(str2).isEqualTo(unicodeString);
    }


    @Test
    public void testEncodeToMazowia(){
        //given

        //when
        byte[] result = unicodeString.getBytes(Charset.forName("mazovia"));

        //then
        assertThat(result).isEqualTo(mazoviaBytes);
    }

    @Test(expected = UnsupportedCharsetException.class)
    public void testInvalidCharset(){
        //given

        //when
        Charset charset = Charset.forName("mazovia-bad-name");

        //then
    }


    private String makeUnicodeTestString(){
        char[] unicodeChars = new char[MazoviaCharset.CHARS_UNICODE_SORT.length];
        for(int i=0;i<unicodeChars.length; i++)
        {
            unicodeChars[i] = MazoviaCharset.CHARS_UNICODE_SORT[i][0];
        }
        return new String(unicodeChars);
    }

    private byte[] makeMazowiaTestBytes(){
        byte[] mazowiaBytes = new byte[MazoviaCharset.CHARS_UNICODE_SORT.length];
        for(int i=0;i<mazowiaBytes.length; i++)
        {
            mazowiaBytes[i] = (byte)MazoviaCharset.CHARS_UNICODE_SORT[i][1];
        }
        return mazowiaBytes;
    }
}
