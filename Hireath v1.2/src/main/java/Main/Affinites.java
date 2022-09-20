package Main;

import javax.sound.midi.Soundbank;

import static Main.Generic.pad;

public class Affinites {
    static int pad = 18;
    public static String statString(){
        String str = "";
        if(!(DEATH == 0)){
             str = str + "``"+pad("Death : "+DEATH, pad) +"``"+ " | ";
        }if(!(BONE == 0)){
            str = str + "``"+pad("Bone : "+BONE, pad) +"``"+ " | ";
        }if(!(BLOOD == 0)){
            str = str + "``"+pad("Blood : "+BLOOD, pad) +"``"+ " | ";
        }if(!(FIRE == 0)){
            str = str + "``"+pad("Fire : "+FIRE, pad) +"``"+ " | ";
        }if(!(WATER == 0)){
            str = str + "``"+pad("Water : "+WATER, pad) +"``"+ " | ";
        }if(!(STEAM == 0)){
            str = str + "``"+pad("Steam : "+STEAM, pad) +"``"+ " | ";
        }if(!(LAVA == 0)){
            str = str + "``"+pad("Lava : "+LAVA, pad) +"``"+ " | ";
        }if(!(MAGMA == 0)){
            str = str + "``"+pad("Magma : "+MAGMA, pad) +"``"+ " | ";
        }if(!(ELECTRIC == 0)){
            str = str + "``"+pad("Electric : "+ELECTRIC, pad) +"``"+ " | ";
        }if(!(TIME== 0)){
            str = str + "``"+pad("Time : "+TIME, pad) +"``"+ " | ";
        }if(!(REALITY == 0)){
            str = str + "``"+pad("Reality : "+REALITY, pad) +"``"+ " | ";
        }if(!(PLANT == 0)){
            str = str + "``"+pad("Plant : "+PLANT, pad) +"``"+ " | ";
        }if(!(NATURE == 0)){
            str = str + "``"+pad("Nature : "+NATURE, pad) +"``"+ " | ";
        }if(!(PRIMAL == 0)){
            str = str + "``"+pad("Primal : "+PRIMAL, pad) +"``"+ " | ";
        }if(!(SPACE == 0)){
            str = str + "``"+pad("Space : "+SPACE, pad) +"``"+ " | ";
        }if(!(GRAVITY == 0)){
            str = str + "``"+pad("Gravity : "+GRAVITY, pad) +"``"+ " | ";
        }if(!(LIGHT == 0)){
            str = str + "``"+pad("Light : "+LIGHT, pad) +"``"+ " | ";
        }if(!(DARK == 0)){
            str = str + "``"+pad("Dark : "+DARK, pad) +"``"+ " | ";
        }if(!(VOID == 0)){
            str = str + "``"+pad("Void : "+VOID, pad) +"``"+ " | ";
        }if(!(AETHER == 0)){
            str = str + "``"+pad("Aether : "+AETHER, pad) +"``"+ " | ";
        }if(!(LUCK == 0)){
            str = str + "``"+pad("Luck : "+LUCK, pad) +"``"+ " | ";
        }if(!(CODE == 0)){
            str = str + "``"+pad("Code : "+CODE, pad) +"``"+ " | ";
        }if(!(IMAGINATION == 0)){
            str = str + "``"+pad("Imagination : "+IMAGINATION, pad) +"``"+ " | ";
        }if(!(SOUL == 0)){
            str = str + "``"+pad("Soul : "+SOUL, pad) +"``"+ " | ";
        }if(!(SHADOW == 0)){
            str = str + "``"+pad("Shadow : "+SHADOW, pad) +"``"+ " | ";
        }if(!(AIR == 0)){
            str = str + "``"+pad("Air : "+AIR, pad) +"``"+ " | ";
        }if(!(CLOUD == 0)){
            str = str + "``"+pad("Cloud : "+CLOUD, pad) +"``"+ " | ";
        }if(!(RAIN == 0)){
            str = str + "``"+pad("Rain : "+DEATH, RAIN) +"``"+ " | ";
        }if(!(SOUND == 0)){
            str = str + "``"+pad("Sound : "+DEATH, SOUND) +"``"+ " | ";
        }if(!(THUNDER == 0)){
            str = str + "``"+pad("Thunder : "+DEATH, THUNDER) +"``"+ " | ";
        }if(!(LIGHTNING == 0)){
            str = str + "``"+pad("Lightning : "+LIGHTNING, pad) +"``"+ " | ";
        }if(!(HEAT == 0)){
            str = str + "``"+pad("Heat : "+HEAT, pad) +"``"+ " | ";
        }if(!(COLD == 0)){
            str = str + "``"+pad("Cold : "+COLD, pad) +"``"+ " | ";
        }if(!(TEMPERATURE == 0)){
            str = str + "``"+pad("Temperature : "+TEMPERATURE, pad) +"``"+ " | ";
        }if(!(SLEEP== 0)){
            str = str + "``"+pad("Sleep : "+SLEEP, pad) +"``"+ " | ";
        }if(!(HOPE == 0)){
            str = str + "``"+pad("Hope : "+HOPE, pad) +"``"+ " | ";
        }if(!(COURAGE == 0)){
            str = str + "``"+pad("Courage : "+COURAGE, pad) +"``"+ " | ";
        }if(!(MIND == 0)){
            str = str + "``"+pad("Mind : "+MIND, pad) +"``"+ " | ";
        }if(!(EARTH == 0)){
            str = str + "``"+pad("Earth : "+EARTH, pad) +"``"+ " | ";
        }if(!(SPECTRAL == 0)){
            str = str + "``"+pad("Spectral : "+SPECTRAL, pad) +"``"+ " | ";
        }if(!(ASTRAL == 0)){
            str = str + "``"+pad("Astral : "+ASTRAL, pad) +"``"+ " | ";
        }if(!(UNDEATH == 0)){
            str = str + "``"+pad("Undeath : "+UNDEATH, pad) +"``"+ " | ";
        }if(!(LIFE == 0)){
            str = str + "``"+pad("Life : "+LIFE, pad) +"``"+ " | ";
        }if(!(STAR == 0)){
            str = str + "``"+pad("Star : "+STAR, pad) +"``"+ " | ";
        }if(!(LUNAR == 0)){
            str = str + "``"+pad("Lunar : "+LUNAR, pad) +"``"+ " | ";
        }if(!(SOLAR == 0)){
            str = str + "``"+pad("Solar : "+SOLAR, pad) +"``"+ " | ";
        }if(!(ARACHNID == 0)){
            str = str + "``"+pad("Arachnid : "+ARACHNID, pad) +"``"+ " | ";
        }if(!(INSECT == 0)){
            str = str + "``"+pad("Insect : "+INSECT, pad) +"``"+ " | ";
        }if(!(BLADE == 0)){
            str = str + "``"+pad("Blade : "+BLADE, pad) +"``"+ " | ";
        }if(!(DIVINE == 0)){
            str = str + "``"+pad("Divine : "+DIVINE, pad) +"``"+ " | ";
        }if(!(ANGELIC == 0)){
            str = str + "``"+pad("Angelic : "+ANGELIC, pad) +"``"+ " | ";
        }if(!(DEMONIC == 0)){
            str = str + "``"+pad("Demonic : "+DEMONIC, pad) +"``"+ " | ";
        }if(!(SMOKE == 0)){
            str = str + "``"+pad("Smoke : "+SMOKE, pad) +"``"+ " | ";
        }if(!(NARU_HANDLING == 0)){
            str = str + "``"+pad("Naru Handling : "+NARU_HANDLING, pad) +"``"+ " | ";
        }if(!(DIVINITY == 0)){
            str = str + "``"+pad("Divinity : "+DIVINITY, pad) +"``"+ " | ";
        }if(!(ICE == 0)){
            str = str + "``"+pad("Ice : "+ICE, pad) +"``"+ " | ";
        }if(!(SNOW == 0)){
            str = str + "``"+pad("Snow : "+SNOW, pad) +"``"+ " | ";
        }if(!(FEL == 0)){
            str = str + "``"+pad("Fel : "+FEL, pad) +"``"+ " | ";
        }if(!(ARCANE == 0)){
            str = str + "``"+pad("Arcane : "+ARCANE, pad) +"``"+ " | ";
        }if(!(IMAGINARY_UNITS == 0)){
            str = str + "``"+pad("Imaginary Units : "+IMAGINARY_UNITS, pad) +"``"+ " | ";
        }if(!(GLASS == 0)){
            str = str + "``"+pad("Glass : "+GLASS, pad) +"``"+ " | ";
        }if(!(SAND == 0)){
            str = str + "``"+pad("Sand : "+SAND, pad) +"``"+ " | ";
        }if(!(SUNLIGHT == 0)){
            str = str + "``"+pad("Sunlight : "+SUNLIGHT, pad) +"``"+ " | ";
        }if(!(MOONLIGHT == 0)){
            str = str + "``"+pad("Moonlight : "+MOONLIGHT, pad) +"``"+ " | ";
        }if(!(STARLIGHT == 0)){
            str = str + "``"+pad("Starlight : "+STARLIGHT, pad) +"``"+ " | ";
        }if(!(MUSIC == 0)){
            str = str + "``"+pad("Music : "+MUSIC, pad) +"``"+ " | ";
        }
        int interval = 50;
        char separator = '\n';

        StringBuilder sb = new StringBuilder(str);

        for(int i = 0; i < str.length() / interval; i++) {
            sb.insert(((i + 1) * interval) + i, separator);
        }
        return sb.toString();
    }
    public static String REGEX = "hsgf";
    public static void toObj(String str){
            String[] lt = str.split(REGEX,NUM);
            DEATH = Integer.parseInt(lt[0]);
        BONE = Integer.parseInt(lt[1]);
        BLOOD = Integer.parseInt(lt[2]);
        FIRE = Integer.parseInt(lt[3]);
        WATER = Integer.parseInt(lt[4]);
        STEAM = Integer.parseInt(lt[5]);
        LAVA = Integer.parseInt(lt[6]);
        MAGMA = Integer.parseInt(lt[7]);
        ELECTRIC = Integer.parseInt(lt[8]);
        TIME = Integer.parseInt(lt[9]);
        REALITY = Integer.parseInt(lt[10]);
        PLANT = Integer.parseInt(lt[11]);
        NATURE = Integer.parseInt(lt[12]);
        PRIMAL = Integer.parseInt(lt[13]);
        SPACE = Integer.parseInt(lt[14]);
        GRAVITY = Integer.parseInt(lt[15]);
        LIGHT = Integer.parseInt(lt[16]);
        DARK = Integer.parseInt(lt[17]);
        VOID = Integer.parseInt(lt[18]);
        AETHER = Integer.parseInt(lt[19]);
        LUCK = Integer.parseInt(lt[20]);
        CODE = Integer.parseInt(lt[21]);
        IMAGINATION = Integer.parseInt(lt[22]);
        SOUL = Integer.parseInt(lt[23]);
        SHADOW = Integer.parseInt(lt[24]);
        AIR = Integer.parseInt(lt[25]);
        CLOUD = Integer.parseInt(lt[26]);
        RAIN = Integer.parseInt(lt[27]);
        SOUND = Integer.parseInt(lt[28]);
        THUNDER = Integer.parseInt(lt[29]);
        LIGHTNING = Integer.parseInt(lt[30]);
        HEAT = Integer.parseInt(lt[31]);
        COLD = Integer.parseInt(lt[32]);
        TEMPERATURE = Integer.parseInt(lt[33]);
        SLEEP= Integer.parseInt(lt[34]);
        HOPE = Integer.parseInt(lt[35]);
        COURAGE = Integer.parseInt(lt[36]);
        MIND = Integer.parseInt(lt[37]);
        EARTH = Integer.parseInt(lt[38]);
        SPECTRAL = Integer.parseInt(lt[39]);
        ASTRAL = Integer.parseInt(lt[40]);
        UNDEATH = Integer.parseInt(lt[41]);
        LIFE = Integer.parseInt(lt[42]);
        STAR = Integer.parseInt(lt[43]);
        LUNAR = Integer.parseInt(lt[44]);
        SOLAR = Integer.parseInt(lt[45]);
        ARACHNID = Integer.parseInt(lt[46]);
        INSECT = Integer.parseInt(lt[47]);
        BLADE = Integer.parseInt(lt[48]);
        DIVINE = Integer.parseInt(lt[49]);
        ANGELIC = Integer.parseInt(lt[50]);
        DEMONIC = Integer.parseInt(lt[51]);
        SMOKE = Integer.parseInt(lt[52]);
        NARU_HANDLING = Integer.parseInt(lt[53]);
        DIVINITY = Integer.parseInt(lt[54]);
        ICE  = Integer.parseInt(lt[55]);
        SNOW = Integer.parseInt(lt[56]);
        FEL = Integer.parseInt(lt[57]);
        ARCANE = Integer.parseInt(lt[58]);
        IMAGINARY_UNITS= Integer.parseInt(lt[59]);
        GLASS = Integer.parseInt(lt[60]);
        SAND = Integer.parseInt(lt[61]);
        SUNLIGHT = Integer.parseInt(lt[62]);
        MOONLIGHT = Integer.parseInt(lt[63]);
        STARLIGHT = Integer.parseInt(lt[64]);
        MUSIC = Integer.parseInt(lt[65]);


    }
    public static String toStr(){
        String str = "";
        str = str + DEATH + REGEX+
                BONE + REGEX+
                BLOOD + REGEX+
                FIRE + REGEX+
                WATER + REGEX+
                STEAM + REGEX+
                LAVA + REGEX+
                MAGMA + REGEX+
                ELECTRIC + REGEX+
                TIME + REGEX+
                REALITY + REGEX+
                PLANT + REGEX+
                NATURE + REGEX+
                PRIMAL + REGEX+
                SPACE + REGEX+
                GRAVITY + REGEX+
                LIGHT + REGEX+
                DARK + REGEX+
                VOID + REGEX+
                AETHER + REGEX+
                LUCK + REGEX+
                CODE + REGEX+
                IMAGINATION + REGEX+
                SOUL + REGEX+
                SHADOW + REGEX+
                AIR + REGEX+
                CLOUD + REGEX+
                RAIN + REGEX+
                SOUND + REGEX+
                THUNDER + REGEX+
                LIGHTNING + REGEX+
                HEAT + REGEX+
                COLD + REGEX+
                TEMPERATURE + REGEX+
                SLEEP + REGEX+
                HOPE + REGEX+
                COURAGE + REGEX+
                MIND + REGEX+
                EARTH + REGEX+
                SPECTRAL + REGEX+
                ASTRAL + REGEX+
                UNDEATH + REGEX+
                LIFE + REGEX+
                STAR + REGEX+
                LUNAR + REGEX+
                SOLAR + REGEX+
                ARACHNID + REGEX+
                INSECT + REGEX+
                BLADE + REGEX+
                DIVINE + REGEX+
                ANGELIC + REGEX+
                DEMONIC + REGEX+
                SMOKE + REGEX+
                NARU_HANDLING + REGEX+
                DIVINITY + REGEX+
                ICE + REGEX+
                SNOW + REGEX+
                FEL + REGEX+
                ARCANE + REGEX+
                IMAGINARY_UNITS + REGEX+
                GLASS + REGEX+
                SAND + REGEX+
                SUNLIGHT + REGEX+
                MOONLIGHT + REGEX+
                STARLIGHT + REGEX+
                MUSIC;
        return str;
    }
    public static int NUM = 66;
    public static int DEATH = 0;
    public static int BONE = 0;
    public static int BLOOD = 0;
    public static int FIRE = 0;
    public static int WATER = 0;
    public static int STEAM = 0;
    public static int LAVA = 0;
    public static int MAGMA = 0;
    public static int ELECTRIC = 0;
    public static int TIME = 0;
    public static int REALITY = 0;
    public static int PLANT = 0;
    public static int NATURE = 0;
    public static int PRIMAL = 0;
    public static int SPACE  = 0;
    public static int GRAVITY = 0;
    public static int LIGHT = 0;
    public static int DARK = 0;
    public static int VOID = 0;
    public static int AETHER = 0;
    public static int LUCK = 0;
    public static int CODE = 0;
    public static int IMAGINATION = 0;
    public static int SOUL = 0;
    public static int SHADOW = 0;
    public static int AIR = 0;
    public static int CLOUD = 0;
    public static int RAIN = 0;
    public static int SOUND = 0;
    public static int THUNDER = 0;
    public static int LIGHTNING = 0;
    public static int HEAT = 0;
    public static int COLD = 0;
    public static int TEMPERATURE = 0;
    public static int SLEEP = 0;
    public static int HOPE = 0;
    public static int COURAGE = 0;
    public static int MIND = 0;
    public static int EARTH = 0;
    public static int SPECTRAL = 0;
    public static int ASTRAL = 0;
    public static int UNDEATH = 0;
    public static int LIFE = 0;
    public static int STAR = 0;
    public static int LUNAR = 0;
    public static int SOLAR = 0;
    public static int ARACHNID = 0;
    public static int INSECT = 0;
    public static int BLADE = 0;
    public static int DIVINE = 0;
    public static int ANGELIC = 0;
    public static int DEMONIC = 0;
    public static int SMOKE = 0;
    public static int NARU_HANDLING = 0;
    public static int DIVINITY = 0;
    public static int ICE = 0;
    public static int SNOW = 0;
    public static int FEL = 0;
    public static int ARCANE = 0;
    public static int IMAGINARY_UNITS = 0;
    public static int GLASS = 0;
    public static int SAND = 0;
    public static int SUNLIGHT = 0;
    public static int MOONLIGHT = 0;
    public static int STARLIGHT = 0;
    public static int MUSIC = 0;
    public static void addAffin(String affin, int amount){
        if(affin.equalsIgnoreCase("death")){
            DEATH = amount;
        }if(affin.equalsIgnoreCase("bone")){
            BONE = amount;
        }if(affin.equalsIgnoreCase("blood")){
            BLOOD = amount;
        }if(affin.equalsIgnoreCase("fire")){
            FIRE = amount;
        }if(affin.equalsIgnoreCase("water")){
            WATER = amount;
        }if(affin.equalsIgnoreCase("steam")){
            STEAM = amount;
        }if(affin.equalsIgnoreCase("lava")){
            LAVA = amount;
        }if(affin.equalsIgnoreCase("magma")){
            MAGMA = amount;
        }if(affin.equalsIgnoreCase("electric")){
            ELECTRIC = amount;
        }if(affin.equalsIgnoreCase("time")){
            TIME = amount;
        }if(affin.equalsIgnoreCase("reality")){
            REALITY = amount;
        }if(affin.equalsIgnoreCase("plant")){
            PLANT = amount;
        }if(affin.equalsIgnoreCase("nature")){
            NATURE = amount;
        }if(affin.equalsIgnoreCase("primal")){
            PRIMAL = amount;
        }if(affin.equalsIgnoreCase("space")){
            SPACE = amount;
        }if(affin.equalsIgnoreCase("gravity")){
            GRAVITY = amount;
        }if(affin.equalsIgnoreCase("light")){
            LIGHT  = amount;
        }if(affin.equalsIgnoreCase("dark")){
            DARK = amount;
        }if(affin.equalsIgnoreCase("void")){
            VOID = amount;
        }if(affin.equalsIgnoreCase("aether")){
            AETHER = amount;
        }if(affin.equalsIgnoreCase("luck")){
            LUCK = amount;
        }if(affin.equalsIgnoreCase("code")){
            CODE = amount;
        }if(affin.equalsIgnoreCase("imagination")){
            IMAGINATION = amount;
        }if(affin.equalsIgnoreCase("soul")){
            SOUL = amount;
        }if(affin.equalsIgnoreCase("shadow")){
            SHADOW = amount;
        }if(affin.equalsIgnoreCase("air")){
            AIR = amount;
        }if(affin.equalsIgnoreCase("cloud")){
            CLOUD = amount;
        }if(affin.equalsIgnoreCase("rain")){
            RAIN = amount;
        }if(affin.equalsIgnoreCase("sound")){
            SOUND = amount;
        }if(affin.equalsIgnoreCase("thunder")){
            THUNDER = amount;
        }if(affin.equalsIgnoreCase("lightning")){
            LIGHTNING = amount;
        }if(affin.equalsIgnoreCase("heat")){
            HEAT  = amount;
        }if(affin.equalsIgnoreCase("cold")){
            COLD = amount;
        }if(affin.equalsIgnoreCase("Temperature")){
            TEMPERATURE = amount;
        }if(affin.equalsIgnoreCase("sleep")){
            SLEEP = amount;
        }if(affin.equalsIgnoreCase("hope")){
            HOPE = amount;
        }if(affin.equalsIgnoreCase("courage")){
            COURAGE = amount;
        }if(affin.equalsIgnoreCase("mind")){
            MIND = amount;
        }if(affin.equalsIgnoreCase("earth")){
            EARTH = amount;
        }if(affin.equalsIgnoreCase("spectral")){
            SPECTRAL = amount;
        }if(affin.equalsIgnoreCase("astral")){
            ASTRAL = amount;
        }if(affin.equalsIgnoreCase("undeath")){
            UNDEATH = amount;
        }if(affin.equalsIgnoreCase("life")){
            LIFE = amount;
        }if(affin.equalsIgnoreCase("star")){
            STAR = amount;
        }if(affin.equalsIgnoreCase("lunar")){
            LUNAR = amount;
        }if(affin.equalsIgnoreCase("solar")){
            SOLAR = amount;
        }if(affin.equalsIgnoreCase("arachnid")){
            ARACHNID = amount;
        }if(affin.equalsIgnoreCase("insect")){
            INSECT = amount;
        }if(affin.equalsIgnoreCase("blade")){
            BLADE = amount;
        }if(affin.equalsIgnoreCase("divine")){
            DIVINE = amount;
        }if(affin.equalsIgnoreCase("angelic")){
            ANGELIC = amount;
        }if(affin.equalsIgnoreCase("demonic")){
            DEMONIC = amount;
        }if(affin.equalsIgnoreCase("smoke")){
            SMOKE = amount;
        }if(affin.equalsIgnoreCase("naru handling")){
            NARU_HANDLING = amount;
        }if(affin.equalsIgnoreCase("divinity")){
            DIVINITY = amount;
        }if(affin.equalsIgnoreCase("ice")){
            ICE = amount;
        }if(affin.equalsIgnoreCase("snow")){
            SNOW = amount;
        }if(affin.equalsIgnoreCase("fel")){
            FEL = amount;
        }if(affin.equalsIgnoreCase("arcane")){
            ARCANE = amount;
        }if(affin.equalsIgnoreCase("imaginary units")){
            IMAGINARY_UNITS = amount;
        }if(affin.equalsIgnoreCase("glass")){
            GLASS = amount;
        }if(affin.equalsIgnoreCase("sand")){
            SAND = amount;
        }if(affin.equalsIgnoreCase("sunlight")){
            SUNLIGHT = amount;
        }if(affin.equalsIgnoreCase("moonlight")){
            MOONLIGHT = amount;
        }if(affin.equalsIgnoreCase("starlight")){
            STARLIGHT = amount;
        }if(affin.equalsIgnoreCase("music")){
            MUSIC = amount;
        }
    }







}
