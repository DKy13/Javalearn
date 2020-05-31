import org.junit.Test;

import java.io.PrintWriter;
import java.io.StringWriter;

public class PrintWriterTest {

    @Test
    public void t1(){
        try {
            int i = 1/0;
            System.out.println("1/0");
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            System.err.println(sw.toString());
        }
        System.out.println("t1");
    }
}
