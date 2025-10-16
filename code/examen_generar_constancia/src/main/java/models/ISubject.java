package models;
/**
 * ISubject.java
 *
 * Interfaz que define el comportamiento del patrón Observer
 * en este caso para el objeto observado, aquí, las clases que 
 * implementen esta interfaz podrán registrar, eliminar y notificar 
 * observadores sobre los cambios o eventos que ocurran.
 * 
 * @author Yuri Germán García López
 * ID: 00000252583
 */
public interface ISubject {

    /**
     * Agrega un nuevo observador a la lista de observadores del sujeto.
     * 
     * @param observador Objeto que implementa IObserver y que será notificado ante cambios.
     */
    void agregarObserver(IObserver observador);

    /**
     * Elimina un observador previamente registrado.
     * 
     * @param observador Objeto observador a eliminar.
     */
    void quitarObserver(IObserver observador);

    
    /**
     * Notifica a todos los observadores registrados sobre un evento o cambio.
     * 
     * @param mensaje Mensaje que describe el evento ocurrido.
     */
    void notificarObservadores(String mensaje);
    
}