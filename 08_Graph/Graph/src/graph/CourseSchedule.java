/**
 * DESIGN A SCHEDULE FOR A STUDENT TO COMPLETE HER DEGREE GIVEN 
 * THE LIST OF COURSES ALONG WITH THE PREREQUISITES FOR EACH COURSE
 * 
 * Algorithm:
 *      1. Break down the problem into a graph.
 *      2. Directed type graph, unweighted edges. 
 *         A. Recall Topological Sort: An order of vertices in a directed acyclic graph
 *            in which each node comes before all the nodes to that have outgoing edges. 
 *      3. Count the in-degrees of each course. (0 in-degrees means you can take the course without pre-reqs). 
 *      4. 
 *      
 *     
 */
package graph;

import javafx.util.Pair;

import java.util.*;

public class CourseSchedule {

    public static void main(String[] args) {
        List<String> Courses = new ArrayList<>();
        
        Courses.add("CS100");
        Courses.add("CS101");
        Courses.add("CS102");
        Courses.add("CS103");
        Courses.add("CS104");
        Courses.add("CS105");

        Map<String, List<String>> prereqs = new HashMap<>();
        List<String> list = new ArrayList<>();

        list.add("CS101");
        list.add("CS102");
        list.add("CS103");
        prereqs.put("CS100", list);

        list = new ArrayList<>();
        list.add("CS104");
        prereqs.put("CS102", list);

        list = new ArrayList<>();
        list.add("CS105");
        prereqs.put("CS103", list);

        List<String> courseSchedule = order(Courses, prereqs);
        System.out.println("Valid schedule for CS Students");

        for (String course : courseSchedule) {
            System.out.println(course);
        }
    }

    /* Input is a list of courses. and List of pre-reqs, which are maps from a 
     * course to the pre reqs of that courses. */
    public static List<String> order(List<String> courseList, Map<String, List<String>> prereqs) {
        
        Graph courseGraph = new AdjacencyMatrixGraph(courseList.size(), Graph.GraphType.DIRECTED);

        /**
         * To represent: Set up the 2 helper maps. 
         * Every course has a unique integerId which represent the vertex of the graph
         * Since the course is the vertex of the graph it has a unique intID to represent that vertex.
         * 
         * courseIDMAP maps from a string to an int from the course name to that unique ID
         * And idCourseMap, maps from the unique INTid to a string(course name)
         * 
         * One mapping from course name to unique ID and the other 
         * the reverse map  from uniqueID to course name. 
         */
        Map<String, Integer> courseIdMap = new HashMap<>();
        Map<Integer, String> idCourseMap = new HashMap<>();

        /* Add an edge to the graph for every course thats a pre-req to the other. */
        for(int i = 0; i < courseList.size(); i++) {
            courseIdMap.put(courseList.get(i), i);
            idCourseMap.put(i, courseList.get(i));
        }

        for (Map.Entry<String, List<String>> prereq : prereqs.entrySet()) {
            for (String course : prereq.getValue()) {
                courseGraph.addEdge(courseIdMap.get(prereq.getKey()),
                        courseIdMap.get(course));
            }
        }
        
        /* Call the topological sort on the grpah. */
        List<Integer> courseIdList =  TopologicalSort.sort(courseGraph);

        List <String> courseScheduleList =  new ArrayList<>();

        for (int courseId : courseIdList) {
            courseScheduleList.add(idCourseMap.get(courseId));
        }

        return courseScheduleList;
    }
}
