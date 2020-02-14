package demo08_Date;

import java.util.Calendar;

/**
 * Date 日期类
 * Calendar 日历类
 */
public class MyDate {
    public static void main(String[] args) throws Exception{
        //获取当前时间
        Calendar cal = Calendar.getInstance();
        //获取当前年份、月份、日数、小时、分钟、秒数
        //
        System.out.println(cal.get(Calendar.YEAR));
        System.out.println(cal.get(Calendar.MONTH)+1);
        System.out.println(cal.get(Calendar.DAY_OF_MONTH));
        System.out.println(cal.get(Calendar.HOUR_OF_DAY));
        System.out.println(cal.get(Calendar.MINUTE));

        //重设当前时间
        cal.setTimeInMillis(System.currentTimeMillis());

    }
}
