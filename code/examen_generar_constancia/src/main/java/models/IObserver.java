package models;
/**
 *
 * @author Usuario
 */
public interface IObserver {

    void notificar(String mensaje, ISubject origen);
    
}