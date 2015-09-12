package calculadora2;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Interfaz  extends JFrame implements ActionListener {
    String opera[]={"R","C", "+", "*", "/", "-" ,"="},  auxiliar="";
    float numero1, numero2, resultado, M;
    JTextField jtexto, jtexto2;
    Panel panel1, panel2, panel3;
    JPanel pan1, pan2;
     boolean x=false;//control sobre escribir un nuevo numero despues de alguna operacion cambia a true cuando se ha realizado una operacion
    JButton  BotonSuma, BotonMenos, numeros[], operaciones[];
    int tipoBoton; //para controlar el tipo de operacion que se realiza


    public Interfaz(){
        JFrame jfMain = new JFrame("Calculadora");
        jfMain.setLayout(new BorderLayout(5, 5));

        norte();
        sur();

        jfMain.add(panel1, BorderLayout.NORTH);
        jfMain.add(pan1, BorderLayout.CENTER);

        jfMain.setLocation(500, 225);
        jfMain.setResizable(false);
        jfMain.setVisible(true);
        jfMain.setSize(300, 300);
        jfMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       try{
       URL url =new URL("indice.jpg");
       Toolkit kit=Toolkit.getDefaultToolkit();
       Image img=kit.createImage(url);
       this.setIconImage(img);
       }
       catch(Exception e){
       System.out.println(e);
       }
    }
    public void sur(){

        pan1 = new JPanel(new BorderLayout(6, 50));
        pan1.setLayout(new BorderLayout(4, 4));

        
        botonesNumeros();
        botonesOperaciones();

      
        pan1.add(pan2, BorderLayout.CENTER); 
        pan1.add(panel3, BorderLayout.EAST); 

        pan1.setSize(270, 330);
    }
    public void norte(){

        panel1 = new Panel(null);        

        jtexto = new JTextField("");
        jtexto2 = new JTextField("0");

        jtexto.setHorizontalAlignment(JTextField.RIGHT); 
        jtexto2.setHorizontalAlignment(JTextField.RIGHT); 

        //Quitar bordes a los campos de texto
        jtexto.setBorder(BorderFactory.createLineBorder(Color.white));
        jtexto2.setBorder(BorderFactory.createLineBorder(Color.white));

        //desabilitando los campos de texto
        jtexto.setEditable(false);
        jtexto2.setEditable(false);

        jtexto.setBackground(Color.white);
        jtexto2.setBackground(Color.white);

        panel1.add(jtexto); panel1.add(jtexto2);

        jtexto.setBounds(35, 10, 200, 15);
        jtexto2.setBounds(35, 25, 200, 30);

        panel1.setSize(270, 47);
        panel1.setVisible(true);

    }
  
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    private void botonesNumeros() {
        
    }

    private void botonesOperaciones() {
       panel3 = new Panel(null);

        int u=0, z=0, p=0;

        operaciones = new JButton[7];

        for(int i=0; i<=6; i++){
            if(u<=1){

                operaciones[i] = new JButton(opera[i]);
                panel3.add(operaciones[i]);

                    operaciones[i].setBounds(z, p, 30, 35);

                    operaciones[i].setMargin(new Insets(1, 1, 1, 1));
                    operaciones[i].addActionListener(this);
                    z+=33;
                    u++;               
            }
            else{
                if(i==6){
                    z=0; p+=43;
                    operaciones[i] = new JButton(opera[i]);
                    panel3.add(operaciones[i]);

                    operaciones[i].setBounds(z, p, 65, 35);

                    operaciones[i].setMargin(new Insets(1, 1, 1, 1));
                    operaciones[i].addActionListener(this);
                    z+=33;
                    u++;
                }
                else{
                    u=0;
                    z=0; p+=43;
                    operaciones[i] = new JButton(opera[i]);
                    panel3.add(operaciones[i]);

                    operaciones[i].setBounds(z, p, 30, 35);

                    operaciones[i].setMargin(new Insets(1, 1, 1, 1));
                    operaciones[i].addActionListener(this);
                    z+=33;
                    u++;   
                }                             
            }                

        }

        panel3.setVisible(true);
        panel3.setSize(120, 200);
    
    }
    }

