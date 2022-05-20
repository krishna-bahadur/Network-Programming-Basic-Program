//Write a program that lists all the active network interface of machine and display its properties.

import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;

public class Qns2 {
    public static void main(String[] args) {
        try {
            ArrayList<NetworkInterface> interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
            System.out.println("Information about current network interfaces...\n");
            for(NetworkInterface NI: interfaces){
                if(NI.isUp()){
                    System.out.println("Interface Name: "+NI.getName());
                    System.out.println("Interface display name: "+NI.getDisplayName());
                    System.out.println("Hardware address: "+NI.getHardwareAddress());
                    System.out.println("Parent :"+NI.getParent());
                    System.out.println("Index: "+NI.getIndex());

                    System.out.println("\nInterface addresses :");

                    for (InterfaceAddress address:NI.getInterfaceAddresses()){
                        System.out.println("\t\t"+address.getAddress().toString());
                    }

                    System.out.println("\nInetAddress associated with this interface: ");
                    Enumeration<InetAddress> en = NI.getInetAddresses();
                    while (en.hasMoreElements()) {
                        System.out.println("\t\t" + en.nextElement().toString());
                    }
                    System.out.println("\tMTU: " + NI.getMTU());
                    System.out.println("\tSubinterfaces: " + Collections.list(NI.getSubInterfaces()));
                    System.out.println("\tis loopback: " + NI.isLoopback());
                    System.out.println("\tis virtual: " + NI.isVirtual());
                    System.out.println("\tis point to point: " + NI.isPointToPoint());
                    System.out.println("Supports Multicast: " + NI.supportsMulticast());

                    NetworkInterface nif = NetworkInterface.getByIndex(1);
                    System.out.println("Network interface 1: " + nif.toString());
                    NetworkInterface nif2 = NetworkInterface.getByName("eth0");
                    InetAddress ip = InetAddress.getByName("localhost");
                    NetworkInterface nif3 = NetworkInterface.getByInetAddress(ip);
                    System.out.println("\nlocalhost associated with: " + nif3);
                    boolean eq = nif.equals(nif2);
                    System.out.println("nif==nif2: " + eq);
                    System.out.println("Hashcode : " + nif.hashCode());
                }
            }

        }
        catch (Exception ex){
            System.out.println("Error :" + ex);
        }
    }
}
