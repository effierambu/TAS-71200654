package com.rplbo.carisudutjam;

public class Algo {
    // https://blog.abelotech.com/posts/clock-angle-problem-interview-question/

    private static final double HOUR_ANGLE = 360.0 / 12;
    private static final double MINUTE_ANGLE = 360.0 / 60;
    private static final double HOUR_DELTA_ANGLE = HOUR_ANGLE / 60;
    private static final double MINUTE_DELTA_ANGLE = MINUTE_ANGLE / 60;

    private final int angle;
    private final int hourAngle;
    private final int minAngle;

    public Algo(final int hour, final int min) {
        this(hour, min, 0);
    }

    public Algo(final int hour, final int min, final int sec) {
        this.minAngle = (int) (min * MINUTE_ANGLE + MINUTE_DELTA_ANGLE * sec);
        this.hourAngle = (int) (hour % 12 * HOUR_ANGLE + HOUR_DELTA_ANGLE * min);
        int angle = hourAngle - minAngle;
        if (angle < 0) {
            angle = 360 + angle;
        }
        this.angle = angle;
    }

    public int getHourAngle() {
        return hourAngle;
    }

    public int getMinAngle() {
        return minAngle;
    }

    public int getMinHourAngle() {
        return this.angle;
    }

    public int getHourMinAngle() {
        return 360 - this.angle;
    }

    public boolean isMinOverHour() {
        return this.angle == 0;
    }

    public double getAngle() {
        if(getHourMinAngle() < getMinHourAngle()) {
            return getHourMinAngle();
        } else {
            return getMinHourAngle();
        }
    }
}
