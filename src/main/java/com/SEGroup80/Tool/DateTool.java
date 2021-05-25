package com.SEGroup80.Tool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTool {

    public Date getBeforeOrAfterDate(Date date, int num) {
        Calendar calendar = Calendar.getInstance(); //获取日历
        calendar.setTime(date);                     //当date的值是当前时间，则可以不用写这段代码。
        calendar.add(Calendar.DATE, num);
        Date d = calendar.getTime();                //把日历转换为Date
        return d;
    }


    /**
     * Compare two time points
     * @param startPoint The 1st time point
     * @param endPoint The 2nd time point
     * @param simpleDateFormat with right format of time point
     * @return if the first time point is before the 2nd
     * @throws ParseException if the format of the SimpleDateFormat is not match the format of time point, there will be a ParseException
     */
    public Boolean CompareTimeString(String startPoint, String endPoint, SimpleDateFormat simpleDateFormat) throws ParseException {

        String beginTime = new String(startPoint);
        String endTime = new String(endPoint);

        Date beginDate = simpleDateFormat.parse(beginTime);
        Date endDate = simpleDateFormat.parse(endTime);

        return beginDate.before(endDate);
    }


}
