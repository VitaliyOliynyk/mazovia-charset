package eu.vitaliy.pl.charset;

import org.junit.Test;

import java.nio.charset.Charset;
import static org.fest.assertions.Assertions.*;
/**
 * Created by IntelliJ IDEA.
 * User: xaoc
 * Date: 13.03.12
 * Time: 12:26
 * To change this template use File | Settings | File Templates.
 */
public class SPITest {

    @Test
    public void testDecodeFromMazowia(){
        //given
        byte[] mazowiaBytes = new byte[]{(byte)143, (byte)134, (byte)149};

        //when
        String str2 = new String(mazowiaBytes, Charset.forName("mazovia"));

        //then
        assertThat(str2).isEqualTo("\u0104\u0105\u0106");
    }


     @Test
    public void testEncodeToMazowia(){
        //given
        byte[] expectedMazoviaBytes = new byte[]{(byte)143, (byte)134, (byte)149};
        String str = "\u0104\u0105\u0106";

        //when
        byte[] result = str.getBytes(Charset.forName("mazovia"));

        //then
        assertThat(result).isEqualTo(expectedMazoviaBytes);
    }
}
