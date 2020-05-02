

import com.dbc.leecode.Algorithm.Reclass.ListNode;
import com.dbc.leecode.Algorithm.Solution191_200.Solution195;
import com.dbc.leecode.Algorithm.Solution191_200.Solution197;
import com.dbc.leecode.Algorithm.Solution201_210.Solution204;
import com.dbc.leecode.Algorithm.Solution201_210.Solution205;
import com.dbc.leecode.Algorithm.Solution201_210.Solution207;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Stream;

public class Main {
    public static String res = "";
    public static void main(String[] args) throws ParseException {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("")
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.parse("2018-10-3 00:00:00").getTime());
        System.out.println(simpleDateFormat.parse("2018-10-4 00:00:00").getTime());

        Long time = 1538528319845L;
        Long time1 = 1538528510170L;

        Long time2 = 1538528632558L;
        Long time3 = 1538530180824L;

        Long time4 = 1538530184125L;
        Long time5 = 1538530715461L;
        String res = simpleDateFormat.format(new Date(Long.parseLong(String.valueOf(time))));
        String res1 = simpleDateFormat.format(new Date(Long.parseLong(String.valueOf(time1))));

        String res2 = simpleDateFormat.format(new Date(Long.parseLong(String.valueOf(time2))));
        String res3 = simpleDateFormat.format(new Date(Long.parseLong(String.valueOf(time3))));

        String res4 = simpleDateFormat.format(new Date(Long.parseLong(String.valueOf(time4))));
        String res5 = simpleDateFormat.format(new Date(Long.parseLong(String.valueOf(time5))));
        System.out.println(res);
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
        System.out.println(res4);
        System.out.println(res5);
    }
}