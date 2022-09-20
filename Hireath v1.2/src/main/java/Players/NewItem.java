package Players;

import JDA_Utili.Category;
import Main.Item;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import static Main.Generic.convertToString;
import static Main.Generic.getConn;


public class NewItem extends JDA_Utili.Command {
    private final EventWaiter waiter;
    public NewItem(EventWaiter waiter, Category Cat){

        super.name = "New Item";
        super.help = "A command to make a new item!";
        super.aliases = new String[]{"NewItem","new"};
        super.cooldown = 5;
        this.waiter = waiter;

        super.category = Cat;
        super.userPermissions = new Permission[]{Permission.MANAGE_SERVER};

    }

    @Override
    public void execute(MessageReceivedEvent event, String command) {
        if(event.getMember().hasPermission(super.userPermissions)){
            Item item = new Item();
            //////////////////////////////////////////////////////////////////////////////////
            event.getChannel().sendMessage("Okie, now give me the name of the item!").queue();
            waiter.waitForEvent(GuildMessageReceivedEvent.class, e -> e.getAuthor().equals(event.getAuthor()) && e.getChannel().equals(event.getChannel()), e -> {
                //First argument is the event we are waiting for. Second is the condition that is checked when the event is triggered. Third is the code that will be run with the event and condition is fulfilled.
                try{
                    item.NAME = e.getMessage().getContentRaw();
                    //////////////////////////////////////////////////////////////////////////////////
                    e.getChannel().sendMessage("The items name is "+item.NAME +". What is the description?").queue();
                    System.out.println("First message");
                    waiter.waitForEvent(GuildMessageReceivedEvent.class, f -> f.getAuthor().equals(event.getAuthor()) && f.getChannel().equals(event.getChannel()), f -> {
                        try{
                            System.out.println("Second Message");
                            item.DESCRIPTION = f.getMessage().getContentRaw();
                            //////////////////////////////////////////////////////////////////////////////////
                            f.getChannel().sendMessage("The items name is \""+item.DESCRIPTION +"\". What are the skills? ( Example : Attack : 1, Armor : 4").queue();
                            waiter.waitForEvent(GuildMessageReceivedEvent.class, g -> g.getAuthor().equals(event.getAuthor()) && g.getChannel().equals(event.getChannel()), g -> {
                                try{
                                    System.out.println("Third msg");
                                    String[] msgs = g.getMessage().getContentRaw().split(",");
                                    int index0 = 0;
                                    while(index0<msgs.length){
                                        try{
                                            String affin = "";
                                            int ammount = 0;
                                            affin = msgs[index0].split(":")[0].trim();
                                            ammount = Integer.parseInt(msgs[index0].split(":")[1].trim());
                                            item.STATS.addStats(affin,ammount);

                                        }catch(Exception p){

                                        }

                                        index0++;
                                    }
                                    //////////////////////////////////////////////////////////////////////////////////
                                    g.getChannel().sendMessage(" What are the affinities? ( Example : Water : 1, Fire : 4").queue();
                                    waiter.waitForEvent(GuildMessageReceivedEvent.class, d -> d.getAuthor().equals(event.getAuthor()) && d.getChannel().equals(event.getChannel()), d -> {
                                        System.out.println("Fourth");
                                        String[] msgss = d.getMessage().getContentRaw().split(",");
                                        int index = 0;
                                        while(index<msgss.length){
                                            try{
                                                String affin = "";
                                                int ammount = 0;
                                                affin = msgss[index].split(":")[0].trim();
                                                ammount = Integer.parseInt(msgss[index].split(":")[1].trim());
                                                item.AFFINITIES.addAffin(affin,ammount);

                                            }catch(Exception p){

                                            }

                                            index++;
                                        }

                                        //////////////////////////////////////////////////////////////////////////////////
                                        d.getChannel().sendMessage("Do you want it equipped or unequpped?(E or U)").queue();
                                        waiter.waitForEvent(GuildMessageReceivedEvent.class, le -> le.getAuthor().equals(event.getAuthor()) && le.getChannel().equals(event.getChannel()), le -> {
                                            if(le.getMessage().getContentRaw().equalsIgnoreCase("E")){
                                                item.EQUIPPED = true;
                                            }else{
                                                item.EQUIPPED = false;
                                            }

                                            le.getChannel().sendMessage("Please ping the person who you wish this item to go to!").queue();
                                            waiter.waitForEvent(GuildMessageReceivedEvent.class, lel -> lel.getAuthor().equals(event.getAuthor()) && lel.getChannel().equals(event.getChannel()), lel -> {
                                                System.out.println("sixyth");

                                                try{
                                                    Statement stmt;

                                                    stmt = getConn().createStatement();
                                                    stmt.execute("INSERT INTO GameMaster.dbo."+convertToString(lel.getMessage().getMentionedMembers().get(0).getId()) + " (ItemInfo) VALUES ('"+item.toStr()+"')");
                                                    lel.getChannel().sendMessage("Item creation is complete!").queue();
                                                    System.out.println("done");
                                                    d.getChannel().sendMessage(item.build().build()).queue();

                                                }catch(Exception th){
                                                    lel.getChannel().sendMessage("This player has not been registered! or you did not mention a proper person!").queue();
                                                    th.printStackTrace();
                                                }

                                            });

                                        });

                                    });
                                }catch(Exception m){

                                }
                            });
                        }catch(Exception g){

                        }
                    });
                }catch (IndexOutOfBoundsException ex){

                }
            });
        }else{
            event.getChannel().sendMessage("You do not have the proper permissions!").queue();
        }


    }
}