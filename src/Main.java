import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n");
            System.out.println("Choose an option:");
            System.out.println("1. Compress from console input");
            System.out.println("2. Decompress from console input");
            System.out.println("3. Compress from file ");
            System.out.println("4. Decompress from file");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1/2/3/4/5): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter the text to compress: ");
                String input = scanner.nextLine();
                String compressedData = compression.compress(input);
                System.out.println("Compressed Data: " + compressedData);
            }  else if (choice == 2) {
                System.out.print("Enter the compressed data as a list of integers separated by commas: ");
                String compressedDataInput = scanner.nextLine();
                String decompressedData = decompression.decompress(compressedDataInput);
                System.out.println("Decompressed Data: " + decompressedData);
            }
            else if (choice == 3) {
                compressFromFile();
            } else if (choice == 4) {
                decompressToFile();
            } else if (choice == 5) {
                System.out.println("Exiting the program.");
                break;
            } else {
                System.out.println("Invalid choice. Please choose a valid option.");
            }
        }

        scanner.close();
    }

    private static void compressFromFile() {
        try {
            File file = new File("java.txt");

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            StringBuilder fileContent = new StringBuilder();

            while ((line = reader.readLine()) != null) {

                fileContent.append(line);


            }
            String strcon=fileContent.toString();
            String compressedData = compression.compress(strcon);

            BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
            writer.write(compressedData);
            writer.newLine();
            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void decompressToFile() {
        try {
            File file = new File("java.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            StringBuilder fileContent = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                fileContent.append(line);

            }
            String strcon=fileContent.toString();
            String decompressedData = decompression.decompress(strcon);
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
            writer.write(decompressedData);
            writer.newLine();
            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
//"ABAABABBAABAABAAAABABBBBBBBB"
