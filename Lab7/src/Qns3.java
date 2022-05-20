import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;


public class Qns3 {
    private final static int PORT = 13;
    private final static Logger audit = Logger.getLogger("requests");
    private final static Logger errors = Logger.getLogger("errors");

    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(PORT)) {
            while (true) {
                try {
                    DatagramPacket request = new DatagramPacket(new byte[1024], 1024);
                    socket.receive(request);
                    String daytime = new Date().toString();
                    byte[] data = daytime.getBytes("US-ASCII");
                    DatagramPacket response = new DatagramPacket(data, data.length,
                            request.getAddress(), request.getPort());
                    socket.send(response);
                    audit.info(daytime + " " + request.getAddress());
                } catch (IOException | RuntimeException ex) {
                    errors.log(Level.SEVERE, ex.getMessage(), ex);
                }
            }
        } catch (IOException ex) {
            errors.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}


public class UDPTimeClient {
    public final static int PORT = 37;
    public final static String DEFAULT_HOST = "time.nist.gov";

    public static void main(String[] args) {
        InetAddress host;
        try {
            if (args.length > 0) {
                host = InetAddress.getByName(args[0]);
            } else {
                host = InetAddress.getByName(DEFAULT_HOST);
            }
        } catch (RuntimeException | UnknownHostException ex) {
            System.out.println("Usage: java UDPTimeClient [host]");
            return;
        }

        UDPPoke poker = new UDPPoke(host, PORT);
        byte[] response = poker.poke();
        if (response == null) {
            System.out.println("No response within allotted time");
            return;
        } else if (response.length != 4) {
            System.out.println("Unrecognized response format");
            return;
        }
        // The time protocol sets the epoch at 1900,
        // the Java Date class at 1970. This number
        // converts between them.
        long differenceBetweenEpochs = 2208988800L;
        long secondsSince1900 = 0;
        for (int i = 0; i < 4; i++) {
            secondsSince1900 = (secondsSince1900 << 8) | (response[i] & 0x000000FF);
        }
        long secondsSince1970 = secondsSince1900 - differenceBetweenEpochs;
        long msSince1970 = secondsSince1970 * 1000;
        Date time = new Date(msSince1970);
        System.out.println(time);
    }
}




public class UDPPoke {
    private int bufferSize; // in bytes
    private int timeout; // in milliseconds
    private InetAddress host;
    private int port;

    public UDPPoke(InetAddress host, int port, int bufferSize, int timeout) {
        this.bufferSize = bufferSize;
        this.host = host;
        if (port < 1 || port > 65535) {
            throw new IllegalArgumentException("Port out of range");
        }
        this.port = port;
        this.timeout = timeout;
    }

    public UDPPoke(InetAddress host, int port, int bufferSize) {
        this(host, port, bufferSize, 30000);
    }

    public UDPPoke(InetAddress host, int port) {
        this(host, port, 8192, 30000);
    }

    public byte[] poke() {
        try (DatagramSocket socket = new DatagramSocket(0)) {
            DatagramPacket outgoing = new DatagramPacket(new byte[1], 1, host, port);
            socket.connect(host, port);
            socket.setSoTimeout(timeout);
            socket.send(outgoing);
            DatagramPacket incoming = new DatagramPacket(new byte[bufferSize], bufferSize);
            // next line blocks until the response is received
            socket.receive(incoming);
            int numBytes = incoming.getLength();
            byte[] response = new byte[numBytes];
            System.arraycopy(incoming.getData(), 0, response, 0, numBytes);
            return response;
        } catch (IOException ex) {
            return null;
        }
    }

    public static void main(String[] args) {
        InetAddress host;
        int port = 0;
        try {
            host = InetAddress.getByName(args[0]);
            port = Integer.parseInt(args[1]);
        } catch (RuntimeException | UnknownHostException ex) {
            System.out.println("Usage: java UDPPoke host port");
            return;
        }
        try {
            UDPPoke poker = new UDPPoke(host, port);
            byte[] response = poker.poke();
            if (response == null) {
                System.out.println("No response within allotted time");
                return;
            }
            String result = new String(response, "US-ASCII");
            System.out.println(result);
        } catch (UnsupportedEncodingException ex) {
            // Really shouldn't happen
            ex.printStackTrace();
        }
    }
}