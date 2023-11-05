import java.util.*;
import java.io.*;
public class compression {
    public static String compress(String data){
        int dicSize=128;
        Map<String,Integer>dic=new HashMap<>();

        for (int i = 65; i < dicSize; i++) {
            dic.put(String.valueOf((char)i), i);
        }
        // "ABAABABBAABA"
        StringBuilder sb=new StringBuilder();
        int i=0;
        while( i < data.length()) {
            int matching=0;
            while(i+matching<data.length()&&dic.containsKey(data.substring(i, i+matching+1))){
                matching++;
            }
            String currentSubstring=data.substring(i,i+matching);
            sb.append(dic.get(currentSubstring));
            if (i + matching < data.length() - 1) {
                sb.append(",");
            }

            if (i+matching<data.length()) {
                dic.put(currentSubstring+data.charAt(i+matching),dicSize++);
            }

            i += matching;
            
        }
        return sb.toString();
    }  
}
