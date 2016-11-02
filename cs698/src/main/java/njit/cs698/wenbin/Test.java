package njit.cs698.wenbin;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
  
  public static void main(String[] args) {
    
    String str = "“;Ét.oi.lesdgeere;.";
    String str2 = "$12345,";
    String str3 = "1234";
    Pattern pt = Pattern.compile("^\\W*(\\w+[.\\w]*\\w)\\W*$", Pattern.UNICODE_CHARACTER_CLASS);
    Matcher m = pt.matcher(str);
    if(m.find()) {
      System.out.println(m.group(1));
      
    }
    System.out.println(str.matches("^[a-zA-Z]+\\w*\\W?"));
    System.out.println(str2.matches("^[a-zA-Z]+\\w*[\\W]?"));
    System.out.println(str3.matches("^[a-zA-Z]+\\w*[\\W]?"));
    System.out.println(str.endsWith("\\w"));
    
    ArrayList<String> list = new ArrayList();
    list.add("hello");
    list.add("World");
    for (String s: list) {
      System.out.println(s);
    }
  }

}
