package com.stir.cscu9t4practical1;

import java.util.Calendar;

public class Entry {
    private Training training;
  
    public Entry(String name, int day, int month, int year, int hour, int min, int sec, float dist, String type) {
        Calendar inst = Calendar.getInstance();
        inst.set(year, month - 1, day, hour, min, sec);
        switch (type) {
            case "Run":
                training = new Run(name, inst, dist);
                break;
            case "Cycle":
                training = new Cycle(name, inst, dist);
                break;
            case "Swim":
                training = new Swim(name, inst, dist);
                break;
        }
    } //constructor
  
    public String getName() {
        return training.getName();
    } //getName
  
    public int getDay() {
        return training.getDay();
    } //getDay
  
    public int getMonth() {
        return training.getMonth();
    } //getMonth
  
    public int getYear() {
        return training.getYear();
    } //getYear

    public int getHour() {
        return training.getHour();
    } //getHour

    public int getMin() {
        return training.getMin();
    } //getMin

    public int getSec() {
        return training.getSec();
    } //getSec

    public float getDistance() {
        return training.getDistance();
    } //getYear

    public String getType() {
        return training.getType();
    } //getType

    public String getEntry() {
        return training.getEntry();
    } //getEntry
   
} // Entry

abstract class Training {
    protected String name;
    protected Calendar dateAndTime;
    protected float distance;

    public Training(String n, Calendar dat, float dist) {
        name = n;
        dateAndTime = dat;
        distance = dist;
    }

    public String getName() {
        return name;
    }

    public int getDay() {
        return dateAndTime.get(Calendar.DATE);
    }

    public int getMonth() {
        int month =  dateAndTime.get(Calendar.MONTH) + 1;
        return month;
    }

    public int getYear() {
        return dateAndTime.get(Calendar.YEAR);
    }

    public int getHour() {
        return dateAndTime.get(Calendar.HOUR);
    }

    public int getMin() {
        return dateAndTime.get(Calendar.MINUTE);
    }

    public int getSec() {
        return dateAndTime.get(Calendar.SECOND);
    }

    public float getDistance() {
        return distance;
    }

    public abstract String getType();

    public abstract String getEntry();
}

class Run extends Training {
    public Run(String n, Calendar dat, float dist) {
        super(n, dat, dist);
    }

    @Override
    public String getType() {
        return "Run";
    }

    @Override
    public String getEntry() {
        return getName() + " ran " + getDistance() + " km in "
                + getHour() + ":" + getMin() + ":" + getSec() + " on "
                + getDay() + "/" + getMonth() + "/" + getYear() + "\n";
    }
}

class Cycle extends Training {
    public Cycle(String n, Calendar dat, float dist) {
        super(n, dat, dist);
    }

    @Override
    public String getType() {
        return "Cycle";

    }
    

    @Override
    public String getEntry() {
        return getName() + " swam " + getDistance() + " km in "
            + getHour() + ":" + getMin() + ":" + getSec() + " on "
            + getDay() + "/" + getMonth() + "/" + getYear() + "\n";
}
    
    }



//Entry