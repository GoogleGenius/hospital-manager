import java.util.TreeMap;
import java.util.Map;

class Schedule {
    private TreeMap<Period, Boolean> schedule;

    public Schedule() {
        schedule = new TreeMap<Period, Boolean>();
        schedule.put(Period.ONE, true);
        schedule.put(Period.TWO, true);
        schedule.put(Period.THREE, true);
        schedule.put(Period.FOUR, true);
        schedule.put(Period.FIVE, true);
        schedule.put(Period.SIX, true);
        schedule.put(Period.SEVEN, true);
        schedule.put(Period.EIGHT, true);
    }

    public boolean isAvailable(Period periodStart, Period periodEnd) {
        for (Map.Entry<Period, Boolean> entry : schedule.entrySet()) {
            Period period = entry.getKey();
            Boolean available = entry.getValue();
            if (period.getValue() >= periodStart.getValue() && period.getValue() <= periodEnd.getValue()) {
                if (!available) {
                    return false;
                }
            }
        }

        return true;
    }

    public void setAvailability(Period periodStart, Period periodEnd, boolean availability) {
        schedule.forEach((k, v) -> {
            if (k.getValue() >= periodStart.getValue() && k.getValue() <= periodEnd.getValue()) {
                schedule.put(k, availability);
            }
        });
    }

    public String toString() {
        return schedule.toString();
    }
}
