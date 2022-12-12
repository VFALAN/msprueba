package com.vf.nach.msprueba.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static Boolean validDates(Date startDate, Date endDate) {
        return startDate.before(endDate);
    }

    public static Date parseFromString(String dateValue , String format) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
     return   simpleDateFormat.parse(dateValue);
    }
}
