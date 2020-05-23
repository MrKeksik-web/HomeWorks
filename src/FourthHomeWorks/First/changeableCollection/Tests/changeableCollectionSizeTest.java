package FourthHomeWorks.First.changeableCollection.Tests;

import FourthHomeWorks.First.changeableCollection.changeableCollection;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class changeableCollectionSizeTest {

    @Test
    public void size() {
        changeableCollection collection = new changeableCollection();
        collection.add(5);
        collection.add("String");
        collection.add(6);
        collection.add(1);
        collection.add(new HashMap<>());
        int expected = collection.size();
        int actual = 5;

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void sizeNull() {
        changeableCollection collection = new changeableCollection();

        Assert.assertEquals(collection.size(),0);
    }
}