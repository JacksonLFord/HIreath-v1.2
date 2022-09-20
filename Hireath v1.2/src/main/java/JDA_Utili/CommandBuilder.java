package JDA_Utili;

import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.PrivateChannel;
import net.dv8tion.jda.api.events.Event;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


import java.sql.Array;
import java.sql.Statement;
import java.util.ArrayList;

public class CommandBuilder  {
    public CommandBuilder(String Token){
        TOKEN = Token;

    }
    private static String TOKEN;

    private static net.dv8tion.jda.api.JDA JDA;
    private static Activity ACTIVITY;
    private static OnlineStatus ONLINE_STATUS;
    private static boolean BUILT = false;
    private static ArrayList<Command>COMMANDS= new ArrayList<Command>();
    private static String PREFIX ="/";
    private static EventWaiter waiter;
    private static ArrayList<Category> CATEGORIES = new ArrayList<Category>();
    private static ArrayList<ArrayList<Command>> CMDLIST= new ArrayList<ArrayList<Command>>();
    public static void setActivity(Activity activity){
        if(!BUILT){
            ACTIVITY = activity;

        }

    }public static void setWaiter(EventWaiter activity){
        if(!BUILT){
            waiter = activity;

        }

    }

        public static void build (){
        if(!BUILT){
            try{
                System.out.println(CMDLIST.size());
                COMMANDS.add(new Help(new Category("Help"),COMMANDS,PREFIX,CMDLIST));
                if(ACTIVITY != null && ONLINE_STATUS != null ){
                    if(waiter==null){
                        JDA = JDABuilder.createDefault(TOKEN).
                                addEventListeners(new EventHandler(COMMANDS,PREFIX,CMDLIST))
                                .setActivity(ACTIVITY)
                                .setStatus(ONLINE_STATUS)
                                .build();
                    }else{
                        JDA = JDABuilder.createDefault(TOKEN).
                                addEventListeners(new EventHandler(COMMANDS,PREFIX,CMDLIST))
                                .setActivity(ACTIVITY)
                                .setStatus(ONLINE_STATUS)
                                .addEventListeners(waiter)
                                .build();
                    }

                }else if(ONLINE_STATUS != null && ACTIVITY == null ){
                    if(waiter==null){
                        JDA = JDABuilder.createDefault(TOKEN).
                                addEventListeners(new EventHandler(COMMANDS,PREFIX,CMDLIST))
                                .setStatus(ONLINE_STATUS)
                                .build();
                    }else{
                        JDA = JDABuilder.createDefault(TOKEN).
                                addEventListeners(new EventHandler(COMMANDS,PREFIX,CMDLIST))
                                .setStatus(ONLINE_STATUS)
                                .addEventListeners(waiter)
                                .build();
                    }

                }else if(ONLINE_STATUS == null && ACTIVITY != null){
                    if(waiter==null){
                        JDA = JDABuilder.createDefault(TOKEN).
                                addEventListeners(new EventHandler(COMMANDS,PREFIX,CMDLIST))
                                .setActivity(ACTIVITY)
                                .build();
                    }else{
                        JDA = JDABuilder.createDefault(TOKEN).
                                addEventListeners(new EventHandler(COMMANDS,PREFIX,CMDLIST))
                                .setActivity(ACTIVITY)
                                .addEventListeners(waiter)
                                .build();
                    }

                }else{
                    if(waiter==null){
                        JDA = JDABuilder.createDefault(TOKEN).
                                addEventListeners(new EventHandler(COMMANDS,PREFIX,CMDLIST))
                                .build();
                    }else{
                        JDA = JDABuilder.createDefault(TOKEN).
                                addEventListeners(new EventHandler(COMMANDS,PREFIX,CMDLIST))
                                .addEventListeners(waiter)
                                .build();
                    }

                }
                JDA.awaitReady();

            }catch(Exception e){
                e.printStackTrace();
            }
            System.out.println("Finished Loading!");
        }


    }public static void setStatus(OnlineStatus status){
        if(!BUILT){
            ONLINE_STATUS = status;

        }

    }public static void addCommand(Command command){

        if(!BUILT){
            COMMANDS.add(command);
            if(COMMANDS.contains(command.category)){

            }else{
                CATEGORIES.add(command.category);
            }
            int index = 0;

            boolean check = false;

            while(index<CMDLIST.size()&&(check==false)){

                if(CMDLIST.get(index).get(0).category.equals(command.category)){
                    CMDLIST.get(index).add(command);

                    check = true;
                }
                index++;
            }if(check == false){
                System.out.println("new");
                ArrayList<Command> temp = new ArrayList<Command>();
                temp.add(command);
                CMDLIST.add(temp);

            }
        }


    }public static  void setPrefix(String prefix){
        if(!BUILT){
            PREFIX = prefix;
        }

    }

}
