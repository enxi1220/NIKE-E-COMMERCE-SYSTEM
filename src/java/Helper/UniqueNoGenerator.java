package Helper;

import java.time.LocalDate;

/**
 *
 * @author Lim En Xi
 */
public class UniqueNoGenerator {

    public static String generator(String currNo, String prefix) {
        String[] elements = currNo.split("/");
        int suffix = Integer.parseInt(elements[2]);
        LocalDate localDate = LocalDate.now();
        int year = localDate.getYear();
        int month = localDate.getMonthValue();
        
        if (!elements[1].equals(Integer.toString(year) + String.format("%02d", month))) {
            suffix = 1;
        }else{
            ++suffix;        
        }

        String nextNo = prefix + "/" + year + String.format("%02d", month) + "/" + String.format("%06d", suffix);
        return nextNo;
    }
}
