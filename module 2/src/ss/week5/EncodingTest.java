package ss.week5;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.Base64;

/**
 * A simple class that experiments with the Hex encoding
 * of the Apache Commons Codec library.
 *
 */


public class EncodingTest {
	public static void main(String[] args) throws DecoderException {
        String a = "a";
        String aa = "aa";
        String aaa = "aaa";
        String aaaa = "aaaaa";

		String input = "Hello Big World";
        String hexInput = "4d6f64756c652032";
        String base64Input = "010203040506";
        String base64Input2 = "U29mdHdhcmUgU31zdGVtcw==";
        
        byte[] decodedHex = Hex.decodeHex(hexInput.toCharArray());
        byte[] decodedBase64 = Base64.decodeBase64(base64Input);
        byte[] decodedBase642 = Base64.decodeBase64(base64Input2);
        
        String hexDecoded = new String(decodedHex);
        String base64Decoded2 = new String(decodedBase642);
        
        System.out.println("Hex:" + Hex.encodeHexString(input.getBytes()));
        System.out.println("Base64:" + Base64.encodeBase64String(input.getBytes()));
        
        System.out.println("Decoded Hex:" + hexDecoded);
        System.out.println("Base64 re encode:" + Base64.encodeBase64String(decodedBase64));   
        System.out.println("Decoded Base64:" + base64Decoded2);
        
        System.out.println("Encoded Base64 of a:" + Base64.encodeBase64String(a.getBytes()));
        System.out.println("Encoded Base64 of aa:" + Base64.encodeBase64String(aa.getBytes()));
        System.out.println("Encoded Base64 of aaa:" + Base64.encodeBase64String(aaa.getBytes()));
        System.out.println("Encoded Base64 of aaaa:" + Base64.encodeBase64String(aaaa.getBytes()));        
    }
}
