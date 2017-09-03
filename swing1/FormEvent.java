
import java.util.EventObject;


public class FormEvent extends EventObject {
    private String name;
    private String occupation;
    private int ageCategory;
    private String empCat;
    private String taxId;
    private boolean indianCitizen;
    private String gender;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    
    public FormEvent(Object source) {
        super(source);
    }
    
    public FormEvent(Object source, String name,String occupation,int ageCat, String empCat,String taxId,boolean indianCitizen,String gender) {
        super(source);
        this.name= name;
        this.occupation=occupation;
        this.ageCategory=ageCat;
        this.empCat= empCat;
        this.taxId=taxId;
        this.indianCitizen = indianCitizen;
        this.gender=gender;
    }
    
    
    
    
    public String getName() {
        return name;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public boolean isIndianCitizen() {
        return indianCitizen;
    }

    public void setIndianCitizen(boolean indianCitizen) {
        this.indianCitizen = indianCitizen;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
    public int getAgeCategory(){
    return ageCategory;
    
    }
    public String getEmploymentCategory(){
        return empCat;
    
    }

}
