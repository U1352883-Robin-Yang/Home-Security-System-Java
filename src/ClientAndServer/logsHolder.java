package ClientAndServer;


/**
* ClientAndServer/logsHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Relay.idl
* Wednesday, 5 April 2017 17:15:29 o'clock BST
*/

public final class logsHolder implements org.omg.CORBA.portable.Streamable
{
  public String value[] = null;

  public logsHolder ()
  {
  }

  public logsHolder (String[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = ClientAndServer.logsHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    ClientAndServer.logsHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return ClientAndServer.logsHelper.type ();
  }

}
