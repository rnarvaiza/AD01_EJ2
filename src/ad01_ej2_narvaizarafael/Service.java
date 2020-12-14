
package ad01_ej2_narvaizarafael;

/**
 * @author rnarvaiza
 */

public class Service {

    /**
     * Service class is designed to store the different variables that a service contains.
     */

    /**
     * Variables instantiating.
     */

    private int order;
    private String code;
    private String serviceName;
    private String worker;
    private int cost;

    /**
     * Void constructor.
     */


    public Service(){
    this(0,"","","",0);
    }

    /**
     * Constructor throw parameters.
     * @param order
     * @param code
     * @param serviceName
     * @param worker
     * @param cost
     */
    
    public Service(int order, String code, String serviceName, String worker, int cost){
        super();
        setOrder(order);
        setCode(code);
        setServiceName(serviceName);
        setWorker(worker);
        setCost(cost);
    }

    /**
     * Setters & Getters.
     * @return
     */

    public int getOrder() { return order;}

    public void setOrder(int order) {this.order = order;}

    public String getCode() {return code;}

    public void setCode(String code) {this.code = code;}

    public String getServiceName() {return serviceName;}

    public void setServiceName(String serviceName) {this.serviceName = serviceName;}

    public String getWorker() {return worker;}

    public void setWorker(String worker) {this.worker = worker;}

    public int getCost() {return cost;}

    public void setCost(int cost) {this.cost = cost;}
    
    
    
    @Override
    
    public String toString(){
        return "Person [ORDER=" + order 
                + ", code = " + code 
                + ", service = " + serviceName
                + ", worker= " + worker 
                + ", cost = " + cost + "]";
    }
    
}
