class MalformedSequenceException extends Exception {
    public MalformedSequenceException() {
        super("Sequence contains letters other than `A`, `C`, `G`, or `T`");
    }
}
