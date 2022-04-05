import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * @author likuan
 */
public class Tree {

    public void tree(String file) {
        if (file == null) {
            return;
        }
        File root = new File(file);
        if (!root.exists()) {
            return;
        }

        print(new File(file), 0);
    }

    void print(File file, int level) {
        for (int i=2; i<=level;i++) {
            System.out.print("|   ");
        }
        if (level != 0) {
            System.out.print("|-- ");
        }
        System.out.println(file.getName());
        if (file.isDirectory()) {
            for (File f : Objects.requireNonNull(file.listFiles())) {
                if (!f.isHidden()) {
                    print(f, level+1);
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        Tree ranges = new Tree();
        ranges.tree("/Users/likuan/tasknode");
    }

}
