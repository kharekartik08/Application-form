
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.VK_ENTER;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;



public class FormPanel extends JPanel{
    private JLabel name;
    private JLabel occupation;
    private JTextField nameFeild;
    private JTextField occupationFeild;
    private JButton okbtn;
    private FormListener formListener;
    private JList ageList;
    private JComboBox empCombo;
    private JLabel employment;
    private JLabel selectage;
    private JCheckBox citizenCheck;
    private JTextField tax;
    private JLabel textLabel;
    private JRadioButton maleRadio;
    private JRadioButton femaleRadio;
    private ButtonGroup genderGroup;
    
        
    public FormPanel(){
        Dimension dim = getPreferredSize();
        dim.width=250;
        name=new JLabel("Name:");
        occupation= new JLabel("Occupation:");
        nameFeild= new JTextField(10);
        occupationFeild=new JTextField(10);
        ageList= new JList();
        okbtn= new JButton("Submit");
        okbtn.setMnemonic(KeyEvent.VK_S);
        
        
        empCombo= new JComboBox();
        employment= new JLabel("Employment:");
        selectage=new JLabel("Select Age:");
        citizenCheck= new JCheckBox();
        tax= new JTextField(10);
        textLabel= new JLabel("TAX ID ");
        textLabel.setEnabled(false);
        tax.setEnabled(false);
        maleRadio= new JRadioButton("Male");
        femaleRadio= new JRadioButton("Female");
        genderGroup= new ButtonGroup();
        maleRadio.setActionCommand("male");
        femaleRadio.setActionCommand("female");
        
        
        citizenCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isTicked= citizenCheck.isSelected();
                tax.setEnabled(isTicked);
                textLabel.setEnabled(isTicked);
            
            
            }
        });
        //set up list box
        DefaultListModel ageModel= new DefaultListModel();
                ageModel.addElement(new AgeCategory(0,"Under 18"));
                ageModel.addElement(new AgeCategory(1,"18 to 65"));
                ageModel.addElement(new AgeCategory(2,"above 65"));
                //combobox item add
                DefaultComboBoxModel empModel = new DefaultComboBoxModel();
                empModel.addElement("Employed");
                empModel.addElement("Self-Employed");
                empModel.addElement("Un-Employed");
                empCombo.setModel(empModel);
                
                
                genderGroup.add(maleRadio);
                genderGroup.add(femaleRadio);
                
                ageList.setModel(ageModel);
                ageList.setPreferredSize(new Dimension(110,66));
                ageList.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
                okbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nameget= nameFeild.getText();
                String occupationget=occupationFeild.getText();
                AgeCategory ageCat= (AgeCategory)ageList.getSelectedValue();
                String empCat =(String)empCombo.getSelectedItem();
                String taxId=tax.getText();
                boolean indian=citizenCheck.isSelected();
                String gender=genderGroup.getSelection().getActionCommand();
                System.out.println(empCat);
                
                
                
                FormEvent ev=new FormEvent(this,nameget,occupationget,ageCat.getId(),empCat,taxId,indian,gender);
                if (formListener!= null){
                
                formListener.formEventOccurred(ev);
                        
                }
            }
        });
        
        setPreferredSize(dim);
        Border innerBorder = BorderFactory.createTitledBorder("Add person");
        Border outerBorder= BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
        
        layoutComponents();
    }
public void layoutComponents(){
setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
gc.gridy=0;
//first row
//use insets for pading
        gc.weightx=1;
        gc.weighty=.1;
        gc.gridx=0;
        gc.anchor= GridBagConstraints.LINE_START; 
        gc.fill=GridBagConstraints.NONE;
        add(name,gc);
        gc.gridx=1;
        add(nameFeild,gc);
        
//second row
gc.gridy++;
        gc.weightx=1;
        gc.weighty=.01;
        gc.gridx=0;
        //use insets for pading
        add(occupation,gc);
        gc.gridx=1;
        add(occupationFeild,gc);
//thrird row
gc.gridy++;
        gc.weightx=1;
        gc.weighty=.1;
        gc.gridx=0;
        gc.anchor=GridBagConstraints.LINE_START;
        add(selectage,gc);
        gc.gridx=1;
        //use insets for pading
        gc.anchor=GridBagConstraints.LAST_LINE_START;
        add(ageList,gc);

gc.gridy++;
        gc.weightx=1;
        gc.weighty=.1;
        gc.gridx=0;
        gc.anchor=GridBagConstraints.LINE_START;
        add(employment,gc);
        gc.gridx=1;
        //use insets for pading
        gc.anchor=GridBagConstraints.LAST_LINE_START;
        add(empCombo,gc);
        
        gc.gridy++;
        gc.weightx=1;
        gc.weighty=.1;
        gc.gridx=0;
        gc.anchor=GridBagConstraints.LINE_START;
        add(new JLabel("India Citizen:"),gc);
        gc.gridx=1;
        //use insets for pading
        gc.anchor=GridBagConstraints.LAST_LINE_START;
        add(citizenCheck,gc);

        gc.gridy++;
        gc.weightx=1;
        gc.weighty=.1;
        gc.gridx=0;
        add(new JLabel("TAX :"),gc);
        gc.gridx=1;
        //use insets for pading
        gc.anchor=GridBagConstraints.LAST_LINE_START;
        add(tax,gc);
        
        
        gc.gridy++;
        gc.weightx=1;
        gc.weighty=.001;
        gc.gridx=0;
        gc.anchor=GridBagConstraints.LINE_START;
        add(new JLabel("Gender :"),gc);
        gc.gridx=1;
        //use insets for pading
        gc.anchor=GridBagConstraints.LAST_LINE_START;
        add(maleRadio,gc);
        
        gc.gridy++;
        gc.weightx=1;
        gc.weighty=.001;
        gc.gridx=1;
        //use insets for pading
        gc.anchor=GridBagConstraints.LAST_LINE_START;
        add(femaleRadio,gc);
        


        //forth row
        gc.gridy++;
        gc.weightx=1;
        gc.weighty=2;
        gc.gridx=1;
        //use insets for pading
        gc.anchor=GridBagConstraints.LAST_LINE_START;
        add(okbtn,gc);
        
        

}


    
public void setFormListener(FormListener listener){
this.formListener=listener;
}
class AgeCategory{
private int id;
private String text;
    public AgeCategory(int id, String text)
{
    this.id=id;
    this.text=text;
    
}
public String toString(){

    return text;

}
public int getId(){
return id;
}
}    
    
}
