package backend;

import java.util.Objects;

public class Time {
    private int minutes, seconds, milliseconds;

    public Time(int minutes, int seconds, int milliseconds) {
        this.minutes = minutes + seconds / 60;
        this.seconds = seconds % 60 + milliseconds / 1000;
        this.milliseconds = milliseconds % 1000;
    }

    @Override
    public String toString() {
        return minutes + ":" + seconds + "." + milliseconds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Time time = (Time) o;
        return minutes == time.minutes && seconds == time.seconds && milliseconds == time.milliseconds;
    }

    public boolean isGreater(Time time) {
        if(minutes > time.minutes) return true;
        if(seconds > time.seconds) return true;
        return milliseconds > time.milliseconds;
    }

    public boolean isSmaller(Time time) {
        if(minutes < time.minutes) return true;
        if(seconds < time.seconds) return true;
        return milliseconds < time.milliseconds;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public int getMilliseconds() {
        return milliseconds;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public void setMilliseconds(int milliseconds) {
        this.milliseconds = milliseconds;
    }
}

