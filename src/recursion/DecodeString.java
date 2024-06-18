package recursion;

// lc 394.字符串解码
public class DecodeString {

    private static int where;

    public String decodeString(String s) {
        return decode(s.toCharArray(), 0);
    }

    private String decode(char[] array, int i) {
        StringBuilder builder = new StringBuilder();
        int times = 0;
        while (i < array.length && array[i] != ']') {
            if (array[i] >= '0' && array[i] <= '9') {
                times = times * 10 + array[i++] - '0';
            } else if (array[i] == '[') {
                String result = decode(array, i + 1);
                builder.append(get(times, result));
                times = 0;
                i = where + 1;
            } else {
                builder.append(array[i++]);
            }
        }
        where = i;
        return builder.toString();
    }

    private String get(int times, String s) {
        return String.valueOf(s).repeat(Math.max(0, times));
    }
}
