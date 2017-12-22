package com.wxf.serviceport;

import android.util.Log;
import com.wxf.serviceport.interfaces.INetService;

import java.util.HashMap;

import fi.iki.elonen.NanoHTTPD;

/**
 * Created by Mikhael LOPEZ on 14/12/2015.
 */
public class AndroidWebServer extends NanoHTTPD {


    public AndroidWebServer(String hostname, int port) {
        super(hostname, port);
    }

    @Override
    public Response serve(IHTTPSession session) {
        Log.i("wxf", "serve: 访问"+  session.getMethod().name());
        if(session.getMethod() ==Method.POST){
            try {
                session.parseBody(new HashMap<String, String>());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
       INetService service  = ServiceContext.getService(session.getUri());
        String result = "";
        if(service!=null){
            result = service.deal(session);
        }else {
            result="error";
        }
        return newFixedLengthResponse(Response.Status.OK, "application/json;charset=UTF-8", result);
    }

}
