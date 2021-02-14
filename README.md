#Squad Stack Parking lot
## Setup
1. Download and install the latest JDK 8 version from 
https://www.oracle.com/in/java/technologies/javase/javase-jdk8-downloads.html
2. Add java to Path
`export PATH=$PATH:<jdk 8 path>
3. verify java
`java -version`
4. Clone the repo
`git clone https://github.com/KrishnaGadia/super-duper-pancake.git`
5. Go to the src folder
`cd super-duper-pancake/src`
6. Compile the classes
`javac -cp . com/squadstack/Car.java` 
`javac -cp . com/squadstack/ParkingLot.java` 
`javac -cp . com/squadstack/CommandProcessor.java` 
## Run
`java -cp . com/squadstack/CommandProcessor <input>`
