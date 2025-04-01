package technical.challenges;

public class PerfilTICCodeChallengeTask1 {

    public static void main(String[] args) {
        PerfilTICCodeChallengeTask1 so = new PerfilTICCodeChallengeTask1();
        System.out.println("isPrime: " + so.isPrime(0));
        System.out.println("isPrime: " + so.isPrime(1));
        System.out.println("isPrime: " + so.isPrime(3));
        System.out.println("isPrime: " + so.isPrime(6));
        System.out.println("isPrime: " + so.isPrime(540));
        System.out.println("isPrime: " + so.isPrime(53));
        System.out.println("isPrime: " + so.isPrime(7));
    }

    public boolean isPrime(int A) {
        if (A == 0 || A == 1)
            return false;
        else {
            int i = 1;
            while ((A - i) > 1) {
                if (A % (A - i) == 0)
                    return false;
                i++;
            }
            return true;
        }

    }
}
