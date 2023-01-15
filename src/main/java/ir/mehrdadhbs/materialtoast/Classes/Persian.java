package ir.mehrdadhbs.materialtoast.Classes;

import java.text.DecimalFormat;

public class Persian {

    public static String TOM = "تومان";
    public static String RIAL = "ریال";
    private static final String[] persianNumbers = new String[]{"۰", "۱", "۲", "۳", "۴", "۵", "۶", "۷", "۸", "۹"};

    public static String moneyFormat(Long price, String currency) {

        String p = String.valueOf(price).trim();
        p = p.replaceAll("\\D", "")
                .replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
        p = p + " " + currency;

        return faDigit(p);
    }

    public static String moneyFormat(long price) {

        String p = String.valueOf(price).trim();
        p = p.replaceAll("\\D", "")
                .replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
        return faDigit(p);

    }

    public static String moneyFormat(String price) {

        String p = String.valueOf(price).trim();
        p = p.replaceAll("\\D", "")
                .replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
        return faDigit(p);
    }


    public static String faDigit(String text) {
        if (text.length() == 0) {
            return "";
        }
        String out = "";
        int length = text.length();
        for (int i = 0; i < length; i++) {
            char c = text.charAt(i);
            if ('0' <= c && c <= '9') {
                int number = Integer.parseInt(String.valueOf(c));
                out += persianNumbers[number];
            }/* else if (c == '٫') {
                out += '،';
            }*/ else {
                out += c;
            }
        }
        return out;
    }

    public static String faDigit(float n) {
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setDecimalSeparatorAlwaysShown(false);
        String text = decimalFormat.format(n);
        if (text.length() == 0) {
            return "";
        }
        String out = "";
        int length = text.length();
        for (int i = 0; i < length; i++) {
            char c = text.charAt(i);
            if ('0' <= c && c <= '9') {
                int number = Integer.parseInt(String.valueOf(c));
                out += persianNumbers[number];
            } else if (c == '.') {
                out += '/';
            } else {
                out += c;
            }
        }
        return out;
    }

    public static String faDigit(double n) {
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setDecimalSeparatorAlwaysShown(false);
        String text = decimalFormat.format(n);
        if (text.length() == 0) {
            return "";
        }
        String out = "";
        int length = text.length();
        for (int i = 0; i < length; i++) {
            char c = text.charAt(i);
            if ('0' <= c && c <= '9') {
                int number = Integer.parseInt(String.valueOf(c));
                out += persianNumbers[number];
            } else if (c == '.') {
                out += '/';
            } else {
                out += c;
            }
        }
        return out;
    }

    public static String enDigit(String num) {
        return num
                .replace("۰", "0")
                .replace("۱", "1")
                .replace("۲", "2")
                .replace("۳", "3")
                .replace("۴", "4")
                .replace("۵", "5")
                .replace("۶", "6")
                .replace("۷", "7")
                .replace("۸", "8")
                .replace("۹", "9");
    }

}
