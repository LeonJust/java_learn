import java.net.InetAddress;
import java.net.UnknownHostException;

public class Mexception {
    public static void main(String[] args) throws UnknownHostException {
        System.out.println(InetAddress.getLocalHost().toString());
    }
}