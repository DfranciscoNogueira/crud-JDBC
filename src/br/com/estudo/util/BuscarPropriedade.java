package br.com.estudo.util;

import java.util.Locale;
import java.util.ResourceBundle;

public class BuscarPropriedade {

    private static final String MESSAGES_PROPERTIES = "br.com.estudo.propertys.propriedades";
    private static final Locale ptBR = new Locale("pt", "BR");

    private static ResourceBundle bundle = ResourceBundle.getBundle(MESSAGES_PROPERTIES, ptBR);

    public static String getString(String key) {
        return bundle.getString(key);
    }

}
