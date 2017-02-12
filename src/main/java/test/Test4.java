package test;

import com.online_exchange.model.Client;
import com.online_exchange.model.Exchanger;
import com.online_exchange.model.Transactionoffer;
import com.online_exchange.model.Transactionrequest;
import java.util.ArrayList;
import java.util.List;

public class Test4 {

    public static void main(String[] args) {

        Client client1 = new Client();
        client1.setEmail("pera@gmail.com");
        client1.setPassword("macka123");
        client1.setId(1);
        
        
        Exchanger exchanger1 = new Exchanger();
        exchanger1.setName("Panter");
        exchanger1.setPassword("omglol");
        exchanger1.setId(1);
        Exchanger exchanger2 = new Exchanger();
        exchanger2.setName("Pirana");
        exchanger2.setPassword("roflmao");
        exchanger1.setId(2);
        
        Transactionrequest request1 = new Transactionrequest();
        request1.setAmount(450);
        request1.setClient(client1);
        request1.setRate(120);
        request1.setId(1);
        
        List<Transactionrequest> requests = new ArrayList<Transactionrequest>();
        requests.add(request1);
        
        
        Transactionoffer offer1 = new Transactionoffer();
        offer1.setAmount(450);
        offer1.setRate(119);
        offer1.setId(1);
        offer1.setClient(client1);
        offer1.setExchanger(exchanger1);
        offer1.setTransactionRequest(request1);
        
        Transactionoffer offer2 = new Transactionoffer();
        offer2.setAmount(450);
        offer2.setRate(121);
        offer2.setId(2);
        offer2.setClient(client1);
        offer2.setExchanger(exchanger2);
        offer2.setTransactionRequest(request1);
        
        List<Transactionoffer> offers = new ArrayList<Transactionoffer>();
        offers.add(offer1);
        offers.add(offer2);
        request1.setTransactionofferCollection(offers);
        
        client1.setTransactionrequestCollection(requests);
        client1.setTransactionofferCollection(offers);
        
        List<Transactionoffer> offersFromExchanger1 = new ArrayList<Transactionoffer>();
        offersFromExchanger1.add(offer1);
        
        List<Transactionoffer> offersFromExchanger2 = new ArrayList<Transactionoffer>();
        offersFromExchanger2.add(offer2);
        
        exchanger1.setTransactionofferCollection(offersFromExchanger1);
        exchanger2.setTransactionofferCollection(offersFromExchanger2);
    }

}
