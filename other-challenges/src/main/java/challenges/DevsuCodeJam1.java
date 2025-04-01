package technical.challenges;

public class DevsuCodeJam1 {

    public static void main(String[] args) {
        System.out.println("result 2: " + DevsuCodeJam1.calculateNthSequence(2L));
        System.out.println("result 4: " + DevsuCodeJam1.calculateNthSequence(4L));
        System.out.println("result 8: " + DevsuCodeJam1.calculateNthSequence(8L)); // 6
        System.out.println("result 5: " + DevsuCodeJam1.calculateNthSequence(5L)); // 3
        System.out.println("result 6: " + DevsuCodeJam1.calculateNthSequence(6L)); // 4
        System.out.println("result 13: " + DevsuCodeJam1.calculateNthSequence(13L)); // 21
        System.out.println("result 77: " + DevsuCodeJam1.calculateNthSequence(77L)); // 39
        System.out.println("result 545421: " + DevsuCodeJam1.calculateNthSequence(545421L)); // 272711
        System.out.println("result 545421: " + DevsuCodeJam1.calculateNthSequence(4611686018427387L));
        System.out.println("maximumDistanceText: " + DevsuCodeJam1.maximumDistanceText("abcdefghi", "de"));
        System.out.println("maximumDistanceText: " + DevsuCodeJam1.maximumDistanceText("abcdefgci", "c"));
        System.out.println("maximumDistanceText: " + DevsuCodeJam1.maximumDistanceText(
                "uepnzleaiogoxbvdcwalayckdzfzxdvddexcofcjlujrzofzolxmigtogtslkwwuxdilwmdjlpaqufnvuuufvhcmwpjqhlchtmqzrijwajbqzwrtzcmbwjvzfdhgunizgddehprykgvbpohccigzyvhintlpwotuvvlzrqicnavvnxfteduomtdjlwqyxbridegazizo",
                "egazizo"));
        System.out.println("maximumDistanceText: " + DevsuCodeJam1.maximumDistanceText(
                "npwaaibtpulwlixduaybxpfqqmshamzfpsbfydhptwdgiblevllgucruzscoewhwhavngcrgyyzbgluhxocbjdcxhysziadikmzebcvbqkvfabfilkqxmksmtflnchewxvosiiumwwpjiegehwosifhqeabccwpblypwgpfrvvaebayysejqekwkshsdvpgjswlanvkd",
                "npwaaib"));
        System.out.println("maximumDistanceText: " + DevsuCodeJam1.maximumDistanceText(
                "yfuajpocenamocibexujhalinesvlijlmylxmpexvfddpejowufvkbzkwlmxeoyartjholmpzxeuhquvmiuhgvasitvtgiexvunqhoeeowkpwbwwvipeptperrnljsomwcnrvpjmhfsjgixkopmxbgtlogplujljwxodbfczsxgondmgfhpicdroumealpplxkozuusmufmojyatfthxjlkdzewjfvjmijmkqppvhoedbhxnruuonntgstdbxchxyztnoqttgigyaxtyjlpfckefclzuylaskhgynmopqkbafsrnvifjuurmafusdqbziqpejdscfvyepevmfodjchakjndqcyvlleoxyadpzcmphchajrrbumoivxruwdliknfhgpdjfxreosblkjyjtrmjrqmfjheamkmckipseuzhvqcgyortoaheajxfiziunqgzizijoawrvjeyvcrmtpedrzkdukhzjjnaiejfxtkfpdpgdhsskfkfyusgfaefpodnprtcwtwfmjtyfwlsiqtgwnvluxkmvgmvshgikrteakgydwtbnhqfbtnynlwghstcpvufrvjxoehamfbvnjrrccwqgickbynzjzroyyiirnsdchfbivviqnbmhtercgvqolwzlixigoddxiukmitymvljojpwjjdmteegbqwgovnxanresklkiabrnlfumxtmuclccbkajcbrmmdzfdzzcftqiuaadcfrfocdpifyrasthgkmufkoyvlopavsjpmjystcuwtrqxsrymlmjbdapjmtcsberjknhyawbkeeimdmhtpuixkmllpqbjhqpzfybemsilpzzrlifxjxhskzengcldevyswdtxqkniuiffjqwdhjushlowheuotpfinwodqzfcjcypgqrtvpclogidofispdmgdjbscpouxckilknnqcjwydqzfbfnrwfahkmorcndxqwljefekdpafbsdoldbmkvizvtzko",
                "jfx"));
    }

    public static Long calculateNthSequence(Long n) {
        if (n <= 4)
            return n;
        Long num = n;
        Long m = 0L;
        Long i = 1L;
        while (n > 4) {
            if ((num / 4) > 1000)
                m = num - (2 * i);
            n = n - 4;
            i++;
        }
        return m;
    }

    public static Integer maximumDistanceText(String text, String subtext) {
        if (!text.contains(subtext))
            return -1;
        else {
            int leftDistance = text.lastIndexOf(subtext);
            int rightDistance = text.length() - subtext.length() - text.indexOf(subtext);
            if (leftDistance >= rightDistance)
                return leftDistance;
            else
                return rightDistance;
        }
    }

}
