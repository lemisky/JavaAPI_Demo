package demo08_Date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyDate2 {
    public static void main(String[] args) throws Exception {
        //日期格式化，一般使用 SimpleDateFormat
        SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd");
        Date parse = format.parse("2014/06/08");
        System.out.println((System.currentTimeMillis()-parse.getTime())/1000/3600/24);

        //计算出生多少天
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR,2014);
        calendar.set(Calendar.MONTH,6-1);
        calendar.set(Calendar.DATE,8);
        System.out.println((System.currentTimeMillis()-calendar.getTimeInMillis())/1000/3600/24);


    }
}
