package biblioteca.observer;

public interface Sujeito {
    void registrarObservador(Observador observador);
    void notificarObservadores();
}
