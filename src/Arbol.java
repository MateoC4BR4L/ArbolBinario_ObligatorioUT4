import javax.swing.*;
import java.util.*;

public class Arbol<T extends Comparable<T>> implements IArbol<T>
{
    // Nodo raiz del arbol, padre de todos los nodos
    private Nodo<T> raiz;

    public Arbol()
    {
        this.raiz = null;
    }

    @Override
    public boolean esArbolBB(Nodo<T> nodo)
    {
        List<T> lista = this.listaInorden();

        for(int i = 0; i < lista.size() - 1; i++)
        {
            if(lista.get(i).compareTo(lista.get(i + 1)) > 0)
            {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean esArbolBB()
    {
        if(vacio())
        {
            System.out.println("El arbol está vacío, por lo que no se puede verificar si es de búsqueda");
            return false;
        }
        return esArbolBB(raiz);
    }

    // Insertar un Nodo en el arbol de busqueda
    @Override
    public boolean insertar(Nodo<T> padre, T valor)
    {
        if(valor.equals(padre.getValor()))
        {
            System.out.println("El valor ingresado ya existe.");
            return false;
        }
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
                return insertar(padre.getHijo_Izq(), valor);
            }
        }
        // Si el valor dado es mayor al valor del padre, se mueve a la derecha del arbol
        else
        {
            if (padre.getHijo_Der() == null) {
                padre.setHijo_Der(new Nodo<>(valor));
                return true;
            } else {
                return insertar(padre.getHijo_Der(), valor);
            }
        }
    }

    // Llama a la otra funcion insertar para lograr la llamada recursiva
    @Override
    public boolean insertar(T valor)
    {
        if(vacio())
        {
            this.raiz = new Nodo<>(valor);
            return true;
        }
        else
        {
            return insertar(this.raiz, valor);
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
                return buscar(valor, nodo.getHijo_Izq());
            }
            else
            {
                System.out.println("El nodo no existe.");
                return null;
            }
        }
        else
        {
            if(nodo.getHijo_Der() != null)
            {
                return buscar(valor, nodo.getHijo_Der());
            }
            else
            {
                System.out.println("El nodo no existe.");
                return null;
            }
        }
    }

    public Nodo<T> buscar(T valor)
    {
        if(vacio())
        {
            System.out.println("El arbol esta vacio.");
            return null;
        }
        return buscar(valor, raiz);
    }

    // Obtener la menor clave del arbol
    @Override
    public T menorClave(Nodo<T> nodo)
    {
        if(nodo.getHijo_Izq() == null)
            return nodo.getValor();

        return menorClave(nodo.getHijo_Izq());
    }

    @Override
    public T menorClave()
    {
        if(vacio())
        {
            System.out.println("El arbol está vacío");
            return null;
        }
        return menorClave(raiz);
    }

    @Override
    public T mayorClave(Nodo<T> nodo)
    {
        if(nodo.getHijo_Der() == null)
            return nodo.getValor();

        return mayorClave(nodo.getHijo_Der());
    }

    // Obtener la mayor clave del arbol
    @Override
    public T mayorClave()
    {
        if(vacio())
        {
            System.out.println("El arbol está vacío");
            return null;
        }
        return mayorClave(raiz);
    }

    @Override
    public T claveAnterior(T valor, Nodo<T> nodo)
    {
        if(valor.equals(raiz.getValor()))
        {
            System.out.println("El valor ingresado no tiene clave anterior debido a que este valor es la raiz.");
            return null;
        }

        if(valor.compareTo(nodo.getValor()) < 0)
        {
            if(nodo.getHijo_Izq() != null)
            {
                if (valor.equals(nodo.getHijo_Izq().getValor()))
                    return nodo.getValor();
                return claveAnterior(valor, nodo.getHijo_Izq());
            }
            else
            {
                System.out.print("El elemento que usted ingresó no existe.");
                return null;
            }
        }
        else
        {
            if(nodo.getHijo_Der() != null)
            {
                if(valor.equals(nodo.getHijo_Der().getValor()))
                    return nodo.getValor();
                return claveAnterior(valor, nodo.getHijo_Der());

            }
            else
            {
                System.out.print("El elemento que usted ingresó no existe.");
                return null;
            }
        }
    }

    @Override
    public T claveAnterior(T valor)
    {
        if(vacio())
        {
            System.out.println("El arbol está vacío");
            return null;
        }
        return claveAnterior(valor, raiz);
    }


    // Obtener la cantidad de nodos de un nivel determinado
    @Override
    public int nodos_por_Nivel(int nivel)
    {
        if(nivel == 0)
            return 1;

        int lvl = 0;
        int contador = 0;
        Nodo<T> actual = null;

        Queue<Nodo<T>> cola = new ArrayDeque<Nodo<T>>();
        cola.add(raiz);

        while(!cola.isEmpty())
        {
            int largo = cola.size();
            for (int i = 0; i <= largo - 1; i++)
            {
                if(lvl == nivel)
                    contador += 1;

                actual = cola.poll();
                assert actual != null;

                if(actual.getHijo_Izq() != null)
                    cola.offer(actual.getHijo_Izq());
                if(actual.getHijo_Der() != null)
                    cola.offer(actual.getHijo_Der());
            }
            lvl++;
        }
        return contador;
    }

    @Override
    public Map<Nodo<T>, Integer> hojas()
    {
        if (vacio())
        {
            System.out.println("El árbol está vacío.");
            return null;
        }

        Map<Nodo<T>, Integer> diccionario_Hojas = new HashMap<>();

        int lvl = 0;
        Nodo<T> actual = null;

        Queue<Nodo<T>> cola = new ArrayDeque<Nodo<T>>();
        cola.add(raiz);

        while (!cola.isEmpty())
        {
            int largo = cola.size();
            for (int i = 0; i < largo; i++)
            {
                actual = cola.poll();
                assert actual != null;
                if (actual.getHijo_Izq() == null && actual.getHijo_Der() == null)
                {
                    diccionario_Hojas.put(actual, lvl);
                }
                if (actual.getHijo_Izq() != null)
                    cola.offer(actual.getHijo_Izq());
                if (actual.getHijo_Der() != null)
                    cola.offer(actual.getHijo_Der());
            }
            lvl++;
        }
        return diccionario_Hojas;
    }

    @Override
    public boolean vacio() { return (this.raiz == null); }

    @Override
    public void inorden()
    {
        if(vacio())
        {
            System.out.print("Arbol vacío.");
            return;
        }
        inorden(raiz);
    }

    @Override
    public void preorden()
    {
        if(vacio())
        {
            System.out.print("Arbol vacío.");
            return;
        }
        preorden(raiz);
    }

    @Override
    public void postorden()
    {
        if(vacio())
        {
            System.out.print("Arbol vacío.");
            return;
        }
        postorden(raiz);
    }

    @Override
    public void inorden(Nodo<T> nodo)
    {
        if (nodo != null)
        {
            inorden(nodo.getHijo_Izq());
            System.out.println(nodo.getValor());
            inorden(nodo.getHijo_Der());
        }
    }

    @Override
    public void preorden(Nodo<T> nodo)
    {
        if (nodo != null) {
            System.out.println(nodo.getValor());
            preorden(nodo.getHijo_Izq());
            preorden(nodo.getHijo_Der());
        }
    }

    @Override
    public void postorden(Nodo<T> nodo)
    {
        if (nodo != null) {
            postorden(nodo.getHijo_Izq());
            postorden(nodo.getHijo_Der());
            System.out.println(nodo.getValor());
        }
    }

    @Override
    public List<T> listaInorden()
    {
        if(vacio())
        {
            System.out.print("Arbol vacío.");
            return null;
        }
        List<T> lista = new ArrayList<>();
        return listaInorden(raiz, lista);
    }

    @Override
    public List<T> listaInorden(Nodo<T> nodo, List<T> lista)
    {
        if (nodo != null)
        {
            listaInorden(nodo.getHijo_Izq(), lista);
            lista.add(nodo.getValor());
            listaInorden(nodo.getHijo_Der(), lista);
        }
        return lista;
    }
}
