package vMahogany.util;

import org.powerbot.script.wrappers.Tile;
import vMahogany.fw.Area;

public class Constants {

    public static final Area TREE_AREA = new Area(new Tile[] { new Tile(2817, 3090, 0), new Tile(2817, 3076, 0), new Tile(2828, 3076, 0),
            new Tile(2828, 3089, 0), new Tile(2827, 3090, 0) });
    public static final Area BANK_AREA = new Area(new Tile[] { new Tile(2785, 3089, 0), new Tile(2788, 3095, 0), new Tile(2786, 3098, 0),
            new Tile(2779, 3099, 0), new Tile(2776, 3098, 0), new Tile(2776, 3092, 0),
            new Tile(2776, 3090, 0) });
    public static final Area OUT_AREA = new Area(new Tile[] { new Tile(2815, 3085, 0), new Tile(2815, 3081, 0), new Tile(2814, 3082, 0),
            new Tile(2814, 3085, 0) });

    public static final Tile[] PATH_TO_BANK = {new Tile(2815, 3086, 0), new Tile(2814, 3091, 0), new Tile(2809, 3093, 0),
            new Tile(2804, 3093, 0), new Tile(2799, 3092, 0), new Tile(2794, 3092, 0),
            new Tile(2789, 3092, 0), new Tile(2784, 3093, 0), new Tile(2781, 3095, 0) };
    public static final Tile[] PATH_TO_TREES = {new Tile(2783, 3093, 0), new Tile(2790, 3090, 0),
            new Tile(2795, 3085, 0),
            new Tile(2801, 3081, 0), new Tile(2808, 3079, 0), new Tile(2815, 3082, 0)};

    public static final int[] NESTS = {5070, 5071, 5072, 5073, 5074, 5075, 7413, 11966 };
    public static final int TREE = 70076;
    public static final int[] LOGS = {6332, 15290, 6333, 15289, 5070, 5071, 5072, 5073, 5074, 5075, 7413, 11966, 28590};
    public static final int STICKS = 6306;

    public static final Tile BANK_TILE = new Tile(2781, 3095, 0);


}
