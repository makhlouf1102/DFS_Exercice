package devices;
import java.util.*;
public abstract class Device {
    private final int id;
    private boolean isVisited = false;
    protected String type;
    protected List<Device> connectedDevices = new LinkedList<Device>();

    public Device(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public List<Device> getConnectedDevices() {
        return connectedDevices;
    }

    public void connect(Device d) {
        this.connectedDevices.add(d);
    }

    public boolean isVisited(){
        return this.isVisited;
    }

    public void setVisited(boolean b){
        this.isVisited = b;
    }

    public boolean canCommunicateWith(Device device){
        return dfsRecursively(this, device);
    }

    private boolean dfsRecursively(Device current, Device wanted) {
        current.setVisited(true);
        System.out.print(current);
        if (current.equals(wanted)){
            return true;
        }
        for (Device d: current.connectedDevices) {
            if (!d.isVisited()) {
                System.out.print(" -> ");
                if (dfsRecursively(d, wanted)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return this.type + " (" + this.id + ")";
    }
}
