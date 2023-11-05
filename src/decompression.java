import java.util.*;
import java.io.*;

public class decompression {
    public static String decompress(String compressedInput) {
        List<Integer> compressedData = parse(compressedInput);

        HashMap<Integer, String> dictionary = new HashMap<>();
        for (int i = 0; i < 128; i++) {
            dictionary.put(i, Character.toString(i));
        }

        int currentCode = 128;
        String previous = Character.toString(compressedData.remove(0));

        StringBuilder decompressed = new StringBuilder(previous);

        for (int code : compressedData) {
            String entry;
            if (dictionary.containsKey(code)) {
                entry = dictionary.get(code);
            } else if (code == currentCode) {
                entry = previous + previous.charAt(0);
            } else {
                throw new IllegalArgumentException("Invalid compressed data");
            }

            decompressed.append(entry);
            dictionary.put(currentCode++, previous + entry.charAt(0));
            previous = entry;
        }

        return decompressed.toString();
    }

    public static List<Integer> parse(String input) {
        List<Integer> compressedData = new ArrayList<>();
        String result=input.substring(1,input.length()-1);
        String[] values = result.split(", ");

        for (String value : values) {
            compressedData.add(Integer.parseInt(value.trim()));
        }

        return compressedData;
    }

    public static void main(String[] args) {
        String inputString = "[65, 66, 65, 128, 128, 129, 131, 134, 130, 129, 66, 138, 139, 138]";
        String decompressedData = decompress(inputString);
        System.out.println(decompressedData);
    }
}
