package FourthHomeWorks.First.changeableCollection.Tests;

import FourthHomeWorks.First.changeableCollection.changeableCollection;
import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class changeableCollectionGetArrTest {

    @Test
    public void getArr() {
        changeableCollection collection = new changeableCollection();
        collection.add(1);
        collection.add(2);
        collection.add(3);

        Object[] arr = collection.getArr();

        Iterator iterator = collection.iterator();
        int i = 0;
        boolean expected = true;
        boolean actual = true;

        while (iterator.hasNext()){
            if(!arr[i++].equals(iterator.next())){
                expected = false;
            }
        }

        Assert.assertEquals(expected,actual);
    }
}