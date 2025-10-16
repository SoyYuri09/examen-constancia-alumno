package models;
/**
 * IObserver.java
 *
 * Interfaz que define el comportamiento del patrón Observer
 * donde las clases que implementen esta interfaz podrán recibir
 * notificaciones cuando ocurra un cambio en los objetos observados
 * 
 * @author Yuri Germán García López
 * ID: 00000252583
 */
public interface IObserver {

    /**
     * Método que recibe notificaciones 
     * desde un sujeto observado.
     * 
     * @param mensaje Mensaje que describe el evento ocurrido
     * @param origen Objeto que generó la notificación
     */
    void notificar(String mensaje, ISubject origen);
    
}