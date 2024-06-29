import java.util.ArrayList;

// A class that stores `Record`s, including `MedicalRecord`s
class Database {
    private ArrayList<Record> db;

    public Database() {
        db = new ArrayList<Record>();
    }

    public ArrayList<Record> toArrayList() {
        return db;
    }

    public Record searchByName(String name) {
        for (Record r : db) {
            if (r.getName().equals(name)) {
                return r;
            }
        }
        return null;
    }

    public ArrayList<MedicalRecord> filterByMedicalRecord() {
        ArrayList<MedicalRecord> medicalRecords = new ArrayList<MedicalRecord>();

        for (Record r : db) {
            if (r instanceof MedicalRecord) {
                medicalRecords.add((MedicalRecord) (r));
            }
        }

        return medicalRecords;
    }

    public ArrayList<GeneSequence> getGenePool() {
        ArrayList<GeneSequence> genePool = new ArrayList<GeneSequence>();

        for (Record r : db) {
            if (r instanceof MedicalRecord) {
                GeneSequence geneSequence = ((MedicalRecord) r).getGeneSequence();
                genePool.add(geneSequence);
            }
        }

        return genePool;
    }
}
