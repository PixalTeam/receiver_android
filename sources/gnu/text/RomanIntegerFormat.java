package gnu.text;

import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;

public class RomanIntegerFormat extends NumberFormat {
    static final String codes = "IVXLCDM";
    private static RomanIntegerFormat newRoman;
    private static RomanIntegerFormat oldRoman;
    public boolean oldStyle;

    public RomanIntegerFormat(boolean oldStyle2) {
        this.oldStyle = oldStyle2;
    }

    public RomanIntegerFormat() {
    }

    public static RomanIntegerFormat getInstance(boolean oldStyle2) {
        if (oldStyle2) {
            if (oldRoman == null) {
                oldRoman = new RomanIntegerFormat(true);
            }
            return oldRoman;
        }
        if (newRoman == null) {
            newRoman = new RomanIntegerFormat(false);
        }
        return newRoman;
    }

    public static String format(int num, boolean oldStyle2) {
        if (num <= 0 || num >= 4999) {
            return Integer.toString(num);
        }
        StringBuffer sbuf = new StringBuffer(20);
        int unit = 1000;
        for (int power = 3; power >= 0; power--) {
            int digit = num / unit;
            num -= digit * unit;
            if (digit != 0) {
                if (oldStyle2 || !(digit == 4 || digit == 9)) {
                    int rest = digit;
                    if (rest >= 5) {
                        sbuf.append(codes.charAt((power * 2) + 1));
                        rest -= 5;
                    }
                    while (true) {
                        rest--;
                        if (rest < 0) {
                            break;
                        }
                        sbuf.append(codes.charAt(power * 2));
                    }
                } else {
                    sbuf.append(codes.charAt(power * 2));
                    sbuf.append(codes.charAt((power * 2) + ((digit + 1) / 5)));
                }
            }
            unit /= 10;
        }
        return sbuf.toString();
    }

    public static String format(int num) {
        return format(num, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x001a  */
    public StringBuffer format(long num, StringBuffer sbuf, FieldPosition fpos) {
        String str;
        if (num > 0) {
            if (num < ((long) (this.oldStyle ? 4999 : 3999))) {
                str = format((int) num, this.oldStyle);
                if (fpos != null) {
                    long tval = 1;
                    int len = str.length();
                    int i = len;
                    while (true) {
                        i--;
                        if (i <= 0) {
                            break;
                        }
                        tval = (10 * tval) + 9;
                    }
                    new DecimalFormat("0").format(tval, new StringBuffer(len), fpos);
                }
                sbuf.append(str);
                return sbuf;
            }
        }
        str = Long.toString(num);
        if (fpos != null) {
        }
        sbuf.append(str);
        return sbuf;
    }

    public StringBuffer format(double num, StringBuffer sbuf, FieldPosition fpos) {
        long inum = (long) num;
        if (((double) inum) == num) {
            return format(inum, sbuf, fpos);
        }
        sbuf.append(Double.toString(num));
        return sbuf;
    }

    public Number parse(String text, ParsePosition status) {
        throw new Error("RomanIntegerFormat.parseObject - not implemented");
    }
}
