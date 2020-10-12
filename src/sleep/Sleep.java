package sleep;
public class Sleep {
    public static void main(String[] args) {
        int[] a = new int[20];
        for(int i=1;i<=20;i++) {
            a[i-1] = i;
            try {
                Thread.sleep(1000);
            }
            catch (Exception e) {
                e.getStackTrace();
            }
            System.out.println(a[i-1]);
        }
    }
}
