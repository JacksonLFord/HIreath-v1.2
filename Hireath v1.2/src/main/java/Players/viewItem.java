package Players;

import Main.Item;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.PrivateChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;
import java.util.ArrayList;

import static Main.Generic.getItems;
import static Main.Generic.pad;

public class viewItem extends JDA_Utili.Command{
    private final EventWaiter waiter;
    public viewItem(EventWaiter waiter, JDA_Utili.Category Cat){
        super.name = "item";
        super.help = "A command to see the stats for an item.";
        super.aliases = new String[]{"viewitem","view"};
        super.cooldown = 5;
        this.waiter = waiter;
        super.arguments = "[index] [person]";

        super.category = Cat;
        super.userPermissions = new Permission[]{Permission.MANAGE_SERVER};

    }

    @Override
    public void execute(MessageReceivedEvent event, String command) {
        User user;

        try{

            user = event.getMessage().getMentionedUsers().get(0);
            if(event.getMember().hasPermission(super.userPermissions)){
                try{
                    //If someone is mentioned
                    ArrayList<String> items = getItems(user.getIdLong());
                    String[] str = event.getMessage().getContentRaw().split(" ", 3);
                    int index = Integer.parseInt(str[1]);
                    if (index >= items.size()) {
                        event.getChannel().sendMessage("The item of that index does not exist!").queue();
                        return;
                    }else{
                        Item item = new Item();

                        item.toObj(items.get(index));
                        PrivateChannel pm = event.getAuthor().openPrivateChannel().complete();
                        pm.sendMessage(item.build().build()).queue();

                    }
                }catch(Exception e){
                    event.getChannel().sendMessage("Please mention a *registered* user!").queue();
                }
            }else{
                event.getChannel().sendMessage("You do not have the proper permissions!").queue();
            }



        }catch(Exception e){
            user = event.getAuthor();
            try{
                //If someone is mentioned
                ArrayList<String> items = getItems(user.getIdLong());
                String[] str = event.getMessage().getContentRaw().split(" ", 3);
                int index = Integer.parseInt(str[1]);
                if (index >= items.size()) {
                    event.getChannel().sendMessage("The item of that index does not exist!").queue();
                    return;
                }else{
                    Item item = new Item();

                    item.toObj(items.get(index));
                    PrivateChannel pm = event.getAuthor().openPrivateChannel().complete();
                    pm.sendMessage(item.build().build()).queue();

                }
            }catch(Exception f){
                event.getChannel().sendMessage("You are not registered!").queue();
            }

        }
    }

}
