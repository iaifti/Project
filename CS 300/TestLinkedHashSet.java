//Md Istiaq Ahmed

import java.util.*;

public class TestLinkedHashSet{
    public static void main(String[] args){
        Set<String> set1 =  new LinkedHashSet<>();
        
        set1.add("George");
        set1.add("Jim");
        set1.add("John");
        set1.add("Blake");
        set1.add("Kevin");
        set1.add("Micheal");
        
        Set<String> set2 =  new LinkedHashSet<>();
        
        set2.add("George");
        set2.add("Katie");
        set2.add("Kevin");
        set2.add("Michelle");
        set2.add("Ryan");
        
        Set<String> unionSet = new LinkedHashSet<>(set1);
        unionSet.addAll(set2);

        // Print the union set
        System.out.println("Union Set: " + unionSet);
        
        Set<String> differenceSet = new LinkedHashSet<>(set1);
        differenceSet.removeAll(set2);

        //Difference set
        System.out.println("Difference Set: " + differenceSet);
        
        Set<String> intersectSet = new LinkedHashSet<>(set1);
        intersectSet.retainAll(set2);

        //Intersection set
        System.out.println("Intersection Set: " + intersectSet);
        
        //CLone Sets
        Set<String> clonedSet1 = new HashSet<>(set1);

        Set<String> clonedSet2 = new HashSet<>(set2);
        
        System.out.println("Cloned set1: " + clonedSet1);
        System.out.println("Cloned set2: " + clonedSet2);
    }
    
}