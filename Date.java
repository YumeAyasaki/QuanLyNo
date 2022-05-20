public class Date {
    protected int day = 01;
    protected int month = 05;
    protected int year = 2022;

    public Date()
    {

    }

    public Date(int day, int month, int year)
    {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Date(Date newDate)
    {
        this.day = newDate.day;
        this.month = newDate.month;
        this.year = newDate.year;
    }

    public int getDay()
    {
        return this.day;
    }
    
    public int getMonth()
    {
        return this.month;
    }

    public int getYear()
    {
        return this.year;
    }

    public void setDay(int day)
    {
        this.day = day;
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
}
