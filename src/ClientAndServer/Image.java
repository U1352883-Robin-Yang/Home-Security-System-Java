package ClientAndServer;


/**
* ClientAndServer/Image.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Relay.idl
* Thursday, 6 April 2017 23:57:23 o'clock BST
*/

public final class Image implements org.omg.CORBA.portable.IDLEntity
{

  // make up image type
  public String time = null;
  public String date = null;
  public String status = null;

  public Image ()
  {
  } // ctor

  public Image (String _time, String _date, String _status)
  {
    time = _time;
    date = _date;
    status = _status;
  } // ctor

} // class Image
