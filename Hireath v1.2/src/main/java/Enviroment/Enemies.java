package Enviroment;

import Enviroment.Enemy_Admin;
import JDA_Utili.Category;
import JDA_Utili.CommandBuilder;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;

public class Enemies {
    public Enemies(CommandBuilder builder, EventWaiter waiter){

        Category Dragonbane = new Category("``[Dragonbane Forest]``");
        Category Familar = new Category("``[Familar]``");
        Category Whistle = new Category("``[Whistling Woods]``");
        Category Briar = new Category("``[Briarwoods]``");
        Category Unknown = new Category("``[Unknown]``");
        builder.addCommand(new Enemy_Admin(waiter,Unknown,
                "Bonenettle Bee",
                "bnb",15,
                20));

        builder.addCommand(new Enemy_Admin(waiter,Unknown,
                "Large Hive Beetle",
                "lhb",
                20,
                30));

        builder.addCommand(new Enemy_Admin(waiter,Unknown,
                "Bonenettle Bee Larve",
                "bbl",
                5,
                3));
        builder.addCommand(new Enemy_Admin(waiter,Unknown,
                "Briarwood Termite Larve",
                "btl",
                4,
                4));

        builder.addCommand(new Enemy_Admin(waiter,Familar,
                "St Valentine Elemental",
                "sve",
                10,
                5));
        builder.addCommand(new Enemy_Admin(waiter,Briar,
                "Briarthorn recluse",
                "btr",
                60,
                80));
        builder.addCommand(new Enemy_Admin(waiter,Briar,
                "Skull Widow Spider",
                "sws",
                120,
                90));
        builder.addCommand(new Enemy_Admin(waiter,Briar,
                "Briarwood Worker Termite",
                "bwt",
                40,
                40));

        builder.addCommand(new Enemy_Admin(waiter,Dragonbane,
                "Bloody Perch",
                "bp",
                2,
                0.5));
        builder.addCommand(new Enemy_Admin(waiter,Dragonbane,
                "Bonehide Naru",
                "bhn",
                10,
                1));
        builder.addCommand(new Enemy_Admin(waiter,Dragonbane,
                "Draken Horder",
                "dh",
                20,
                15));
        builder.addCommand(new Enemy_Admin(waiter,Dragonbane,
                "Spinetail Lynx",
                "stl",
                12,
                7));
        builder.addCommand(new Enemy_Admin(waiter,Dragonbane,
                "Exospine Minidrake",
                "em",
                1,
                1));
        builder.addCommand(new Enemy_Admin(waiter,Dragonbane,
                "Bloodflame Minidrake",
                "bfm",
                1,
                1));
        builder.addCommand(new Enemy_Admin(waiter,Dragonbane,
                "Musclebound Naru",
                "mbn",
                1,
                10));
        builder.addCommand(new Enemy_Admin(waiter,Dragonbane,
                "Bonemane Naru",
                "bmn",
                5,
                2));
        builder.addCommand(new Enemy_Admin(waiter,Dragonbane,
                "Boneplate Naru",
                "bpn",
                20,
                10));
        builder.addCommand(new Enemy_Admin(waiter,Dragonbane,
                "Scarlet Hound",
                "sh",
                8,
                5));
        builder.addCommand(new Enemy_Admin(waiter,Dragonbane,
                "Bloodrend Naru",
                "brn",
                7,
                12));
        builder.addCommand(new Enemy_Admin(waiter,Whistle,
                "Swistle Bird",
                "sb",
                3,
                1));
    }
}
