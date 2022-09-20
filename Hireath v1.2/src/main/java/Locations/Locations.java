package Locations;

import java.util.ArrayList;

public class Locations {
    public static void main(String args[]){
        ArrayList<String> Dragonbanes = new ArrayList<String>();
        Dialouge dragon = new Dialouge( "The vision abruptly ends and you feel intense pain in your mind before finding yourself laying in grass with a quiet breeze bringing a sweet smell to your nose. You hear chirping and feel warmth on your skin.\n" +
                "You see light shining through a canopy of green leaves until suddenly what looks like a pale, almost bluish grey skinned child with dark hair and colorful eyes that shift and twist into shapes of various dimensions seems to appear before your eyes. \"Hello.\" His distorted and glass like voice echoes from behind you\n" +
                "\"There was an..error \"\n" +
                "He smiles to reveal a toothy grin","You find yourself in a forest with scarce vegetation, red-tinted green grass, and the occasional pale flower and white weeds. Tall, thin trees cover your view as you take a quick look around.");

        Location Dragonbane = new Location("Dragonbane",dragon);
    }
}
