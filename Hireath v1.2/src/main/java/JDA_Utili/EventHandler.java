package JDA_Utili;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class EventHandler extends ListenerAdapter {
    final ArrayList<Command> COMMANDS;
    final String PREFIX;
    private static ArrayList<ArrayList<Command>> CMDLIST;
    public EventHandler(ArrayList<Command> commands,String prefix,ArrayList<ArrayList<Command>> cmd){
        COMMANDS = commands;
        PREFIX = prefix;
        CMDLIST = cmd;
    }
    public static ArrayList<Timestamp> disctionary = new ArrayList<Timestamp>();

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {



        int index = 0;
        String command = "";
        Command currcomm = null;
        boolean check = false;
        while(index<COMMANDS.size()){

            //For each command added
            ArrayList<String> aliases = new ArrayList<String>();
            int index2 = 0;
            try{
                while(index2<COMMANDS.get(index).aliases.length){
                    aliases.add(PREFIX+COMMANDS.get(index).aliases[index2]);
                    index2++;
                }
            }catch(Exception t ){

            }
           aliases.add(PREFIX+COMMANDS.get(index).name);
            //Getting all the aliases and names the command goes by

            int index3 = 0;
            while(index3<aliases.size()){
                //for each name
                    String first[] = event.getMessage().getContentRaw().split(" ");


                if(first[0].equalsIgnoreCase(aliases.get(index3).toLowerCase())){

                    //If the message contains the alias
                    check = true;

                    command = (aliases.get(index3));
                    currcomm = COMMANDS.get(index);
                    index3 = aliases.size();
                    index = COMMANDS.size();
                }
                index3++;
            }

            index++;
        }if(check){

            int index10 = 0;
            int mark = 0;
            boolean mack = false;
            while(index10<disctionary.size()){
                if(disctionary.get(index10).ID==(event.getAuthor().getIdLong())
                &&(disctionary.get(index10).COMMAND.name ==currcomm.name) ){
                    mark = index10;

                    mack = true;

                }
                index10++;
            }
            if(mack == true){

                LocalDateTime time = disctionary.get(mark).TIME;
                if(time.isBefore(event.getMessage().getTimeCreated().toLocalDateTime())){
                    disctionary.remove(mark);
                    currcomm.execute(event,command);
                    disctionary.add(new Timestamp(event.getAuthor().getIdLong(),currcomm,
                            event.getMessage().getTimeCreated().toLocalDateTime().plusSeconds(currcomm.cooldown) ));
                }if(time.isAfter(event.getMessage().getTimeCreated().toLocalDateTime())){
                    LocalDateTime tim = event.getMessage().getTimeCreated().toLocalDateTime();
                    int TotalSeconds = (((time.getHour() * 60) + time.getMinute()) * 60) +time.getSecond();
                    int TatSeconds = (((tim
                            .getHour() * 60) + tim
                            .getMinute()) * 60) +tim
                            .getSecond();
                    int remaining = TotalSeconds - TatSeconds;
                    event.getChannel().sendMessage("You have "+remaining + " seconds before you can use this command again!").queue();

                }

            }
            if (mack == false) {

                currcomm.execute(event,command);
                disctionary.add(new Timestamp(event.getAuthor().getIdLong(),currcomm,
                        event.getMessage().getTimeCreated().toLocalDateTime().plusSeconds(currcomm.cooldown) ));


                System.out.println("Command finish");

            }

        }



    }

}
