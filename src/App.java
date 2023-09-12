import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
 
public class App implements ActionListener{//implementando el listener de eventos
    
    Arbol arbol = new Arbol();
    JButton insertar;//creando variables globales de los botones
    JButton buscar;//creando variables globales de los botones
    JButton eliminar;//creando variables globales de los botones
    JButton inorden;//creando variables globales de los botones
    JButton posorden;//creando variables globales de los botones
    JButton preorden;//creando variables globales de los botones
    JLabel label_dato;//creando variables globales para las etiquetas
    JTextField tf_dato;//creando variables globales para los campos de texto
    JFrame contenedor_principal = new JFrame("Arboles");
    JTextArea salida;
    String nombres ="\nSegundo Paladines\nDavid Pasaje\n";
    String acosar ="\n\nPONGANOS 5 PROFE :v";
    public App(){//constructor de la clase        
        
        contenedor_principal.setLayout(new FlowLayout());//Configurar como se dispondra el espacio del jframe
        Dimension d = new Dimension();//objeto para obtener el ancho de la pantalla
        
        //Instanciando etiquetas
        label_dato = new JLabel("Dato");
        
        //Instanciando cuadros de texto
        tf_dato = new JTextField(10);
        
        //Instanciando boton con texto
        insertar = new JButton("Incertar");
        eliminar = new JButton("Eliminar");
        inorden = new JButton("In Orden");
        posorden = new JButton("Pos Orden");
        preorden = new JButton("Pre Orden");
        buscar = new JButton("Buscar");
        salida = new JTextArea("\nSegundo Paladines\nDavid Pasaje\nPONGANOS 5 PROFE :v");
        salida.setBounds(100, 200, 200, 200);
        salida.setEditable(false);
        
        //añadiendo objetos a la ventana
        contenedor_principal.add(insertar);
        contenedor_principal.add(buscar);
        contenedor_principal.add(eliminar);
        contenedor_principal.add(inorden);
        contenedor_principal.add(posorden);
        contenedor_principal.add(preorden);
        contenedor_principal.add(label_dato);
        contenedor_principal.add(tf_dato);
        contenedor_principal.add(salida);

        //añadiendo el listener a los botones para manipular los eventos del click
        insertar.addActionListener(this);
        buscar.addActionListener(this);
        eliminar.addActionListener(this);
        inorden.addActionListener(this);
        posorden.addActionListener(this);
        preorden.addActionListener(this);
        
        contenedor_principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//finaliza el programa cuando se da click en la X        
        contenedor_principal.setResizable(false);//para configurar si se redimensiona la ventana
        contenedor_principal.setLocation((int) ((d.getWidth()/2)+500), 150);//para ubicar inicialmente donde se muestra la ventana (x, y)
        contenedor_principal.setSize(400, 400);//configurando tamaño de la ventana (ancho, alto)
        contenedor_principal.setVisible(true);//configurando visualización de la venta
    }
 
    public static void main(String[] args) {        
        App arbol_binario = new App();//uso de constructor para la ventana
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {//sobreescribimos el metodo del listener
                
        if(e.getSource()==insertar){

            boolean existe = arbol.existe(tf_dato.getText().toString());
            if(!existe){

                arbol.insertar(tf_dato.getText().toString());
                JOptionPane.showMessageDialog(null, "Agregado Con Exito", "REALIZADO", JOptionPane.INFORMATION_MESSAGE);
                tf_dato.setText("");

            }else{
                JOptionPane.showMessageDialog(null, "El Elemento Ya Existe", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            salida.setText(nombres+"\n       INORDEN          \n"+arbol.inorden()+acosar);

        }
        if(e.getSource()==eliminar){

            boolean existe = arbol.existe(tf_dato.getText().toString());
            if(existe){

                arbol.eliminar(tf_dato.getText().toString());
                JOptionPane.showMessageDialog(null, tf_dato.getText().toString()+" Eliminado Con Exito", "REALIZADO", JOptionPane.INFORMATION_MESSAGE);
                tf_dato.setText("");

            }else{
                JOptionPane.showMessageDialog(null, "El Dato No Existe", "ERROR", JOptionPane.ERROR_MESSAGE);
            }

            salida.setText(nombres+"\n           INORDEN         \n"+arbol.inorden()+acosar);

        }
        if(e.getSource()==inorden){

            salida.setText(nombres+"\n          INORDEN           \n"+arbol.inorden()+acosar);

        }
        if(e.getSource()==posorden){

            salida.setText(nombres+"\n         POSTORDEN         \n"+arbol.postorden()+acosar);

        }
        if(e.getSource()==preorden){

            salida.setText(nombres+"\n        PREORDEN            \n"+arbol.preorden()+acosar);

        }
        if(e.getSource()==buscar){

            boolean existe=arbol.existe(tf_dato.getText().toString());
            if(existe){
                salida.setText(nombres+"\n   EL DATO SI EXISTE    \n"+acosar);
            }else{
                salida.setText(nombres+"\nTRISTEMENTE NO EXISTE EL DATO\n"+acosar);
            }

            

        }      
    }
}