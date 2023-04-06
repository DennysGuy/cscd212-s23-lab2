package cscd212comparators.lab2;

import cscd212classes.lab2.Television;

import java.util.Comparator;

public class TelevisionScreenSizeComparator implements Comparator<Television> {
    @Override
    public int compare(Television t1, Television t2) throws IllegalArgumentException{
        if (t1 == null || t2 == null){
            throw new IllegalArgumentException("null parameter in TelevisionScreenSizeComparator");
        }
        return Integer.compare(t2.getScreenSize(), t1.getScreenSize());
    }
}
