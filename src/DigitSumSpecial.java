public class DigitSumSpecial {
    public static int digitSumSpecial(String s) {
        if (s.isEmpty()) return 0;
        char first = s.charAt(0);
        int value = Character.isDigit(first) ? Character.getNumericValue(first) : 0;
        return value + digitSumSpecial(s.substring(1));
    }

    public static void main(String[] args) {
        System.out.println(digitSumSpecial("1a32b35c"));  // → 14
        System.out.println(digitSumSpecial("Hallo Welt")); // → 0
    }
}
