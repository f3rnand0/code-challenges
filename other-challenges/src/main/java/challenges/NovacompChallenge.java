package technical.challenges;

/*
Using TDD, write a program that prints the numbers from 1 to 100.
For multiples of 3 print "Fizz" instead of the number
For the multiples of 5 print "Buzz".
For numbers which are multiples of both 3 and 5 print "FizzBuzz"
 */

public class NovacompChallenge {

    public static void main(String[] args) {
        System.out.println(new NovacompChallenge().givenNotMultiple3or5_whenNotMultiple_thenNumberReturned());
        System.out.println(new NovacompChallenge().givenMultipleOnly3_whenMultipleOnly3_thenNumberReturned());
    }

    public void printNumber() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(validateNumber(i));
        }
    }

    public String validateNumber(int n) {
        String str;
        if (n == 3)
            str = "Fizz";
        else
            str = String.valueOf(n);
        return str;
    }

    public boolean givenNotMultiple3or5_whenNotMultiple_thenNumberReturned() {
        NovacompChallenge novacompChallenge = new NovacompChallenge();
        String str = novacompChallenge.validateNumber(1);
        return str.equals("1");
    }

    public boolean givenMultipleOnly3_whenMultipleOnly3_thenNumberReturned() {
        NovacompChallenge novacompChallenge = new NovacompChallenge();
        String str = novacompChallenge.validateNumber(3);
        return str.equals("Fizz");
    }

}
