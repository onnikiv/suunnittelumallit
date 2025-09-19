package adapter;

import java.util.Calendar;

public class CalendarToNewDateAdapter implements NewDateInterface {

    private final Calendar calendar = Calendar.getInstance();

    @Override
    public void setDay(int day) {
        calendar.set(Calendar.DATE, day);
    }

    @Override
    public void setMonth(int month) {
        calendar.set(Calendar.MONTH, month - 1);
    }

    @Override
    public void setYear(int year) {
        calendar.set(Calendar.YEAR, year);
    }

    @Override
    public int getDay() {
        return calendar.get(Calendar.DATE);
    }

    @Override
    public int getMonth() {
        return calendar.get(Calendar.MONTH) + 1;
    }

    @Override
    public int getYear() {
        return calendar.get(Calendar.YEAR);
    }

    @Override
    public void advanceDays(int days) {
        calendar.add(Calendar.DATE, days);
        System.out.println("DAYS TO ADVANCE: " + days);
        System.out.println(getDay() + "." + getMonth() + "." + getYear());
    }
}
