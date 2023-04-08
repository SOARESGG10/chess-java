package br.soares.util;

import java.util.Properties;

import br.soares.util.enums.Systems;

public class OsSystems {

    public static Systems getOperatingSystem() {
        Properties properties = System.getProperties();
        String OS = properties.getProperty("os.name").toLowerCase();

        return OS.contains("win") ? Systems.WINDOWS : Systems.UNIX;
    }
}
