package application.agentlogic;


import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;


public class JobAssigner<J, W> {
    public boolean printEnabled = false;

    public HashMap<J, W> computeAssignment(int[][] costValues, List<J> jobIds, List<W> workerIds){
        int workers = costValues.length; //rows
        int jobs = costValues[0].length; //columns

        boolean moreJobs = (jobs > workers);

        // find the maximum value between rows and columns
        int max = Math.max(jobs, workers);

        //create a square matrix
        int[][] hungarianMatrix = new int[max][max];

        //copy the values from the costValues matrix to hungarianMatrix (), filling the inexisting cells with 0
        for (int i = 0; i < hungarianMatrix.length; i++)
            for (int j = 0; j < hungarianMatrix.length; j++)
                if ((i >= workers ) || (j >= jobs))
                    hungarianMatrix[j][i] = 0;
                else
                    hungarianMatrix[j][i] = costValues[i][j];


        /**/
        //for testing
        if (printEnabled)
            for (int i = 0; i < hungarianMatrix.length; i++){

                System.out.print("JOB ");
                if (i < jobIds.size())
                    System.out.print(jobIds.get(i) + "   ");
                else
                    System.out.print("DUMMY" + (i - jobIds.size() + 1) + "   ");
                for (int j = 0; j < hungarianMatrix.length; j++)
                    System.out.print("  " + hungarianMatrix[i][j]);
                System.out.println();
            }
        /**/



        //find 1st assignment
        HungarianAlgorithm ha = new HungarianAlgorithm(hungarianMatrix);
        int[][] assignment = ha.findOptimalAssignment();

        //there might be not assigned jobs. They will be found, and they will be assigned in the next recursive invocation of the method
        List<J> notAssignedJobs = new ArrayList<J>();
        HashMap<J, W> assignedJobs = new HashMap<J, W>();

        int totalCost = 0;
        if (assignment.length > 0) {
            // print assignment
            if (printEnabled)
                System.out.println();
            for (int i = 0; i < assignment.length; i++) {
                if ((assignment[i][0] >= workers)|| (assignment[i][1] >= jobs)){
                    if (assignment[i][1] < jobs){
                        if (printEnabled)
                            System.out.println("JOB " + jobIds.get(assignment[i][1]) + " not assigned!!");
                        if (notAssignedJobs.isEmpty())
                            notAssignedJobs.add(jobIds.get(assignment[i][1]));
                        else
                            notAssignedJobs.add(notAssignedJobs.size() - 1,jobIds.get(assignment[i][1]));
                    }
                }

                else{
                    if (printEnabled)
                        System.out.println(jobIds.get(assignment[i][1]) + " assigned to " + workerIds.get(assignment[i][0]));
                    assignedJobs.put(jobIds.get(assignment[i][1]), workerIds.get(assignment[i][0]));
                    totalCost += costValues[assignment[i][0]][assignment[i][1]];
                }
            }
            if (printEnabled){
                System.out.println();
                System.out.println("Assignment cost: " + totalCost);
                System.out.println("------------------");
                System.out.println();
            }

            // if there where more jobs than workers, then there will be jobs that are not assigned.
            // In order to be assigned, there will be a recursive invocation of this method
            if (moreJobs){
                //Prepare the new cost matrix with the values of the jobs that are not assigned
                int[][] newCosts = new int[workerIds.size()][notAssignedJobs.size()];
                for(int i = 0; i< workerIds.size(); i++){
                    for(int j = 0; j < notAssignedJobs.size(); j++){
                        newCosts[i][j] = costValues[i][jobIds.indexOf(notAssignedJobs.get(j))];
                    }
                }
                //find the assignment for these jobs
                HashMap<J, W> newAssignedJobs = this.computeAssignment(newCosts, notAssignedJobs, workerIds);
                //add the newly assigned jobs to the already assigned jobs' hashmap
                for (J job: newAssignedJobs.keySet()){
                    assignedJobs.put(job, newAssignedJobs.get(job));
                }
            }
        }


        return assignedJobs;

    }
}
