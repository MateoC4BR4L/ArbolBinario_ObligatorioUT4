public class Nodo <T extends Comparable<T>>
{
    private final T valor;
    private Nodo<T> hijo_Izq = null;
    private Nodo<T> hijo_Der = null;

    public Nodo (T val)
    {
        this.valor = val;
    }

    // Obtiene el valor del nodo
    public T getValor() { return valor; }

    // Obtiene el hijo izquierdo del nodo
    public Nodo<T> getHijo_Izq() { return hijo_Izq; }

    // Obtiene el hijo derecho del nodo
    public  Nodo<T> getHijo_Der() { return hijo_Der; }

    // Define el hijo izquierdo del nodo
    public void setHijo_Izq(Nodo<T> hijo_Izq) { this.hijo_Izq = hijo_Izq; }

    // Define el hijo derecho del nodo
    public void setHijo_Der(Nodo<T> hijo_Der) { this.hijo_Der = hijo_Der; }
}
