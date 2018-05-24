package leetcode.local;

public class Num7_ReverseInterger {
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int tail = x % 10;
            int newResult = result * 10;
            // check whether overflow
            if (newResult / 10 != result) {
                return 0;
            }
            result = newResult + tail;
            x = x / 10;
        }
        return result;
    }

    public static void main(String[] args) {
        Num7_ReverseInterger m = new Num7_ReverseInterger();
        System.out.println(m.reverse(123));
    }
}
