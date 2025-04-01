package technical.challenges;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VanHackChallenge1 {

    public static void main(String[] args) {
        String prog = "[ x y z ] ( 2*3*x + 5*y - 3*z ) / (1 + 3 + 2*2)";
        VanHackChallenge1.pass1(prog);
    }

    public static void pass1(String prog) {
        Deque<String> tokens = tokenize(prog);
        List<String> tokenList = new ArrayList<>(tokens);
        int numArgs = tokenList.indexOf("]") - (tokenList.indexOf("[") + 1);
        System.out.println("tokensList1: " + tokenList);
        tokenList = tokenList.subList(numArgs + 2, tokenList.size() - 1);
        System.out.println("tokensList1: " + tokenList);
        if (tokenList.indexOf(")") > 0) {
            int firstExpressionIndex = tokenList.indexOf(")");
            int secondExpressionIndex = 0;
            for (int i = firstExpressionIndex; i < tokenList.size(); i++) {
                if ("(".equals(tokenList.get(i))) {
                    secondExpressionIndex = i - 1;
                    break;
                }
            }
            System.out.println("first Bin: " + tokenList.get(secondExpressionIndex));
            List<String> indexesList1 = getIndexes(tokenList, secondExpressionIndex - 2, 1);
            List<String> indexesList2 =
                    getIndexes(tokenList, tokenList.size() - 2, secondExpressionIndex + 2);
            System.out.println("indexesList1: " + indexesList1);
            System.out.println("indexesList2: " + indexesList2);
            Ast ast;
            for (int i = 0; i < indexesList1.size(); i++) {
                if (indexesList1.get(i).contains("UnOp")) {
                    int index = Integer.valueOf(indexesList1.get(i).split(",")[1]);
                    String operator = tokenList.get(index - 1);
                    int a = Integer.valueOf(tokenList.get(index));
                    int b = Integer.valueOf(tokenList.get(index + 1));
                   // ast = createAst(null, operator, a, b);
                }
            }
        }
        else {

        }

    }

    private static List<String> getIndexes(List<String> tokenList, int beginIndex, int endIndex) {
        List<String> indexesList1 = new ArrayList<>();
        List<String> indexesList2 = new ArrayList<>();
        for (int i = beginIndex; i > endIndex; i--) {
            if ("+".equals(tokenList.get(i)) || "-".equals(tokenList.get(i)))
                indexesList1.add("BinOp," + i);
        }
        int index = indexesList1.size() - 1;
        int k = Integer.valueOf(indexesList1.get(index).split(",")[1]) - 1;
        index--;
        int l = endIndex;
        for (int i = 0; i <= indexesList1.size(); i++) {
            for (int j = k; j >= l; j--) {
                if ("+".equals(tokenList.get(j)) || "-".equals(tokenList.get(j)) ||
                    "*".equals(tokenList.get(j)) || "/".equals(tokenList.get(j)))
                    indexesList2.add("BinOp," + j);
            }
            for (int j = l; j <= k; j++) {
                if (tokenList.get(j).matches("\\w+"))
                    indexesList2.add("UnOp," + j);
            }
            l = k + 2;
            if (index >= 0) {
                k = Integer.valueOf(indexesList1.get(index).split(",")[1]) - 1;
                index--;
            } else
                k = beginIndex;
        }
        indexesList1.addAll(indexesList2);
        return indexesList1;
    }

    private static Ast createAst(String operator, Object a, Object b) {
        Ast ast;
        if (a instanceof Integer) {
            if (b instanceof Integer)
                return new BinOp(operator, new UnOp("imm", (Integer) a), new UnOp("imm", (Integer) b));
            else if (((String) b).split(",").length == 0)
                return new BinOp(operator, new UnOp("imm", (Integer) a), new UnOp("arg", (Integer) b));
            else
                createAst(operator, a, b);
        } else if (((String) a).split(",").length == 0) {
            if (b instanceof Integer)
                return new BinOp(operator, new UnOp("arg", (Integer) a), new UnOp("imm", (Integer) b));
            else if (((String) b).split(",").length == 0)
                return new BinOp(operator, new UnOp("arg", (Integer) a), new UnOp("arg", (Integer) b));
            else
                createAst(operator, a, b);
        } else {
            String[] variables = ((String)a).split(",");
            new BinOp(variables[1], createAst(a, b), createAst(a, b));
        }
        return null;
    }

    private static Ast createAst(Object a, Object b) {

        return null;
    }

    private static Deque<String> tokenize(String prog) {
        Deque<String> tokens = new LinkedList<>();
        Pattern pattern = Pattern.compile("[-+*/()\\[\\]]|[a-zA-Z]+|\\d+");
        Matcher m = pattern.matcher(prog);
        while (m.find()) {
            tokens.add(m.group());
        }
        tokens.add("$"); // end-of-stream
        return tokens;
    }

    static interface Ast {

    }

    static class BinOp implements Ast {
        public BinOp(String str, Ast a, Ast b) {
        }
    }

    static class UnOp implements Ast {
        public UnOp(String str, Integer n) {
        }
    }
}
