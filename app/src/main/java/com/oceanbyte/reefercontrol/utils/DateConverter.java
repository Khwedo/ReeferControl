package com.oceanbyte.reefercontrol.utils;

import androidx.room.TypeConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateConverter {

    // Формат: 03 Aug 2025 17:54
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy HH:mm", Locale.getDefault());

    @TypeConverter
    public static Date fromString(String value) {
        if (value == null) return null;
        try {
            return sdf.parse(value);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    @TypeConverter
    public static String fromDate(Date date) {
        if (date == null) return null;
        return sdf.format(date);
    }
}