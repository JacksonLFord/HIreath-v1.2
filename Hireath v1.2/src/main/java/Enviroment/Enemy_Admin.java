package Enviroment;

import JDA_Utili.Category;
import JDA_Utili.Command;
import Main.Generic;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;

public class Enemy_Admin extends Command {
    private final EventWaiter waiter;
    private final String realName;
    private final double basehp;
    private final double basedmg;

    public Enemy_Admin(EventWaiter waiter, Category Cat, String nameOf, String abbrev, double baseHealth, double baseDamage) {
        super.name = nameOf.replace(" ", "");
        super.help = "A command to give the stats for the " + nameOf;
        String alias1 = name;
        realName = nameOf;
        super.aliases = new String[]{nameOf, alias1, abbrev};
        super.cooldown = 10;
        this.waiter = waiter;
        super.arguments = "[level]";

        super.category = Cat;
        this.basehp = baseHealth;
        this.basedmg = baseDamage;

        Generic.COMMANDS.add("#" + super.name + " & #" + abbrev);
        super.userPermissions = new Permission[]{Permission.MANAGE_SERVER};
    }

    @Override
    public void execute(MessageReceivedEvent event, String command) {
        if(event.getMember().hasPermission(super.userPermissions)){
            String args = event.getMessage().getContentRaw().toLowerCase().replace(command.toLowerCase(),"").trim();
            try {

                System.out.println("Command is Run!");
                double exp = 0;
                int level = Integer.parseInt(args);
                int highest =(int)Math.round( basedmg * level);
                int healthhh = (int)Math.round(basehp * level);
                exp = (((basehp * level) + (basedmg * level)) * level) / 2;

                EmbedBuilder ed = new EmbedBuilder();
                ed.setTitle(this.realName);
                ed.addField("```Stats: ```", "``Health: " + healthhh + "`` | ``Highest: "
                        + highest + "`` | ``Level: " + level + "`` | ``Exp: " + exp + "`` |", false);
                if(super.category.getName().equalsIgnoreCase("``[Familar]``")){
                    ed.addField("```Location:```", "The ``"+this.name+"`` can be found in the ``[Unknown]``!",false);
                }else{
                    ed.addField("```Location:```", "The ``"+this.name+"`` can be found in the "+super.category.getName()+"!",false);
                }
                ed.setColor(new Color(0, 78, 255, 1));
                event.getChannel().sendMessage(ed.build()).queue();
            } catch (Exception e) {
                event.getChannel().sendMessage("Please use the proper arguments :"+arguments).queue();
            }
        }else{
            event.getChannel().sendMessage("You do not have the proper permissions!").queue();
        }

    }
}
