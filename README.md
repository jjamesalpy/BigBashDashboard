# BigBashDashboard
This application reads trhe data from the file using spring batch and stores to the in memory database
this data will populated to the web layer using rest API.

/******************************************************************/
As of now the dataupload part is completed and is available in this branch
/*******************************************************************/

The files can be accssed from the below path.

BigBashDashboard/src/main/java/com/joapps/bigbashdashboard/dataupload/

BatchConfig.java   // This file is written to handle the batch confiurations
JobCompletionNotificationListener.java   //This file will notify the job completion
MatchDataInputEntity.java  // This file is the plane POJO class 
MatchDataProcessor.java  //This file enriches the match data model

This uploaded data will be stored to the inmemory H2DB. 

/********************************************************/
Web service to fetch this data and the UI is pending for completion 
/********************************************************?
