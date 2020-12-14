package ad01_ej2_narvaizarafael;


import java.io.IOException;
import java.io.RandomAccessFile;



public class ServiceRecord extends Service{
    
    public static final int SIZE = Integer.BYTES + Character.BYTES * 3 + Character.BYTES * 35 + Character.BYTES * 35 + Integer.BYTES;
    

    public ServiceRecord() {
    this(0,"","","",0);
    }
    
    public ServiceRecord(int order, String code, String service, String worker, int cost){
        super(order, code, service, worker, cost);
    }
    
    
    private String readString(RandomAccessFile file, int size) throws IOException{
        char[] s = new char[size];
        for (int i = 0; i < s.length; i++){
            s[i] = file.readChar();
            
        }
        
     //   System.out.println("readString has been used");
        return new String(s).replace('\0', ' ');
    }
    
    
    private void writeString(RandomAccessFile file, String s, int size) throws IOException {
        StringBuffer buffer = null;
        if (s != null){
            buffer = new StringBuffer(s);
        }
        else{
            buffer = new StringBuffer(size);
        }
        buffer.setLength(size);
        file.writeChars(buffer.toString());

      //  System.out.println("writeString has been used");
    }
    
    
    public void readFromFile(RandomAccessFile file) throws IOException {

        setOrder(file.readInt());
        setCode(readString(file, 3));
        setServiceName(readString(file, 35));
        setWorker(readString(file, 35));
        setCost(file.readInt());

      //  System.out.println("readFromFile has been used");
    }
    
    
    public void writeToFile(RandomAccessFile file) throws IOException{
        file.writeInt(getOrder());
        writeString(file,getCode(),3);
        writeString(file, getServiceName(), 35);
        writeString(file,getWorker(), 35);
        file.writeInt(getCost());

      //  System.out.println("writeToFile has been used");
    }


}
