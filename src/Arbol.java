public class Arbol<T extends Comparable<T>> implements IArbol<T>
{
    // Nodo raiz del arbol, padre de todos los nodos
    private Nodo<T> raiz;

    public Arbol()
    {
        this.raiz = null;
    }

    @Override
    public boolean esArbolBB(){
        return false;
    }

    // Insertar un Nodo en el arbol de busqueda
    @Override
    public boolean insertar(Nodo<T> padre, T valor)
    {
        // Si el valor dado es menor al valor del padre, se mueve a la izquierda del arbol
        if(valor.compareTo(padre.getValor()) < 0)
        {
            if(padre.getHijo_Izq() == null)
            {
                padre.setHijo_Izq(new Nodo<>(valor));
                System.out.println("Se ha insertado el nodo con exito.");
                return true;
            }
            else
            {
                insertar(padre.getHijo_Izq(), valor);
            }
        }
        // Si el valor dado es mayor al valor del padre, se mueve a la derecha del arbol
        else if(valor.compareTo(padre.getValor()) > 0)
        {
            if (padre.getHijo_Der() == null) {
                padre.setHijo_Der(new Nodo<>(valor));
                return true;
            } else {
                insertar(padre.getHijo_Izq(), valor);
            }
        }
        // Si se llega a esta parte del programa se debe a que el valor ya existe
        System.out.println("El valor que se quiere ingresar ya existe.");
        return false;
    }

    // Llama a la otra funcion insertar para lograr la llamada recursiva
    @Override
    public void insertar(T valor)
    {
        if(vacio())
        {
            this.raiz = new Nodo<>(valor);
        }
        else
        {
            insertar(this.raiz, valor);
        }
    }

    // Buscar un nodo dentro del arbol
    @Override
    public Nodo<T> buscar(T valor, Nodo<T> nodo)
    {
        if(valor.equals(nodo.getValor()))
            return nodo;

        if(valor.compareTo(nodo.getValor()) < 0)
        {
            if(nodo.getHijo_Izq() != null)
            {
                buscar(valor, nodo.getHijo_Izq());
            }
            else
            {
                System.out.println("El nodo no existe.");
                return null;
            }
        }
        else if(valor.compareTo(nodo.getValor()) > 0)
        {
            if(nodo.getHijo_Der() != null)
            {
                buscar(valor, nodo.getHijo_Der());
            }
            else
            {
                System.out.println("El nodo no existe.");
                return null;
            }
        }
        // En caso de que no exista va a
        System.out.println("El nodo indicado no existe.");
        return null;
    }

    public void buscar(T valor)
    {
        if(vacio())
        {
            System.out.println("El arbol esta vacio.");
            return;
        }
        buscar(valor, raiz);

    }

    // Obtener la menor clave del arbol
    @Override
    public T menorClave(Nodo<T> nodo)
    {
        if(nodo.getHijo_Izq() == null)
        {
            return nodo.getValor();
        }
        else
        {
            menorClave(nodo.getHijo_Izq());
        }
        // No debería de llegar hasta este return el programa...
        return null;
    }

    @Override
    public void menorClave()
    {
        if(vacio())
        {
            System.out.println("El arbol está vacío");
            return;
        }
        menorClave(raiz);
    }

    @Override
    public T mayorClave(Nodo<T> nodo) {
        return null;
    }

    // Obtener la mayor clave del arbol
    @Override
    public void mayorClave(){
    }

    @Override
    public T claveAnterior(T valor, Nodo<T> nodo) {
        return null;
    }

    @Override
    public void claveAnterior(T valor) {
    }


    // Obtener la cantidad de nodos de un nivel determinado
    @Override
    public int nodos_por_Nivel(int nivel) {
        return 0;
    }

    // Obtener las hojas del arbol con sus respectivos niveles
    @Override
    public void hojas() {}

    @Override
    public boolean vacio() { return (this.raiz == null); }

    @Override
    public void inorden() {

    }

    @Override
    public void preorden() {

    }

    @Override
    public void postorden() {

    }

    @Override
    public void inorden(Nodo<T> nodo) {

    }

    @Override
    public void preorden(Nodo<T> nodo) {

    }

    @Override
    public void postorden(Nodo<T> nodo) {

    }
}
