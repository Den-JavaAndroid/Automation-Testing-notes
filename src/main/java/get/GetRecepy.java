package get;

import com.google.gson.Gson;
import controller.RequestController;
import model.Recepy;

/**
 * Created by denx7 on 10.12.2017.
 */
public class GetRecepy {

    public static Recepy getRecepy(String url){
        Gson gson = new Gson();
        RequestController requestController = new RequestController();
        String recepyResponce = requestController.getRequest(url);
        Recepy recepyRs = gson.fromJson(recepyResponce, Recepy.class);
        return recepyRs;
    }

}
