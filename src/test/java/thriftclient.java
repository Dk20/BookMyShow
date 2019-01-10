import org.BookMyShow.thrift.gen.SeatTService;
import org.BookMyShow.thrift.gen.ShowTService;
import org.BookMyShow.thrift.gen.ShowThrift;
import org.BookMyShow.thrift.gen.UserTService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TJSONProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.THttpClient;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.Arrays;
import java.util.List;

public class thriftclient {

    //private static UserTService.Client clientU;
    private static ShowTService.Client clientS;
    private static SeatTService.Client clientSeat;



    public static void main(String[] args) throws TException {
        THttpClient tHttpClient = new THttpClient("http://localhost:8080/show");
        TProtocol protocol =  new TBinaryProtocol(tHttpClient);
        clientS = new ShowTService.Client(protocol);

        System.out.println(clientS.getAllShow());
        System.out.println(clientS.getShows("5c2f1999176c44eaa7afaeac","12-1-19"));

        tHttpClient = new THttpClient("http://localhost:8080/seat");
        protocol =  new TBinaryProtocol(tHttpClient);
        clientSeat = new SeatTService.Client(protocol);
        System.out.println();
        System.out.println(clientSeat.getSeats(new ShowThrift("5c2f255fe9b8d42e46cbc902","5c2df0ffdb0c2b2aee2f9566",
                "5c2f1999176c44eaa7afaeac","12-1-19")));
        System.out.println("--->");
        List<String> input = Arrays.asList("5c2f3868e9b8d42e46cbc904","5c2f38e8e9b8d42e46cbc906");
        System.out.println(clientSeat.bookSeats(input,"12-1-19"));
    }
}
