package Players;

import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;

public class Player {

        public static String RACE;
        public static String LOCATION;
        public static String NAME;
        public static String REGEX = "gdfgk";
        public String toStr(){
            return RACE + REGEX+
                    LOCATION+REGEX+
                    NAME;
        }public static void toObj(String str){
            String[] obj = str.split(REGEX,3);
            RACE = obj[0];
            LOCATION = obj[1];
            NAME = obj[2];
        }public static EmbedBuilder build(){
            EmbedBuilder embed  = new EmbedBuilder();
            embed.setTitle(NAME + "'s Profile");
            embed.addField("Location:",LOCATION,false);
            embed.addField("Race:",RACE,false);
            embed.setColor(new Color(0, 78, 255, 1));
            return embed;
        }

}
