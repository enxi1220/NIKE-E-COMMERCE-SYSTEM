package Helper;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class CurrentDate{
    
    public static Timestamp getDate(){
        return Timestamp.valueOf(LocalDateTime.now());
    }
}