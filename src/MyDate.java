import java.util.Objects;

class MyDate implements Comparable<MyDate> {
    private int day, month, year;

    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public int compareTo(MyDate other) {
        int cmpYear = Integer.compare(this.year, other.year);
        if (cmpYear != 0) return cmpYear;
        int cmpMonth = Integer.compare(this.month, other.month);
        if (cmpMonth != 0) return cmpMonth;
        return Integer.compare(this.day, other.day);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyDate myDate = (MyDate) o;
        return day == myDate.day && month == myDate.month && year == myDate.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, month, year);
    }

    @Override
    public String toString() {
        return String.format("%02d.%02d.%04d", day, month, year);
    }

    public static void main(String[] args) {
        MyDate date1 = new MyDate(1, 1, 2020);
        MyDate date2 = new MyDate(2, 2, 2020);
        MyDate date3 = new MyDate(1, 1, 2020);

        System.out.println(date1.compareTo(date2)); // -1
        System.out.println(date2.compareTo(date1)); // 1
        System.out.println(date1.compareTo(date3)); // 0

        System.out.println(date1.equals(date3)); // true
        System.out.println(date1.equals(date2)); // false

        System.out.println(date1); // 01.01.2020
    }
}