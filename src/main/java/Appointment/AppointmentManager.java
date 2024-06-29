import java.util.ArrayList;

class AppointmentManager {
    private ArrayList<Appointment> appointments;
    private Schedule schedule;

    // We inject the dependency so that schedules can be modular
    public AppointmentManager(Schedule schedule) {
        appointments = new ArrayList<Appointment>();
        this.schedule = schedule;
    }

    public void scheduleAppointment(Appointment appointment) throws InvalidAppointmentSchedulingException {
        // Guard statement that has been abstracted to loop through the schedule hashmap
        if (!schedule.isAvailable(appointment.getPeriodStart(), appointment.getPeriodEnd())) {
            throw new InvalidAppointmentSchedulingException();
        }

        appointments.add(appointment);
        schedule.setAvailability(appointment.getPeriodStart(), appointment.getPeriodEnd(), false);
    }

    public Appointment findAppointment(String name, Period periodStart, Period periodEnd) {
        for (Appointment a : appointments) {
            if (a.getPatient().getName().equals(name) && a.getPeriodStart().getValue() == periodStart.getValue()
                    && a.getPeriodEnd().getValue() == periodEnd.getValue()) {
                return a;
            }
        }

        return null;
    }

    public Appointment findAppointment(MedicalRecord record, Period periodStart, Period periodEnd) {
        for (Appointment a : appointments) {
            if (a.getPatient().equals(record) && a.getPeriodStart().getValue() == periodStart.getValue()
                    && a.getPeriodEnd().getValue() == periodEnd.getValue()) {
                return a;
            }
        }

        return null;
    }

    public void cancelAppointment(String name, Period periodStart, Period periodEnd)
            throws FailedAppointmentCancelingException {
        Appointment appointment = findAppointment(name, periodStart, periodEnd);
        if (appointment == null) {
            throw new FailedAppointmentCancelingException();
        }
        appointments.remove(appointment);
        schedule.setAvailability(periodStart, periodEnd, true);
    }

    public void cancelAppointment(MedicalRecord record, Period periodStart, Period periodEnd)
            throws FailedAppointmentCancelingException {
        Appointment appointment = findAppointment(record, periodStart, periodEnd);
        if (appointment == null) {
            throw new FailedAppointmentCancelingException();
        }
        appointments.remove(appointment);
        schedule.setAvailability(periodStart, periodEnd, true);
    }

    public String toString() {
        return appointments.toString();
    }
}
