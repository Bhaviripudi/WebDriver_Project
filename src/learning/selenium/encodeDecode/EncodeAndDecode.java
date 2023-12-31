package learning.selenium.encodeDecode;

import org.apache.commons.codec.binary.Base64;

public class EncodeAndDecode {

	public static void main(String[] args) {

		String str = "secret_sauce";
		byte[] encodedStr = Base64.encodeBase64(str.getBytes());
		System.out.println(encodedStr);//bytes format
		System.out.println("Encoded string "+new String(encodedStr));//string format
		
		byte[] decodedStr = Base64.decodeBase64(encodedStr);
		System.out.println(decodedStr);
		System.out.println("Decoded String "+new String(decodedStr));

	}

}
