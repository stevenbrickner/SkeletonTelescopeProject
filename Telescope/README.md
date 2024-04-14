Steven Brickner
Gary Hrezo
CEN 4025 01Z

I'm sorry about how incredibly much this is. I'm incredibly bad at skeleton code. The majority of the events and listeners are just tags because for some reason I wanted this to be easily extensible and now it looks like this. I recommend ignoring everything in the Repos folder aside from maybe the factory and data store. Same for Sensors aside from the main sensor class - I refactored this a bunch to contain all or at least most child behavior there. The connection manager is a disaster, as is the ground control driver.

Sample output
    TelescopeDriver

PS C:\Users\steve\OneDrive - Eastern Florida State College\CEN 4025 - Software Development 2\SkeletonTelescopeProject>  & 'C:\Program Files\Java\jdk-11.0.12\bin\java.exe' '-cp' 'C:\Users\steve\OneDrive - Eastern Florida State College\CEN 4025 - Software Development 2\SkeletonTelescopeProject\Telescope\bin' 'TelescopeDriver'
Dispatcher processing events
Sensor GyroscopeM initialized.
Sensor GyroscopeB initialized.    
Sensor AccelerometerM initialized.
Sensor AccelerometerB initialized.
Sensor TemperatureM initialized.  
Sensor TemperatureB initialized.  
Sensor PowerM initialized.        
Sensor PowerB initialized.        
Sensor RadiationM initialized.    
Sensor RadiationB initialized.
Sensor FuelM initialized.
Sensor FuelB initialized.
Sensor LightM initialized.
Sensor LightB initialized.
Sensor PressureM initialized.
Sensor PressureB initialized.

Activating main sensors.
Gyroscope taking readings at 2024-04-14T05:57:31.759718Z
Accelerometer taking readings at 2024-04-14T05:57:32.763681400Z
        Alert logged successfully
        Anomalous sensor reading detected in 
                AccelerometerM
        Alert logged successfully
        Anomalous sensor reading detected in
                AccelerometerM
Temperature taking readings at 2024-04-14T05:57:33.779350600Z
Power taking readings at 2024-04-14T05:57:34.788479400Z
        Alert logged successfully
        Anomalous sensor reading detected in
                PowerM
Radiation taking readings at 2024-04-14T05:57:35.790719600Z
Fuel taking readings at 2024-04-14T05:57:36.797010600Z
        Alert logged successfully
        Anomalous sensor reading detected in
                FuelM
Light taking readings at 2024-04-14T05:57:37.801751900Z
        Alert logged successfully
        Anomalous sensor reading detected in
                LightM
Pressure taking readings at 2024-04-14T05:57:38.800927400Z
Sensors initialized successfully.


Starting mission manager
Initializing Connection Manager
Next mission is Test at 2024-04-14T05:57:54.678240300Z
Server started and listening on port 12345
Accepted connection from /127.0.0.1
        Starting mission Test
Next mission is Ceres Astrometry at 2024-04-21T09:00:00Z
        Ending mission Test
Gyroscope taking readings at 2024-04-14T05:58:31.794283900Z
        Alert logged successfully
        Anomalous sensor reading detected in
                GyroscopeM
Error handling client connection: invalid stream header: 00215445
java.io.StreamCorruptedException: invalid stream header: 00215445
        at java.base/java.io.ObjectInputStream.readStreamHeader(ObjectInputStream.java:940)
        at java.base/java.io.ObjectInputStream.<init>(ObjectInputStream.java:379)
        at Managers.Connection.handleClient(Connection.java:67)
        at Managers.Connection.lambda$0(Connection.java:55)
        at java.base/java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:515)
        at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:264)
        at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
        at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
        at java.base/java.lang.Thread.run(Thread.java:834)
Accepted connection from /127.0.0.1
Error handling client connection: null
java.io.EOFException
        Mission Test added to data store.       at java.base/java.io.ObjectInputStream$BlockDataInputStream.peekByte(ObjectInputStream.java:3171)

        at java.base/java.io.ObjectInputStream.readObject0(ObjectInputStream.java:1630)
        at java.base/java.io.ObjectInputStream.readObject(ObjectInputStream.java:493)
        at java.base/java.io.ObjectInputStream.readObject(ObjectInputStream.java:451)
        at Managers.Connection.handleClient(Connection.java:70)
        at Managers.Connection.lambda$0(Connection.java:55)
        at java.base/java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:515)
        at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:264)
        at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
        at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
        at java.base/java.lang.Thread.run(Thread.java:834)

    GroundControlDriver

Attempting to connect to server...
Connected to server: localhost:12345
Enter your choice:
1. Request sensor information
2. Add a mission to the scheduled mission log
Choice: 2
Sending telecommand: Test
Enter your choice:
1. Request sensor information
2. Add a mission to the scheduled mission log
Choice: 1
Error sending telemetry request: Socket is closed
java.net.SocketException: Socket is closed
        at java.base/java.net.Socket.getOutputStream(Socket.java:961)
        at GroundControl.sendTelemetryRequest(GroundControl.java:81)
        at GroundControl.start(GroundControl.java:52)
        at GroundControlDriver.main(GroundControlDriver.java:8)
Enter your choice:
1. Request sensor information
2. Add a mission to the scheduled mission log
Choice: 2
Error sending telecommand: Socket is closed
java.net.SocketException: Socket is closed
        at java.base/java.net.Socket.getOutputStream(Socket.java:961)
        at GroundControl.sendTelecommand(GroundControl.java:99)
        at GroundControl.start(GroundControl.java:55)
        at GroundControlDriver.main(GroundControlDriver.java:8)
Enter your choice:
1. Request sensor information
2. Add a mission to the scheduled mission log
Choice:

Bugs: 

All of the anomalous sensor readings from the server are intentional.
Every bug at the moment is solely related to sending data between the two programs. It's almost certainly because I wanted telecommands and telemetry requests to be sent as objects of each type respectively and I have absolutely no idea how serialization works in any capacity. I couldn't get sending objects working and now I can't even get the server to send a string to the client. If I had more time to refactor this, I could probably get something working, but I need to do other classwork.

Other things aren't bugs but aren't implemented. The telescope state variable never changes, for example - event listeners were supposed to but I never got to it. An anomalous sensor was supposed to trigger a switch to the backup sensor, or deactivate the sensor if it's already active, but I never got around to testing that either. But I guess that's a good thing because that's not very skeleton code of me.