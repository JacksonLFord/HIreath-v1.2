package Players;


import JDA_Utili.Category;
import JDA_Utili.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;


public class Dice extends Command {
    private final EventWaiter waiter;
    public Dice(EventWaiter waiter, Category Cat){
        super.name = "Dice";
        super.help = "A command to get a random number from 1 - the given number.";
        super.aliases = new String[]{"roll"};
        super.cooldown = 5;
        this.waiter = waiter;
        super.arguments = "[max]";

        super.category = Cat;
        super.userPermissions = new Permission[]{Permission.MANAGE_SERVER};

    }

    @Override
    public void execute(MessageReceivedEvent event, String command) {

        String args = event.getMessage().getContentRaw().toLowerCase().replace(command.toLowerCase(),"").trim();
        System.out.println(args);
            try {
                int levelee = Integer.parseInt(args);
                int dice1 = (int) (Math.random() * levelee + 1);
                EmbedBuilder ed = new EmbedBuilder();
                ed.setTitle("" + dice1);

                event.getChannel().sendMessage(ed.build()).queue();

            } catch (Exception e) {
                event.getChannel().sendMessage("Please use the proper arguments :"+arguments).queue();
            }

    }
}