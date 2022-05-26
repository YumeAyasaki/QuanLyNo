public class Date {
    protected int month = 05;
    protected int year = 2022;

    public Date()
    {

    }

    public Date(int month, int year)
    {
        this.month = month;
        this.year = year;
    }

    public Date(Date newDate)
    {
        this.month = newDate.month;
        this.year = newDate.year;
    }
    
    public int getMonth()
    {
        return this.month;
    }

    public int getYear()
    {
        return this.year;
    }
    
    public void setMonth(int month)
    {
        this.month = month;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public void plusMonths(int months) {
        month += months;
        if (month > 12) {
            int temp = month / 12;
            year += temp;
            month -= temp * 12;
        }
    }

    public int diffMonths(Date date) {
        return Math.abs(date.year * 12 + date.month - month - year * 12);
    }
}
