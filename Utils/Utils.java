
public class Utils {
    public static String getFileExString(String Name){
    int pointIndex= Name.lastIndexOf(".");
    if(pointIndex==-1){
    return null;
    }
    if(pointIndex==Name.length()-1){
     return null;   
    }
    return Name.substring(pointIndex+1,Name.length());
    
    
    }
    
    
}
