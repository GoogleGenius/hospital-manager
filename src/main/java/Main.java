import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws MalformedSequenceException, FailedAppointmentCancelingException,
            InvalidAppointmentSchedulingException {
        // Data and records
        System.out.println("-------------------------------");
        System.out.println("Data and Records:");
        System.out.println();

        Database database = new Database();

        MedicalRecord patientJJ = new MedicalRecord("JJ",
                new ArrayList<Disease>(Arrays.asList(DiseaseCollection.BAD_GRADE_IN_AP_CSA)), new GeneSequence("AAA"));
        MedicalRecord patientNA = new MedicalRecord("NA",
                new ArrayList<Disease>(Arrays.asList(DiseaseCollection.EMOTIONAL_DAMAGE)), new GeneSequence("ATGGATT"));
        MedicalRecord patientNK = new MedicalRecord("NK", new ArrayList<Disease>(),
                new GeneSequence("TTAGTAG"));
        Record visitorGL = new Record("GL");
        Record visitorNJ = new Record("NJ");

        // Specific disease info
        System.out.println("Specific Disease Info:");
        patientJJ.getDiagnosedConditions().get(0).printData();
        System.out.println();
        patientNA.getDiagnosedConditions().get(0).printData();

        // Add to db
        database.toArrayList().add(patientJJ);
        database.toArrayList().add(patientNA);
        database.toArrayList().add(patientNK);
        database.toArrayList().add(visitorGL);
        database.toArrayList().add(visitorNJ);

        System.out.println();
        System.out.println("Database:");
        System.out.println(database.toArrayList());

        // Print gene pool
        System.out.println();
        System.out.println("Gene Pool:");
        System.out.println(database.getGenePool());

        // Filter only medical records
        System.out.println();
        System.out.println("Filtered:");
        System.out.println(database.filterByMedicalRecord());

        // Print individual record data
        System.out.println();
        System.out.println("Individual Record Data:");
        database.searchByName("GL").printData();
        System.out.println();
        database.searchByName("NJ").printData();
        System.out.println();
        database.searchByName("JJ").printData();
        System.out.println();
        database.searchByName("NA").printData();
        System.out.println();
        database.searchByName("NK").printData();

        // Scheduling and appointments
        System.out.println("-------------------------------");
        System.out.println("Scheduling and Appointments:");

        Schedule schedule = new Schedule();
        AppointmentManager appointmentManager = new AppointmentManager(schedule);

        // Schedule appointment
        // Check schedule availability initially
        System.out.println();
        System.out.println("Schedule:");
        System.out.println(schedule);

        Appointment appointmentJJ = new Appointment(patientJJ, Period.ONE, Period.FOUR);
        Appointment appointmentNA = new Appointment(patientNA, Period.TWO, Period.FOUR);
        Appointment appointmentNK = new Appointment(patientNK, Period.FIVE, Period.SIX);
        appointmentManager.scheduleAppointment(appointmentJJ);
        appointmentManager.scheduleAppointment(appointmentNK);

        // Test an invalid case
        try {
            appointmentManager.scheduleAppointment(appointmentNA);
        } catch (InvalidAppointmentSchedulingException e) {
            System.out.println();
            System.out.println(appointmentNA.getPatient().getName()
                    + "'s appointment failed to schedule because periods overlapped.");
        }

        // Check schedule availability after scheduling
        System.out.println();
        System.out.println("Schedule after Scheduling:");
        System.out.println(schedule);

        // See the str reprs of the appointments
        System.out.println();
        System.out.println("JJ's Appointment:");
        System.out.println(appointmentJJ);
        System.out.println();
        System.out.println("NK's Appointment via search:");
        System.out.println(appointmentManager.findAppointment(patientNK, Period.FIVE, Period.SIX));

        System.out.println();
        System.out.println("All Appointments:");
        System.out.println(appointmentManager);

        // Cancel appointment
        appointmentManager.cancelAppointment("NK", Period.FIVE, Period.SIX);
        System.out.println();
        System.out.println("All Appointments after canceling NK:");
        System.out.println(appointmentManager);

        // Check schedule availability after cancl
        System.out.println();
        System.out.println("Schedule after Canceling:");
        System.out.println(schedule);

        // Genetic management
        System.out.println("-------------------------------");
        System.out.println("Genetic Management:");

        System.out.println();
        System.out.println("Edit Distance (similarity) NA vs. NK:");
        System.out.println(GeneManager.computeEditDistance(patientNA.getGeneSequence(), patientNK.getGeneSequence()));

        System.out.println();
        System.out.println("Edit Distance (similarity) JJ vs. NA:");
        // Search by name for fun
        MedicalRecord jj_ = (MedicalRecord) database.searchByName("JJ");
        MedicalRecord na_ = (MedicalRecord) database.searchByName("NA");
        System.out.println(GeneManager.computeEditDistance(jj_.getGeneSequence(), na_.getGeneSequence()));
    }
}
