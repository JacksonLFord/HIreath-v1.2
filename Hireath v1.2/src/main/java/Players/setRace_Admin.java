package Players;

import Players.Player;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static Main.Generic.getConn;

public class setRace_Admin extends JDA_Utili.Command{
    private final EventWaiter waiter;
    public setRace_Admin(EventWaiter waiter, JDA_Utili.Category Cat){
        super.name = "setRace";
        super.help = "A command to set the race of a player";
        super.aliases = new String[]{"race"};
        super.cooldown = 5;
        this.waiter = waiter;
        super.arguments = "[mention] [race]";

        super.category = Cat;
        super.userPermissions = new Permission[]{Permission.MANAGE_SERVER};

    }

    @Override
    public void execute(MessageReceivedEvent event, String command) {
        String[] strs = event.getMessage().getContentRaw().split(" ",3);

        String name = strs[2];

        User user;
        try{

            user = event.getMessage().getMentionedUsers().get(0);
            if(event.getMember().hasPermission(super.userPermissions)){
                try{
                    Statement strss= null;
                    String info = "";
                    try {
                        strss = getConn().createStatement();
                        String sqlrs = "SELECT info FROM GameMaster.dbo.Players WHERE id = "+user.getId();
                        ResultSet rs = strss.executeQuery(sqlrs);
                        while (rs.next()) {
                            info = rs.getString("info");

                        }

                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    Player player =  new Player();
                    player.toObj(info);
                    player.RACE = name;
                    String newstr = player.toStr();
                    Statement str = null;

                    try {
                        str = getConn().createStatement();
                        String sqlr = "UPDATE GameMaster.dbo.Players\n" +
                                "SET    info = '"+newstr+"'\n" +
                                "WHERE  Id = "+user.getId();
                        str.execute(sqlr);

                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    event.getChannel().sendMessage("Location is set!").queue();
                }catch(Exception e){
                    event.getChannel().sendMessage("Please mention a *registered* user!").queue();
                    e.printStackTrace();
                }

            }else{
                event.getChannel().sendMessage("You do not have the proper permissions!").queue();
            }


        }catch(Exception e){
            event.getChannel().sendMessage("Please mention someone!").queue();
        }
    }
}
