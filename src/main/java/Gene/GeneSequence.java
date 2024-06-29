// Example of composition technique
class GeneSequence {
    private String underLyingString;

    public GeneSequence(String s) throws MalformedSequenceException {
        for (int i = 0; i < s.length(); i++) {
            char currentCharacter = s.charAt(i);
            if (currentCharacter != 'A' &&
                    currentCharacter != 'C' &&
                    currentCharacter != 'G' &&
                    currentCharacter != 'T') {
                throw new MalformedSequenceException();
            }
        }

        this.underLyingString = s;
    }

    public String toString() {
        return underLyingString;
    }

    public boolean equals(Object o) {
        if (o instanceof GeneSequence) {
            if (this.underLyingString.equals(((GeneSequence) o).toString())) {
                return true;
            }
        }

        return false;
    }

    public int length() {
        return underLyingString.length();
    }

    public char charAt(int i) {
        return underLyingString.charAt(i);
    }
}
