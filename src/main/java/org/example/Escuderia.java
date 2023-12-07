package org.example;

/**
 * Clase que representa un Equipo en el contexto de tu aplicación.
 * Esta clase contiene información básica del equipo como su referencia,
 * nombre, nacionalidad y URL.
 */
public class Escuderia {
    // Atributos de la clase
    private String constructorRef;
    private String name;
    private String nationality;
    private String url;

    /**
     * Constructor vacío para crear una instancia sin inicializar los campos.
     */
    public Escuderia() {
    }

    /**
     * Constructor para crear una instancia de Equipo con todos los atributos.
     *
     * @param constructorRef Referencia del constructor del equipo.
     * @param name           Nombre del equipo.
     * @param nationality    Nacionalidad del equipo.
     * @param url            URL del equipo.
     */
    public Escuderia(String constructorRef, String name, String nationality, String url) {
        this.constructorRef = constructorRef;
        this.name = name;
        this.nationality = nationality;
        this.url = url;
    }



    public String getConstructorRef() {
        return constructorRef;
    }

    public void setConstructorRef(String constructorRef) {
        this.constructorRef = constructorRef;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Método para obtener la representación en String del objeto Equipo.
     *
     * @return String que representa al objeto Equipo.
     */
    @Override
    public String toString() {
        return "Equipo{" +
                "constructorRef='" + constructorRef + '\'' +
                ", name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
