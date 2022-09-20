package Main;

import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;

public class Item {
    public static String NAME = "";
    public static String DESCRIPTION= "";
    public static Stats STATS = new Stats();
    public static Affinites AFFINITIES = new Affinites();
    public static String REGEX = "hsxxs";
    public static boolean EQUIPPED = false;

    public static EmbedBuilder build(){
        EmbedBuilder embed = new EmbedBuilder();
        if(EQUIPPED){
            embed.setAuthor(NAME +" - EQUIPPED");
            embed.setColor(new Color(33, 156, 47, 1));
            //(228, 69, 69, 1)
        }else{
            embed.setAuthor(NAME +" - UNEQUIPPED");
            embed.setColor(new Color(228, 69, 69, 1));
        }

        embed.setDescription(DESCRIPTION);
        embed.addField("``Stats:``",STATS.statString(),false);
        embed.addField("``Affinities:``",AFFINITIES.statString(),false);

        return embed;
    }public static String toStr(){
        String str = NAME + REGEX+
                DESCRIPTION+REGEX+
                STATS.toStr()+REGEX+
                EQUIPPED+REGEX+
                AFFINITIES.toStr();

        return str;
    }public static void toObj(String str){
        String[] lt = str.split(REGEX,5);
        NAME = lt[0];
        DESCRIPTION = lt[1];
        STATS.toObj(lt[2]);
        if(lt[3].equalsIgnoreCase("true")){
            EQUIPPED = true;
        }
        AFFINITIES.toObj(lt[4]);

    }
}
