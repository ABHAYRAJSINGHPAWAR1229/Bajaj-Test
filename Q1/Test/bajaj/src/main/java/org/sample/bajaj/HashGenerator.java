package org.sample.bajaj;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class HashGenerator {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java HashGenerator <PRN Number> <path to JSON file>");
            return;
        }

        String prnNumber = args[0].toLowerCase().replaceAll("\\s+", "");
        String jsonFilePath = args[1];

        try {

            FileReader reader = new FileReader(jsonFilePath);
            JSONTokener tokener = new JSONTokener(reader);
            JSONObject jsonObject = new JSONObject(tokener);

            
            String destinationValue = findDestination(jsonObject);

            if (destinationValue == null) {
                System.out.println("Key 'destination' not found in the JSON file.");
                return;
            }


            String randomString = generateRandomString(8);


            String toHash = prnNumber + destinationValue + randomString;


            String hash = DigestUtils.sha256Hex(toHash);

            System.out.println(hash + ", " + randomString);

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error processing the JSON file: " + e.getMessage());
        }
    }

    private static String findDestination(JSONObject jsonObject) {
        for (String key : jsonObject.keySet()) {
            Object value = jsonObject.get(key);
            if (key.equalsIgnoreCase("destination")) {
                return value.toString();
            }
            if (value instanceof JSONObject) {
                String result = findDestination((JSONObject) value);
                if (result != null) {
                    return result;
                }
            }
        }
        return null;
    }

    private static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }
}

