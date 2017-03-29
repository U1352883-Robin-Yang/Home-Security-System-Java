import ClientAndServer.*;
import org.omg.CORBA.*;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.*;
import java.util.Properties;
import javax.swing.*;
import java.awt.event.*;

class ClientSensorServant extends ClientSensorPOA{
	
	private ClientAndServer.Relay relay;
	private ORB orb;
	private Sensor parent;
	
	public ClientSensorServant(Sensor parentGUI, ORB orb_val){
		parent = parentGUI;
		orb = orb_val;
		try {
			// Initialize the ORB
			System.out.println("Initializing the ORB");
			//ORB orb = ORB.init(args, null);
			Properties prop = new Properties();
			prop.put("org.omg.CORBA.ORBInitialPort","1050");
			prop.put("org.omg.CORBA.ORBInitialPort","localhost");

			// Get a reference to the Naming service
			org.omg.CORBA.Object nameServiceObj = 
					orb.resolve_initial_references ("NameService");
			if (nameServiceObj == null) {
				System.out.println("nameServiceObj = null");
				return;
			}

			// Use NamingContextExt instead of NamingContext. This is 
			// part of the Interoperable naming Service.  
			NamingContextExt nameService = NamingContextExtHelper.narrow(nameServiceObj);
			if (nameService == null) {
				System.out.println("nameService = null");
				return;
			}
			String name = parent.homeHubName;
			// resolve the Count object reference in the Naming service
			relay = RelayHelper.narrow(nameService.resolve_str(name));
			
		} catch (Exception e) {
			System.out.println("ERROR : " + e) ;
			e.printStackTrace(System.out);
		}
		
	}

	public void sendSensorPanicMessage(String sensorID) {
		relay.sendSensorPanicMessage(sensorID);
		
	}

}

public class Sensor extends JFrame {
	private JPanel textpanel;
	private JButton panicButton;
	public static String sensorID;
	private ClientSensorServant clientRef;
	public static String homeHubName;
	public static JTextField statusField;

	public Sensor(String[] args, String sensorID2, String homeHubName2) {
		
		sensorID = sensorID2;
		
		homeHubName = homeHubName2;
		
		try {
		    // Initialize the ORB
			
			Properties prop = new Properties();
			prop.put("org.omg.CORBA.ORBInitialPort","1050");
			prop.put("org.omg.CORBA.ORBInitialPort","localhost");
			
		    ORB orb = ORB.init(args, prop);
		    
		    // get reference to rootpoa & activate the POAManager
		    POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
		    rootpoa.the_POAManager().activate();
		    
		    // Create the Count servant object
		    clientRef = new ClientSensorServant(this, orb);

		    // get object reference from the servant
		    org.omg.CORBA.Object ref = rootpoa.servant_to_reference(clientRef);
		    ClientAndServer.ClientSensor cref = ClientSensorHelper.narrow(ref);
		    
		    // Get a reference to the Naming service
		    org.omg.CORBA.Object nameServiceObj = 
			orb.resolve_initial_references ("NameService");
		    if (nameServiceObj == null) {
			System.out.println("nameServiceObj = null");
			return;
		    }

		    // Use NamingContextExt which is part of the Interoperable
		    // Naming Service (INS) specification.
		    NamingContextExt nameService = NamingContextExtHelper.narrow(nameServiceObj);
		    if (nameService == null) {
			System.out.println("nameService = null");
			return;
		    }
		    
		    // bind the Count object in the Naming service
		    String name = sensorID;
		    NameComponent[] countName = nameService.to_name(name);
		    nameService.rebind(countName, cref);
			textpanel = new JPanel();
			textpanel.setLayout(null);

			getContentPane().add(textpanel, "Center");
			panicButton = new JButton("Send Panic");
			panicButton.setBounds(139, 195, 117, 25);
			textpanel.add(panicButton);
			panicButton.addActionListener (new ActionListener() {
				public void actionPerformed (ActionEvent evt) {
					clientRef.sendSensorPanicMessage(sensorID);
				}
			});

			setSize(400, 500);
			setTitle("Sensor " + sensorID);

			addWindowListener (new java.awt.event.WindowAdapter () {
				public void windowClosing (java.awt.event.WindowEvent evt) {
					System.exit(0);;
				}
			} );


		} catch (Exception e) {
			System.out.println("ERROR : " + e) ;
			e.printStackTrace(System.out);
		}
	}

	public static void main(String args[]) {
		final String[] arguments = args;
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				JFrame frame = new JFrame();
				
				sensorID = JOptionPane.showInputDialog(frame,"Sensor Name");
				
				JFrame frame1 = new JFrame();
				
				homeHubName = JOptionPane.showInputDialog(frame1,"Connect to Homehub");
				
				Sensor sensor = new Sensor(arguments, sensorID, homeHubName);
				
				sensor.setVisible(true);
				
			}
		});
	}
}