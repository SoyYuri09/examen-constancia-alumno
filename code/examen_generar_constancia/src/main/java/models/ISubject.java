package models;
/**
 * @author Usuario
 */
public interface ISubject {

    void agregarObserver(IObserver observador);

    void quitarObserver(IObserver observador);

    void notificarObservadores(String mensaje);
    
}
