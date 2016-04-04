package Exercise_1;

public class Date {
    public Date() {
        
    }
    
    public Date(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    private int month, day, year;
    
    public Date nextDate() throws InvalidDateException, ArgumentException {
        Date result;

        result = new Date();

        if (month <= 0 || month >= 13
                || day <= 0 || day >= 32
                || year <= 1811 || year >= 2015) {
            throw new ArgumentException();
        }

        // Default, no sweat...
        if (day <= 27) {
            result.month = month;
            result.day = day + 1;
            result.year = year;
        } // February, a lot of sweat...
        else if (month == 2) {
            if (day >= 30) {
                throw new InvalidDateException();
            } // Leap year
            else if (IsLeapYear(year)) {
                // Second last day of february
                if (day == 28) {
                    result.day = day + 1;
                    result.month = month;
                    result.year = year;
                } // last day of february
                else {
                    result.day = 1;
                    result.month = month + 1;
                    result.year = year;
                }
            } // Common year
            else {
                if (day == 29) {
                    throw new InvalidDateException();
                } // last day of february
                else {
                    result.day = 1;
                    result.month = month + 1;
                    result.year = year;
                }
            }
        } // April, june, september, november
        else if (month == 4
                || month == 6
                || month == 9
                || month == 11) {
            // Last day of the month
            if (day == 30) {
                result.day = 1;
                result.month = month + 1;
                result.year = year;
            } // 28. or 29. of the month
            else {
                result.day = day + 1;
                result.month = month;
                result.year = year;
            }
        } // January, march, may, july, august, october
        else if (month == 1
                || month == 3
                || month == 5
                || month == 7
                || month == 8
                || month == 10) {
            // Last day of the month
            if (day == 31) {
                result.day = 1;
                result.month = month + 1;
                result.year = year;
            } // 28., 29. or 30. of the month
            else {
                result.day = day + 1;
                result.month = month;
                result.year = year;
            }
        } // December
        else {
            // Last day of december
            if (day == 31) {
                result.day = 1;
                result.month = 1;
                result.year = year + 1;
            } // 28., 29. or 30. of december
            else {
                result.day = day + 1;
                result.month = month;
                result.year = year;
            }
        }

        return result;
    }
    
    private boolean IsLeapYear(int year)
        {
            boolean result;

            result = false;

            if (year % 4 == 0)
                if (year % 100 != 0)
                    result = true;
                else if (year % 400 == 0)
                    result = true;
                else
                    result = false;

            return result;
        }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.month;
        hash = 67 * hash + this.day;
        hash = 67 * hash + this.year;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Date other = (Date) obj;
        if (this.month != other.month) {
            return false;
        }
        if (this.day != other.day) {
            return false;
        }
        if (this.year != other.year) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return month + "-" + day + "-" + year;
    }
}