import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class Accounts {

    private String path;
    private File file;
    private ArrayList<File> files;

    public Accounts() {
        String path = System.getProperty("user.home")+"/.accounts";
        File file = new File(path);
        //Creates filesystem if not present
        file.mkdir();

        //Reads all files from the folder
        files = new ArrayList<>(Arrays.asList(file.listFiles()));
    }

    public boolean isValidAcc(String name, String code){
         return true;
    }

    public static void main(String[] args) {
        Accounts acc = new Accounts();
    }
}