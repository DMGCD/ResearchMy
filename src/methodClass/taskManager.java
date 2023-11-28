package methodClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class taskManager {


    private  static taskManager task;

    public static taskManager getInstance(){
        return (task == null) ? task =new taskManager() :task;
    }
    public boolean geTaskManager(String appName){
        boolean x=false;
        try {
            // Run the "tasklist" command
            Process tasklist = new ProcessBuilder("tasklist").start();
            // Read the output of the command
            BufferedReader reader = new BufferedReader(new InputStreamReader(tasklist.getInputStream()));
            String line;
            boolean isRunning=false;
            // Check if the application is running
            while ((line=reader.readLine())!=null){
                if(line.contains(appName)){
                    isRunning =true;
                    break;
                }
            }
            if(isRunning){
                // Get the runtime MXBean
                RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();

                // Get the start time of the Java application
                long startTime = runtimeMXBean.getStartTime();
                java.util.Date startDate = new java.util.Date(startTime);
                System.out.println("Formatted Start Time: " + startDate);

                x=true;
            }
            else{
                System.out.println("notRunning");
            }
            // Wait for the process to complete
            int i = tasklist.waitFor();
            if(i==0){

            }
            else{
                System.err.println("Is not complete execution!");
            }


        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return x;

    }


}
