public interface IArbol <T extends Comparable<T>>
{
    // Funcion que verifica si el arbol es de busqueda
    public boolean esArbolBB();

    // Funcion para insertar un nodo al arbol
    public boolean insertar(Nodo<T> padre, T valor);

    // Metodo que llama a la otra funcion insertar para hacer la llamada recursiva
    public boolean insertar(T valor);

    // Funcion para buscar un nodo en el arbol
    public Nodo<T> buscar(T valor, Nodo<T> nodo);

    // Llama a la funcion buscar
    public Nodo<T> buscar(T valor);

    // Obtener la menor clave del arbol
    public T menorClave(Nodo<T> nodo);

    // Llama al metodo para obtener la menor clave del arbol
    public T menorClave();

    // Obtener la mayor clave del arbol
    public T mayorClave(Nodo<T> nodo);

    // Llama al metodo para obtener la mayor clave del arbol
    public T mayorClave();

    // Llama al metodo para obtener la clave anterior a una clave dada
    public T claveAnterior(T valor);

    // Obtener la clave anterior a una clave dada
    public T claveAnterior(T valor, Nodo<T> nodo);

    // Obtener la cantidad de nodos en un nivel
    public int nodos_por_Nivel(int nivel);

    // Listar todas las hojas con su nivel
    public void hojas();

    // Verifica si el arbol esta vacio
    public boolean vacio();

    // Llama a la funcion que imprime el arbol de forma inorden
    public void inorden();

    // Llama a la funcion que imprime el arbol de forma preorden
    public void preorden();

    // Llama a la funcion que imprime el arbol de forma postorden
    public void postorden();

    // Imprime el arbol de forma inorden
    public void inorden(Nodo<T> nodo);

    // Imprime el arbol de forma preorden
    public void preorden(Nodo<T> nodo);

    // Imprime el arbol de forma postorden
    public void postorden(Nodo<T> nodo);
}
