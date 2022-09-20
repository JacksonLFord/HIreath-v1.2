package Main;

import static Main.Generic.pad;

public class Stats {
    public static int HEALTH = 0;
    public static int STRENGTH = 0;
    public static int ATTACK = 0;
    public static int SPEED = 0;
    public static int ARMOR = 0;
    public static int MAGICAL_ARMOR = 0;
    public static int MANA_POOL_MULTIPLIER = 0;
    public static int MANA_POOL = 0;
    public static int ARCANE_ENERGY = 0;
    public static int ARCANE_POOL = 0;
    public static String REGEX = "lsdz";
    public static int NUM = 10;
    public static void addStats(String affin, int amount) {
        if (affin.equalsIgnoreCase("health")) {
            HEALTH = amount;
        }else if (affin.equalsIgnoreCase("strength")) {
            STRENGTH = amount;
        }else if (affin.equalsIgnoreCase("attack")) {
            ATTACK = amount;
        }else if (affin.equalsIgnoreCase("speed")) {
            SPEED = amount;
        }else if (affin.equalsIgnoreCase("armor")) {
            ARMOR = amount;
        }else if (affin.equalsIgnoreCase("magical armor")) {
            MAGICAL_ARMOR = amount;
        }else if (affin.equalsIgnoreCase("mana pool multiplier")) {
            MANA_POOL_MULTIPLIER = amount;
        }else if (affin.equalsIgnoreCase("mana pool")) {
            MANA_POOL = amount;
        }else if (affin.equalsIgnoreCase("arcane energy")) {
            ARCANE_ENERGY = amount;
        }else if (affin.equalsIgnoreCase("arcane pool")) {
            ARCANE_POOL = amount;
        }
    }public static String statString(){
        int pad = 18;
        String str = "``"+pad("Health : "+HEALTH,pad) +"``"+ " | "+
                "``"+pad("Strength : "+STRENGTH,pad) +"``"+ " | \n"+
                "``"+pad("Attack : "+ATTACK,pad) +"``"+ " | "+
                "``"+pad("Speed : "+SPEED,pad) +"``"+ " | \n"+
                "``"+pad("Armor : "+ARMOR,pad) +"``"+ " | "+
                "``"+pad("Magical Armor : "+MAGICAL_ARMOR,pad) +"``"+ " | \n"+
                "``"+pad("Mana Pool * : "+MANA_POOL_MULTIPLIER,pad) +"``"+ " | "+
                "``"+pad("Mana Pool : "+MANA_POOL,pad) +"``"+ " | \n"+
                "``"+pad("Arcane Energy : "+ARCANE_ENERGY,pad) +"``"+ " | "+
                "``"+pad("Arcane Pool : "+ARCANE_POOL,pad) +"``"+ " | \n";

        return str;
    }public static String toStr(){
       String str =  HEALTH+REGEX+
               STRENGTH+REGEX+
               ATTACK+REGEX+
               SPEED+REGEX+
               ARMOR+REGEX+
               MAGICAL_ARMOR+REGEX+
               MANA_POOL_MULTIPLIER+REGEX+
               MANA_POOL+REGEX+
               ARCANE_ENERGY+REGEX+
               ARCANE_POOL;
       return str;
    }public static void toObj(String str){
        String[] lt = str.split(REGEX,NUM);
        HEALTH = Integer.parseInt(lt[0]);
        STRENGTH= Integer.parseInt(lt[1]);
        ATTACK = Integer.parseInt(lt[2]);
        SPEED = Integer.parseInt(lt[3]);
        ARMOR = Integer.parseInt(lt[4]);
        MAGICAL_ARMOR = Integer.parseInt(lt[5]);
        MANA_POOL_MULTIPLIER = Integer.parseInt(lt[6]);
        MANA_POOL = Integer.parseInt(lt[7]);
        ARCANE_ENERGY = Integer.parseInt(lt[8]);
        ARCANE_POOL = Integer.parseInt(lt[9]);
    }
}
