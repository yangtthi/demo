import java.io.File;

/**
 * @Description: TODO
 * @Author wyatt
 * @Data 2019/05/16 17:04
 */
public class WidTest {

    public static void main(String[] args) {

        File file = new File("../weathier/test.txt");
        file.exists();

        File file2 = new File("file.txt");
        file2.exists();

    }

}
