package ClientAndServer;

/**
* ClientAndServer/ClientServerHomeHubHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Relay.idl
* Wednesday, 5 April 2017 22:14:33 o'clock BST
*/

public final class ClientServerHomeHubHolder implements org.omg.CORBA.portable.Streamable
{
  public ClientAndServer.ClientServerHomeHub value = null;

  public ClientServerHomeHubHolder ()
  {
  }

  public ClientServerHomeHubHolder (ClientAndServer.ClientServerHomeHub initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = ClientAndServer.ClientServerHomeHubHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    ClientAndServer.ClientServerHomeHubHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return ClientAndServer.ClientServerHomeHubHelper.type ();
  }

}
