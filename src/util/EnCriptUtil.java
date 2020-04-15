package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 閸旂喕鍏樼粻锟界矙閿涙瓉D5閸旂姴鐦戝銉ュ徔缁拷 鐎靛棛鐖滅粵澶婄暔閸忋劋淇婇幁顖氱摠閸忋儲鏆熼幑顔肩氨閺冭绱濇潪顒佸床閹存�D5閸旂姴鐦戣ぐ銏犵础
 * 
 * @author
 * 
 * 
 */
public class EnCriptUtil {
	// encriptType閸欘垯浜掗柅澶屾暏MD5閸滃HA-1
	public static String getEcriptStr(String inStr, String encriptType) {
		String outStr = null;
		if (inStr == null) {
			outStr = null;
		} else if ("".equals(inStr)) {
			outStr = "";
		} else {
			try {
				MessageDigest md = MessageDigest.getInstance(encriptType);
				md.update(inStr.getBytes());
				byte b[] = md.digest();

				StringBuffer buf = new StringBuffer();
				for (int i = 0; i < b.length; i++) {
					int c = b[i] >>> 4 & 0xf;
					buf.append(Integer.toHexString(c));
					c = b[i] & 0xf;
					buf.append(Integer.toHexString(c));
				}
				outStr = buf.toString();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return outStr;
	}

	// 123456 -> md5鐎靛棙鏋�
	// 閻€劋绨悽鐔稿灇鐎靛湱鏁ら幋宄扮槕閻浇绻樼悰瀹甦5閸旂姴鐦戦惃鍕摟缁楋缚瑕嗙紒鎾寸�閿涘奔濞囬悽銊ф暏閹村嘲鎮�閸忔娊鏁�锟界�鍡欑垳
	public static String fix(String str1, String str2) {
		return str1 + "ac" + SystemParameter.key + "bd" + str2;
	}

	// public static void main(String args[]) {
	// // String str = "123456";
	// // System.out.println(EnCriptUtil.getEcriptStr("TravelForumAdmin123456",
	// // "MD5"));
	//
	// String str = fix("admin", "123456");
	// System.out.println(str);
	// String s = EnCriptUtil.getEcriptStr(str, "MD5");
	// System.out.println(s);
	// System.out.println(s.length());
	// // 2c415067d31c71e2dd364ae173c78a
	// }
}