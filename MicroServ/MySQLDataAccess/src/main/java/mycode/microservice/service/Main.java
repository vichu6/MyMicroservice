package mycode.microservice.service;


import mycode.microservice.service.Registry.RegistrationServer;
import mycode.microservice.service.ServiceDiscovery.ServiceDiscoverClientApplication;
import mycode.microservices.service.UserService.UserServer;


/**
 * Allow the servers to be invoked from the command-line. The jar is built with
 * this as the <code>Main-Class</code> in the jar's <code>MANIFEST.MF</code>.
 * 
 * @author Paul Chapman
 */
public class Main {

	public static void main(String[] args) {

		String serverName = "NO-VALUE";

		switch (args.length) {
		case 2:
			// TO override Http port to listen on 
			
			System.setProperty("server.port", args[1]);
			System.out.println(" server port has been set to "+args[1]+" for service name of "+args[0] );

		case 1:
			serverName = args[0].toLowerCase();
			break;

		default:
			usage();
			return;
		}

		if (serverName.equals("registration") || serverName.equals("reg")) {
			RegistrationServer.main(args);
		} else if (serverName.equals("users") || serverName.equals("usr")) {
			UserServer.main(args);
		} else if (serverName.equals("client") || serverName.equals("clnt")) {
			ServiceDiscoverClientApplication.main(args);
		} else {
			System.out.println("Unknown server type: " + serverName);
			usage();
		}
	}

	protected static void usage() {
		System.out.println("Usage: java -jar ... <server-name> [server-port]");
		System.out.println(
				"     where server-name is 'reg', 'registration', " + "'users' , 'usr'," + "'client , clnt'  and server-port > 1024");
	}
}
