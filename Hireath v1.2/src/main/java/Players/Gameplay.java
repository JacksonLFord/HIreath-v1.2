package Players;

import JDA_Utili.Category;
import Main.Item;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.PrivateChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;
import java.sql.Statement;
import java.util.ArrayList;

import static Main.Generic.*;
import static Main.Main.*;

public class Gameplay extends JDA_Utili.Command {
    private final EventWaiter waiter;
    public Gameplay(EventWaiter waiter, Category Cat){
        super.name = "setgameplay";
        super.help = "Assigning a gameplay to a player!";
        super.aliases = new String[]{"gameplay","setgp","gp"};
        super.cooldown = 5;
        this.waiter = waiter;
        super.arguments = "[gameplay] [person]";

        super.category = Cat;
        super.userPermissions = new Permission[]{Permission.MANAGE_SERVER};

    }

    @Override
    public void execute(MessageReceivedEvent event, String command) {

        String args = event.getMessage().getContentRaw().toLowerCase().replace(command.toLowerCase(),"").trim();
        if(event.getMember().hasPermission(super.userPermissions)){
            try {

                String gameplay = args.split(" ")[0];
                try{
                    Statement stmt;

                    stmt = getConn().createStatement();
                    stmt.execute("UPDATE GameMaster.dbo.Players SET Gameplay = "+gameplay+" WHERE Id = "+event.getMessage().getMentionedUsers().get(0).getId());
                    event.getChannel().sendMessage("Okie, "+event.getMessage().getMentionedUsers().get(0).getName()+"'s Gameplay is now "+gameplay).queue();

                }catch(Exception e){
                    event.getChannel().sendMessage("This player has not been registered!").queue();
                    e.printStackTrace();
                }
            } catch (Exception e) {
                event.getChannel().sendMessage("Please use the proper arguments :"+arguments).queue();
            }
        }else{
            event.getChannel().sendMessage("You do not have the proper permissions!").queue();
        }


    }
}
