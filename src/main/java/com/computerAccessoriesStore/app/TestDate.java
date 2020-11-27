package com.computerAccessoriesStore.app;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class TestDate {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
    }
}
