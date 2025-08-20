package chucknorris;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean isProgramRunning = true;
        while (isProgramRunning) {
            System.out.println("Please input operation (encode/decode/exit):");
            String userChoice = sc.nextLine();

            switch (userChoice) {
                case "encode":
                    System.out.println("Input string:");
                    String encodeInput = sc.nextLine();
                    String binaryInput = "";
                    for (char ch : encodeInput.toCharArray()) {
                        binaryInput += convertCharToBinary(ch);
                    }

                    System.out.println("Encoded string:");
                    System.out.println(convertBinaryToCipher(binaryInput));
                    System.out.println();
                    break;
                case "decode":
                    System.out.println("Input encoded string:");
                    String decodeInput = sc.nextLine();
                    if (!areEncodedInputCharsValid(decodeInput) ||
                            !areEncodedInputBlocksValid(decodeInput) ||
                            !areEncodedInputBlocksCountEven(decodeInput)) {
                        System.out.println("Encoded string is not valid.\n");
                        break;
                    }
                    StringBuilder binaryResult = new StringBuilder(convertCipherToBinary(decodeInput));
                    if (!isDecodedBinaryStringValid(binaryResult.toString())) {
                        System.out.println("Encoded string is not valid.\n");
                        break;
                    }
                    char[] result = new char[binaryResult.length() / 7];
                    for (int i = 0; i < result.length; i++) {
                        result[i] = convertBinaryToChar(binaryResult.substring(0, 7));
                        binaryResult.delete(0, 7);
                    }

                    System.out.println("Decoded string:");
                    System.out.println(result);
                    System.out.println();
                    break;
                case "exit":
                    System.out.println("Bye!");
                    isProgramRunning = false;
                    break;
                default:
                    System.out.printf("There is no '%s' operation\n\n", userChoice);
            }
        }
    }

    static String convertCharToBinary(char ch) {
        String binaryCh = Integer.toBinaryString(ch);
        return String.format("%7s", binaryCh).replace(" ", "0");
    }

    static String convertBinaryToCipher(String binary) {
        String cipher = "";

        for (int i = 0; i < binary.length(); ) {
            if (binary.charAt(i) == '1') {
                cipher += "0 ";
                while (i < binary.length() && binary.charAt(i) == '1') {
                    cipher += "0";
                    i++;
                }
                cipher += " ";
            } else {
                cipher += "00 ";
                while (i < binary.length() && binary.charAt(i) == '0') {
                    cipher += "0";
                    i++;
                }
                cipher += " ";
            }
        }

        return cipher;
    }

    static String convertCipherToBinary(String cipher) {
        String binary = "";
        for (int i = 0; i < cipher.length(); ) {
            if (cipher.charAt(i) == '0' && cipher.charAt(i + 1) == ' ') {
                i += 2;
                while (i < cipher.length() && cipher.charAt(i) == '0') {
                    binary += "1";
                    i++;
                }
                i++;
            } else if (cipher.charAt(i) == '0' && cipher.charAt(i + 1) == '0' && cipher.charAt(i + 2) == ' ') {
                i += 3;
                while (i < cipher.length() && cipher.charAt(i) == '0') {
                    binary += "0";
                    i++;
                }
                i++;
            }
        }
        return binary;
    }

    static char convertBinaryToChar(String binary) {
        return (char) Integer.parseInt(binary, 2);
    }

    static boolean areEncodedInputCharsValid(String cipher) {
        for (char c : cipher.toCharArray()) {
            if (c != '0' && c != ' ') {
                return false;
            }
        }
        return true;
    }

    static boolean areEncodedInputBlocksValid(String cipher) {
        for (int i = 0; i < cipher.length(); ) {
            if (i == cipher.length() || i + 1 == cipher.length() || i + 2 == cipher.length()) {
                return false;
            }
            if (cipher.charAt(i) == '0' && cipher.charAt(i + 1) == ' ') {
                i += 2;
                while (i < cipher.length() && cipher.charAt(i) == '0') {
                    i++;
                }
                i++;
            } else if (cipher.charAt(i) == '0' && cipher.charAt(i + 1) == '0' && cipher.charAt(i + 2) == ' ') {
                i += 3;
                while (i < cipher.length() && cipher.charAt(i) == '0') {
                    i++;
                }
                i++;
            } else {
                return false;
            }
        }
        return true;
    }

    static boolean areEncodedInputBlocksCountEven(String cipher) {
        return cipher.split(" ").length % 2 == 0;
    }

    static boolean isDecodedBinaryStringValid(String binaryResult) {
        return binaryResult.length() % 7 == 0;
    }
}