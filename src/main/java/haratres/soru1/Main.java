package haratres.soru1;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.print("Lütfen  maksimum karakter sayısını girin: ");
        Scanner scanner = new Scanner(System.in);
        int maxSize = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Girdiğiniz sayı: " + maxSize);
        System.out.print("Lütfen metni giriniz: ");
        String userInput = "";
        int inputSize = 0;
        do {
            userInput = scanner.nextLine();
            inputSize = userInput.length();
            if (inputSize > maxSize) {
                System.out.print("Lütfen limit dahilinde bir cümle giriniz: ");
            }
        } while (inputSize > maxSize);
        Boolean isCaseSensitive;
        System.out.print("Büyük küçük hassasiyeti istiyor musunuz? (evet/hayır): ");
        String sensitivityPreference="";
        while (true) {
            System.out.print("Büyük/küçük harf duyarlılığı aktif olsun mu? (Evet/Hayır): ");
            sensitivityPreference = scanner.nextLine();

            if (sensitivityPreference.equalsIgnoreCase("Evet")) {
                System.out.println("Büyük/küçük harf duyarlılığı aktif.");
                isCaseSensitive=true;
                break;
            } else if (sensitivityPreference.equalsIgnoreCase("Hayır")) {
                System.out.println("Büyük/küçük harf duyarlılığı devre dışı.");
                isCaseSensitive=false;
                break;
            } else {
                System.out.println("Lütfen geçerli bir cevap giriniz (Evet/Hayır).");
            }
        }


        char targetChar;
        while (true) {
            System.out.print("Analiz etmek için bir harf girin: ");
            String charInput = scanner.nextLine().trim();
            if (charInput.length() == 1) {
                targetChar = charInput.charAt(0);
                break;
            } else {
                System.out.println("Geçerli bir karakter giriniz.");
            }
        }

        int count = 0;
        for (char c : userInput.toCharArray()) {
            if (isCaseSensitive) {
                if (c == targetChar) {
                    count++;
                }
            } else {
                if (Character.toLowerCase(c) == Character.toLowerCase(targetChar)) {
                    count++;
                }
            }
        }
        System.out.println("Girilen cümlede '" + targetChar + "' harfi toplamda " + count + " defa geçmektedir.");


        scanner.close();
    }
}