class Arbol{
    private Nodo raiz;
    String info;

    public Arbol() {

    }

    public boolean existe(String busqueda) {
        return existe(this.raiz, busqueda);
    }

    private boolean existe(Nodo n, String busqueda) {
        if (n == null) {
            return false;
        }
        if (n.getDato().equals(busqueda)) {
            return true;
        } else if (busqueda.compareTo(n.getDato()) < 0) {
            return existe(n.getIzquierda(), busqueda);
        } else {
            return existe(n.getDerecha(), busqueda);
        }

    }

    public void eliminar(String busqueda) {
        Nodo aux=this.raiz;
        this.raiz=null;
        eliminar(aux, busqueda);
    }

    private void eliminar(Nodo n, String busqueda) {
        if (n !=null) {
            eliminar(n.getIzquierda(), busqueda);
            if(!(n.getDato().equals(busqueda))){
                insertar(n.getDato());
            }
            eliminar(n.getDerecha(), busqueda);
        }
    }

    public void insertar(String dato) {
        if (this.raiz == null) {
            this.raiz = new Nodo(dato);
        } else {
            this.insertar(this.raiz, dato);
        }
    }

    private void insertar(Nodo padre, String dato) {
        if (dato.compareTo(padre.getDato()) > 0) {
            if (padre.getDerecha() == null) {
                padre.setDerecha(new Nodo(dato));
            } else {
                this.insertar(padre.getDerecha(), dato);
            }
        } else {
            if (padre.getIzquierda() == null) {
                padre.setIzquierda(new Nodo(dato));
            } else {
                this.insertar(padre.getIzquierda(), dato);
            }
        }
    }

    private void preorden(Nodo n) {
        if (n != null) {
            this.info=this.info+"\n"+n.imprimirDato();
            preorden(n.getIzquierda());
            preorden(n.getDerecha());
        }
    }

    private void inorden(Nodo n) {
        if (n != null) {
            inorden(n.getIzquierda());
            this.info=this.info+"\n"+n.imprimirDato();
            inorden(n.getDerecha());
        }
    }

    private void postorden(Nodo n) {
        if (n != null) {
            postorden(n.getIzquierda());
            postorden(n.getDerecha());
            this.info=this.info+"\n"+n.imprimirDato();
        }
    }

    public String preorden() {
        this.info="";
        this.preorden(this.raiz);
        return this.info;
    }

    public String inorden() {
        this.info="";
        this.inorden(this.raiz);
        return this.info;
    }

    public String postorden() {
        this.info="";
        this.postorden(this.raiz);
        return this.info;
    }
}