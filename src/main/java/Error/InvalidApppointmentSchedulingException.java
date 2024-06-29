class InvalidAppointmentSchedulingException extends Exception {
    public InvalidAppointmentSchedulingException() {
        super("The appointment failed to be scheduled. Possibly check `periodStart` and `periodEnd`?");
    }
}
