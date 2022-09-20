package JDA_Utili;

import java.time.LocalDateTime;

public class Timestamp {
    public static long ID;
    public static Command COMMAND;
    public static LocalDateTime TIME;
    public Timestamp(Long id, Command Command, LocalDateTime time){
        ID = id;
        COMMAND = Command;
        TIME = time;


    }
}
