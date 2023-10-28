package _01_StringBuilder;


public class _03_StringBuilder {
    
    public static String append(String str, char[] characters) {
    	StringBuilder builder = new StringBuilder(str);
    	String end = "";
    	
    	for(int i=0;i<characters.length;i++) {
    		end = end + characters[i];
    	}
    	String newstr = builder.append(end).toString();
    	//System.out.println(newstr);
    	
        return newstr;
    }
    
    public static String reverse(String str) {
    	
    	char[] chars = str.toCharArray();
    	String newstr = "";
    	
    	for(int i=chars.length-1;i>-1;i--) {
    		newstr = newstr + chars[i];
    	}
    	
        return newstr;
    }
    
    public static String insert(String str, int index, char newChar) {
    	
    	StringBuilder builder = new StringBuilder(str);
    	builder.insert(index, newChar);
    	String newstr = builder.toString();
    	
        return newstr;
    }
    
    public static String delete(String str, int startIndex, int endIndex) {
    	
    	StringBuilder builder = new StringBuilder(str);
    	String newstr = builder.delete(startIndex, endIndex).toString();
    	
        return newstr;
    }
}