public class Main {
    public static void main(String[] args){
        HamletParser hamletParser = new HamletParser();
        hamletParser.outputNewFile("replaced",hamletParser.replaceAll(hamletParser.getHamletData()));
    }
}
