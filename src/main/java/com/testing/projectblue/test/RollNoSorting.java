package com.testing.projectblue.test;

import java.util.Comparator;

public class RollNoSorting implements Comparator<SortingTestComparator>{
    @Override
    public int compare(SortingTestComparator s1, SortingTestComparator s2)
    {
        return s1.getRollno() - s2.getRollno();
    }

}
