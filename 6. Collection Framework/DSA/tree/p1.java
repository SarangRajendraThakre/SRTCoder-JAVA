package tree;

import java.io.*;
import java.util.*;

public class p1 {
    public static void printparents(int node,Vector<Vector<Integer>>adj,int parent)
    {
        if(parent==0)
        {
            System.out.println(node+"->Root");

        }
        else
        {
            System.out.println(node+"->"+parent);
        }
        for(int i=0;i<adj.get(node).size();i++)
        {
            if(adj.get(node).get(i)!=parent)
            {
                printparents(adj.get(node).get(i), adj, node);
            }
        }


    }

    public static void printChildren(int root,Vector<>)
    
}
