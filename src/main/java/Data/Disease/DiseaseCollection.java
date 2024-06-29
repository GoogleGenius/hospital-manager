import java.util.ArrayList;
import java.util.Arrays;

class DiseaseCollection {
        public static final Disease BAD_GRADE_IN_AP_CSA = new Disease("Bad Grade in AP CSA",
                        "Bad Grade in AP CSA is what happens when you happen to not finish the last and hardest FRQ on the exam ;(",
                        new ArrayList<String>(Arrays.asList("Fever", "Fatigue", "Trevor Packer is coming for you")),
                        new ArrayList<String>(Arrays.asList("Retake Exam", "Accept your fate")));
        public static final Disease EMOTIONAL_DAMAGE = new Disease("Emotional Damage",
                        "Emotional damage is what happens when your tiger mum is angry at you",
                        new ArrayList<String>(Arrays.asList("Sadness", "Anxiety")),
                        new ArrayList<String>(Arrays.asList("Get better grades", "Get a job", "Be better")));
}
