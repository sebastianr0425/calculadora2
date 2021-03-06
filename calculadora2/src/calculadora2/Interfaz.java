package calculadora2;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Interfaz  extends JFrame implements ActionListener {
    String opera[]={"CE","C", "+", "*", "/", "-" ,"="},  auxiliar="";
    float numero1, numero2, resultado, M;
    JTextField jtexto, jtexto2;
    Panel panel1, panel2, panel3;
    JPanel pan1, pan2;
     boolean x=false;
    JButton  BotonSuma, BotonMenos, numeros[], operaciones[];
    int tipoBoton;


    public Interfaz(){

        JFrame jfMain = new JFrame("Calculadora");
        jfMain.setIconImage(new ImageIcon(getClass().getResource("../imagenes/Calculadora.png")).getImage());
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

        
        jtexto.setBorder(BorderFactory.createLineBorder(Color.white));
        jtexto2.setBorder(BorderFactory.createLineBorder(Color.white));

        
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
     public void botonesOperaciones(){

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

    

    public void botonesNumeros(){

        pan2 = new JPanel(null);
        numeros = new JButton[11];
        int numero=86,numerox3=121, numerox2=121, numerox1=121, numero3=0, numero2y=43;
       

        
        
        for (int i=0; i<=10; i++){

            if(i<=9){
                numeros[i] = new JButton(""+i);
                pan2.add(numeros[i]);
                numeros[i].setMargin(new Insets(1, 1, 1, 1));
                numeros[i].addActionListener(this);  
            }
            else{
                numeros[i] = new JButton(".");
                pan2.add(numeros[i]);
                numeros[i].setMargin(new Insets(1, 1, 1, 1));
                numeros[i].addActionListener(this);
            }
        }
        
        for(int i=10; i>=0; i--){

            if(i==10){
                numeros[i].setBounds(122, 130, 36, 36);
            }
            else{
                if(i<=9 && i>=7){
                    numeros[i].setBounds(numerox3, numero3, 35, 35);
                    numerox3-=43;
                }
                else if(i<=6 && i>=4){   
                    numero3+=43;                    
                    numeros[i].setBounds(numerox2, numero2y, 35, 35);
                    numerox2-=43;
                }
                else if(i<=3 && i>=1){
                    numero3+=43;                    
                    numeros[i].setBounds(numerox1, numero, 35, 35);
                    numerox1-=43;
                }
                else if(i==0){
                    numeros[i].setBounds(35, 129, 78, 35);                    
                }
            }                
        }

        pan2.setSize(170, 150);
        pan2.setVisible(true);
    }

   
     @Override
    public void actionPerformed(ActionEvent e) {

        String  opera="";

        if(esNumero(e.getActionCommand())){

            if(jtexto.getText().equals("")){
                auxiliar += e.getActionCommand();
                jtexto2.setText(auxiliar);
            }
            else{
                if(tipoBoton==0){
                    if(x){
                        auxiliar=""; 

                        jtexto.setText(jtexto2.getText());                        
                        auxiliar += e.getActionCommand();
                        jtexto2.setText(auxiliar);    
                        x = false;
                    }
                    else{
                        auxiliar="";
                        auxiliar += jtexto2.getText()+e.getActionCommand();
                        jtexto2.setText(auxiliar);
                    }                
                }else{
                    auxiliar="";
                    auxiliar += jtexto2.getText()+e.getActionCommand();
                    jtexto2.setText(auxiliar);
                }
            }            
        }
        else{

            if(e.getActionCommand().equals("CE") ){
               
                if ( jtexto2.getText().length() != 0) {
                         jtexto2.setText( jtexto2.getText().substring(0,  jtexto2.getText().length() - 1));
                         
                }
                auxiliar=jtexto2.getText();
                
            }
            if(e.getActionCommand().equals("C") ){ 
               tipoBoton=0; numero1 = 0; numero2 =0; resultado=0; jtexto.setText(""); jtexto2.setText("0"); auxiliar="";
                
             
           
               
                       
            }
            if(e.getActionCommand().equals(".")){
                auxiliar="";
                if(numeros[10].isEnabled()){
                    numeros[10].setEnabled(false);
                    auxiliar = jtexto2.getText() +".";
                    jtexto2.setText(auxiliar);
                }
            }
            if(e.getActionCommand().equals("+") ){
                numeros[10].setEnabled(true);
                auxiliar="";
                if(tipoBoton==1){

                }else if(tipoBoton==0 ){
                        if(jtexto.getText().equals("") ){
                            numero1 = Float.parseFloat(jtexto2.getText());                    
                            auxiliar += jtexto.getText()+jtexto2.getText();
                            jtexto.setText(auxiliar+" + ");
                            jtexto2.setText("");
                            tipoBoton = 1;
                        }
                        else {
                            if(!x){//validacion para nueva operacion
                                numero1 = Float.parseFloat(jtexto2.getText());                    
                                auxiliar += jtexto2.getText();
                                jtexto.setText(auxiliar+" + ");
                                jtexto2.setText("");
                                tipoBoton = 1;
                            }
                            else{//usar otras operaciones con la suma
                                numero1 = Float.parseFloat(jtexto2.getText());                    
                                auxiliar += jtexto.getText();
                                jtexto.setText(auxiliar+" + ");
                                jtexto2.setText("");
                                tipoBoton = 1;
                            }
                        }
                    }                     
             }
                if(e.getActionCommand().equals("-") ){
                    numeros[10].setEnabled(true);
                    auxiliar="";
                    if(tipoBoton==2){

                    }else if(tipoBoton==0){
                            if(jtexto.getText().equals("")){
                            numero1 = Float.parseFloat(jtexto2.getText());                    
                            auxiliar += jtexto.getText()+ jtexto2.getText();
                            jtexto.setText(auxiliar+" - ");
                            jtexto2.setText("");
                            tipoBoton = 2;
                        }
                        else{
                            if(!x){
                                numero1 = Float.parseFloat(jtexto2.getText());                    
                                auxiliar += jtexto2.getText();
                                jtexto.setText(auxiliar+" - ");
                                jtexto2.setText("");
                                tipoBoton = 2;
                            }
                            else{
                                numero1 = Float.parseFloat(jtexto2.getText());                    
                                auxiliar += jtexto.getText();
                                jtexto.setText(auxiliar+" - ");
                                jtexto2.setText("");
                                tipoBoton = 2;
                            }
                        }
                    }                    
                }
                if(e.getActionCommand().equals("*") ){
                    numeros[10].setEnabled(true);
                    auxiliar="";
                    if(tipoBoton==3){

                    }else if(tipoBoton==0){
                        if(jtexto.getText().equals("")){
                            numero1 = Float.parseFloat(jtexto2.getText());                    
                            auxiliar += jtexto.getText()+jtexto2.getText();
                            jtexto.setText(auxiliar+" * ");
                            jtexto2.setText("");
                            tipoBoton = 3;
                        }
                        else{
                            if(!x){
                                numero1 = Float.parseFloat(jtexto2.getText());                    
                                auxiliar += jtexto2.getText();
                                jtexto.setText(auxiliar+" * ");
                                jtexto2.setText("");
                                tipoBoton = 3;
                            }
                            else{
                                numero1 = Float.parseFloat(jtexto2.getText());                    
                                auxiliar += jtexto.getText();
                                jtexto.setText(auxiliar+" * ");
                                jtexto2.setText("");
                                tipoBoton = 3;
                            }
                        }
                    }                      
                }
                if(e.getActionCommand().equals("/") ){
                    numeros[10].setEnabled(true);
                    auxiliar="";
                    if(tipoBoton==4){

                    }else if(tipoBoton==0){
                        if(jtexto.getText().equals("")){
                            numero1 = Float.parseFloat(jtexto2.getText());                    
                            auxiliar += jtexto.getText()+jtexto2.getText();
                            jtexto.setText(auxiliar+" / ");
                            jtexto2.setText("");
                            tipoBoton = 4;
                        }
                        else{
                            if(!x){
                                numero1 = Float.parseFloat(jtexto2.getText());                    
                                auxiliar += jtexto2.getText();
                                jtexto.setText(auxiliar+" / ");
                                jtexto2.setText("");
                                tipoBoton = 4;
                            }
                            else{
                                numero1 = Float.parseFloat(jtexto2.getText());                    
                                auxiliar += jtexto.getText();
                                jtexto.setText(auxiliar+" / ");
                                jtexto2.setText("");
                                tipoBoton = 4;
                            }
                        }
                    }                      
                }
                if(e.getActionCommand().equals("=") && !jtexto2.getText().equals("")){
                    x = true;
                    if(tipoBoton==1){
                        tipoBoton = 0;
                        auxiliar="";
                        auxiliar+=jtexto.getText() + jtexto2.getText();
                        jtexto.setText(auxiliar);
                        numero2 = Float.parseFloat(jtexto2.getText());
                        resultado=numero1+numero2;
                        jtexto2.setText(String.valueOf(resultado));
                    }
                    else if(tipoBoton==2){ 
                        tipoBoton = 0;
                        auxiliar="";
                        auxiliar+=jtexto.getText()+jtexto2.getText();
                        jtexto.setText(auxiliar);
                        numero2 = Float.parseFloat(jtexto2.getText());
                        resultado=numero1-numero2;
                        jtexto2.setText(String.valueOf(resultado));
                    }
                    if(tipoBoton==3){
                        tipoBoton = 0;
                        auxiliar="";
                        auxiliar+=jtexto.getText()+jtexto2.getText();
                        jtexto.setText(auxiliar);
                        numero2 = Float.parseFloat(jtexto2.getText());
                        resultado=numero1*numero2;
                        jtexto2.setText(String.valueOf(resultado));
                    }
                    if(tipoBoton==4){ 
                        try{
                        if(Float.parseFloat(jtexto2.getText())!=0){
                            tipoBoton = 0;
                            auxiliar="";
                            auxiliar+=jtexto.getText()+jtexto2.getText();
                            jtexto.setText(auxiliar);
                            numero2 = Float.parseFloat(jtexto2.getText());
                            resultado=numero1/numero2;
                            jtexto2.setText(String.valueOf(resultado));
                        }
                        else{
                        ExceptionInInitializerError();
                        }
                           
                        }catch(Exception w){
                       
                            JOptionPane.showMessageDialog(null, "No se puede operar divison por 0");
                    }
                    }
                }
        }
    }
        
    
        

    private void ExceptionInInitializerError() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public boolean esNumero(String ax){

        try{
            int n = Integer.parseInt(ax);
            return true;
        }catch(NumberFormatException e){
            return false;
        }

    }

   
    }       
