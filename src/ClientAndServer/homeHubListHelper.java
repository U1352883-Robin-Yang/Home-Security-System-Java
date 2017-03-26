package ClientAndServer;


/**
* ClientAndServer/homeHubListHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Relay.idl
* Sunday, 26 March 2017 14:54:51 o'clock BST
*/

abstract public class homeHubListHelper
{
  private static String  _id = "IDL:ClientAndServer/homeHubList:1.0";

  public static void insert (org.omg.CORBA.Any a, ClientAndServer.HomeHubObject[] that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static ClientAndServer.HomeHubObject[] extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = ClientAndServer.HomeHubObjectHelper.type ();
      __typeCode = org.omg.CORBA.ORB.init ().create_sequence_tc (0, __typeCode);
      __typeCode = org.omg.CORBA.ORB.init ().create_alias_tc (ClientAndServer.homeHubListHelper.id (), "homeHubList", __typeCode);
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static ClientAndServer.HomeHubObject[] read (org.omg.CORBA.portable.InputStream istream)
  {
    ClientAndServer.HomeHubObject value[] = null;
    int _len0 = istream.read_long ();
    value = new ClientAndServer.HomeHubObject[_len0];
    for (int _o1 = 0;_o1 < value.length; ++_o1)
      value[_o1] = ClientAndServer.HomeHubObjectHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, ClientAndServer.HomeHubObject[] value)
  {
    ostream.write_long (value.length);
    for (int _i0 = 0;_i0 < value.length; ++_i0)
      ClientAndServer.HomeHubObjectHelper.write (ostream, value[_i0]);
  }

}
