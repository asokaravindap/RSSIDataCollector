# RSSIDataCollector
This includes the implementation of RSSI data collection

Important Notes:

The directory where the output file is written requires necessary permissions to avoid permission denied exception. Therefore, granting permission as follows is essential.

sudo mkdir ..SOMEPATH../outputdir

sudo chown tomcat7:tomcat7 ..SOMEPATH../outputdir

sudo chmod u+wrx ..SOMEPATH../outputdir
