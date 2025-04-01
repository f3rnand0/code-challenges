package crashminimizer;

import java.io.FileNotFoundException;
import java.io.IOException;

public class CrashMinimizer {

    /**
     * This function minimizes a crashing test case to
     * a single character that still causes the crash.
     *
     * @param String command - the command to execute the
     *               program under test.
     * @param String failingTestInputFilename - the path
     *               to the file causing a crash in the
     *               target program. The contents of
     *               this file are to be minimized by
     *               this function.
     * @return String - the final, minimized version of the
     * failing test input file which still
     * causes a crash.
     */
    public static String minimize(
            String command, String failingInputFilename
    ) throws FileNotFoundException, IOException {
        String lineFile = Utilities.readFile1(failingInputFilename);
        String str;
        minimizeRecursive(lineFile.toCharArray(), 0, lineFile.length());
        return "";
    }

    private static int minimizeRecursive(String input, int start, int end) {
        if (start > end)
            return -1;
        int mid = start + (end - start) / 2;
        if (!isCaesarCipherValid(input[mid])) {
            return mid;
        } else {
            if ()
                return minimizeRecursive(input, mid + 1, end);
            else
                return minimizeRecursive(input, start, mid - 1);
        }
    }

    private static boolean isCaesarCipherValid(String input) {
        try {
            new CaesarCipher().execute(String.valueOf(input));
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}