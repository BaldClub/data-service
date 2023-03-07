package com.pearadmin.mock;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;

public class FakerUtil {
//    public static Faker faker = new Faker(new Locale("zh-CN"));
    public static Faker faker = new Faker(Locale.CHINA);

    public static String randomNumberString(int min, int max) {
        return String.valueOf(randomNumber(min, max));
    }

    public static String randomNumberString(int max) {
        return String.valueOf(randomNumber(max));
    }

    public static String randomNumberString(long min, long max) {
        return String.valueOf(randomNumber(min, max));
    }

    public static int randomNumber(int min, int max) {
        return faker.number().numberBetween(min, max);
    }

    public static int randomNumber(int max) {
        return randomNumber(0, max);
    }

    public static long randomNumber(long min, long max) {
        return faker.number().numberBetween(min, max);
    }

    public static String randomDoubleString(int min, int max) {
        return String.valueOf(randomDouble(min, max));
    }

    public static String randomDoubleString(int max) {
        return String.valueOf(randomDouble(max));
    }

    public static String randomDoubleString(long min, long max) {
        return String.valueOf(randomDouble(min, max));
    }

    public static double randomDouble(int min, int max) {
        return faker.number().randomDouble(2, min, max);
    }

    public static double randomDouble(int max) {
        return randomDouble(0, max);
    }

    public static double randomDouble(long min, long max) {
        return faker.number().randomDouble(2, min, max);
    }

    public static Date randomDate(Date from, Date to) {
        return faker.date().between(from, to);
    }

    public static Date randomLastYearDate() {
        return randomDate(lastYearDate(), new Date());
    }

    public static LocalDate randomLastYearLocalDate() {
        return dateToLocalDate(randomLastYearDate());
    }

    public static Date lastYearDate() {
        return localDateToDate(lastYearLocalDate());
    }

    public static LocalDate lastYearLocalDate() {
        return LocalDate.now().plusYears(-1);
    }

    public static Date localDateToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static LocalDate dateToLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

}
