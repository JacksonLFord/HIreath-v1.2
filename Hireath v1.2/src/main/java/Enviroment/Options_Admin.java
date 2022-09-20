package Enviroment;

import JDA_Utili.Category;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.ArrayList;

import static Main.Generic.pad;


public class Options_Admin extends JDA_Utili.Command{
    private final EventWaiter waiter;
    private final ArrayList<String> items;
    public Options_Admin(EventWaiter waiter, Category Cat, ArrayList<String> enem){
        super.name = "Options";
        super.help = "A command to show all the available monsters/people/familiars.";
        super.aliases = new String[]{"enemies"};
        super.cooldown = 5;
        this.waiter = waiter;

        this.items = enem;
        super.category = Cat;
        super.userPermissions = new Permission[]{Permission.MANAGE_SERVER};

    }

    @Override
    public void execute(MessageReceivedEvent event, String command) {
        if(event.getMember().hasPermission(super.userPermissions)){
            EmbedBuilder embed = new EmbedBuilder();

            String str = "";
            int index = 0;
            while(index<items.size()){
                str = str + "``"+pad(items.get(index),40)+"`` | \n";
                index++;
            }embed.addField("Avaliable Options : ",str,false);
            event.getChannel().sendMessage(embed.build()).queue();
        }else{
            event.getChannel().sendMessage("You do not have the proper permissions!").queue();
        }



    }
}
