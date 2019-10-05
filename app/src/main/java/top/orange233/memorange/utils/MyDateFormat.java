package top.orange233.memorange.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDateFormat {

    private static final MyDateFormat instance = new MyDateFormat();

    private MyDateFormat() {

    }

    public static MyDateFormat getInstance() {
        return instance;
    }

    public String getDate() {
        Date dNow = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日 HH:mm");
        return sdf.format(dNow);
    }
}
