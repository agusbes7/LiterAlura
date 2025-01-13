package LiterAlura.model;

import java.util.Optional;

public enum Idioma {
       ESPANIOL("Es"),
        INGLES("En"),
       CHINO("zh"),
           FRANCES("fr"),
    PORTUGAL("pt"),
    ALEMAN("de"),
    FINLANDIA("fi"),
    SININFORMACION("s/n");


        private String idiomaGut;

Idioma (String idioma){            this.idiomaGut = idioma; }

        public static Idioma fromString(String text) {
            for (Idioma lengua : Idioma.values()) {
                if (lengua.idiomaGut.equalsIgnoreCase(text)) {
                    return lengua;}}
return  null;}
    public static boolean validacion(String text) {
        for (Idioma lengua : Idioma.values()) {
            if (lengua.idiomaGut.equalsIgnoreCase(text)) {
                return true;}}

            return false;
        }

}



