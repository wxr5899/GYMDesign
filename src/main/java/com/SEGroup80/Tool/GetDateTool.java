package com.SEGroup80.Tool;

import java.util.Calendar;
import java.util.Date;

public class GetDateTool {

    public Date getBeforeOrAfterDate(Date date, int num) {
        Calendar calendar = Calendar.getInstance(); //获取日历
        calendar.setTime(date);                     //当date的值是当前时间，则可以不用写这段代码。
        calendar.add(Calendar.DATE, num);
        Date d = calendar.getTime();                //把日历转换为Date
        return d;
    }


}
