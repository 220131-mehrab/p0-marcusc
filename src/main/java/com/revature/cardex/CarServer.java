package com.revature.cardex;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;



public class CarServer {
    private Server server;

    public void start() throws Exception{
        server = new Server();
        ServerConnector connector = new ServerConnector(server);
            connector.setPort(8090);
            server.setConnectors(new Connector[] {connector});
    }
}
