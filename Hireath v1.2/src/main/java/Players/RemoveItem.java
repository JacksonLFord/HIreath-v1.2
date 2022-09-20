package Players;

import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static Main.Generic.*;

public class RemoveItem extends JDA_Utili.Command{
    private final EventWaiter waiter;

    public RemoveItem(EventWaiter waiter, JDA_Utili.Category Cat){
        super.name = "remove";
        super.help = "A command to remove an item from someones inv";

        super.cooldown = 5;
        this.waiter = waiter;
        super.arguments = " [person] [index]";
        super.userPermissions = new Permission[]{Permission.MANAGE_SERVER};
        super.category = Cat;


    }

    @Override
    public void execute(MessageReceivedEvent event, String command) {
        User user;
        try{

            user = event.getMessage().getMentionedUsers().get(0);
            if(event.getMember().hasPermission(super.userPermissions)){
                try{

                    try{
                        int index = Integer.parseInt(event.getMessage().getContentRaw().split(" ",3)[2]);
                        ArrayList<String> items = getItems(user.getIdLong());
                        String item = items.get(index);
                        Statement str = null;

                        try {
                            str = getConn().createStatement();
                            String sqlr = "DELETE FROM GameMaster.dbo."+convertToString(user.getId())+"\n" +
                                    "WHERE ItemInfo = '"+item+"'";
                            str.execute(sqlr);
                            event.getChannel().sendMessage("Item deleted!").queue();
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }catch(Exception e){
                        event.getChannel().sendMessage("Please use the proper arguments :"+arguments).queue();
                    }


                }catch(Exception e){
                    event.getChannel().sendMessage("Please mention a *registered* user!").queue();
                }
            }else{
                event.getChannel().sendMessage("You do not have the proper permissions!").queue();
            }



        }catch(Exception e){
            event.getChannel().sendMessage("Please mention someone!").queue();
        }
    }
}
