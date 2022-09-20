package Players;

import Players.Player;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.PrivateChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static Main.Generic.*;

public class Profile extends JDA_Utili.Command{
    private final EventWaiter waiter;

    public Profile(EventWaiter waiter, JDA_Utili.Category Cat){
        super.name = "profile";
        super.help = "A command to show a persons profile!";
        super.aliases = new String[]{"stats","stat"};
        super.cooldown = 5;
        this.waiter = waiter;

        super.userPermissions = new Permission[]{Permission.MANAGE_SERVER};
        super.category = Cat;


    }

    @Override
    public void execute(MessageReceivedEvent event, String command) {

        User user;
        try{
            System.out.println("Commands is being run!");
            user = event.getMessage().getMentionedUsers().get(0);
            if(event.getMember().hasPermission(super.userPermissions)){
                try{
                    Statement strss= null;
                    Player player = new Player();
                    try {
                        strss = getConn().createStatement();
                        String sqlrs = "SELECT info FROM GameMaster.dbo.Players WHERE id = "+user.getId();
                        ResultSet rs = strss.executeQuery(sqlrs);
                        while (rs.next()) {
                            player.toObj(rs.getString("info"));
                            PrivateChannel pm = event.getAuthor().openPrivateChannel().complete();
                            System.out.println("build");
                            pm.sendMessage(player.build().build()).queue();
                        }

                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }catch(Exception e){
                    event.getChannel().sendMessage("Please mention a *registered* user!").queue();
                }
            }else{
                event.getChannel().sendMessage("You do not have the proper permissions!").queue();
            }



        }catch(Exception e){
            e.printStackTrace();
            user = event.getAuthor();
            try{
                Statement strss= null;
                Player player = new Player();
                try {
                    strss = getConn().createStatement();
                    String sqlrs = "SELECT info FROM GameMaster.dbo.Players WHERE id = "+user.getId();
                    ResultSet rs = strss.executeQuery(sqlrs);
                    while (rs.next()) {
                        player.toObj(rs.getString("info"));
                        PrivateChannel pm = event.getAuthor().openPrivateChannel().complete();
                        System.out.println("Build");
                        pm.sendMessage(player.build().build()).queue();
                    }

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }catch(Exception f){
                event.getChannel().sendMessage("You are not registered!").queue();
            }
        }
    }
}
