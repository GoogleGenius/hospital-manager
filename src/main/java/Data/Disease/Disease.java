import java.util.ArrayList;

class Disease {
    private String name;
    private String description;
    private ArrayList<String> symptoms;
    private ArrayList<String> treatments;

    public Disease(String name, String description, ArrayList<String> symptoms, ArrayList<String> treatments) {
        this.name = name;
        this.description = description;
        this.symptoms = symptoms;
        this.treatments = treatments;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<String> getSymptoms() {
        return symptoms;
    }

    public ArrayList<String> getTreatments() {
        return treatments;
    }

    public String toString() {
        return getName();
    }

    public void printData() {
        System.out.println("Disease:");
        System.out.println("Name: " + name);
        System.out.println();
        System.out.println("Description: " + description);
        System.out.println();
        System.out.println("Symptoms: " + symptoms);
        System.out.println();
        System.out.println("Treatments: " + treatments);
    }
}
