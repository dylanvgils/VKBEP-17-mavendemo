package nl.hu.dylanvgils.mavendemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Main {
    private static final String APPLICATION_PROPERTIES = "application.properties";
    private static final ClassLoader classLoader = Main.class.getClassLoader();
    private static final Properties properties = new Properties();

    private static String logFormat = "%-45s: %s\n";

    public static void main(String[] args) {
        // Load application properties from class path
        try (InputStream input = classLoader.getResourceAsStream(APPLICATION_PROPERTIES)) {
            properties.load(input);
            System.out.printf("[LOAD]\t: %s\n", APPLICATION_PROPERTIES);
        } catch (IOException e) {
            System.out.printf("[ERROR]\t: Could not load file: %s\n", APPLICATION_PROPERTIES);
        }

        // Load external properties
        String externalPath = properties.getProperty("application.home") + "/" + APPLICATION_PROPERTIES;
        try (InputStream input = new FileInputStream(externalPath)) {
            System.out.printf("[LOAD]\t: %s\n", externalPath);
            properties.load(input);
        } catch (IOException e) {
            System.out.printf("[ERROR]\t: Could not load file: %s\n", externalPath);
        }

        // Print configuration
        System.out.println("\n[CONFIGURATION]");
        System.out.printf(logFormat, "application.home", properties.getProperty("application.home"));
        System.out.printf(logFormat, "database.url", properties.getProperty("database.url"));
        System.out.printf(logFormat, "database.user", properties.getProperty("database.user"));
        System.out.printf(logFormat, "database.password", properties.getProperty("database.password"));
    }
}
