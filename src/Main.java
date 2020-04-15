

import com.dbc.leecode.Algorithm.Reclass.ListNode;
import com.dbc.leecode.Algorithm.Solution191_200.Solution195;
import com.dbc.leecode.Algorithm.Solution191_200.Solution197;
import com.dbc.leecode.Algorithm.Solution201_210.Solution204;
import com.dbc.leecode.Algorithm.Solution201_210.Solution205;

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
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            res = "";
            String s1 = cin.next();
            String s2 = cin.next();
            cal_tree(s1, s2);
            if (res.length() != s1.length()) {
                System.out.println("wrong tree list!");
            }
            else {
                System.out.println(res);
            }
        }

//        String s1 = "DBHEAGCF";
//        String s2 = "DHEBGFCA";
    }

    public static boolean StringEquals(String a1, String a2) {
        boolean state = true;
        if (a1.length() != a2.length()) {
            state = false;
        }
        if (a1.length() == a2.length()) {
            for (int i = 0; i < a1.length(); i++) {
                if (a2.indexOf(a1.charAt(i)) == -1)
                    state = false;
            }
        }
        return state;
    }

    public static void cal_tree(String smid, String slast) {
        boolean state = StringEquals(smid, slast);
        if (state == false)
            return;
        if (smid.length() == 0)
            return;
        if (smid.length() == 1) {
            res += smid;
            return;
        }
        char root = slast.charAt(slast.length()-1);
        int mid = smid.indexOf(root);
        String c=smid.substring(0, mid);
        String d = smid.substring(mid+1);
        res += String.valueOf(root);
        cal_tree(c,slast.substring(0, c.length()));
        cal_tree(d,slast.substring(c.length(),slast.length()-1));
        return;
    }
}