package ClientAndServer;


/**
* ClientAndServer/ClientSensorPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Relay.idl
* Thursday, 6 April 2017 23:57:23 o'clock BST
*/

public abstract class ClientSensorPOA extends org.omg.PortableServer.Servant
 implements ClientAndServer.ClientSensorOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("sendSensorPanicMessage", new java.lang.Integer (0));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // ClientAndServer/ClientSensor/sendSensorPanicMessage
       {
         String sensorID = in.read_string ();
         String roomName = in.read_string ();
         this.sendSensorPanicMessage (sensorID, roomName);
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:ClientAndServer/ClientSensor:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public ClientSensor _this() 
  {
    return ClientSensorHelper.narrow(
    super._this_object());
  }

  public ClientSensor _this(org.omg.CORBA.ORB orb) 
  {
    return ClientSensorHelper.narrow(
    super._this_object(orb));
  }


} // class ClientSensorPOA
