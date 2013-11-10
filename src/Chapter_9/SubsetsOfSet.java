package Chapter_9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: sowmyahariharan
 * Date: 10/18/13
 * Time: 1:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class SubsetsOfSet {

    public static Set<Set<Integer>> powerSet(Set<Integer> originalSet,String me) {
        System.out.println(me +originalSet);
        Set<Set<Integer>> sets = new HashSet<Set<Integer>>();
        if (originalSet.isEmpty()) {
            sets.add(new HashSet<Integer>());
            return sets;
        }
        List<Integer> list = new ArrayList<Integer>(originalSet);
        Integer head = list.get(0);
        System.out.println("\tHead: "+head);
        Set<Integer> rest = new HashSet<Integer>(list.subList(1, list.size()));
        System.out.println("\tRest: "+rest);
        for (Set<Integer> set : powerSet(rest, "With OriginalSet: ")) {
            Set<Integer> newSet = new HashSet<Integer>();
            System.out.print("\n\t\tHead:" + head + ", Set:" + set + ",");
            newSet.add(head);
            newSet.addAll(set);
            System.out.println(" Head + Set:" + newSet);
            sets.add(newSet);
            sets.add(set);
            System.out.println("\t\t"+sets);
        }
        System.out.println("Function returns");
        return sets;
    }

    public static Set<Set<Integer>> returnPowerSet(Set<Integer> originalSet){

        Set<Set<Integer>> subSets = new HashSet<Set<Integer>>();
        if(originalSet.size() == 0){
            subSets.add(new HashSet<Integer>());
            return subSets;
        }
        List<Integer> list = new ArrayList<Integer>(originalSet);
        Integer head = list.get(0);
        Set<Integer> rest = new HashSet<Integer>(list.subList(1,list.size()));
        for(Set<Integer> set:returnPowerSet(rest)){
            subSets.add(set);

            Set<Integer> newSet = new HashSet<Integer>();
            newSet.add(head);
            newSet.addAll(set);

            subSets.add(newSet);
        }
        return subSets;
    }

    public static void main(String[] args){
       Set<Integer> originalSet = new HashSet<Integer>();
       originalSet.add(1);
       originalSet.add(2);
       originalSet.add(3);
//       originalSet.add(4);

        Set<Set<Integer>> subsetsOfSets = powerSet(originalSet, "Main passing the OriginalSet: ");
        subsetsOfSets = returnPowerSet(originalSet);
        for(Set<Integer> set : subsetsOfSets){
            System.out.println(set.toString());
        }

//        public static Set<Set<Integer>> powerSet(Set<Integer> originalSet,String me) {
//            System.out.println(me +originalSet);
//            Set<Set<Integer>> sets = new HashSet<Set<Integer>>();
//            if (originalSet.isEmpty()) {
//                sets.add(new HashSet<Integer>());
//                return sets;
//            }
//            List<Integer> list = new ArrayList<Integer>(originalSet);
////        System.out.println("List: "+list);
//            Integer head = list.get(0);
//            System.out.println("\tHead: "+head);
//            Set<Integer> rest = new HashSet<Integer>(list.subList(1, list.size()));
//            System.out.println("\tRest: "+rest);
//            for (Set<Integer> set : powerSet(rest, "With OriginalSet: ")) {
//                System.out.println("\tForming the new set with set: "+set.toString());
//                Set<Integer> newSet = new HashSet<Integer>();
//                System.out.println("\t\tForming the new set with head: "+head);
//                newSet.add(head);
//                newSet.addAll(set);
//                System.out.println("\t\t\tThe new set formed is: "+newSet);
//                sets.add(newSet);
//                sets.add(set);
//                System.out.println("\t\t\t\tSize of power set: "+sets.size());
//            }
//            System.out.println("Function returns");
//            return sets;
//
//        }
    }

//    public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index, String me) {
//        System.out.println(me);
//        ArrayList<ArrayList<Integer>> allsubsets;
//        if (set.size() == index) { // Base case - add empty set
//            allsubsets = new ArrayList<ArrayList<Integer>>();
//            allsubsets.add(new ArrayList<Integer>());
//        } else {
//            allsubsets = getSubsets(set, index + 1, "With: "+(index+1));
//            System.out.println("\t"+me);
//            int item = set.get(index);
//            ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
//            for (ArrayList<Integer> subset : allsubsets) {
//                ArrayList<Integer> newsubset = new ArrayList<Integer>();
//                newsubset.addAll(subset); //
//                newsubset.add(item);
//                moresubsets.add(newsubset);
//            }
//            allsubsets.addAll(moresubsets);
//        }
//        return allsubsets;
//    }
//
//    public static ArrayList<Integer> convertIntToSet(int x, ArrayList<Integer> set) {
//        ArrayList<Integer> subset = new ArrayList<Integer>();
//        int index = 0;
//        for (int k = x; k > 0; k >>= 1) {
//            if ((k & 1) == 1) {
//                subset.add(set.get(index));
//            }
//            index++;
//        }
//        return subset;
//    }
//
//    public static ArrayList<ArrayList<Integer>> getSubsets2(ArrayList<Integer> set) {
//        ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();
//        int max = 1 << set.size(); /* Compute 2^n */
//        for (int k = 0; k < max; k++) {
//            ArrayList<Integer> subset = convertIntToSet(k, set);
//            allsubsets.add(subset);
//        }
//        return allsubsets;
//    }
//
//    public static void main(String[] args) {
//        ArrayList<Integer> list = new ArrayList<Integer>();
//        for (int i = 1; i < 4; i++) {
//            list.add(i);
//        }
//        ArrayList<ArrayList<Integer>> subsets = getSubsets(list, 0, "main");
//        System.out.println(subsets.toString());
//
//        ArrayList<ArrayList<Integer>> subsets2 = getSubsets2(list);
//        System.out.println(subsets2.toString());
//    }
}
