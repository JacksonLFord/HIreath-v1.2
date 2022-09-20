package Main;



import Enviroment.Enemies;
import Enviroment.Options_Admin;
import Players.*;
import JDA_Utili.Category;
import JDA_Utili.CommandBuilder;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


public class Main extends ListenerAdapter {



    //Creating a new instance of my FileLogger

    public static void main(String [] args) throws Exception{

        try{
            CommandBuilder builder = new CommandBuilder("TOKEN");


            EventWaiter waiter = new EventWaiter(); //EventWaiter object used for command
            builder.setWaiter(waiter);
            new Enemies(builder,waiter);

            Category misc = new Category("``[Misc Commands]``");
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            builder.addCommand(new Dice(waiter,misc));
            builder.addCommand(new NewItem(waiter,misc));
            builder.addCommand(new Options_Admin(waiter,misc,Generic.COMMANDS));
            builder.addCommand(new Gameplay(waiter,misc));
            builder.addCommand(new Register(waiter,misc));
            builder.addCommand(new Items(waiter,misc));
            builder.addCommand(new viewItem(waiter,misc));
            builder.addCommand(new setName_Admin(waiter,misc));
            builder.addCommand(new setLocation(waiter,misc));
            builder.addCommand(new setRace_Admin(waiter,misc));


            builder.addCommand(new Profile(waiter,misc));
            builder.addCommand(new RemoveItem(waiter,misc));
            builder.addCommand(new Levels_Admin(waiter,misc));
            builder.addCommand(new Level_Admin(waiter,misc));




            builder.build();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
