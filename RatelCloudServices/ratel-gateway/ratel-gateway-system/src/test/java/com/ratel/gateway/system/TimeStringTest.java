package com.ratel.gateway.system;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeStringTest {
    public static void main(String args[]) {
        ZoneId zoneId = ZoneId.of("Australia/Melbourne");
        System.out.println("TimeZone : " + zoneId);
        ZonedDateTime zbj = ZonedDateTime.now(zoneId);
        System.out.println("Time:"+zbj);
    }
}
