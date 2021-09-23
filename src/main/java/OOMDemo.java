import java.util.ArrayList;

public class OOMDemo {
    byte[] array = new byte[1024*1024];

    public static void main(String[] args) {
        ArrayList<OOMDemo> list = new ArrayList<>();
        int count = 0;

        try {
            while (true){
                list.add(new OOMDemo());
                count++;
            }
        } catch (Error e){
            System.out.println(count);
            e.printStackTrace();
        }
    }
}
