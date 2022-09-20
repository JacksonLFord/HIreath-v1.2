package Main;

import JDA_Utili.Category;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static Main.Generic.*;

public class Levels_Admin extends JDA_Utili.Command{
    private final EventWaiter waiter;

    public Levels_Admin(EventWaiter waiter, Category Cat){
        super.name = "levels";
        super.help = "A command to show all exp for commands";

        super.cooldown = 5;
        this.waiter = waiter;
        super.userPermissions = new Permission[]{Permission.MANAGE_SERVER};
        super.category = Cat;


    }

    @Override
    public void execute(MessageReceivedEvent event, String command) {
     EmbedBuilder embed = new EmbedBuilder();
        embed.setColor(new Color(0, 78, 255, 1));
        String str = "";
        int index = 1;

        while(index<25){

            str = str + "``"+pad("Level "+index+" : "+getLevel(index)+" exp",30)+"`` |\n";


            index++;
        }
        embed.addField("Levels : ",str,false);
        event.getChannel().sendMessage(embed.build()).queue();
    }

}
