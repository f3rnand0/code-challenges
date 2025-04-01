package technical.challenges;

public class VanHackChallenge3 {

    public static final String STRIKE = "X";
    public static final String SPARE = "/";


    public static void main(String[] args) {
        String frames = null;
        frames = "X X X X X X X X X XXX";
        System.out.println(VanHackChallenge3.bowling_score(frames));
        frames = "5/ 4/ 3/ 2/ 1/ 0/ X 9/ 4/ 7/2";
        System.out.println(VanHackChallenge3.bowling_score(frames));
        frames = "11 11 11 11 11 11 11 11 11 11";
        System.out.println(VanHackChallenge3.bowling_score(frames));
        frames = "11 11 11 11 11 11 X 11 X 1/X";
        System.out.println(VanHackChallenge3.bowling_score(frames));
        frames = "11 11 11 11 11 11 X X X 1/X";
        System.out.println(VanHackChallenge3.bowling_score(frames));
        frames = "11 11 11 11 11 11 X X X 12";
        System.out.println(VanHackChallenge3.bowling_score(frames));
        frames = "11 11 11 11 11 11 X X X 12X";
        System.out.println(VanHackChallenge3.bowling_score(frames));
        frames = "00 00 00 00 00 0/ X 00 0 7/2";
        System.out.println(VanHackChallenge3.bowling_score(frames));
        frames = "X X 9/ 80 X X 90 8/ 7/ 44";
        System.out.println(VanHackChallenge3.bowling_score(frames));
        frames = "9/ 50 5/ 26 62 22 07 5/ 6/ XX1";
        System.out.println(VanHackChallenge3.bowling_score(frames));

    }

    public static int bowling_score(String frames) {
        String[] framesArray = frames.split(" ");
        String firstValue, middleValue, lastValue;
        int totalScore = 0;
        for (int i = 0; i < framesArray.length; i++) {
            // For first nine frames
            if (i < framesArray.length - 1) {
                // If it isn't strike
                if (framesArray[i].length() > 1) {
                    firstValue = framesArray[i].substring(0, 1);
                    lastValue = framesArray[i].substring(1);
                    // If it's a spare
                    if (lastValue.equals(SPARE)) {
                        totalScore += 10 + getNextFrameResult(i, framesArray);
                    }
                    // If it's a normal frame result
                    else {
                        totalScore += Integer.parseInt(firstValue) + Integer.parseInt(lastValue);
                    }
                }
                // If it's a strike
                else {
                    totalScore += 10 + getNextTwoFrameResults(i, framesArray);
                }
            }
            // For 10th frame
            else {
                if (framesArray[i].length() == 3) {
                    firstValue = framesArray[i].substring(0, 1).equals(STRIKE) ? "10" :
                                 framesArray[i].substring(0, 1);
                    if (framesArray[i].substring(1, 2).equals(SPARE))
                        middleValue = String.valueOf(10 - Integer.parseInt(firstValue));
                    else if (framesArray[i].substring(1, 2).equals(STRIKE)) middleValue = "10";
                    else middleValue = framesArray[i].substring(1, 2);
                    lastValue = framesArray[i].substring(2).equals(STRIKE) ? "10" :
                                framesArray[i].substring(2);
                    totalScore += Integer.parseInt(firstValue) + Integer.parseInt(middleValue) +
                                  Integer.parseInt(lastValue);
                } else {
                    firstValue = framesArray[i].substring(0, 1);
                    lastValue = framesArray[i].substring(1).equals(SPARE) ?
                                String.valueOf(10 - Integer.parseInt(firstValue)) :
                                framesArray[i].substring(1);
                    totalScore += Integer.parseInt(firstValue) + Integer.parseInt(lastValue);
                }
            }
            //System.out.println("totalScore " + totalScore);
        }
        return totalScore;
    }

    private static int getNextFrameResult(int index, String[] frameArray) {
        int result;
        String frameResult = frameArray[index + 1];
        if (frameResult.startsWith(STRIKE)) result = 10;
        else result = Integer.parseInt(frameResult.substring(0, 1));
        return result;
    }

    private static int getNextTwoFrameResults(int index, String[] frameArray) {
        int result, firstResult;
        String frameResult = frameArray[index + 1];
        // For first 8 frames
        if (index < frameArray.length - 2) {
            // If there's a strike
            if (frameResult.equals(STRIKE)) {
                result = 10;
                frameResult = frameArray[index + 2];
                if (frameResult.startsWith(STRIKE)) {
                    String partialResult = frameResult.substring(0, 1);
                    if (partialResult.equals(STRIKE)) result += 10;
                    else result += Integer.parseInt(frameResult.substring(0, 1));
                } else result += Integer.parseInt(frameResult.substring(0, 1));
            } else {
                firstResult = Integer.parseInt(frameResult.substring(0, 1));
                result = firstResult;
                result += frameResult.substring(1).equals(SPARE) ? 10 - firstResult :
                          Integer.parseInt(frameResult.substring(1));
            }
        }
        // For 9th frame
        else {
            if (frameResult.startsWith(STRIKE)) {
                result = 10;
                frameResult = frameResult.substring(1, 2);
                result += frameResult.equals(STRIKE) ? 10 :
                          Integer.parseInt(frameResult.substring(0, 1));
            } else {
                firstResult = Integer.parseInt(frameResult.substring(0, 1));
                result = firstResult;
                result += frameResult.substring(1, 2).equals(SPARE) ? 10 - firstResult :
                          Integer.parseInt(frameResult.substring(1, 2));
            }
        }
        return result;
    }
}
