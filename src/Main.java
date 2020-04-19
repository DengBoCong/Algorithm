

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
    }
}