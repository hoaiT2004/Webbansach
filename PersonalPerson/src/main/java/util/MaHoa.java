package util;

import java.security.MessageDigest;

import org.apache.tomcat.util.codec.binary.Base64;

public class MaHoa {
//sha - 1 ==> thường được sử dụng
	//md5
	public static String toSHA1 (String str) {
		String salt = "asdfghjkl123;sdsas@23Sasdjaasdjiwadjasda%532";
		String res = "";
		str = str + salt;
		try {
			byte[] dataBytes = str.getBytes("UTF-8");
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			res = Base64.encodeBase64String(md.digest(dataBytes));
			//digest:tiêu hóa
			//define:định nghĩa 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	return res;
	}
	public static void main(String[] args) {
		System.out.println(toSHA1("12345"));
	}
}
