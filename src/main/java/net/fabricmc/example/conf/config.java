package net.fabricmc.example.conf;

public class config {
    public static boolean isPanic() {
        return panic;
    }

    public static void setPanic(boolean panic) {
        config.panic = panic;
    }

    public static double getSize() {
        return size;
    }

    public static void setSize(double size) {
        config.size = size;
    }

    private static boolean panic;
    private static double size;
}
