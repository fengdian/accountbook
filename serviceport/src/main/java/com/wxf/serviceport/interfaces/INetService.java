package com.wxf.serviceport.interfaces;

import fi.iki.elonen.NanoHTTPD;

/**
 * Created by FB on 2017/6/14.
 */

public interface INetService {

    public String deal(NanoHTTPD.IHTTPSession session);

}
