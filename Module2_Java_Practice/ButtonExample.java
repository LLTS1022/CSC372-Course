//import javax.swing.*;    

//public class ButtonExample extends JFrame {  
//public static void main(String[] args) {  
   // JFrame f=new JFrame("Button Example");  
    //JButton b=new JButton("Click Here");  
    //b.setBounds(50,100,95,30);  
    //f.add(b);  
    //f.setSize(400,400);  
    //f.setLayout(null);  
    //f.setVisible(true);   
//}  
//}  



import javax.swing.*; 

public class ButtonExample extends JFrame {
    public ButtonExample() {
        setTitle("Button Example");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 100);

         JFrame f=new JFrame("Button Example");  
    JButton b=new JButton("Click Here");  
    b.setBounds(50,100,95,30);  
    f.add(b);  
    f.setSize(400,400);  
    f.setLayout(null);  
    f.setVisible(true); 
    }

}