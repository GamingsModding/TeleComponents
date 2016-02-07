package com.gamingsmod.telecomponents.common.helper;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class TimeHelper
{
    public static String ticksToSeconds(int ticks)
    {
        double timeLeft = ticks / 10;
        DecimalFormat df = new DecimalFormat("#");
        df.setRoundingMode(RoundingMode.CEILING);
        return df.format(timeLeft);
    }
}
