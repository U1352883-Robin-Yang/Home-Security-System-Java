package ClientAndServer;


/**
* ClientAndServer/alarmListHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Relay.idl
* Wednesday, 5 April 2017 11:35:44 o'clock BST
*/

abstract public class alarmListHelper
{
  private static String  _id = "IDL:ClientAndServer/alarmList:1.0";

  public static void insert (org.omg.CORBA.Any a, ClientAndServer.AlarmLogs[] that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static ClientAndServer.AlarmLogs[] extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = ClientAndServer.AlarmLogsHelper.type ();
      __typeCode = org.omg.CORBA.ORB.init ().create_sequence_tc (0, __typeCode);
      __typeCode = org.omg.CORBA.ORB.init ().create_alias_tc (ClientAndServer.alarmListHelper.id (), "alarmList", __typeCode);
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static ClientAndServer.AlarmLogs[] read (org.omg.CORBA.portable.InputStream istream)
  {
    ClientAndServer.AlarmLogs value[] = null;
    int _len0 = istream.read_long ();
    value = new ClientAndServer.AlarmLogs[_len0];
    for (int _o1 = 0;_o1 < value.length; ++_o1)
      value[_o1] = ClientAndServer.AlarmLogsHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, ClientAndServer.AlarmLogs[] value)
  {
    ostream.write_long (value.length);
    for (int _i0 = 0;_i0 < value.length; ++_i0)
      ClientAndServer.AlarmLogsHelper.write (ostream, value[_i0]);
  }

}
