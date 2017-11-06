package com.se491.sensorweb.Service;

import org.springframework.stereotype.Service;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

@Service
public class RouteService {

    public int[] getPathToDestination(int destination){

        return new int[]{5, 3, 2, 4, 1};
    }

    public static void calculatePathsForGraph(){
        int[][] adjacencies = buildAdjacencies(getxy());
        runFloydWarshall(initializeMatrix(adjacencies));
    }

    private static int[][] buildAdjacencies(List<Point2D.Float> coordinates){
        int[][] adjacencyMatrix = new int[coordinates.size()][coordinates.size()];
        for(int i=0; i < coordinates.size(); i++){
            for(int j=0; j < coordinates.size(); j++){
                if(i == j){
                    adjacencyMatrix[i][j] = 0;
                } else if(coordinates.get(i).distance(coordinates.get(j)) == 1){
                    adjacencyMatrix[i][j] = 1;
                }
            }
        }

        return adjacencyMatrix;
    }

    private static List<Point2D.Float> getxy(){
        List<Point2D.Float> coordinates = new ArrayList<>();
        coordinates.add(new Point2D.Float(1,1));
        coordinates.add(new Point2D.Float(2,1));
        coordinates.add(new Point2D.Float(3,1));
        coordinates.add(new Point2D.Float(4,1));
        coordinates.add(new Point2D.Float(3,2));
        coordinates.add(new Point2D.Float(4,2));
        coordinates.add(new Point2D.Float(6,2));
        coordinates.add(new Point2D.Float(2,3));
        coordinates.add(new Point2D.Float(3,3));
        coordinates.add(new Point2D.Float(4,3));
        coordinates.add(new Point2D.Float(5,3));
        coordinates.add(new Point2D.Float(6,3));
        coordinates.add(new Point2D.Float(3,4));
        coordinates.add(new Point2D.Float(5,4));
        coordinates.add(new Point2D.Float(6,4));
        coordinates.add(new Point2D.Float(2,5));
        coordinates.add(new Point2D.Float(3,5));
        coordinates.add(new Point2D.Float(4,5));
        coordinates.add(new Point2D.Float(5,5));
        coordinates.add(new Point2D.Float(6,6));

        int[][] toReturn = {{1,2,3,4,3,4,6,2,3,4,5,6,3,5,6,2,3,4,5,6},
                            {1,1,1,1,2,2,2,3,3,3,3,3,4,4,4,5,5,5,5,6}};
        return coordinates;
    }

    private static String runFloydWarshall(int[][] adjacencyMatrix){
        int i,j;
        int k;
        int distanceThroughK;
        int size = adjacencyMatrix.length;

        printMatrix(adjacencyMatrix);
        //Calculate shortest paths
        for(k=0; k < size; k++){
            for(i=0; i < size; i++){
                for(j=0; j < size; j++){
                    if(adjacencyMatrix[i][k] == Integer.MAX_VALUE || adjacencyMatrix[k][j] == Integer.MAX_VALUE){
                        distanceThroughK = Integer.MAX_VALUE;
                    }else {
                        distanceThroughK = adjacencyMatrix[i][k] + adjacencyMatrix[k][j];
                    }
                    adjacencyMatrix[i][j] = Math.min(distanceThroughK, adjacencyMatrix[i][j]);
                }
            }

        }
        printMatrix(adjacencyMatrix);

        //Calculate center node
        int longestTime;
        int rowTotal;
        int minTotalDistance = Integer.MAX_VALUE;
        int finalRowNumber = Integer.MAX_VALUE;
        int finalLongestTime = 0;

        //For each row...
        for(i=0; i < size; i++){
            rowTotal=0;
            longestTime = 0;
            //Calculate the node with the shortest total travel time to all other nodes
            for(j=0; j < size; j++){
                if(adjacencyMatrix[i][j] > longestTime){
                    longestTime = adjacencyMatrix[i][j]; //If our current column is greater than our previous longest time, update it
                }
                if(adjacencyMatrix[i][j] == Integer.MAX_VALUE){
                    rowTotal = Integer.MAX_VALUE;
                    break; //If we find a max value int, we can say the row total is infinite (or Int.maxval), and don't need to keep calculating. If we do go ahead and add, the integer goes over max value
                } else{
                    rowTotal += adjacencyMatrix[i][j];
                }

            }

            if(rowTotal < minTotalDistance){ //Update information about this row as the new best node
                minTotalDistance = rowTotal; //If our current row (node) is less than our previous best, update it.
                finalRowNumber = i+1; //update our contact
                finalLongestTime = longestTime; //update our longest time for this row
            }
        }

        //Print out the results!
        if(minTotalDistance == Integer.MAX_VALUE){ //If we never got a node that can reach all the other nodes, we have a disjoint graph
            return("disjoint"+"\n");
        }else {
            return(""+finalRowNumber+" "+finalLongestTime+"\n");
        }

    }

    private static int[][] initializeMatrix(int[][] adjacencyMatrix){
        for(int i=0; i < adjacencyMatrix.length; i++){
            for(int j=0; j < adjacencyMatrix.length; j++){
                if(i != j && adjacencyMatrix[i][j] != 1){
                    adjacencyMatrix[i][j] = Integer.MAX_VALUE;
                } else {
                    //cross section is 0, nodes aren't adjacent to themselves
                    adjacencyMatrix[i][i] = 0;
                }
            }
        }
        return adjacencyMatrix;
    }

    //debug code, don't want to delete it in case i come back.
    private static void printMatrix(int[][] adjacencyMatrix){
        int size = adjacencyMatrix.length;
        for(int i = 0; i < size; i++){
            System.out.print("[ ");
            for(int j = 0; j < size; j++){
                if(adjacencyMatrix[i][j] == Integer.MAX_VALUE){
                    System.out.print("X "); //Print x instead of the max int value for ease of reading

                } else {
                    System.out.print(adjacencyMatrix[i][j] + " ");
                }
                if(j == size-1)
                    System.out.println("]");
            }
        }
        System.out.println("------------------------------------------");
    }
}
