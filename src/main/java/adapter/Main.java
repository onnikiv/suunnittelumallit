package adapter;

public class Main {

    public static void main(String[] args) {

        CalendarToNewDateAdapter adapter = new CalendarToNewDateAdapter();
        adapter.setDay(23);
        adapter.setMonth(1);
        adapter.setYear(2001);

        System.out.println("STARTING DATE: " + adapter.getDay() + "." + adapter.getMonth() + "." + adapter.getYear());

        adapter.advanceDays(9005);
    }
}
