import java.util.ArrayList;

class MedicalRecord extends Record {
    private ArrayList<Disease> diagnosedConditions;
    private GeneSequence geneSequence;

    public MedicalRecord(
            String name,
            ArrayList<Disease> diagnosedConditions,
            GeneSequence geneSequence) {
        super(name);
        this.diagnosedConditions = diagnosedConditions;
        this.geneSequence = geneSequence;
    }

    public ArrayList<Disease> getDiagnosedConditions() {
        return diagnosedConditions;
    }

    public GeneSequence getGeneSequence() {
        return geneSequence;
    }

    public void setGeneSequence(GeneSequence geneSequence) {
        this.geneSequence = geneSequence;
    }

    public void setGeneSequence(String stringSequence) throws MalformedSequenceException {
        this.geneSequence = new GeneSequence(stringSequence);
    }

    public boolean equals(Object o) {
        if (!(o instanceof MedicalRecord)) {
            return false;
        }

        MedicalRecord other = (MedicalRecord) o;
        if (!this.getName().equals(other.getName())) {
            return false;
        }
        if (!this.getDiagnosedConditions().equals(other.getDiagnosedConditions())) {
            return false;
        }
        if (!this.getGeneSequence().equals(other.getGeneSequence())) {
            return false;
        }

        return true;
    }

    @Override
    public void printData() {
        super.printData();
        System.out.println();

        System.out.print("Diagnosed Conditions: ");
        if (diagnosedConditions.size() != 0) {
            for (int i = 0; i < diagnosedConditions.size() - 1; i++) {
                System.out.print(diagnosedConditions.get(i) + ", ");
            }
            System.out.println(diagnosedConditions.get(diagnosedConditions.size() - 1));
        } else {
            System.out.println("None");
        }

        System.out.println();

        System.out.println("Gene Sequence: " + geneSequence);
    }

    @Override
    public String toString() {
        return "MedicalRecord: " + getName();
    }
}
