public class KeyInfo {
	String okey;
	String expires;
	String device;
	
	public String getOkey() { return okey; }
	public String getExpires() { return expires; }
	public String getDevice() { return device; }
	public void setOkey(String s) { okey = s; }
	public void setExpires(String s) { expires = s; }
	public void setDevice(String s) { device = s; }
	
	
	KeyInfo() {
		device = okey = expires = null;
	}
		
	public String hexStringToAscii(String hex) {	
		byte[] bytes = new byte[hex.length() / 2];
		boolean rest_null = false;
		for (int i = 0; i < bytes.length; i++) {
		   if(!rest_null) {
			   bytes[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
			   if(bytes[i] == 0) {
				   rest_null = true;
			   }
		   } else {
			   bytes[i] = (byte)0;
		   }		   
		}
		return new String(bytes);	
	}
	
	public String toString() {
		String s = null;
		s = new String(okey).trim();
		s = s + " " + new String(expires).trim();
		s = s + " " + device;
		return s;
	}
		
	public static int getChar(byte[] array, int offset) {
        return (array[offset] & 0xff);
    }
	public static int getChar(byte[] array) {
        return (array[0] & 0xff);
    }
	
	public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                                 + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }

    public static void main(String... args) {
      System.out.println("Hello.");
      KeyInfo k = new KeyInfo();
      k.setOkey("303731352033");
      k.setExpires("Never");
      k.setDevice("N9OH-1000");
      System.out.println("key: " + k.hexStringToAscii(k.getOkey()));
    }
}
