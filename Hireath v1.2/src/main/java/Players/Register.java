package Players;

import Players.Player;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static Main.Generic.convertToString;
import static Main.Generic.getConn;

public class Register extends JDA_Utili.Command{
    private final EventWaiter waiter;
    public Register(EventWaiter waiter, JDA_Utili.Category Cat){
        super.name = "Register";
        super.help = "A command to register yourself!";
        super.aliases = new String[]{"reg"};
        super.cooldown = 5;
        this.waiter = waiter;


        super.category = Cat;


    }

    @Override
    public void execute(MessageReceivedEvent event, String command) {

        if (!isPlayer(event.getAuthor())) {

            Statement str = null;
            try {
                str = getConn().createStatement();
                String sqlr = "CREATE TABLE GameMaster.dbo." + convertToString(event.getAuthor().getId())+" (ItemInfo VARCHAR(1000))";
                str.execute(sqlr);

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            Statement stmt;
            try {
                Player player = new Player();

                stmt = getConn().createStatement();
                stmt.execute("INSERT INTO GameMaster.dbo.Players (Id , Gameplay, info) VALUES " + "(" + event.getAuthor().getId() + ",0,'"+player.toStr()+"')");
            } catch (Exception e) {
                e.printStackTrace();
            }
            event.getChannel().sendMessage("You are now registed!").queue();
        }else{
            event.getChannel().sendMessage("You have already been registered!").queue();
        }

    }public static boolean isPlayer(User mem) {

        if(getPeople().contains(mem.getId())){
            return true;
        }else{
            return false;
        }

    }

    public static ArrayList<String> getPeople(){
        Statement stmt = null;
        ArrayList<String> Ids = new ArrayList<String>();
        try {
            stmt = getConn().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Id FROM GameMaster.dbo.Players");
            while (rs.next()) {
                String Id = rs.getString("Id");
                Ids.add(Id);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return Ids;
    }

}
