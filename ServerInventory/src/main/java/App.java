
import com.sg.serverinventory.dao.ServerDao;
import com.sg.serverinventory.dao.ServerDaoInMemImpl;
import com.sg.serverinventory.dto.Server;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class App {
    public static void main(String[] args) {
        ServerDao dao = new ServerDaoInMemImpl();
        Server myServer = new Server();
        
        myServer.setName("web01");
        myServer.setIp("92.168.1.1");
        myServer.setManufacturer("Dell");
        myServer.setRam(8);
        myServer.setNumProcessors(9);
        myServer.setPurchaseDate(LocalDate.parse("2010-01-01", DateTimeFormatter.ISO_DATE));
        dao.addServer(myServer);
        
        myServer = new Server();
        myServer.setName("web02");
        myServer.setIp("92.168.1.2");
        myServer.setManufacturer("HP");
        myServer.setRam(16);
        myServer.setNumProcessors(24);
        myServer.setPurchaseDate(LocalDate.parse("2013-01-01", DateTimeFormatter.ISO_DATE));
        dao.addServer(myServer);
        
        myServer = new Server();
        myServer.setName("web03");
        myServer.setIp("92.168.1.3");
        myServer.setManufacturer("IBM");
        myServer.setRam(16);
        myServer.setNumProcessors(12);
        myServer.setPurchaseDate(LocalDate.parse("2014-01-01", DateTimeFormatter.ISO_DATE));
        dao.addServer(myServer);
        
        myServer = new Server();
        myServer.setName("web04");
        myServer.setIp("92.168.1.4");
        myServer.setManufacturer("Toshiba");
        myServer.setRam(32);
        myServer.setNumProcessors(64);
        myServer.setPurchaseDate(LocalDate.parse("2016-01-01", DateTimeFormatter.ISO_DATE));
        dao.addServer(myServer);
        
        myServer = new Server();
        myServer.setName("web05");
        myServer.setIp("92.168.1.5");
        myServer.setManufacturer("HP");
        myServer.setRam(8);
        myServer.setNumProcessors(32);
        myServer.setPurchaseDate(LocalDate.parse("2010-01-01", DateTimeFormatter.ISO_DATE));
        dao.addServer(myServer);
        
        List<Server> dells = dao.getServersByManufacturer("Dell");
        for(Server currentServer : dells) {
            System.out.println(currentServer.getName());
        }
        dells.stream()
             .forEach(s -> System.out.println(s.getName()));
        
        Map<String, List<Server>>  serverMap = dao.getAllServersGroupByManufacturer();
        Set<String> manufacturers = serverMap.keySet();
        manufacturers.stream()
                     .forEach(name -> {
                         System.out.println("============================");
                         System.out.println("Manufacturer:" + name);
                         serverMap.get(name).stream()
                                            .forEach(s -> System.out.println(s.getName()));
                     });
    }
}