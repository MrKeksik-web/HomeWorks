package FourthHomeWorks.First.changeableCollection.Tests;


import FourthHomeWorks.First.changeableCollection.changeableCollection;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;

public class changeableCollectionAddTest {

    @Test
    public void add() {
        changeableCollection<Integer> coll1 = new changeableCollection<>();
        boolean expected = coll1.add(10);
        boolean actual = true;

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void addNull() {
        changeableCollection<Integer> coll1 = new changeableCollection<>();
        boolean expected = coll1.add(null);
        boolean actual = true;

        Assert.assertEquals(expected,actual);
    }
}