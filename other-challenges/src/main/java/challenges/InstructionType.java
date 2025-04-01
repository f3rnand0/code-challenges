package technical.challenges;

public enum InstructionType {
    DEF ("def"),
    CALC ("calc"),
    CLEAR ("clear");

    private final String value;

    InstructionType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
