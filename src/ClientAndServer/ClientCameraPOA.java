package ClientAndServer;


/**
* ClientAndServer/ClientCameraPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Relay.idl
* Wednesday, 5 April 2017 22:14:33 o'clock BST
*/

public abstract class ClientCameraPOA extends org.omg.PortableServer.Servant
 implements ClientAndServer.ClientCameraOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("switchOn", new java.lang.Integer (0));
    _methods.put ("switchOff", new java.lang.Integer (1));
    _methods.put ("sendPanicMessage", new java.lang.Integer (2));
    _methods.put ("sendOkayMessage", new java.lang.Integer (3));
    _methods.put ("setCamServer", new java.lang.Integer (4));
    _methods.put ("resetCamStatus", new java.lang.Integer (5));
    _methods.put ("itemName", new java.lang.Integer (6));
    _methods.put ("roomName", new java.lang.Integer (7));
    _methods.put ("currentImage", new java.lang.Integer (8));
    _methods.put ("getCameraStatus", new java.lang.Integer (9));
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
       case 0:  // ClientAndServer/ClientCamera/switchOn
       {
         String camID = in.read_string ();
         this.switchOn (camID);
         out = $rh.createReply();
         break;
       }

       case 1:  // ClientAndServer/ClientCamera/switchOff
       {
         String camID = in.read_string ();
         this.switchOff (camID);
         out = $rh.createReply();
         break;
       }

       case 2:  // ClientAndServer/ClientCamera/sendPanicMessage
       {
         String camID = in.read_string ();
         this.sendPanicMessage (camID);
         out = $rh.createReply();
         break;
       }

       case 3:  // ClientAndServer/ClientCamera/sendOkayMessage
       {
         String camID = in.read_string ();
         this.sendOkayMessage (camID);
         out = $rh.createReply();
         break;
       }

       case 4:  // ClientAndServer/ClientCamera/setCamServer
       {
         String camID = in.read_string ();
         this.setCamServer (camID);
         out = $rh.createReply();
         break;
       }

       case 5:  // ClientAndServer/ClientCamera/resetCamStatus
       {
         this.resetCamStatus ();
         out = $rh.createReply();
         break;
       }

       case 6:  // ClientAndServer/ClientCamera/itemName
       {
         String $result = null;
         $result = this.itemName ();
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 7:  // ClientAndServer/ClientCamera/roomName
       {
         String $result = null;
         $result = this.roomName ();
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 8:  // ClientAndServer/ClientCamera/currentImage
       {
         ClientAndServer.Image $result = null;
         $result = this.currentImage ();
         out = $rh.createReply();
         ClientAndServer.ImageHelper.write (out, $result);
         break;
       }

       case 9:  // ClientAndServer/ClientCamera/getCameraStatus
       {
         String camID = in.read_string ();
         this.getCameraStatus (camID);
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
    "IDL:ClientAndServer/ClientCamera:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public ClientCamera _this() 
  {
    return ClientCameraHelper.narrow(
    super._this_object());
  }

  public ClientCamera _this(org.omg.CORBA.ORB orb) 
  {
    return ClientCameraHelper.narrow(
    super._this_object(orb));
  }


} // class ClientCameraPOA
