package ClientAndServer;

/**
* ClientAndServer/ClientSensorHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Relay.idl
* Wednesday, 29 March 2017 16:23:14 o'clock BST
*/

public final class ClientSensorHolder implements org.omg.CORBA.portable.Streamable
{
  public ClientAndServer.ClientSensor value = null;

  public ClientSensorHolder ()
  {
  }

  public ClientSensorHolder (ClientAndServer.ClientSensor initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = ClientAndServer.ClientSensorHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    ClientAndServer.ClientSensorHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return ClientAndServer.ClientSensorHelper.type ();
  }

}