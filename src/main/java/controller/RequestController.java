package controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * Created by denx7 on 10.12.2017.
 */
public class RequestController {


    public String getRequest(String url) {

        try {
            Client client = Client.create();
            WebResource webResource = client.resource(url);
            ClientResponse response = webResource.accept("application/json")
                    .header("Content-Type", "application/json;charset=UTF-8")
                    //.header() //  если нужны заголовки
                    .get(ClientResponse.class);

            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatus());
            }

            String output = response.getEntity(String.class);
            System.out.println("Получен ответ от сервера по get запросу " + url + " .... \n");
            System.out.println(output);

            return output;
        }catch (Exception e){
            e.printStackTrace();

        }
        return null;
    }


    public String postRequest(String url, String postBody){
        try {
            Client client = Client.create();
            WebResource webResource = client.resource(url);
            ClientResponse response = webResource.type("application/json")
                    .header("Content-Type", "application/json;charset=UTF-8")
                    .post(ClientResponse.class, postBody);

            if (response.getStatus() != 201) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatus());
            }

            System.out.println("Получен ответ от сервера по post запросу " + url + " .... \n");
            String output = response.getEntity(String.class);
            System.out.println(output);


        }catch (Exception e){
            e.printStackTrace();
        }

        return null;

    }




}
