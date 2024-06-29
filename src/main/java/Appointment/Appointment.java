class Appointment {
    private MedicalRecord patient;
    private Period periodStart;
    private Period periodEnd;

    public Appointment(MedicalRecord patient, Period periodStart, Period periodEnd) {
        this.patient = patient;
        this.periodStart = periodStart;
        this.periodEnd = periodEnd;
    }

    public MedicalRecord getPatient() {
        return patient;
    }

    public Period getPeriodStart() {
        return periodStart;
    }

    public Period getPeriodEnd() {
        return periodEnd;
    }

    public String toString() {
        return "Appointment: " + patient.getName() + "; " + periodStart + ":" + periodEnd;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Appointment)) {
            return false;
        }
        Appointment other = (Appointment) o;
        if (other.getPatient().equals(patient) && other.getPeriodStart().getValue() == periodStart.getValue()
                && other.getPeriodEnd().getValue() == periodEnd.getValue()) {
            return true;
        }

        return false;
    }
}
