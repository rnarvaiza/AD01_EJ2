package ad01_ej2_narvaizarafael;

import java.io.IOException;
import java.io.RandomAccessFile;


public class FileEditor {
    
    RandomAccessFile file;
    
    public FileEditor(String fileString) throws IOException{
        file = new RandomAccessFile(fileString, "rw");
       // System.out.println("RAF has been started.");
    }
    
    
    public void close() throws IOException{
        if(file!=null){
            file.close();
           // System.out.println("File has been closed");
        }
    }
    
    
    public ServiceRecord getRecord(int order) throws IOException{
        ServiceRecord record = new ServiceRecord();
        if(order < 1) throw new IllegalArgumentException("Invalid order");
        file.seek((order-1) * ServiceRecord.SIZE);
        record.readFromFile(file);
        return record;
    }
    
    
    public void insertRecord(ServiceRecord record) throws IllegalArgumentException, IOException{
        file.seek((record.getOrder()-1) * ServiceRecord.SIZE);
        record.writeToFile(file);
       // System.out.println("Record has been added.");
    }

    
    public void updateRecord(ServiceRecord record) throws IllegalArgumentException, IOException{
        if(getRecord(record.getOrder()).getOrder() == 0){
            System.out.println("Record does not exist. Update failed.");
        }
        else{
            file.seek((record.getOrder() - 1) * ServiceRecord.SIZE);
            record.writeToFile(file);
        }
    }
  
    
    public void deleteRecord(ServiceRecord record) throws IllegalArgumentException, IOException{
        if(getRecord(record.getOrder()).getOrder() == 0){
            System.out.println("Record does not exist. Delete failed.");
        }
        else{
            file.seek((record.getOrder() - 1) * ServiceRecord.SIZE);
            record = new ServiceRecord();
            record.writeToFile(file);
        }
    }

    
    public void showRecords(){
        ServiceRecord record = new ServiceRecord();
        try{
            file.seek(0);
            while(true){
                do{
                    record.readFromFile(file);
                } while(record.getOrder() == 0);
                System.out.println(record.toString());
               // System.out.println("showRecords has been started");
            }

        }
        catch (IOException e){
            System.out.println(e.getMessage());  
        }
    }

    public ServiceRecord getServiceRecord(int order) throws IOException{
        ServiceRecord serviceRecord = new ServiceRecord();
        file.seek((order - 1) * ServiceRecord.SIZE);
        serviceRecord.readFromFile(file);
        return serviceRecord;
    }


}
