
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;


public class Toolbar extends JPanel implements ActionListener{
    
    private JButton helloButton;
    private JButton goodbyeButton;
    private TextPanel textPanel;
    public Toolbar(){
        setBorder(BorderFactory.createMatteBorder(3,3 ,3,3, Color.BLUE));
        
        helloButton= new JButton("HELLO");
        goodbyeButton = new JButton("Good bye");
    
        setLayout(new FlowLayout());
        add(helloButton);
        add(goodbyeButton);
        helloButton.addActionListener(this);
        goodbyeButton.addActionListener(this);
        
    }
    public void setTextPanel(TextPanel textPanel){
    this.textPanel=textPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    
        JButton clicked= (JButton)e.getSource();
        if (clicked == helloButton)
        {
            textPanel.appendText("hello button\n");
            
        }
        else if(clicked == goodbyeButton)
        {
        textPanel.appendText("Good ye button \n" );
        
        
        }
    
    
    }
    
}
