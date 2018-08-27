package scanfiletool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author CIT
 */
public class scanfiletool {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.out.println("Enter the path to folder to search for files: ");
        Scanner s1 = new Scanner(System.in);
        String folderPath = s1.next();
        File currentDir = new File(folderPath);
        displayDirectoryContents(currentDir);
    }

    public static void displayDirectoryContents(File dir) throws IOException {
        File[] files = dir.listFiles();
        Scanner s1 = new Scanner(System.in);
        FileInputStream fis;
        Scanner scanner;
        String s;
        System.out.println("Enter the key word: ");
        s = s1.nextLine();
        for (File file : files) {
            if (file.isDirectory()) {

                displayDirectoryContents(file);
            } else {
                fis = new FileInputStream(file.getCanonicalPath());
                scanner = new Scanner(fis);
                String str;
                while (scanner.hasNextLine()) {

                    str = scanner.nextLine();

                    if (str.matches(s) == false) {
                        continue;
                    } else {
                        System.out.println("File have key word: " + file.getCanonicalPath());
                        break;
                    }

                }

            }
        }

    }
}
