public class SpielverlaufCounter {

    public static int countGamePaths(int toreA, int toreB) {
        return countPaths(0, 0, toreA, toreB);
    }

    private static int countPaths(int a, int b, int toreA, int toreB) {
        if (a > toreA || b > toreB) return 0;
        if (a == toreA && b == toreB) return 1;
        return countPaths(a + 1, b, toreA, toreB) + countPaths(a, b + 1, toreA, toreB);
    }

    public static void main(String[] args) {
        System.out.println(countGamePaths(0, 0)); // → 1
        System.out.println(countGamePaths(4, 0)); // → 1
        System.out.println(countGamePaths(2, 1)); // → 3
        System.out.println(countGamePaths(2, 5)); // → 21
    }
}
