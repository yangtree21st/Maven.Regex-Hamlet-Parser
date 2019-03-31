import com.sun.org.apache.xpath.internal.axes.MatchPatternIterator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;
    private final Pattern HAMLET_P = Pattern.compile("\\bHamlet|HAMLET\\b");
    private final Pattern HORATIO_P = Pattern.compile("\\bHoratio|HORATIO\\b");
    private final String Hamlet_replace = "Leon";
    private final String horatio_replace = "Tariq";

    public HamletParser() {
        this.hamletData = loadFile();
    }

    private String loadFile() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData() {
        return hamletData;
    }

    public String replaceHamlet(String fileS) {
        return replacePattern(HAMLET_P, Hamlet_replace, fileS);
    }

    public String replaceHoratio(String fileS) {
        return replacePattern(HORATIO_P, horatio_replace, fileS);
    }

    public String replacePattern(Pattern regex, String replacement, String fileS) {
        Matcher matcher = regex.matcher(fileS);
        return matcher.replaceAll(replacement);
    }

    public String replaceAll(String fileS){
        return replaceHamlet(replaceHoratio(fileS));
    }

    public void outputNewFile(String newFileName, String output) {
        try (PrintWriter out = new PrintWriter(newFileName)) {
            out.println(output);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public int nameFind(Matcher matcher){
        int count = 0 ;
        while(matcher.find())
            count ++;
        return count;
    }

    public int matchPatten(Pattern regex,String fileS ){
        Matcher matcher = regex.matcher(fileS);
        return nameFind(matcher);
    }

    public int findHamlet (String fileS){
        return  matchPatten(HAMLET_P,fileS);
    }

    public int findHoratio(String fileS){
        return  matchPatten(HORATIO_P,fileS);
    }

}
