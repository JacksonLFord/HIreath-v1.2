package Main;

import JDA_Utili.Category;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;

import static Main.Generic.getLevel;
import static Main.Generic.pad;

public class Level_Admin extends JDA_Utili.Command {
    private final EventWaiter waiter;

    public Level_Admin(EventWaiter waiter, Category Cat){
        super.name = "level";
        super.help = "A command to show exp for a level";

        super.cooldown = 5;
        this.waiter = waiter;
        super.userPermissions = new Permission[]{Permission.MANAGE_SERVER};
        super.category = Cat;


    }

    @Override
    public void execute(MessageReceivedEvent event, String command) {
        EmbedBuilder embed = new EmbedBuilder();
        embed.setColor(new Color(0, 78, 255, 1));
        try{
            int index = Integer.parseInt(event.getMessage().getContentRaw().split(" ")[1]);

            String str = "``"+pad(getLevel(index)+" exp",10)+"`` |\n";

            embed.setDescription("Level : "+index + " | "+str);
            event.getChannel().sendMessage(embed.build()).queue();
        }catch(Exception e){
            event.getChannel().sendMessage("Please provide a level #").queue();
        }

    }
}
