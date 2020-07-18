package learn;
//字符串加解密----牛客网
import java.util.Scanner;

public class Cryption {
    public static char encryption(char c) {
        if (c >= 'a' && c < 'z') {
            return (char) (c + 1 - 32);
        }else if (c == 'z') {
            return 'A';
        }else if (c >= 'A' && c < 'Z') {
            return (char) (c + 1 + 32);
        }else if (c == 'Z') {
            return 'a';
        }else if (c >= '0' && c < '9') {
            return (char) (c + 1);
        }else if (c == '9') {
            return '0';
        }else {
            return c;
        }
    }

    public static char  decryption(char c) {
        if (c > 'a' && c <= 'z') {
            return (char) (c - 1 - 32);
        }else if (c == 'a') {
            return 'Z';
        }else if (c > 'A' && c <= 'Z') {
            return (char) (c - 1 + 32);
        }else if (c == 'A') {
            return 'z';
        }else if (c > '0' && c <= '9') {
            return (char) (c - 1);
        }else if (c == '0') {
            return '9';
        }else {
            return c;
        }
    }

    public static String enCryption(String s) {
        char[] chars = s.toCharArray();//将此字符串转换成一个字符数组
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            sb.append(encryption(chars[i]));//append(char c)表示添加字符到StringBuffer对象中末尾
        }
        return sb.toString();//返回StringBuffer缓冲区中的字符串对象
    }

    public static String deCryption(String s) {
        char[] chars = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < chars.length ; i++) {
            sb.append(decryption(chars[i]));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();
            System.out.println(enCryption(s1));
            System.out.println(deCryption(s2));
        }
        scanner.close();
    }
}
