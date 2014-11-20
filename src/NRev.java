import java.util.Scanner;

public class NRev {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        if(args[0].equals("-m") || args[0].equals("multiline")) {
            multiLine();
        } else if (args.length > 0) {
            System.out.println("Program can only be called with no args "+
                    "or the -m option for multiple line sequences");
            System.exit(1);
        } else {
            System.out.println("enter a sequence on a single line");
            output(scan());
            scan.close();
        }
    }
    private static void multiLine() {
        System.out.println("enter a sequence here. You may use as many "+
                "lines as you need");
        System.out.println("enter 'ok' when finished:");
        StringBuilder build = new StringBuilder();
        String forward;
        while (!(forward = scan()).equals("OK")) {
            build.append(forward);
        }
        scan.close();

        output(build.toString());
    }
    private static void output(String forward) {
        StringBuilder build = new StringBuilder();
        for (int i = forward.length()-1; i >= 0 ; i--) {
            build.append(reverse(forward.charAt(i)));
        }
        System.out.println("\n"+build.toString());
    }

    private static String reverse (char c) {
        return c == 'A' ? "T" :
               c == 'T' ? "A" :
               c == 'C' ? "G" :
               c == 'G' ? "C" : ""+c;
    }

    private static String scan () {
        return scan.next().trim().toUpperCase();
    }
}
