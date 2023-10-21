package _01_StringBuilder;


public class _03_StringBuilder {
    
    public static String append(String str, char[] characters) {
    	StringBuilder builder = new StringBuilder(str);
    	String end = "";
    	
    	for(int i=0;i<characters.length;i++) {
    		end = end + characters[i];
    	}
    	String newstr = builder.append(end).toString();
    	System.out.println(newstr);
    	
        return newstr;
    }
    
    public static String reverse(String str) {
        return null;
    }
    
    public static String insert(String str, int index, char newChar) {
        return null;
    }
    
    public static String delete(String str, int startIndex, int endIndex) {
        return null;
    }
}