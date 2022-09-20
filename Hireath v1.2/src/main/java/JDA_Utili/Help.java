package JDA_Utili;

import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.PrivateChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;
import java.util.ArrayList;

public class Help extends Command{
    ArrayList<Command> COMMANDS;
    String PREFIX;

    private static ArrayList<ArrayList<Command>> CMDLIST;
    public Help(Category Cat, ArrayList<Command> cmd,String prefix,ArrayList<ArrayList<Command>> d){
        this.COMMANDS = cmd;
        this.PREFIX = prefix;
        super.name = "Help";
        super.help = "A command to provide help!.";
        super.cooldown = 5;

        super.arguments = "[command]";

        super.category = Cat;
        CMDLIST = d;

    }

    @Override
    public void execute(MessageReceivedEvent event, String command) {
        String args = event.getMessage().getContentRaw().toLowerCase().replace(command.toLowerCase(),"").trim();
        try{
            int index = 0;
            Command currcomm = COMMANDS.get(0);
            Boolean check = false;
            while(index<COMMANDS.size()){

                //For each command added
                ArrayList<String> aliases = new ArrayList<String>();
                int index2 = 0;
                try{
                    while(index2<COMMANDS.get(index).aliases.length){
                        aliases.add(COMMANDS.get(index).aliases[index2]);
                        index2++;
                    }
                }catch(Exception t ){

                }
                aliases.add(COMMANDS.get(index).name);
                //Getting all the aliases and names the command goes by

                int index3 = 0;
                while(index3<aliases.size()){
                    //for each name
                    String first[] = event.getMessage().getContentRaw().split(" ",2);

                    if(first[1].equalsIgnoreCase(aliases.get(index3).toLowerCase())){

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
            }
            if(check){
                PrivateChannel pm = event.getAuthor().openPrivateChannel().complete();
                event.getChannel().sendMessage(currcomm.help(event.getJDA(),PREFIX).build()).queue();
            }else{
                event.getChannel().sendMessage("The command you entered does not exist!").queue();
            }
        }catch(Exception d){
            int index = 0;
            EmbedBuilder em = new EmbedBuilder();
            int check = 50;
            while(index<CMDLIST.size()) {
                System.out.println("Round one");
                String str = "";
                int index2 = 0;
                while (index2 < CMDLIST.get(index).size()) {
                    str = str + "`" +PREFIX+ CMDLIST.get(index).get(index2).name + "` | ";
                    index2++;
                }
                em.addField("`" + CMDLIST.get(index).get(0).category.getName() + "`", str, false);
                index++;
            }
            em.setTitle("`Available commands` :");
            em.setColor(new Color(0, 78, 255, 1));
            PrivateChannel pm = event.getAuthor().openPrivateChannel().complete();
            pm.sendMessage(em.build()).queue();
        }


    }


}
