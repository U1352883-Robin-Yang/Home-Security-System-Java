package ClientAndServer;


/**
* ClientAndServer/ServerRegionalOfficeOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Relay.idl
* Wednesday, 5 April 2017 17:15:29 o'clock BST
*/

public interface ServerRegionalOfficeOperations 
{
  String panicServer (String camID, String homeHubName, String contact);
  void sensorPanicServer (String sensorID, String roomName);
  String switchOn (String camID);
  String switchOff (String camID);
  void showCamStatus (String messageStatus);
  void showSensorStatus (String messageStatus);
  String connection (String name);
  void resetSensor (String CamID, String homeHubName);
  void showOkayMessage (String camID, String homeHubName);
  void getStatus (String camID, String homeHubName);
  void showCameraStatus (String camID, String status);
  void getLog (String homeHubName);
} // interface ServerRegionalOfficeOperations
