package Players;

import JDA_Utili.Category;
import Main.Item;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.PrivateChannel;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static Main.Generic.*;


public class Items extends JDA_Utili.Command {
    private final EventWaiter waiter;
    public Items(EventWaiter waiter, Category Cat){
        super.name = "items";
        super.help = "An items to show all the items belonging to a person!";

        super.cooldown = 5;
        this.waiter = waiter;
        super.arguments = "[person]";
        super.userPermissions = new Permission[]{Permission.MANAGE_SERVER};

        super.category = Cat;


    }
    public static int size = 50;
    @Override
    public void execute(MessageReceivedEvent event, String command) {

        User user;
        try{

            user = event.getMessage().getMentionedUsers().get(0);
            if(event.getMember().hasPermission(super.userPermissions)){
                try{
                    ArrayList<String> items = getItems(user.getIdLong());
                    int index = 0;
                    String str = "";
                    EmbedBuilder embed = new EmbedBuilder();
                    while(index<items.size()){
                        Item item = new Item();
                        item.toObj(items.get(index));
                        str = str + "``" +pad(index+". "+item.NAME,35)+"`` | \n";

                        index++;
                    }
                    embed.addField("Items of : ``"+user.getName()+"``", str,false);
                    embed.setColor(new Color(0, 78, 255, 1));
                    PrivateChannel pm = event.getAuthor().openPrivateChannel().complete();
                    pm.sendMessage(embed.build()).queue();
                }catch(Exception e){
                    event.getChannel().sendMessage("Please mention a *registered* user!").queue();
                }
            }else{
                event.getChannel().sendMessage("You do not have the proper permissions!").queue();
            }



        }catch(Exception e){
            try{
                user = event.getAuthor();
                ArrayList<String> items = getItems(user.getIdLong());
                int index = 0;
                String str = "";
                EmbedBuilder embed = new EmbedBuilder();
                while(index<items.size()){
                    Item item = new Item();
                    item.toObj(items.get(index));
                    str = str + "``" +pad(index+". "+item.NAME,35)+"`` | \n";

                    index++;
                }
                embed.addField("Items of : ``"+user.getName()+"``", str,false);
                embed.setColor(new Color(0, 78, 255, 1));
                PrivateChannel pm = event.getAuthor().openPrivateChannel().complete();
                pm.sendMessage(embed.build()).queue();
            }catch(Exception f){
                event.getChannel().sendMessage("You are not registered!").queue();
            }
        }




    }

}
