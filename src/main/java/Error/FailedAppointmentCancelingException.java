class FailedAppointmentCancelingException extends Exception {
    public FailedAppointmentCancelingException() {
        super("The appointment failed to be canceled. Possibly check `record` or `name`, `periodStart` and `periodEnd`?");
    }
}
