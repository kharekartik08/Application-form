
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.VK_X;
import static java.util.Locale.filter;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;


@SuppressWarnings("serial")
public class MainFrame extends JFrame{
    private JButton btn;
    private TextPanel textPanel;
    private Toolbar toolbar;
    private FormPanel formPanel;
    private JFileChooser fileChooser;
    

    public MainFrame(){
    super("Hello... Enter ur detail bitch");
        btn = new JButton("Click Kar");
        textPanel = new TextPanel();
        toolbar= new Toolbar();
        formPanel = new FormPanel();
        fileChooser= new JFileChooser();
        
        fileChooser.addChoosableFileFilter(new PersonFileFilter());
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("PDF Documents", "pdf"));
        fileChooser .addChoosableFileFilter(new FileNameExtensionFilter("MS Office Documents", "docx", "xlsx", "pptx"));
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "png", "gif", "bmp"));
        setJMenuBar(createMenuBar());
        
        toolbar.setTextPanel(textPanel);
        setLayout(new BorderLayout());
        
        
        
        
        
        btn.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        textPanel.appendText("Hello........\n");
        
        
        }
    });
        formPanel.setFormListener(new FormListener(){
        public void formEventOccurred (FormEvent e){
                String name= e.getName();
                String occupation=e.getOccupation();
                int ageCat=e.getAgeCategory();
                String empCat= e.getEmploymentCategory();
                String tax=e.getTaxId();
                boolean citizen= e.isIndianCitizen();
                String gender=e.getGender();
                char ch=e.getGender().charAt(0);
        textPanel.appendText(name+" : "+occupation+" : "+ageCat+":"+empCat+":"+tax+":"+citizen+":"+ch+"\n");
            }
        });
        
        
        
        add(toolbar,BorderLayout.NORTH);
        add(btn,BorderLayout.SOUTH);
        add(textPanel,BorderLayout.CENTER);
        add(formPanel,BorderLayout.WEST);
        
        
        
        
        setVisible(true);
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
   }
   private JMenuBar createMenuBar(){
   JMenuBar menuBar= new JMenuBar();
   JMenu fileMenu= new JMenu("File");
   JMenu windowMenu= new JMenu("Window");
   
       JMenuItem exportDataItem= new JMenuItem("Export Data.");
       JMenuItem importDataItem= new JMenuItem("Import Data.");
       JMenuItem exitItem= new JMenuItem("Exit");
       fileMenu.add(exportDataItem);
       fileMenu.addSeparator();
       fileMenu.add(importDataItem);
       fileMenu.addSeparator();
       fileMenu.add(exitItem);
       
       importDataItem.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) {
           if (fileChooser.showOpenDialog(MainFrame.this)==JFileChooser.APPROVE_OPTION){
               System.out.println(fileChooser.getSelectedFile());
           
           }
       
       
       }
   });
       JMenu showMenu= new JMenu("Show");
       
       JCheckBoxMenuItem showFormItem= new JCheckBoxMenuItem("Person From");
       showFormItem.setSelected(true);
       
       showMenu.add(showFormItem);
       windowMenu.add(showMenu);
       
       
       menuBar.add(fileMenu);
       menuBar.add(windowMenu);
       showFormItem.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent ev) {
          JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem)ev.getSource();
          formPanel.setVisible(menuItem.isSelected());
       
       }
   });
       fileMenu.setMnemonic(KeyEvent.VK_F);
       exitItem.setMnemonic(KeyEvent.VK_X);
       exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
       exitItem.addActionListener(new ActionListener() {
      
           
           public void actionPerformed(ActionEvent e) {
               JOptionPane.showInputDialog(MainFrame.this,"USER NAME MC","USERNAME POP_UP",JOptionPane.OK_OPTION|JOptionPane.INFORMATION_MESSAGE);
               
               int action=JOptionPane.showConfirmDialog(MainFrame.this,"Bahar Jana Chahta h Kya Bhadwe??","Confirm Exit",JOptionPane.OK_CANCEL_OPTION);
               if(action==JOptionPane.OK_OPTION)
               System.exit(0);
           }
   });
       
       return menuBar;
           
   }
    
    
    
    
}
