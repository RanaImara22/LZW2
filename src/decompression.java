
import java.util.*;
import java.io.*;
class decompression {
    public static String decompress(List<Integer> compressed) {
        HashMap<Integer, String> dictionary = new HashMap<>();
        for (int i = 0; i < 128; i++) {
            dictionary.put(i, Character.toString((char) i));
        }

        int currentCode = 128;
        String previous = Character.toString((char)(int)compressed.remove(0));
        StringBuilder decompressed = new StringBuilder(previous);

        for (int code : compressed) {
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
}