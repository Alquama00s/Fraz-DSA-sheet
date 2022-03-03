public class test {
    static int cState(int i) {
        if (i < 2)
            return i;
        if (i % 2 == 0)
            return 1;
        return 0;
    }
    public static void main(String[] args) {
     System.out.println(cState(2));   
    }
}
