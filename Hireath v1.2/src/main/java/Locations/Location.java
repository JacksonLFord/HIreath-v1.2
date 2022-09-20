package Locations;

import JDA_Utili.Command;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.ArrayList;

public class Location extends Command {
    String NAME;
    public Location(String names ,Dialouge dia){
        super.name = "db";
        super.aliases = new String[]{"Dragonbane"};
        super.arguments= "[command]";
        NAME = names;
    }


    @Override
    public void execute(MessageReceivedEvent event, String command) {

    }
}
