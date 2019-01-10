import org.BookMyShow.BookMyShowThrift;
import org.BookMyShow.Repository.InventoryRepository;
import org.BookMyShow.Repository.UserRepository;
import org.BookMyShow.thrift.gen.*;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.THttpClient;
import org.apache.thrift.transport.TTransport;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

//TODO :
// use mockito to mock repo
// do server side tests - don't call from thrift client
// organise the test folder

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = BookMyShowThrift.class)
public class BookMyShowClientTests {


    @Value("${local.server.port}")
    protected int port;

    @Autowired
    private UserRepository userRepository;
    /*@Autowired
    private InventoryRepository inventoryRepository;
*/
    private  MovieTService.Client client;
    private  UserTService.Client clientU;
    private  ShowTService.Client clientSh;
    private  SeatTService.Client clientSt;
//    @Mock UserRepository us
    @Before
    public void setUp() throws Exception{
        THttpClient transport = new THttpClient("http://localhost:"+port+"/movie");
        TProtocol protocol = new TBinaryProtocol(transport);
        client = new MovieTService.Client(protocol);

        transport = new THttpClient("http://localhost:"+port+"/user");
        protocol = new TBinaryProtocol(transport);
        clientU = new UserTService.Client(protocol);

        transport = new THttpClient("http://localhost:"+port+"/show");
        protocol = new TBinaryProtocol(transport);
        clientSh = new ShowTService.Client(protocol);

        transport = new THttpClient("http://localhost:"+port+"/seat");
        protocol = new TBinaryProtocol(transport);
        clientSt = new SeatTService.Client(protocol);

    }
    @Test
    public void testMovieAll() throws Exception{
        System.out.println(client.getAllMovie());
    }
    @Test
    public void testUserServices() throws Exception{
        //String str = "User Added!";
        //System.out.println("------------->Inside Second test....");
        //when(repo.save(a,b).then)
        String out= clientU.registerUser("test","test");
        //System.out.println("------------->"+out);
        //System.out.println();
        Assert.assertTrue(out.equals("User Added!"));
        Assert.assertTrue(clientU.loginUser("test","test"));

        userRepository.delete(userRepository.findByUname("test"));
    }
    @Test
    public void testShowServices() throws Exception{
        System.out.println(clientSh.getAllShow());
        System.out.println(clientSh.getShows("5c2f1999176c44eaa7afaeac","12-1-19"));
    }
    @Test
    public void testSeatServices() throws Exception{
        System.out.println(clientSt.getSeats(new ShowThrift("5c2f255fe9b8d42e46cbc902","5c2df0ffdb0c2b2aee2f9566",
                "5c2f1999176c44eaa7afaeac","12-1-19")));
        System.out.println("--->");
        List<String> input = Arrays.asList("5c2f3868e9b8d42e46cbc904","5c2f38e8e9b8d42e46cbc906");
        System.out.println(clientSt.bookSeats(input,"12-1-19"));
    }
    @AfterClass
    public static void wrapUp(){
        System.out.println("All tests done!");

    }
}
