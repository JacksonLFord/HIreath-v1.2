package JDA_Utili;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.Event;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;

import static Main.Generic.pad;

public abstract class Command {

    public abstract void execute(MessageReceivedEvent event, String command);

    protected String name="";
    protected  String help ="";
    protected  String[] aliases;
    protected Category category = new Category("misc");
    protected int cooldown=0;
    protected String arguments;
    protected Permission[] userPermissions;


    protected  EmbedBuilder help(JDA jda, String prefix){
        EmbedBuilder embed = new EmbedBuilder();
        embed.setColor(new Color(0, 78, 255, 1));




        embed.addField("``Category`` : ",category.Name,true);
        embed.addField("``Cooldown`` : ",cooldown+" Seconds",true);
        embed.setDescription(help);
        String ali = "";
        int index = 0;
        int size = 0;
        String string = "";
        try{
            while(index<aliases.length){
                if(size < aliases[index].length()){
                    size = aliases[index].length();
                }
                index++;
            }size = size + prefix.length();
            int index2 = 0;

            while(index2<aliases.length){
                ali = ali + "`["+prefix+aliases[index2]+"]` ";
                index2++;

                if(index2%2 == 0)
                {
                    ali = ali+"\n";
                }
            }//insert every 6 + size
            string = ali;
        }catch(Exception e){

        }


        embed.setThumbnail(jda.getSelfUser().getAvatarUrl());
        embed.setTitle("`"+prefix+name+" "+arguments+"` | "+string);
        return embed;
    }public static String insertPeriodically(
            String text, String insert, int period)
    {
        StringBuilder builder = new StringBuilder(
                text.length() + insert.length() * (text.length()/period)+1);

        int index = 0;
        String prefix = "";
        while (index < text.length())
        {
            // Don't put the insert in the very first iteration.
            // This is easier than appending it *after* each substring
            builder.append(prefix);
            prefix = insert;
            builder.append(text.substring(index,
                    Math.min(index + period, text.length())));
            index += period;
        }
        return builder.toString();
    }

}
